package com.FinalProject.FinalProject.controllers;

import com.FinalProject.FinalProject.Models.CustomerRepo;
import com.FinalProject.FinalProject.Models.Employee;
import com.FinalProject.FinalProject.Models.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class MainController {}

   /* @Autowired
    CustomerRepo customerRepo;
    //EmployeeRepo employeeRepo;

    @RequestMapping("/")
    public ModelAndView doHome(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("customerlist", customerRepo.findAll());
       // mv.addObject("employeelist", employeeRepo.findAll());
        return mv;
    }*/

   /* @RequestMapping(value = "/emp_list", method = RequestMethod.POST)
    public ModelAndView employeeHome(){
   *//*     Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return"emp";
        *//*
      ModelAndView mv = new ModelAndView("emp");
        mv.addObject("employeelist", employeeRepo.findAll());
        return mv;
    }
*/