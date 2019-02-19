package hu.codecool.flatium.flatmanager.person;

public abstract class Person {
    private int id;
    private static int idCounter = 0;
    private String name;
    private String phoneNumber;
    private String email;

    public Person() {
    }

    public Person(String name, String phoneNumber, String email) {
        this.id = idCounter++;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
