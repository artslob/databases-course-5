conn = new Mongo();
db = conn.getDB("uni");

db.person.insertMany([
    {
        id: 191950,
        name: "Ivan",
        surname: "Ivanov",
        middle_name: "Ivanovich",
        study_type: "budget" // Вид обучения -- бюджет/контракт
    },
    {id: 191951, name: 'Fedor', surname: 'Fedorov', middle_name: 'Fedorovich', study_type: 'budget'},
    {id: 191952, name: 'Aleksey', surname: 'Alekseev', middle_name: 'Alekseevich', study_type: 'budget'},
    {id: 75950, name: 'Dmitriy', surname: 'Dmitriev', middle_name: 'Dmitrievich', study_type: 'budget'},
    {id: 75951, name: 'Artem', surname: 'Artemiev', middle_name: 'Artemievich', study_type: 'budget'},
    {id: 75952, name: 'Kirill', surname: 'Kirillov', middle_name: 'Kirillovich', study_type: 'budget'}
]);

// общежитие
db.hostel.insertMany([
    {
        id: 1,
        address: 'пер. Вяземский, д. 5/7',  // Местоположение -- пер. Вяземский, наб. р. Карповки
        rooms: 1320                        // Количество комнат в здании
    },
    {id: 2, address: 'ул. Ленсовета, д. 23', rooms: 1035},
    {id: 3, address: 'Альпийский пер., д.15, к. 2', rooms: 650},
    {id: 4, address: 'Белорусская улица, д. 6', rooms: 900}
]);

// комната
db.room.insertMany([
    {
        id: 309,
        hostel_id: 1,       /* -> hostel */
        room_number: 1408,  // Номер комнаты
        capacity: 3,        // Комната -- на 3 человека
        payment: 1030,      // Сумма оплаты
        insects: false,     // Клопы -- Y/N
        disinfection: [     // Когда проводили дезинфекцию дата
            {disinfection_id: 100, date: new Date("2014-01-24")},
            {disinfection_id: 101, date: new Date("2015-12-20")}
        ]
    },
    {id: 310, hostel_id: 1, room_number: 1409, capacity: 3, payment: 1030, insects: false, disinfection: []},
    {id: 500, hostel_id: 2, room_number: 901, capacity: 4, payment: 1500, insects: true, disinfection: []},
    {id: 501, hostel_id: 2, room_number: 902, capacity: 4, payment: 1500, insects: true, disinfection: []},
    {id: 700, hostel_id: 3, room_number: 901, capacity: 5, payment: 500, insects: false, disinfection: []},
    {id: 701, hostel_id: 3, room_number: 902, capacity: 5, payment: 500, insects: false, disinfection: []},
    {id: 900, hostel_id: 4, room_number: 1201, capacity: 2, payment: 1230, insects: false, disinfection: []},
    {id: 901, hostel_id: 4, room_number: 1202, capacity: 2, payment: 1230, insects: false, disinfection: []}
]);

// проживание
db.accommodation.insertMany([
    {
        id: 200,
        person_id: 191950,             /* -> person */
        room_id: 309,                  /* -> room */     // по этому полю можно понять, сколько человек живёт в комнате
        from: new Date("2014-09-01"),  // Период с/по -- Живёт со 2 курса, то есть 01.09.2001-31.08.2002 2 курс
        to: new Date("2015-05-31"),
        exemption: false,              // льготы -- Y/N
        warnings: [                    // Предупреждения -- 1, 2, ...
            {
                warning_id: 111,
                date: new Date("2014-12-31"),
                text: "хулиганил"
            },
            {
                warning_id: 112,
                date: new Date("2015-01-01"),
                text: "состояние алкогольного опьянения"
            }
        ]
    },
    {id: 201, person_id: 191951, room_id: 309, from: new Date("2014-09-01"), to: null, exemption: false, warnings: []},
    {id: 202, person_id: 191952, room_id: 309, from: new Date("2014-09-01"), to: null, exemption: false, warnings: []}
]);

// посещение -- зашёл в общежитие/вышел из общежития
db.visit.insertMany([
    {
        id: 400,
        person_id: 191950,  /* -> person */
        hostel_id: 6,       /* -> hostel */
        inside: new Date("2014-09-01"),
        outside: null
    },
    {
        id: 401,
        person_id: 191950,
        hostel_id: 6,
        inside: null,
        outside: new Date("2014-09-03")
    }
]);

cursor = db.person.find();
if (cursor.hasNext()) {
    printjson(cursor.next());
}
