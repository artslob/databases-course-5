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
    for i, county in enumerate(birthplaces.keys(), 1):
        for j, region in enumerate(birthplaces[county].keys(), 1):
            for k, city in enumerate(birthplaces[county][region], 1):
                lines.extend([
                    f'INSERT INTO birthplace (country_key, country_name, region_key, region_name, city_key, city_name)',
                    f"VALUES ({i}, '{county}', {j}, '{region}', {k}, '{city}');"
                ])
    return '\n'.join(lines)


cwd = Path().absolute()
target_file = cwd / 'scripts' / 'insert.sql'


def write_to_file():
    if not target_file.exists():
        raise ValueError(f"target file '{target_file}' not exist!")

    with open(target_file, 'w') as f:
        f.write(generate_birthplaces())
        f.write('\n')


if __name__ == '__main__':
    print(f"target file is: '{target_file}'")
    print(generate_birthplaces())
    write_to_file()
