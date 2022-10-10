package com.siva.expensetrackerapi.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siva.expensetrackerapi.entity.Expense;
import com.siva.expensetrackerapi.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService{

	@Autowired
	private ExpenseRepository expenseRepo;
	
	@Override
	public List<Expense> getAllExpenses() {
	
		return expenseRepo.findAll();
	}

	@Override
	public Expense getExpenseById(Long id) {
		 Optional<Expense> optional =  expenseRepo.findById(id);
		 if(optional.isPresent()) {
			 return optional.get();
		 }
		 
		 throw new RuntimeException("There are no expenses with this id :"+id);
	}

	@Override
	public void deleteExpenseById(Long id) {
		expenseRepo.deleteById(id);
		
	}

	@Override
	public Expense saveExpenseDetails(Expense expense) {
		return expenseRepo.save(expense);
		 
	}

	@Override
	public Expense updateExpenseDetails(Long id, Expense expense) {
		Expense existingExpense = getExpenseById(id);
		existingExpense.setName(expense.getName() != null ? expense.getName() : existingExpense.getName());
		existingExpense.setAmount(expense.getAmount() != null ? expense.getAmount() : existingExpense.getAmount());
		existingExpense.setCategory(expense.getCategory() != null ? expense.getCategory() : existingExpense.getCategory());
		existingExpense.setDescription(expense.getDescription() != null ? expense.getDescription() : existingExpense.getDescription());
		existingExpense.setDate(expense.getDate() != null ? expense.getDate() : existingExpense.getDate());
		return expenseRepo.save(existingExpense);
	}

}
