package local.qbr.ProductManager;

/*
	This is in another class because if it was actually a DB,
	We would want to try not to much repetitive data
 */

public class Type {
    private String  typename;
    private Long    id;
    public Type(String typename, Long id) {
        this.typename = typename;
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Type{" + "id=" + id + ", typename='" + typename + '\'' + '}';
    }
}
