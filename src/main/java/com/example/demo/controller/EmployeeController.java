package com.example.demo.controller;

import com.example.demo.Service.EmployeeService;
import com.example.demo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/home")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController() {
        employeeService = new EmployeeService();
    }
    @GetMapping
    public String display(Model model){
        model.addAttribute("employees",employeeService.findAll());
        return "/view/display";
    }
@GetMapping("/create")
    public String create(){
        return "/view/create";
}
@PostMapping("/createEmp")
public String createEmp(HttpServletRequest request, Model model){
        int id;
if (employeeService.findAll().isEmpty()){
    id = 1;
}else {
    id = employeeService.findAll().get(employeeService.findAll().size() -1).getId()+1;
}
String name = request.getParameter("name");
int age = Integer.parseInt(request.getParameter("age"));
String address = request.getParameter("address");
employeeService.addEmployee(new Employee(id,name,age,address));
    model.addAttribute("employees",employeeService.findAll());
    return "/view/display";
}
@GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model){
        employeeService.findAll().remove(employeeService.findEmployeeById(id));
    model.addAttribute("employees",employeeService.findAll());
    return "/view/display";
}
@GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model){
        Employee employee = employeeService.findEmployeeById(id);
        model.addAttribute("emp",employee);
    return "/view/update";
}
@PostMapping("/updateEmp/{id}")
public String updateEmp(@PathVariable int id,HttpServletRequest request, Model model){
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));
    String address = request.getParameter("address");
    Employee employee = new Employee(id,name,age,address);
    employeeService.update(employee);
    model.addAttribute("employees",employeeService.findAll());
    return "/view/display";
}
}
