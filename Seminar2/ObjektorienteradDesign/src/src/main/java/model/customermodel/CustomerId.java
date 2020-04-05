package model.customermodel;

public class CustomerId {
    String name;
    String id;

    public CustomerId(String name, String id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
