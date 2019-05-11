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
    birthplaces_table = []
    birthplace_id = 1
    for i, county in enumerate(birthplaces_dict.keys(), 1):
        for j, region in enumerate(birthplaces_dict[county].keys(), 1):
            for k, city in enumerate(birthplaces_dict[county][region], 1):
                birthplaces_table.append(Birthplace(birthplace_id, i, county, j, region, k, city))
                birthplace_id += 1
    return birthplaces_table


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
    t_id = 1
    for year in range(1990, 2000):
        for j in range(1, 3):
            time_table.append(Time(t_id, year, year, j, j))
            t_id += 1
    return time_table


def write_to_file(target, *strings):
    if not target.exists():
        raise ValueError(f"target file '{target}' not exist!")

    with open(target, 'w') as f:
        f.write('\n'.join(strings) + '\n')


def main():
    cwd = Path().absolute()
    target = cwd / 'scripts' / 'insert.sql'
    print(f"target file is: '{target}'")

    birthplaces = generate_birthplaces()
    times = generate_times()

    birthplaces_insert = '\n'.join(str(i) for i in birthplaces)
    times_insert = '\n'.join(str(i) for i in times)

    print()
    print(birthplaces_insert)
    print()
    print(times_insert)

    write_to_file(target, birthplaces_insert, '', times_insert)


if __name__ == '__main__':
    main()
