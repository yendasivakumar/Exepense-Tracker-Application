package com.siva.expensetrackerapi.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.siva.expensetrackerapi.entity.Expense;

public interface ExpenseService {
	
	public Page<Expense> getAllExpenses(Pageable page);
	
	public Expense getExpenseById(Long id);
	
	public void deleteExpenseById(Long id);
	
	public Expense saveExpenseDetails(Expense expense);
	
	public Expense updateExpenseDetails(Long id,Expense expense);
}
