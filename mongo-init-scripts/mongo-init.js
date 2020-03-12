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

db.item.insert({
    name: "name1"
})

