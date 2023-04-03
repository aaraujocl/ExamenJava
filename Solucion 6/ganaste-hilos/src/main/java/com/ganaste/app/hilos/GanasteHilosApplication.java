package com.ganaste.app.hilos;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ganaste.app.model.Account;
import com.ganaste.app.model.AccountOperation;
import com.ganaste.app.model.GlobalClass;

@SpringBootApplication
public class GanasteHilosApplication {
	private static Lock operationLock = new ReentrantLock();
	public static void main(String[] args) {
		SpringApplication.run(GanasteHilosApplication.class, args);
		AccountOperation accountOperation = new AccountOperation();
		GlobalClass classglobal = new GlobalClass();
		Account sourceAccount = new Account(classglobal.Value1,"Value var1",null,accountOperation);
		Account targetAccount = new Account(classglobal.Value2,"Value var2",sourceAccount,accountOperation);
		sourceAccount.start();
		targetAccount.start();
	}

}
