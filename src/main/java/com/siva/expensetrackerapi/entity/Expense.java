package com.siva.expensetrackerapi.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_expenses")
public class Expense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="expense_name")
	private String name;
	
	private String description;
	
	@Column(name="expense_amount")
	private BigDecimal amount;
	
	private String category;
	
	private Date date;
	
	@Column(name="created_at",nullable = false,updatable = false)
	@CreationTimestamp
	private Timestamp createdAt;
	
	@Column(name="updated_at")
	@UpdateTimestamp
	private Timestamp updateAt;
}
