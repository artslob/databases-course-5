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


class Table:
    def __init__(self):
        self.rows = []

    def append(self, *items):
        self.rows.append(*items)

    def __str__(self):
        return '\n'.join(str(i) for i in self.rows)


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
        return (
            f"INSERT INTO birthplace (birthplace_id, country_key, country_name, region_key, region_name, city_key, city_name)\n"
            f"VALUES ({self.birthplace_id}, {self.country_key}, '{self.country_name}', {self.region_key}, '{self.region_name}', {self.city_key}, '{self.city_name}');")

    @staticmethod
    def create_table():
        table = Table()
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
        return (f"INSERT INTO time_t (time_id, year_key, year_name, term_key, term_name)\n"
                f"VALUES ({self.time_id}, {self.year_key}, '{self.year_name}', {self.term_key}, '{self.term_name}');")

    @staticmethod
    def create_table():
        table = Table()
        get_key = count(1)
        t_id = 1
        for year in range(1990, 2000):
            for term_name in ('first', 'second'):
                table.append(Time(t_id, year, f'{year} year', next(get_key), term_name + ' term'))
                t_id += 1
        return table


class Fact2:
    def __init__(self, fact2_id, people_count, birthplace_id, time_id):
        self.fact2_id = fact2_id
        self.people_count = people_count
        self.birthplace_id = birthplace_id
        self.time_id = time_id

    def __str__(self):
        return (f"INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)\n"
                f"VALUES ({self.fact2_id}, {self.people_count}, {self.birthplace_id}, {self.time_id});")

    @staticmethod
    def create_table(birthplaces, times):
        """before call this function recommended step is to seed generator"""
        table = Table()
        t_id = 1
        for b in birthplaces.rows:
            for t in times.rows:
                table.append(Fact2(t_id, random.randint(1_000, 10_000), b.birthplace_id, t.time_id))
                t_id += 1
        return table


publishers_dict = {
    'Russia': {
        'Vologda': ['Eksmo', 'AST'],
        'Yaroslavl': ['ROSMAN', 'ALFA'],
        'Krasnoyarsk': ['OLMA'],
    },
    'Belarus': {
        'Gomel': ['CENTRPOLIGRAF', 'AZBUKA'],
        'Minsk': ['ATTIKUS'],
    }
}


class Publishers:
    def __init__(self, publisher_id, country_key, country_name, city_key, city_name, publisher_key, publisher_name):
        self.publisher_id = publisher_id
        self.country_key = country_key
        self.country_name = country_name
        self.city_key = city_key
        self.city_name = city_name
        self.publisher_key = publisher_key
        self.publisher_name = publisher_name

    def __str__(self):
        return (
            f"INSERT INTO publishers (publisher_id, country_key, country_name, city_key, city_name, publisher_key, publisher_name)\n"
            f"VALUES ({self.publisher_id}, {self.country_key}, '{self.country_name}', {self.city_key}, '{self.city_name}', {self.publisher_key}, '{self.publisher_name}');")

    @staticmethod
    def create_table():
        table = Table()
        get_key = count(1)
        for country_name in publishers_dict.keys():
            country_key = next(get_key)
            for city_name in publishers_dict[country_name].keys():
                city_key = next(get_key)
                for publisher_name in publishers_dict[country_name][city_name]:
                    publisher_id = next(get_key)
                    publisher_key = next(get_key)
                    table.append(Publishers(publisher_id, country_key, country_name, city_key, city_name, publisher_key,
                                            publisher_name))
        return table


def write_to_file(target, *strings):
    if not target.exists():
        raise ValueError(f"target file '{target}' not exist!")

    output = '\n\n'.join(strings) + '\n'

    with open(target, 'r') as f:
        content = f.read()

    if output == content:
        print('files content equals to output')
        return

    with open(target, 'w') as f:
        f.write(output)


def main():
    args = parse_args()
    random.seed(42)
    cwd = Path().absolute()
    target = cwd / 'scripts' / 'insert.sql'
    print(f"target file is: '{target}'")

    birthplaces = Birthplace.create_table()
    times = Time.create_table()
    fact2 = Fact2.create_table(birthplaces, times)
    publishers = Publishers.create_table()

    birthplaces_insert = str(birthplaces)
    times_insert = str(times)
    fact2_insert = str(fact2)
    publishers_insert = str(publishers)

    inserts = [birthplaces_insert, times_insert, fact2_insert, publishers_insert]

    if not args.no_print:
        print('\n', '\n\n'.join(inserts), sep='')

    print()
    if args.write:
        write_to_file(target, *inserts)
        print(f'successful write')
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
