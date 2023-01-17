package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {
	

	
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<MyErrorDetails> myIllegealException(EmployeeException ee,WebRequest wr){
		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),ee.getMessage(), wr.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> myIllegalHandler(Exception ie, WebRequest req){
        MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),ie.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe, WebRequest req) {
        MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
    }
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> mynotFoundHandler(MethodArgumentNotValidException nfe, WebRequest req) {
//        MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
		MyErrorDetails err=new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setDetails("Validation Error...");
		err.setMessage(nfe.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
    }
}
