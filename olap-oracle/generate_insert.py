import argparse
import random
from itertools import count
from pathlib import Path

birthplaces_dict = {
    'Russia': {
        'Vologda Oblast': ['Vologda', 'Cherepovets', 'Sokol'],
        'Yaroslavl Oblast': ['Yaroslavl', 'Rostov', 'Rybinsk', 'Uglich'],
        'Krasnoyarsk Krai': ['Krasnoyarsk', 'Norilsk', 'Zelenogorsk'],
    },
    'Belarus': {
        'Gomel Region': ['Gomel', 'Zhlobin', 'Dobrush'],
        'Minsk Region': ['Minsk', 'Salihorsk', 'Slutsk'],
    }
}


class Birthplace:
    def __init__(self, birthplace_id, country_key, country_name, region_key, region_name, city_key, city_name):
        self.birthplace_id = birthplace_id
        self.country_key = country_key
        self.country_name = country_name
        self.region_key = region_key
        self.region_name = region_name
        self.city_key = city_key
        self.city_name = city_name

    def __str__(self):
        return '\n'.join([
            f'INSERT INTO birthplace (birthplace_id, country_key, country_name, region_key, region_name, city_key, city_name)',
            f"VALUES ({self.birthplace_id}, {self.country_key}, '{self.country_name}', {self.region_key}, '{self.region_name}', {self.city_key}, '{self.city_name}');"
        ])


def generate_birthplaces():
    table = []
    get_key = count(1)
    for country in birthplaces_dict.keys():
        country_key = next(get_key)
        for region in birthplaces_dict[country].keys():
            region_key = next(get_key)
            for city in birthplaces_dict[country][region]:
                birthplace_id = next(get_key)
                city_key = next(get_key)
                table.append(Birthplace(birthplace_id, country_key, country, region_key, region, city_key, city))
    return table


class Time:
    def __init__(self, time_id, year_key, year_name, term_key, term_name):
        self.time_id = time_id
        self.year_key = year_key
        self.year_name = year_name
        self.term_key = term_key
        self.term_name = term_name

    def __str__(self):
        return '\n'.join([
            f'INSERT INTO time_t (time_id, year_key, year_name, term_key, term_name)',
            f"VALUES ({self.time_id}, {self.year_key}, '{self.year_name}', {self.term_key}, '{self.term_name}');"
        ])


def generate_times():
    time_table = []
    get_key = count(1)
    t_id = 1
    for year in range(1990, 2000):
        for term_name in ('first', 'second'):
            time_table.append(Time(t_id, year, f'{year} year', next(get_key), term_name + ' term'))
            t_id += 1
    return time_table


class Fact2:
    def __init__(self, fact2_id, people_count, birthplace_id, time_id):
        self.fact2_id = fact2_id
        self.people_count = people_count
        self.birthplace_id = birthplace_id
        self.time_id = time_id

    def __str__(self):
        return '\n'.join([
            f'INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)',
            f"VALUES ({self.fact2_id}, {self.people_count}, {self.birthplace_id}, {self.time_id});"
        ])


def generate_fact2(birthplaces, times):
    """before call this function recommended to seed generator"""
    table = []
    t_id = 1
    for b in birthplaces:
        for t in times:
            table.append(Fact2(t_id, random.randint(1_000, 10_000), b.birthplace_id, t.time_id))
            t_id += 1
    return table


def write_to_file(target, *strings):
    if not target.exists():
        raise ValueError(f"target file '{target}' not exist!")

    with open(target, 'w') as f:
        f.write('\n'.join(strings) + '\n')


def main():
    args = parse_args()
    random.seed(42)
    cwd = Path().absolute()
    target = cwd / 'scripts' / 'insert.sql'
    print(f"target file is: '{target}'")

    birthplaces = generate_birthplaces()
    times = generate_times()
    fact2 = generate_fact2(birthplaces, times)

    birthplaces_insert = '\n'.join(str(i) for i in birthplaces)
    times_insert = '\n'.join(str(i) for i in times)
    fact2_insert = '\n'.join(str(i) for i in fact2)

    if not args.no_print:
        print('\n', '\n\n'.join([birthplaces_insert, times_insert, fact2_insert]), sep='')

    if args.write:
        write_to_file(target, birthplaces_insert, '', times_insert, '', fact2_insert)
        print(f'successful write to {target}')
        return
    print('write operation was not performed')


def parse_args():
    parser = argparse.ArgumentParser(description='Generate sql inserts.')
    parser.add_argument('-w', '--write', action='store_true', help='need to write to file. default: %(default)s')
    parser.add_argument('-np', '--no-print', action='store_true',
                        help='no need to print inserts to stdout. default: %(default)s')
    return parser.parse_args()


if __name__ == '__main__':
    main()
