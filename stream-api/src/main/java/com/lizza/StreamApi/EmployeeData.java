package com.lizza.StreamApi;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {

    public static List<Employee> getEmployeeList() {
        List<Employee> list = new ArrayList<Employee>(){{
            add(new Employee(1001, "马云", 34, 9876.12));
            add(new Employee(1002, "马化腾", 32, 5876.12));
            add(new Employee(1003, "比尔盖茨", 12, 976.12));
            add(new Employee(1004, "扎克伯格", 45, 3400.11));
            add(new Employee(1005, "任正非", 56, 10876.12));
            add(new Employee(1006, "雷军", 26, 4006.87));
            add(new Employee(1007, "马斯克", 20, 1876.02));
            add(new Employee(1008, "刘强东", 39, 6876.00));
        }};
        return list;
    }
}
