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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (age != contact.age) return false;
        if (Double.compare(contact.height, height) != 0) return false;
        if (isVIP != contact.isVIP) return false;
        if (Float.compare(contact.weight, weight) != 0) return false;
        if (name != null ? !name.equals(contact.name) : contact.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (weight != +0.0f ? Float.floatToIntBits(weight) : 0);
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isVIP ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", isVIP=" + isVIP +
                '}';
    }
}
