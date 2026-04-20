package org.example;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class History {

    private final Database database;
    private final Map<Item, LocalDateTime> visualizations = new HashMap<>();

    public History(Database database) {
        this.database = database;
    }

    public void register(Long itemId) {
        var opItem = database.getItemById(itemId);
        if (opItem.isEmpty()) {
            System.out.println("Item not found: " + itemId);
            return;
        }
        var item = opItem.get();
        LocalDateTime now = LocalDateTime.now();
        visualizations.put(item, now);
        System.out.printf("'%s' visualized in '%s'\n", item.getName(), now);
    }

    public void listVisualizedItems() {
        visualizations.forEach((k, v) -> {
            System.out.printf("- %s em %s\n", k.getName(), v);
        });
    }
}
