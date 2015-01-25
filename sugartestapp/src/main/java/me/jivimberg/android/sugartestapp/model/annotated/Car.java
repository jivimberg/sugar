package me.jivimberg.android.sugartestapp.model.annotated;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

@Table(name = "car")
public class Car {
    private String car_name;

    public Car(){

    }

    public Car(String car_name) {
        this.car_name = car_name;
    }

    public String getName() {
        return car_name;
    }

    public void setName(String car_name) {
        this.car_name = car_name;
    }
}