package org.example;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Database {

    private final int size;

    private final Map<Long, Item> itemsMap;

    private Database() {
        throw new IllegalAccessError();
    }

    public Database(int size) {
        this.size = size;
        itemsMap = LongStream.range(0, size)
                .mapToObj(Database::createNewItem)
                .collect(Collectors.toMap(Item::getId, Function.identity()));
    }

    public List<Item> listOfItems() {
        return itemsMap.values().stream().toList();
    }

    public Optional<Item> getItemById(Long id) {
        return itemsMap.containsKey(id) ? Optional.of(itemsMap.get(id)) : Optional.empty();
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
