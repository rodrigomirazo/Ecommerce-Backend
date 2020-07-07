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

db.ItemCategoryMultiLevel.insert({
    categoryId: 1,
    categoryParentId: null,
    categoryChildId: 2,
    itemTypeId: "shoe",
    catLevelId: 1
});

db.ItemCategoryMultiLevel.insert({
    categoryId: 2,
    categoryParentId: 1,
    categoryChildId: 3,
    itemTypeId: "shoe",
    catLevelId: 2
});

db.ItemCategoryMultiLevel.insert({
    categoryId: 3,
    categoryParentId: 2,
    categoryChildId: null,
    itemTypeId: "shoe",
    catLevelId: 3
});

db.ItemCategoryMultiLevel.insert({
    categoryId: 4,
    categoryParentId: null,
    categoryChildId: 5,
    itemTypeId: "clothe",
    catLevelId: 1
});

db.ItemCategoryMultiLevel.insert({
    categoryId: 5,
    categoryParentId: 4,
    categoryChildId: 6,
    itemTypeId: "clothe",
    catLevelId: 2
});

db.ItemCategoryMultiLevel.insert({
    categoryId: 6,
    categoryParentId: 5,
    categoryChildId: null,
    itemTypeId: "clothe",
    catLevelId: 3
});

db.ItemCategoryMultiLevel.insert({
    categoryId: 6,
    categoryParentId: null,
    categoryChildId: 5,
    itemTypeId: "accesory",
    catLevelId: 1
});

db.ItemCategoryMultiLevel.insert({
    categoryId: 7,
    categoryParentId: 6,
    categoryChildId: 6,
    itemTypeId: "accesory",
    catLevelId: 2
});

db.ItemCategoryMultiLevel.insert({
    categoryId: 8,
    categoryParentId: 7,
    categoryChildId: null,
    itemTypeId: "accesory",
    catLevelId: 3
});

