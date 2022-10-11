package com.siva.expensetrackerapi.exceptions;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.siva.expensetrackerapi.entity.ErrorObject;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorObject> expenseNotFoundExceptionHadler(ResourceNotFoundException ee,WebRequest request){
		
		ErrorObject error = new ErrorObject();
		
		error.setMessage(ee.getMessage());
		
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		error.setTimeStamp(new Date());
		
		return new ResponseEntity<ErrorObject>(error,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorObject> methodArgumentMismatchExceptionHadler(MethodArgumentTypeMismatchException me,WebRequest request){
		
		ErrorObject error = new ErrorObject();
		
		error.setMessage(me.getMessage());
		
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		
		error.setTimeStamp(new Date());
		
		return new ResponseEntity<ErrorObject>(error,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorObject> exceptionHandler(Exception ex,WebRequest request){
		
		ErrorObject error = new ErrorObject();
		
		error.setMessage(ex.getMessage());
		
		error.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		error.setTimeStamp(new Date());
		
		return new ResponseEntity<ErrorObject>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
