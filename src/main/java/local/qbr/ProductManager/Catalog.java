package local.qbr.ProductManager;

import java.util.HashMap;
import java.util.Map;

public class Catalog {
    private Map<Long, Product>  products;
    private TypeManager         tm;
    private Long                currId;

    public Catalog() {
        products = new HashMap<>();
        tm = new TypeManager();
        currId = 0L;
    }

    public boolean addProduct(String type, String name, String desc)
    {
        Type typeEntity = tm.getByName(type);

        if(typeEntity == null)
            tm.addType(type);
        products.put(currId, new Product(tm.getByName(type).getId(), name, desc));
        currId++;
        return (true);
    }

    public boolean addProduct(Product product)
    {
        Type typeEntity = tm.getById(product.getTypeId());

        if(typeEntity == null)
            return false;
        products.put(currId, new Product(typeEntity.getId(), product.getName(), product.getDescription()));
        System.out.println("Added new Product (id " + currId + ")");
        currId++;
        return (true);
    }

    public boolean addType(String typename)
    {
        return (tm.addType(typename));
    }

    //Could use exception handling here for example
    public boolean addStock(Long id, Long amount)
    {
        Product pro = products.get(id);

        if(pro == null)
            return (false);
        return (pro.addStock(amount));
    }

    public boolean removeStock(Long id, Long amount)
    {
        Product pro = products.get(id);

        if(pro == null)
            return (false);
        return (pro.removeStock(amount));
    }

    public boolean removeProduct(Long id)
    {
        return (products.remove(id) != null);
    }

    public Product getById(Long id)
    {
        return products.get(id);
    }
}
