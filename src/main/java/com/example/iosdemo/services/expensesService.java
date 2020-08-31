package com.example.iosdemo.services;

import com.example.iosdemo.controller.IncomeController;
import com.example.iosdemo.dao.IncomeDao;
import com.example.iosdemo.dao.expensesDao;
import com.example.iosdemo.model.Expenses;
import com.example.iosdemo.model.Income;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class expensesService {

    @Autowired
    expensesDao expensesDao;
    //Get All Incomes
    public List<Expenses> getAllExpenses()
    {
        List<Expenses>  expenses = new ArrayList<Expenses>();
        expenses= (List<Expenses>) expensesDao.findAll();
        return expenses;
    }

    public void saveOrUpdate(Expenses expenses)
    {
        expensesDao.save(expenses);
    }



}
