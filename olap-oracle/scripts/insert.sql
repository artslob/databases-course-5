INSERT INTO birthplace (birthplace_id, country_key, country_name, region_key, region_name, city_key, city_name)
VALUES (1, 1, 'Russia', 1, 'Vologda Oblast', 1, 'Vologda');
INSERT INTO birthplace (birthplace_id, country_key, country_name, region_key, region_name, city_key, city_name)
VALUES (2, 1, 'Russia', 1, 'Vologda Oblast', 2, 'Cherepovets');
INSERT INTO birthplace (birthplace_id, country_key, country_name, region_key, region_name, city_key, city_name)
VALUES (3, 1, 'Russia', 1, 'Vologda Oblast', 3, 'Sokol');
INSERT INTO birthplace (birthplace_id, country_key, country_name, region_key, region_name, city_key, city_name)
VALUES (4, 1, 'Russia', 2, 'Yaroslavl Oblast', 1, 'Yaroslavl');
INSERT INTO birthplace (birthplace_id, country_key, country_name, region_key, region_name, city_key, city_name)
VALUES (5, 1, 'Russia', 2, 'Yaroslavl Oblast', 2, 'Rostov');
INSERT INTO birthplace (birthplace_id, country_key, country_name, region_key, region_name, city_key, city_name)
VALUES (6, 1, 'Russia', 2, 'Yaroslavl Oblast', 3, 'Rybinsk');
INSERT INTO birthplace (birthplace_id, country_key, country_name, region_key, region_name, city_key, city_name)
VALUES (7, 1, 'Russia', 2, 'Yaroslavl Oblast', 4, 'Uglich');
INSERT INTO birthplace (birthplace_id, country_key, country_name, region_key, region_name, city_key, city_name)
VALUES (8, 1, 'Russia', 3, 'Krasnoyarsk Krai', 1, 'Krasnoyarsk');
INSERT INTO birthplace (birthplace_id, country_key, country_name, region_key, region_name, city_key, city_name)
VALUES (9, 1, 'Russia', 3, 'Krasnoyarsk Krai', 2, 'Norilsk');
INSERT INTO birthplace (birthplace_id, country_key, country_name, region_key, region_name, city_key, city_name)
VALUES (10, 1, 'Russia', 3, 'Krasnoyarsk Krai', 3, 'Zelenogorsk');
INSERT INTO birthplace (birthplace_id, country_key, country_name, region_key, region_name, city_key, city_name)
VALUES (11, 2, 'Belarus', 1, 'Gomel Region', 1, 'Gomel');
INSERT INTO birthplace (birthplace_id, country_key, country_name, region_key, region_name, city_key, city_name)
VALUES (12, 2, 'Belarus', 1, 'Gomel Region', 2, 'Zhlobin');
INSERT INTO birthplace (birthplace_id, country_key, country_name, region_key, region_name, city_key, city_name)
VALUES (13, 2, 'Belarus', 1, 'Gomel Region', 3, 'Dobrush');
INSERT INTO birthplace (birthplace_id, country_key, country_name, region_key, region_name, city_key, city_name)
VALUES (14, 2, 'Belarus', 2, 'Minsk Region', 1, 'Minsk');
INSERT INTO birthplace (birthplace_id, country_key, country_name, region_key, region_name, city_key, city_name)
VALUES (15, 2, 'Belarus', 2, 'Minsk Region', 2, 'Salihorsk');
INSERT INTO birthplace (birthplace_id, country_key, country_name, region_key, region_name, city_key, city_name)
VALUES (16, 2, 'Belarus', 2, 'Minsk Region', 3, 'Slutsk');

