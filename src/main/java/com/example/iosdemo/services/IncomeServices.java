package com.example.iosdemo.services;

import com.example.iosdemo.dao.IncomeDao;
import com.example.iosdemo.model.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncomeServices {
    @Autowired
    IncomeDao incomeDao;
    //Get All Incomes
    public List<Income> getAllIncome()
    {
        List<Income> incomes = new ArrayList<Income>();
        incomeDao.findAll().forEach(income -> incomes.add(income));
        return  incomes;
    }
    public void saveOrUpdate(Income income)
    {
        incomeDao.save(income);
    }



}
