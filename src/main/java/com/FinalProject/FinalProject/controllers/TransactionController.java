package com.FinalProject.FinalProject.controllers;

import com.FinalProject.FinalProject.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static jdk.nashorn.internal.runtime.Debug.id;

@Controller
public class TransactionController {
    @Autowired
    TransactionRepo transactionRepo;


    @RequestMapping(value = "/trans_list")
            public ModelAndView transHome(){
            ModelAndView mv = new ModelAndView("trans");
            mv.addObject("transactionlist", transactionRepo.findAll());
        return mv;
}

    @RequestMapping(value = "/saveTrans", method = RequestMethod.POST) //Save
    public ModelAndView save(@RequestParam("transactionid") String transactionid, @RequestParam("receiptnum") String receiptnum
                            )
    {

        ModelAndView mv = new ModelAndView("redirect:/trans_list");
        Transaction companyToSave ;
        if(!transactionid.isEmpty())
        {
            Optional<Transaction> users = transactionRepo.findById(transactionid);
            companyToSave = users.get();
        }
        else
        {
            companyToSave = new Transaction();
            companyToSave.setTransactionid(UUID.randomUUID().toString());
        }
        companyToSave.setReceiptnum(receiptnum);

        transactionRepo.save(companyToSave);

        mv.addObject("transactionlist", transactionRepo.findAll());
        return mv;
    }

    @RequestMapping (value = "/edittran/{transactionid}", method = RequestMethod.GET) //Edit
    public ModelAndView edittran(@PathVariable("transactionid") String transactionid) {
        ModelAndView mv = new ModelAndView("edittran");
        Optional<Transaction> candle = transactionRepo.findById(transactionid);
        Transaction candleToMap = candle.get();
        mv.addObject("selectedItem", candleToMap);

        return mv;
    }

   /* @RequestMapping(value = "/trans_list"*//*, method = RequestMethod.POST*//*)
    public ModelAndView employeeHome(){
        ModelAndView mv = new ModelAndView("trans");
        mv.addObject("transactionlist", transaction.findAll());
        return mv;
    }*/

   @RequestMapping( value = "/delete/{transactionid}", method = RequestMethod.GET) //Delete
    public ModelAndView delete(@PathVariable("transactionid") String id){
        ModelAndView mv = new ModelAndView("redirect:/trans_list");
        transactionRepo.deleteById(id);
        return mv;

}}
