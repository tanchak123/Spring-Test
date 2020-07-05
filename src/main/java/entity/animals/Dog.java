package entity.animals;

import org.springframework.stereotype.Component;

@Component
public class Dog {

    String name = "NoName";

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
