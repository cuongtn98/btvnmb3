package com.example.demo.Service;

import com.example.demo.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private List<Employee> employeeList;

    public EmployeeService() {
        this.employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,"son",23,"ha noi"));
        employeeList.add(new Employee(2,"cuong",25,"ha noi"));
        employeeList.add(new Employee(3,"dung",26,"ha noi"));

    }
    public List<Employee> findAll(){
        return  employeeList;
    }
    public Employee findEmployeeById(int id){
        for(Employee e: employeeList ){
            if (e.getId()==id){
                return e;
            }
        }
        return null;
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void update(Employee employee){
        int index = employeeList.indexOf(findEmployeeById(employee.getId()));
        employeeList.set(index,employee);
    }

}