INSERT INTO time_t (time_id, year_key, year_name, term_key, term_name)
VALUES (1, 1990, '1990', 1, '1');
INSERT INTO time_t (time_id, year_key, year_name, term_key, term_name)
VALUES (2, 1990, '1990', 2, '2');
INSERT INTO time_t (time_id, year_key, year_name, term_key, term_name)
VALUES (3, 1991, '1991', 1, '1');
INSERT INTO time_t (time_id, year_key, year_name, term_key, term_name)
VALUES (4, 1991, '1991', 2, '2');
INSERT INTO time_t (time_id, year_key, year_name, term_key, term_name)
VALUES (5, 1992, '1992', 1, '1');
INSERT INTO time_t (time_id, year_key, year_name, term_key, term_name)
VALUES (6, 1992, '1992', 2, '2');
INSERT INTO time_t (time_id, year_key, year_name, term_key, term_name)
VALUES (7, 1993, '1993', 1, '1');
INSERT INTO time_t (time_id, year_key, year_name, term_key, term_name)
VALUES (8, 1993, '1993', 2, '2');
INSERT INTO time_t (time_id, year_key, year_name, term_key, term_name)
VALUES (9, 1994, '1994', 1, '1');
INSERT INTO time_t (time_id, year_key, year_name, term_key, term_name)
VALUES (10, 1994, '1994', 2, '2');
INSERT INTO time_t (time_id, year_key, year_name, term_key, term_name)
VALUES (11, 1995, '1995', 1, '1');
INSERT INTO time_t (time_id, year_key, year_name, term_key, term_name)
VALUES (12, 1995, '1995', 2, '2');
INSERT INTO time_t (time_id, year_key, year_name, term_key, term_name)
VALUES (13, 1996, '1996', 1, '1');
INSERT INTO time_t (time_id, year_key, year_name, term_key, term_name)
VALUES (14, 1996, '1996', 2, '2');
INSERT INTO time_t (time_id, year_key, year_name, term_key, term_name)
VALUES (15, 1997, '1997', 1, '1');
INSERT INTO time_t (time_id, year_key, year_name, term_key, term_name)
VALUES (16, 1997, '1997', 2, '2');
INSERT INTO time_t (time_id, year_key, year_name, term_key, term_name)
VALUES (17, 1998, '1998', 1, '1');
INSERT INTO time_t (time_id, year_key, year_name, term_key, term_name)
VALUES (18, 1998, '1998', 2, '2');
INSERT INTO time_t (time_id, year_key, year_name, term_key, term_name)
VALUES (19, 1999, '1999', 1, '1');
INSERT INTO time_t (time_id, year_key, year_name, term_key, term_name)
VALUES (20, 1999, '1999', 2, '2');

INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (1, 2824, 1, 1);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (2, 1409, 1, 2);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (3, 5506, 1, 3);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (4, 5012, 1, 4);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (5, 4657, 1, 5);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (6, 3286, 1, 6);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (7, 2679, 1, 7);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (8, 9935, 1, 8);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (9, 2424, 1, 9);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (10, 7912, 1, 10);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (11, 1520, 1, 11);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (12, 1488, 1, 12);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (13, 2535, 1, 13);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (14, 4582, 1, 14);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (15, 4811, 1, 15);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (16, 9279, 1, 16);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (17, 1434, 1, 17);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (18, 4257, 1, 18);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (19, 9928, 1, 19);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (20, 7873, 1, 20);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (21, 4611, 2, 1);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (22, 8359, 2, 2);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (23, 5557, 2, 3);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (24, 1106, 2, 4);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (25, 3615, 2, 5);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (26, 7924, 2, 6);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (27, 6574, 2, 7);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (28, 5552, 2, 8);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (29, 3547, 2, 9);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (30, 4527, 2, 10);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (31, 6514, 2, 11);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (32, 2674, 2, 12);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (33, 2519, 2, 13);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (34, 7224, 2, 14);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (35, 2584, 2, 15);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (36, 6881, 2, 16);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (37, 6635, 2, 17);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (38, 5333, 2, 18);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (39, 1711, 2, 19);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (40, 8527, 2, 20);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (41, 9785, 3, 1);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (42, 3045, 3, 2);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (43, 7201, 3, 3);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (44, 2291, 3, 4);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (45, 5803, 3, 5);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (46, 6925, 3, 6);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (47, 4150, 3, 7);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (48, 2139, 3, 8);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (49, 1750, 3, 9);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (50, 4733, 3, 10);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (51, 5741, 3, 11);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (52, 2307, 3, 12);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (53, 4814, 3, 13);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (54, 2654, 3, 14);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (55, 7227, 3, 15);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (56, 5554, 3, 16);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (57, 8428, 3, 17);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (58, 6977, 3, 18);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (59, 3664, 3, 19);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (60, 7065, 3, 20);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (61, 6820, 4, 1);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (62, 4432, 4, 2);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (63, 5374, 4, 3);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (64, 2169, 4, 4);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (65, 3803, 4, 5);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (66, 9751, 4, 6);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (67, 5010, 4, 7);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (68, 3677, 4, 8);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (69, 8573, 4, 9);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (70, 7216, 4, 10);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (71, 5422, 4, 11);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (72, 4598, 4, 12);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (73, 6313, 4, 13);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (74, 1916, 4, 14);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (75, 4752, 4, 15);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (76, 1525, 4, 16);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (77, 6168, 4, 17);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (78, 7572, 4, 18);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (79, 5386, 4, 19);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (80, 2084, 4, 20);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (81, 4456, 5, 1);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (82, 6155, 5, 2);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (83, 4483, 5, 3);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (84, 9179, 5, 4);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (85, 7482, 5, 5);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (86, 8517, 5, 6);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (87, 3340, 5, 7);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (88, 5339, 5, 8);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (89, 3287, 5, 9);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (90, 5040, 5, 10);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (91, 9830, 5, 11);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (92, 5304, 5, 12);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (93, 8019, 5, 13);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (94, 7543, 5, 14);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (95, 6930, 5, 15);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (96, 4593, 5, 16);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (97, 3266, 5, 17);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (98, 9348, 5, 18);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (99, 9085, 5, 19);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (100, 2489, 5, 20);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (101, 1771, 6, 1);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (102, 2796, 6, 2);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (103, 3504, 6, 3);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (104, 3621, 6, 4);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (105, 7916, 6, 5);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (106, 2040, 6, 6);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (107, 7304, 6, 7);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (108, 7252, 6, 8);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (109, 8668, 6, 9);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (110, 9669, 6, 10);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (111, 5119, 6, 11);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (112, 1188, 6, 12);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (113, 2876, 6, 13);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (114, 9797, 6, 14);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (115, 5371, 6, 15);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (116, 6573, 6, 16);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (117, 2827, 6, 17);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (118, 5808, 6, 18);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (119, 8123, 6, 19);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (120, 3591, 6, 20);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (121, 8433, 7, 1);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (122, 1053, 7, 2);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (123, 5315, 7, 3);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (124, 9201, 7, 4);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (125, 3927, 7, 5);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (126, 9317, 7, 6);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (127, 2743, 7, 7);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (128, 5889, 7, 8);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (129, 9317, 7, 9);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (130, 4258, 7, 10);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (131, 3504, 7, 11);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (132, 7126, 7, 12);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (133, 3646, 7, 13);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (134, 9837, 7, 14);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (135, 9689, 7, 15);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (136, 1009, 7, 16);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (137, 6310, 7, 17);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (138, 9005, 7, 18);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (139, 1319, 7, 19);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (140, 2832, 7, 20);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (141, 6947, 8, 1);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (142, 6038, 8, 2);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (143, 4923, 8, 3);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (144, 1949, 8, 4);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (145, 4946, 8, 5);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (146, 2290, 8, 6);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (147, 2403, 8, 7);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (148, 8962, 8, 8);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (149, 2133, 8, 9);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (150, 9727, 8, 10);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (151, 3060, 8, 11);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (152, 3103, 8, 12);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (153, 8787, 8, 13);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (154, 3705, 8, 14);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (155, 5342, 8, 15);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (156, 9645, 8, 16);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (157, 7932, 8, 17);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (158, 4470, 8, 18);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (159, 9835, 8, 19);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (160, 4295, 8, 20);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (161, 6107, 9, 1);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (162, 7537, 9, 2);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (163, 7118, 9, 3);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (164, 8177, 9, 4);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (165, 9479, 9, 5);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (166, 8397, 9, 6);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (167, 2982, 9, 7);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (168, 5061, 9, 8);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (169, 4681, 9, 9);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (170, 2049, 9, 10);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (171, 6539, 9, 11);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (172, 1344, 9, 12);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (173, 4770, 9, 13);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (174, 4608, 9, 14);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (175, 1117, 9, 15);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (176, 2163, 9, 16);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (177, 1964, 9, 17);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (178, 4750, 9, 18);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (179, 2104, 9, 19);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (180, 1514, 9, 20);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (181, 6413, 10, 1);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (182, 2160, 10, 2);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (183, 9423, 10, 3);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (184, 4899, 10, 4);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (185, 5562, 10, 5);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (186, 8953, 10, 6);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (187, 4510, 10, 7);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (188, 9834, 10, 8);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (189, 3167, 10, 9);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (190, 8744, 10, 10);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (191, 4981, 10, 11);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (192, 8749, 10, 12);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (193, 7669, 10, 13);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (194, 4119, 10, 14);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (195, 2545, 10, 15);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (196, 2588, 10, 16);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (197, 8062, 10, 17);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (198, 6804, 10, 18);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (199, 7939, 10, 19);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (200, 7735, 10, 20);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (201, 8651, 11, 1);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (202, 1887, 11, 2);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (203, 2612, 11, 3);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (204, 1993, 11, 4);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (205, 7596, 11, 5);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (206, 6559, 11, 6);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (207, 2790, 11, 7);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (208, 5073, 11, 8);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (209, 4139, 11, 9);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (210, 4116, 11, 10);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (211, 9786, 11, 11);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (212, 8350, 11, 12);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (213, 3296, 11, 13);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (214, 7912, 11, 14);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (215, 4006, 11, 15);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (216, 5563, 11, 16);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (217, 8579, 11, 17);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (218, 5092, 11, 18);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (219, 2235, 11, 19);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (220, 8260, 11, 20);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (221, 2604, 12, 1);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (222, 1828, 12, 2);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (223, 9856, 12, 3);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (224, 1241, 12, 4);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (225, 2528, 12, 5);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (226, 4872, 12, 6);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (227, 3724, 12, 7);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (228, 7658, 12, 8);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (229, 8956, 12, 9);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (230, 8886, 12, 10);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (231, 4502, 12, 11);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (232, 7570, 12, 12);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (233, 1960, 12, 13);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (234, 3697, 12, 14);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (235, 7209, 12, 15);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (236, 1035, 12, 16);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (237, 7396, 12, 17);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (238, 5345, 12, 18);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (239, 8454, 12, 19);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (240, 5673, 12, 20);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (241, 7930, 13, 1);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (242, 8973, 13, 2);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (243, 3536, 13, 3);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (244, 4111, 13, 4);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (245, 5861, 13, 5);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (246, 4566, 13, 6);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (247, 1958, 13, 7);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (248, 9883, 13, 8);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (249, 1998, 13, 9);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (250, 6138, 13, 10);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (251, 1936, 13, 11);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (252, 1821, 13, 12);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (253, 8811, 13, 13);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (254, 9238, 13, 14);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (255, 9701, 13, 15);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (256, 3579, 13, 16);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (257, 1931, 13, 17);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (258, 9320, 13, 18);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (259, 2312, 13, 19);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (260, 4044, 13, 20);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (261, 2122, 14, 1);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (262, 2113, 14, 2);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (263, 4853, 14, 3);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (264, 7615, 14, 4);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (265, 2964, 14, 5);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (266, 5033, 14, 6);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (267, 1651, 14, 7);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (268, 2343, 14, 8);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (269, 7868, 14, 9);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (270, 9565, 14, 10);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (271, 6183, 14, 11);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (272, 5272, 14, 12);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (273, 4346, 14, 13);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (274, 6147, 14, 14);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (275, 4910, 14, 15);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (276, 5351, 14, 16);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (277, 7484, 14, 17);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (278, 3144, 14, 18);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (279, 5915, 14, 19);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (280, 8491, 14, 20);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (281, 6180, 15, 1);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (282, 2188, 15, 2);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (283, 1152, 15, 3);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (284, 8508, 15, 4);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (285, 2638, 15, 5);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (286, 2200, 15, 6);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (287, 9808, 15, 7);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (288, 4492, 15, 8);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (289, 9288, 15, 9);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (290, 5345, 15, 10);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (291, 3170, 15, 11);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (292, 6718, 15, 12);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (293, 2127, 15, 13);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (294, 5002, 15, 14);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (295, 7054, 15, 15);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (296, 5669, 15, 16);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (297, 3584, 15, 17);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (298, 8179, 15, 18);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (299, 9900, 15, 19);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (300, 5956, 15, 20);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (301, 9666, 16, 1);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (302, 1128, 16, 2);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (303, 5905, 16, 3);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (304, 2697, 16, 4);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (305, 3200, 16, 5);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (306, 5333, 16, 6);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (307, 2891, 16, 7);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (308, 2753, 16, 8);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (309, 3546, 16, 9);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (310, 5462, 16, 10);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (311, 5616, 16, 11);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (312, 4450, 16, 12);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (313, 6617, 16, 13);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (314, 4335, 16, 14);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (315, 5325, 16, 15);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (316, 9280, 16, 16);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (317, 9004, 16, 17);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (318, 5114, 16, 18);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (319, 1832, 16, 19);
INSERT INTO fact2 (fact2_id, people_count, birthplace_id, time_id)
VALUES (320, 2512, 16, 20);
