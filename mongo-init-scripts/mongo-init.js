db.createUser(
        {
            user: "item-user",
            pwd: "item-user-pass",
            roles: [
                {
                    role: "readWrite",
                    db: "item"
                }
            ]
        }
);

db.ItemEntity.insert({
    name: "name1"
});

db.ItemCategoryEntity.insert({
    id: "1",
    originEntity: {
        originId: 1,
        name: "shoe"
    }
});



