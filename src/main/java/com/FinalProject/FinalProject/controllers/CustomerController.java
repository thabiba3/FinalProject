package com.FinalProject.FinalProject.controllers;

import com.FinalProject.FinalProject.Models.Customer;
import com.FinalProject.FinalProject.Models.CustomerRepo;
import com.FinalProject.FinalProject.Models.Employee;
import com.FinalProject.FinalProject.Models.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.UUID;

@Controller
public class CustomerController {
    @Autowired
    CustomerRepo customerRepo;

    @RequestMapping("/cust_list")
    public ModelAndView doHome(){
        ModelAndView mv = new ModelAndView("cust");
        mv.addObject("customerlist", customerRepo.findAll());
        // mv.addObject("employeelist", employeeRepo.findAll());
        return mv;
    }

    @RequestMapping( value = "/deleteCust/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") String id){
        ModelAndView mv = new ModelAndView("redirect:/cust_list");
        customerRepo.deleteById(id);
        return mv;
    }


    @RequestMapping(value = "/save_cust", method = RequestMethod.POST) //Save
    public ModelAndView save(@RequestParam("customerid") String customerid, @RequestParam("firstname") String firstname,
                             @RequestParam("lastname") String lastname, @RequestParam("phonenumber") String phonenumber)
    {

        ModelAndView mv = new ModelAndView("redirect:/cust_list");
        Customer CustomerToSave ;
        if(!customerid.isEmpty())
        {
            Optional<Customer> users = customerRepo.findById(customerid);
            CustomerToSave = users.get();
        }
        else
        {
            CustomerToSave = new Customer();
            CustomerToSave.setCustomerid(UUID.randomUUID().toString());
        }
        CustomerToSave.setFirstname(firstname);
        CustomerToSave.setLastname(lastname);
        CustomerToSave.setPhonenumber(phonenumber);
        customerRepo.save(CustomerToSave);
        // mv.addObject("employeelist", employeesRepo.findAll());

        mv.addObject("customerlist", customerRepo.findAll());
        return mv;
    }

  /*  @RequestMapping (value = "/editcust/{id}", method = RequestMethod.GET) //Edit
    public ModelAndView edit(@PathVariable("id") String customerid) {
        ModelAndView mv = new ModelAndView("editcust");
        Optional<Customer> candle = customerRepo.findById(customerid);
        Customer candleToMap = candle.get();
        mv.addObject("selectedItem", candleToMap);

        return mv;
    }*/


  @RequestMapping (value = "/editcust/{customerid}", method = RequestMethod.GET) //Edit
  public ModelAndView editcust(@PathVariable("customerid") String customerid) {
      ModelAndView mv = new ModelAndView("editcust");
      Optional<Customer> candle = customerRepo.findById(customerid);
      Customer candleToMap = candle.get();
      mv.addObject("selectedItem", candleToMap);

      return mv;
  }

}