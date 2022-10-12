package com.siva.expensetrackerapi.service;


import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.siva.expensetrackerapi.entity.Expense;
import com.siva.expensetrackerapi.exceptions.ResourceNotFoundException;

public interface ExpenseService {
	
	public Page<Expense> getAllExpenses(Pageable page);
	
	public Expense getExpenseById(Long id) throws ResourceNotFoundException;
	
	public void deleteExpenseById(Long id);
	
	public Expense saveExpenseDetails(Expense expense);
	
	public Expense updateExpenseDetails(Long id,Expense expense);
	
	public List<Expense> readByCategory(String category,Pageable page);
	
	public List<Expense> readByName(String name,Pageable page);
	
	public List<Expense> readByDate(Date startDate,Date endDate,Pageable page);
 }
