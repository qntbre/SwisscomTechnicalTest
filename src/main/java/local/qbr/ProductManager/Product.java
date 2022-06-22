package local.qbr.ProductManager;

import java.util.function.LongFunction;

public class Product {
    private String  name;
    private String  description;
    private Long    typeId;
    private Long    stock;

    public Product(Long typeId, String name, String description) {
        this.typeId = typeId;
        this.name = name;
        this.description = description;
        stock = 1L;
    }

    public String getName() {
        return name;
    }

    public Long getTypeId() {
        return typeId;
    }

    public String getDescription() {
        return description;
    }

    public boolean addStock(Long amount)
    {
        stock += amount;
        return (true);
    }

    public boolean removeStock(Long amount)
    {
        if(amount > stock)
            return (false);
        stock -= amount;
        return (true);
    }

    @Override
    public String toString() {
        String json = new String();

        json += "Product{name='" + name + ", ";
        json += "typeId='" + typeId + ", ";
        json += "stock='" + stock + ", ";
        json += "description='" + description + "}";
        return json;
    }

}
