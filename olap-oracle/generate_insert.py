import argparse
import random
from itertools import count
from pathlib import Path


class Table:
    def __init__(self):
        self.rows = []

    def append(self, *items):
        self.rows.append(*items)

    def __str__(self):
        return '\n'.join(str(i) for i in self.rows)


class Birthplace:
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

    @classmethod
    def create_table(cls):
        table = Table()
        get_key = count(1)
        for country in cls.birthplaces_dict.keys():
            country_key = next(get_key)
            for region in cls.birthplaces_dict[country].keys():
                region_key = next(get_key)
                for city in cls.birthplaces_dict[country][region]:
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


class Publishers:
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

    @classmethod
    def create_table(cls):
        table = Table()
        get_key = count(1)
        for country_name in cls.publishers_dict.keys():
            country_key = next(get_key)
            for city_name in cls.publishers_dict[country_name].keys():
                city_key = next(get_key)
                for publisher_name in cls.publishers_dict[country_name][city_name]:
                    publisher_id = next(get_key)
                    publisher_key = next(get_key)
                    table.append(Publishers(publisher_id, country_key, country_name, city_key, city_name, publisher_key,
                                            publisher_name))
        return table


class Fact3:
    def __init__(self, fact3_id, people_count, publisher_id, time_id):
        self.fact3_id = fact3_id
        self.people_count = people_count
        self.publisher_id = publisher_id
        self.time_id = time_id

    def __str__(self):
        return (f"INSERT INTO fact3 (fact3_id, people_count, publisher_id, time_id)\n"
                f"VALUES ({self.fact3_id}, {self.people_count}, {self.publisher_id}, {self.time_id});")

    @staticmethod
    def create_table(publishers, times):
        """before call this function recommended step is to seed generator"""
        table = Table()
        t_id = 1
        for p in publishers.rows:
            for t in times.rows:
                table.append(Fact3(t_id, random.randint(100, 1_000), p.publisher_id, t.time_id))
                t_id += 1
        return table


class Campus:
    addresses = ["per. Vyazemskij, d. 5/7", "ul. Lensoveta, d. 23", "Alpijskij per., d.15",
                 "ul. Belorusskaya, d. 6", "Novoizmajlovskij pr., 16", "ul. Vavilovyh, d. 12"]

    def __init__(self, campus_id, address_key, address_name):
        self.campus_id = campus_id
        self.address_key = address_key
        self.address_name = address_name

    def __str__(self):
        return (f"INSERT INTO campus (campus_id, address_key, address_name)\n"
                f"VALUES ({self.campus_id}, {self.address_key}, '{self.address_name}');")

    @classmethod
    def create_table(cls):
        table = Table()
        for t_id, addr in enumerate(cls.addresses, 1):
            table.append(Campus(t_id, t_id, addr))
        return table


class Fact4:
    def __init__(self, fact4_id, room_count, a_mark, a_b_mark, a_e_mark, debts_count, campus_id, time_id):
        self.fact4_id = fact4_id
        self.room_count = room_count
        self.a_mark = a_mark
        self.a_b_mark = a_b_mark
        self.a_e_mark = a_e_mark
        self.debts_count = debts_count
        self.campus_id = campus_id
        self.time_id = time_id

    def __str__(self):
        return (
            f"INSERT INTO fact4 (fact4_id, room_count, a_mark, a_b_mark, a_e_mark, debts_count, campus_id, time_id)\n"
            f"VALUES ({self.fact4_id}, {self.room_count}, {self.a_mark}, {self.a_b_mark}, {self.a_e_mark}, {self.debts_count}, {self.campus_id}, {self.time_id});")

    @staticmethod
    def create_table(campus, times):
        """before call this function recommended step is to seed generator"""
        table = Table()
        t_id = count(1)
        for c in campus.rows:
            for t in times.rows:
                table.append(
                    Fact4(next(t_id), random.randint(1, 6), random.randint(100, 1_000), random.randint(1_000, 10_000),
                          random.randint(5_000, 15_000), random.randint(1_000, 10_000), c.campus_id, t.time_id))
        return table


class Fact1:
    def __init__(self, fact1_id, honor_diplomas, usual_diplomas, publication_count, student_cards_count,
                 conference_count, employee_cards_count, live_campus_count, not_live_campus_count, time_id):
        self.fact1_id = fact1_id
        self.honor_diplomas = honor_diplomas
        self.usual_diplomas = usual_diplomas
        self.publication_count = publication_count
        self.student_cards_count = student_cards_count
        self.conference_count = conference_count
        self.employee_cards_count = employee_cards_count
        self.live_campus_count = live_campus_count
        self.not_live_campus_count = not_live_campus_count
        self.time_id = time_id

    def __str__(self):
        return (
            f"INSERT INTO fact1 (fact1_id, honor_diplomas, usual_diplomas, publication_count, student_cards_count, conference_count, employee_cards_count, live_campus_count, not_live_campus_count, time_id)\n"
            f"VALUES ({self.fact1_id}, {self.honor_diplomas}, {self.usual_diplomas}, {self.publication_count}, {self.student_cards_count}, {self.conference_count}, {self.employee_cards_count}, {self.live_campus_count}, {self.not_live_campus_count}, {self.time_id});")

    @staticmethod
    def create_table(times):
        """before call this function recommended step is to seed generator"""
        table = Table()
        t_id = count(1)
        for t in times.rows:
            table.append(Fact1(next(t_id), random.randint(20, 60), random.randint(200, 600), random.randint(50, 100),
                               random.randint(500, 1000), random.randint(50, 150), random.randint(500, 1000),
                               random.randint(5_000, 10_000), random.randint(2_000, 3_000), t.time_id))
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
    cwd = Path(__file__).parent.absolute()
    target = cwd / 'scripts' / 'insert.sql'
    print(f"target file is: '{target}'")

    birthplaces = Birthplace.create_table()
    times = Time.create_table()
    fact2 = Fact2.create_table(birthplaces, times)
    publishers = Publishers.create_table()
    fact3 = Fact3.create_table(publishers, times)
    campus = Campus.create_table()
    fact4 = Fact4.create_table(campus, times)
    fact1 = Fact1.create_table(times)

    birthplaces_insert = str(birthplaces)
    times_insert = str(times)
    fact2_insert = str(fact2)
    publishers_insert = str(publishers)
    fact3_insert = str(fact3)
    campus_insert = str(campus)
    fact4_insert = str(fact4)
    fact1_insert = str(fact1)

    inserts = [birthplaces_insert, times_insert, fact2_insert, publishers_insert, fact3_insert, campus_insert,
               fact4_insert, fact1_insert]

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
