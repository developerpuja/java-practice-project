package com.java.practice.designpattern.prototype;

import java.util.HashMap;
import java.util.Map;

public class VehicleRegistry {
    private static Map<String, Vehicle> map = new HashMap<>();

    static {
        map.put("TWO", new TwoWheeler("120", "SE",20000.20, false) );
        map.put("FOUR", new FourWheeler("120", "POLICE",20000.20, false, true, false) );
    }

    public Vehicle getVehicle(String vehicle) throws CloneNotSupportedException {
        return (Vehicle) map.get(vehicle).clone();
    }
}
