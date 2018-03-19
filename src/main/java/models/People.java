package models;

public class People {
    private int id;
    private String handle;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", handle='" + handle + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public People(){}

    public People(int id, String handle, String name) {
        this.id = id;
        this.handle = handle;
        this.name = name;
    }

}
