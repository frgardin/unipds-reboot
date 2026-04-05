package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Database {
    
    public List<Item> listOfItems() {
        var result = new ArrayList<Item>();

        IntStream.range(0, 100)
            .forEach(id -> result.add(createNewItem((long)id)));

        return result;
    }

    private static Item createNewItem(Long id) {

        Item item = new Item();
        item.setId(id);
        item.setName("Item name " + id);
        item.setType(id % 2 == 0 ? ItemType.TYPE_2 : ItemType.TYPE_1);
        ItemAttribute itemAttribute1 = new ItemAttribute();
        itemAttribute1.setAttribute1("1");
        ItemAttribute itemAttribute2 = new ItemAttribute();
        itemAttribute2.setAttribute2("2");
        item.setAttributes(List.of(itemAttribute1, itemAttribute2));

        return item;
    }
}
