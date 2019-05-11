from pathlib import Path

birthplaces = {
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


def generate_birthplaces():
    lines = []
    t_id = 1
    for i, county in enumerate(birthplaces.keys(), 1):
        for j, region in enumerate(birthplaces[county].keys(), 1):
            for k, city in enumerate(birthplaces[county][region], 1):
                lines.extend([
                    f'INSERT INTO birthplace (birthplace_id, country_key, country_name, region_key, region_name, city_key, city_name)',
                    f"VALUES ({t_id}, {i}, '{county}', {j}, '{region}', {k}, '{city}');"
                ])
                t_id += 1
    return '\n'.join(lines)


def generate_times():
    lines = []
    t_id = 1
    for year in range(1990, 2000):
        for j in range(1, 3):
            lines.extend([
                f'INSERT INTO time_t (time_id, year_key, year_name, term_key, term_name)',
                f"VALUES ({t_id}, {year}, '{year}', {j}, '{j}');"
            ])
            t_id += 1
    return '\n'.join(lines)


cwd = Path().absolute()
target_file = cwd / 'scripts' / 'insert.sql'


def write_to_file():
    if not target_file.exists():
        raise ValueError(f"target file '{target_file}' not exist!")

    with open(target_file, 'w') as f:
        f.write(
            '\n'.join([
                generate_birthplaces(),
                '',
                generate_times(),
            ])
            + '\n'
        )


if __name__ == '__main__':
    print(f"target file is: '{target_file}'")
    print(generate_birthplaces())
    print(generate_times())
    write_to_file()
