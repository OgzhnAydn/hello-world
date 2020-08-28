package com.example.iosdemo.controller;

import com.example.iosdemo.model.Expenses;
import com.example.iosdemo.model.Income;
import com.example.iosdemo.services.IncomeServices;
import com.example.iosdemo.services.expensesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class expensesController {


    private static final Logger logger = LogManager.getLogger(IncomeController.class);
    private List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);


    @Autowired
    expensesService expensesService;
    @CrossOrigin
    @PostMapping("saveExpenses")
    private ResponseEntity<Income> saveExpenses(@RequestBody Expenses expenses){
         expensesService.saveOrUpdate(expenses);
         System.out.println("incomeServices.getAllIncome() = " + expenses.getId());
         logger.info("Save  Expenses Operation",expenses.getId());
         return new ResponseEntity(expenses.getId(), HttpStatus.OK) ;



    }

        @GetMapping("getAllExpenses")
        @CrossOrigin
    ResponseEntity<Income> getAllExpenses()
    {


        if (expensesService.getAllExpenses().size()!=0) {
            return new ResponseEntity(expensesService.getAllExpenses(), HttpStatus.OK);
        }
         return new ResponseEntity(HttpStatus.FOUND);



    }
}
