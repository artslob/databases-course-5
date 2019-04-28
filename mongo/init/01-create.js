conn = new Mongo();
db = conn.getDB("uni");

db.person.insertMany([
    {
        id: 191950,
        name: "ivan",
        surname: "ivanov",
        middle_name: "petrovich",
        study_type: "бюджет" // Вид обучения -- бюджет/контракт
    }
]);

// общежитие
db.hostel.insertMany([
    {
        id: 6,
        address: "Белорусская улица, д. 6",  // Местоположение -- пер. Вяземский, наб. р. Карповки
        rooms: 900,                          // Количество комнат в здании
    }
]);

// комната
db.room.insertMany([
    {
        id: 309,
        hostel_id: 6,       /* -> hostel */
        room_number: 1408,  // Номер комнаты
        capacity: 3,        // Комната -- на 3 человека
        payment: 1030,      // Сумма оплаты
        insects: false,     // Клопы -- Y/N
        disinfection: [     // Когда проводили дезинфекцию дата
            new Date("2014-01-24"),
            new Date("2015-12-20"),
        ]
    }
]);

// проживание
db.accommodation.insertMany([
    {
        person_id: 191950,             /* -> person */
        room_no: 309,                  /* -> room */     // по этому полю можно понять, сколько человек живёт в комнате
        from: new Date("2014-09-01"),  // Период с/по -- Живёт со 2 курса, то есть 01.09.2001-31.08.2002 2 курс
        to: new Date("2015-05-31"),
        exemption: false,              // льготы -- Y/N
        warnings: [                    // Предупреждения -- 1, 2, ...
            {
                date: new Date("2014-12-31"),
                text: "хулиганил"
            },
            {
                date: new Date("2015-01-01"),
                text: "состояние алкогольного опьянения"
            },
        ],
    }
]);

// посещение -- зашёл в общежитие/вышел из общежития
db.visit.insertMany([
    {
        person_id: 191950,  /* -> person */
        hostel_id: 6,       /* -> hostel */
        inside: new Date("2014-09-01"),
        outside: null,
    },
    {
        person_id: 191950,
        hostel_id: 6,
        inside: null,
        outside: new Date("2014-09-03"),
    },
]);

cursor = db.person.find();
while (cursor.hasNext()) {
    printjson(cursor.next());
}
