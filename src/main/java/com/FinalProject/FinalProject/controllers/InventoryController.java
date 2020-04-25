package com.FinalProject.FinalProject.controllers;

import com.FinalProject.FinalProject.Models.EmployeeRepo;
import com.FinalProject.FinalProject.Models.Inventory;
import com.FinalProject.FinalProject.Models.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class InventoryController {
   @Autowired
   InventoryRepo inventoryRepo;


   @RequestMapping(value = "/invent_list") //list
    public ModelAndView inventoryHome(){
        ModelAndView mv = new ModelAndView("invent");
        mv.addObject("inventorylist", inventoryRepo.findAll());
        return mv;
    }
@RequestMapping( value = "/search") //search bar
public ModelAndView search(@RequestParam("inventoryid") String inventoryid, @RequestParam("description") String description,
                           @RequestParam("price") String price){

   ModelAndView mv = new ModelAndView("redirect:/invent_list");
    inventoryRepo.findAll();
    return mv;
}/*
    @RequestMapping(value = "/search",method=RequestMethod.POST)

    public String findAllByInternship(@RequestParam(value="inventoryid", required=false)String inventoryid,
                                      ModelMap modelMap, HttpServletRequest request)
    {
        List<Inventory> user =  inventoryRepo.findAllByInventory(inventoryid);
        modelMap.addAttribute("inventoryid", inventoryid);
        request.setAttribute("mode", "ALL_USERS");
        ModelAndView mv = new ModelAndView("redirect:/invent_list");
        return mv;
    }

    @RequestMapping( value = "/delete/{id}", method = RequestMethod.GET) //Delete
    public ModelAndView delete(@PathVariable("id") String id){
        ModelAndView mv = new ModelAndView("redirect:/invent_list");
        inventoryRepo.deleteById(id);
        return mv;
    }
*/
    @RequestMapping(value = "/save", method = RequestMethod.POST) //Save
        public ModelAndView save(@RequestParam("inventoryid") String inventoryid, @RequestParam("description") String description,
            @RequestParam("price") String price)
        {

            ModelAndView mv = new ModelAndView("redirect:/invent_list");
            Inventory companyToSave ;
            if(!inventoryid.isEmpty())
            {
                Optional<Inventory> users = inventoryRepo.findById(inventoryid);
                companyToSave = users.get();
            }
            else
            {
                companyToSave = new Inventory();
                companyToSave.setInventoryid(UUID.randomUUID().toString());
            }
            companyToSave.setDescription(description);
            companyToSave.setPrice(price);
            inventoryRepo.save(companyToSave);

        mv.addObject("inventorylist", inventoryRepo.findAll());
        return mv;
    }


    @RequestMapping (value = "/edit/{inventoryid}", method = RequestMethod.GET) //Edit
    public ModelAndView edit(@PathVariable("inventoryid") String Inventoryid) {
        ModelAndView mv = new ModelAndView("edit");
        Optional<Inventory> candle = inventoryRepo.findById(Inventoryid);
        Inventory candleToMap = candle.get();
        mv.addObject("selectedItem", candleToMap);

        return mv;
    }

    @RequestMapping( value = "/delete_invent/{id}", method = RequestMethod.GET) //Delete
    public ModelAndView delete(@PathVariable("id") String id){
        ModelAndView mv = new ModelAndView("redirect:/invent_list");
        inventoryRepo.deleteById(id);
        return mv;
    }


}
