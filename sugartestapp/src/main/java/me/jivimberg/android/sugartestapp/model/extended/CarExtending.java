package me.jivimberg.android.sugartestapp.model.extended;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

public class CarExtending extends SugarRecord {
    private String car_name;

    public CarExtending(){

    }

    public CarExtending(String car_name) {
        this.car_name = car_name;
    }

    public String getName() {
        return car_name;
    }

    public void setName(String car_name) {
        this.car_name = car_name;
    }
}