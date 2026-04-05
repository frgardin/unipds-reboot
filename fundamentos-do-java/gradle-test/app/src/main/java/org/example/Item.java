package org.example;

import java.util.List;

public class Item {
    private Long id;
    private String name;
    private ItemType type;
    private List<ItemAttribute>attributes;
    public Item() {
    }
    public Item(Long id, String name, ItemType type, List<ItemAttribute> attributes) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.attributes = attributes;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ItemType getType() {
        return type;
    }
    public void setType(ItemType type) {
        this.type = type;
    }
    public List<ItemAttribute> getAttributes() {
        return attributes;
    }
    public void setAttributes(List<ItemAttribute> attributes) {
        this.attributes = attributes;
    }
    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + ", type=" + type + ", attributes=" + attributes + "]";
    }
}
