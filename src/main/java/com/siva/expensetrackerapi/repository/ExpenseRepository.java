package com.siva.expensetrackerapi.repository;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siva.expensetrackerapi.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{
	
	//SELECT * FROM tbl_expenses WHERE category = ?;
	public Page<Expense> findByCategory(String category,Pageable page);
	
	//SELECT * FROM tbl_expenses WHERE name LIKE '%name%';
	public Page<Expense> findByNameContaining(String name,Pageable page);
	
	//SELECT * FROM tbl_expenses WHERE date BETWEEN startDate AND endDate;
	public Page<Expense> findByDateBetween(Date startDate,Date endDate,Pageable page);
	

}
