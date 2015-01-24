package me.jivimberg.android.sugartestapp.model.annotated;

import com.orm.dsl.NotNull;
import com.orm.dsl.Table;

@Table(name = "Contact")
public final class Contact {

    @NotNull private String name;
    @NotNull private int age;
    @NotNull private float weight;
    @NotNull private double height;
    @NotNull private boolean isVIP;

    public Contact(String name, int age, float weight, double height, boolean isVIP) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.isVIP = isVIP;
    }

    public Contact(){

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public boolean isVIP() {
        return isVIP;
    }
}
