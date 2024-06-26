package models;

import java.util.Random;

public class User {
    private Long id;
    private String name;

    public User(String name) {
        Random random = new Random();
        this.id = random.nextLong();
        this.name = name;
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
}
