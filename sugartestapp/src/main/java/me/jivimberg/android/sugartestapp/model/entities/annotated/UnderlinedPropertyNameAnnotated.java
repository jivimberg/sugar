package me.jivimberg.android.sugartestapp.model.entities.annotated;

import com.orm.dsl.Table;

import me.jivimberg.android.sugartestapp.model.entities.SugarEntity;

// Issue #213
@Table(name = "car")
public class UnderlinedPropertyNameAnnotated implements SugarEntity {
    private String car_name;

    public UnderlinedPropertyNameAnnotated(){

    }

    public UnderlinedPropertyNameAnnotated(String car_name) {
        this.car_name = car_name;
    }

    public String getName() {
        return car_name;
    }

    public void setName(String car_name) {
        this.car_name = car_name;
    }
}