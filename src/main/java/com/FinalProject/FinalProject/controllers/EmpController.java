package com.FinalProject.FinalProject.controllers;

import com.FinalProject.FinalProject.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.UUID;

import static jdk.nashorn.internal.runtime.Debug.id;

@Controller
public class EmpController {

    @Autowired
    EmployeeRepo employeeRepo;


    @RequestMapping(value = "/emp_list")
    public ModelAndView employeeHome(){
        ModelAndView mv = new ModelAndView("emp");
        mv.addObject("employeelist", employeeRepo.findAll());
        return mv;
    }

    @RequestMapping( value = "/deleteEmp/{id}", method = RequestMethod.GET) //Delete
    public ModelAndView delete(@PathVariable("id") String id){
        ModelAndView mv = new ModelAndView("redirect:/emp_list");
        employeeRepo.deleteById(id);
        return mv;
    }

    @RequestMapping(value = "/save_emp", method = RequestMethod.POST) //Save
    public ModelAndView save(@RequestParam("employeeid") String employeeid, @RequestParam("firstname") String firstname,
                             @RequestParam("lastname") String lastname, @RequestParam("phonenumber") String phonenumber,
                             @RequestParam("email") String email)
    {

        ModelAndView mv = new ModelAndView("redirect:/emp_list");
        Employee CustomerToSave ;
        if(!employeeid.isEmpty())
        {
            Optional<Employee> users = employeeRepo.findById(employeeid);
            CustomerToSave = users.get();
        }
        else
        {
            CustomerToSave = new Employee();
            CustomerToSave.setEmployeeid(UUID.randomUUID().toString());
        }
        CustomerToSave.setFirstname(firstname);
        CustomerToSave.setLastname(lastname);
        CustomerToSave.setPhonenumber(phonenumber);
        CustomerToSave.setEmail(email);
        employeeRepo.save(CustomerToSave);

        mv.addObject("employeelist", employeeRepo.findAll());
        return mv;
    }

    @RequestMapping (value = "/editemp/{employeeid}", method = RequestMethod.GET) //Edit
    public ModelAndView edit(@PathVariable("employeeid") String employeeid) {
        ModelAndView mv = new ModelAndView("editemp");
        Optional<Employee> candle = employeeRepo.findById(employeeid);
        Employee candleToMap = candle.get();
        mv.addObject("selectedItem", candleToMap);

        return mv;
    }
}
