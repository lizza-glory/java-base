package com.lizza.StreamApi;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Java 8 Stream API 终止操作
 */
public class AbortOperation {

    /**
     * min - 返回 Stream 中的最小值
     * 练习: 返回薪水最少的员工
     */
    @Test
    public void testMin() {
        List<Employee> employeeList = EmployeeData.getEmployeeList();
        Optional<Employee> minSalaryEmployee = employeeList.stream().min(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(minSalaryEmployee.get());
    }
}
