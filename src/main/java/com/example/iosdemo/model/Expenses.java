package com.example.iosdemo.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Expenses {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private Date expensesDate;
    private String  whereTo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getExpensesDate() {
        return expensesDate;
    }

    public void setExpensesDate(Date expensesDate) {
        this.expensesDate = expensesDate;
    }

    public String getWhereTo() {
        return whereTo;
    }

    public void setWhereTo(String whereTo) {
        this.whereTo = whereTo;
    }



    public Expenses() {
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "id=" + id +
                ", amount=" + amount +
                ", expensesDate=" + expensesDate +
                ", whereTo='" + whereTo + '\'' +
                '}';
    }
}
