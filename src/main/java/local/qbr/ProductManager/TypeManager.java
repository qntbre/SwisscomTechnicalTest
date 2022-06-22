package local.qbr.ProductManager;

import java.util.HashMap;
import java.util.Map;

public class TypeManager {
    private Map<Long, Type> types;
    private Long            currId;

    public TypeManager() {
        types = new HashMap<>();
        currId = 0L;
    }

    public boolean addType(String typeName)
    {
        if(!types.keySet().contains(typeName)) {
            types.put(currId, new Type(typeName, currId));
            currId++;
            return true;
        }
        return false;
    }

    public Type getById(Long id)
    {
        return (types.get(id));
    }

    public boolean removeType(Long id)
    {
        return (types.remove(id) != null);
    }

    public Type getByName(String name)
    {
        for (Map.Entry<Long, Type> entry : types.entrySet()) {
            if (name.equals(entry.getValue().getTypename())) {
                return entry.getValue();
            }
        }
        return null;
    }
}
