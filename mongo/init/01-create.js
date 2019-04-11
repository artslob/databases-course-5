conn = new Mongo();
db = conn.getDB("uni");
db.testCollection.insertOne({x: "test value"});
cursor = db.testCollection.find();
while (cursor.hasNext()) {
    printjson(cursor.next());
}
