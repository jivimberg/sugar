package me.jivimberg.android.sugartestapp.model.entities.extended;

import com.orm.SugarRecord;

import me.jivimberg.android.sugartestapp.model.entities.SugarEntity;

public class UnderlinedPropertyNameExtended extends SugarRecord implements SugarEntity {
    private String car_name;

    public UnderlinedPropertyNameExtended(){

    }

    public UnderlinedPropertyNameExtended(String car_name) {
        this.car_name = car_name;
    }

    public String getName() {
        return car_name;
    }

    public void setName(String car_name) {
        this.car_name = car_name;
    }
}