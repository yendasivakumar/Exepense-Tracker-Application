package com.siva.expensetrackerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siva.expensetrackerapi.entity.Expense;
import com.siva.expensetrackerapi.service.ExpenseService;

@RestController
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/expenses")
	public List<Expense> getAllExpenses() {
		
		List<Expense> list =  expenseService.getAllExpenses();
		
		return list;
	}
	
	@GetMapping("/expenses/{id}")
	public Expense getExpenseId(@PathVariable Long id ) {
		Expense expense = expenseService.getExpenseById(id);
		return expense;
		
	}
	
	@DeleteMapping("/expenses")
	public String deleteExpenseById(@RequestParam Long id) {
		return "Deleting expense with id :"+id;
	}
}
