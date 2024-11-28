package models;

public class User {
    private static int nextId = 1;
    private int id;
    private String name;

    public User(String name) {
        this.id = nextId++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("User[ID=%d, Name='%s']", id, name);
    }
}
