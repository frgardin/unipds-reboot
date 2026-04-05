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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((attributes == null) ? 0 : attributes.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (type != other.type)
            return false;
        if (attributes == null) {
            if (other.attributes != null)
                return false;
        } else if (!attributes.equals(other.attributes))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + ", type=" + type + ", attributes=" + attributes + "]";
    }
}
