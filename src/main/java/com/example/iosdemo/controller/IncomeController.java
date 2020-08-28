package com.example.iosdemo.controller;
import com.example.iosdemo.dao.IncomeDao;
import com.example.iosdemo.model.Income;
import com.example.iosdemo.services.IncomeServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class IncomeController {


    //Log4J2LoggingSystem getLogger=Log4J2LoggingSystem.get(Logging.)
    //Logger logger = LoggerFactory.getLogger(LoggingController.class);
    private static final Logger logger = LogManager.getLogger(IncomeController.class);
    private List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);


    @Autowired
    IncomeServices incomeServices;
    @CrossOrigin
    @PostMapping("saveIncomes")
    private  ResponseEntity<Income> saveIncome(@RequestBody Income income){
        incomeServices.saveOrUpdate(income);
        System.out.println("incomeServices.getAllIncome() = " + income.getId());
        logger.info("Save  Income Operation",income.getId());
        return new ResponseEntity(income.getId(),HttpStatus.OK) ;



    }

   //TODO get all incomex"
}
