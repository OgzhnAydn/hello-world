package com.example.iosdemo.dao;

import com.example.iosdemo.model.Expenses;
import com.example.iosdemo.model.Income;
import org.springframework.data.repository.CrudRepository;

public interface expensesDao extends CrudRepository<Expenses,Long> {
}
