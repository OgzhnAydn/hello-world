package com.example.iosdemo.dao;

import com.example.iosdemo.model.Income;
import org.springframework.data.repository.CrudRepository;

public interface IncomeDao extends CrudRepository<Income,Long> {
}
