package com.ganaste.app.model;

public class Account extends Thread{

	public long value;
	public String name;
	public Account anotherAccount;
	public AccountOperation accountOperation;
	
	public Account(long value, String name, Account anotherAccount, AccountOperation accountOperation) {
        this.value = value;
        this.name = name;
        this.anotherAccount = anotherAccount;
        this.accountOperation = accountOperation;
    }
	

public void run() {
		StringBuilder text = new StringBuilder();
		
		for(int count=0; count <= 30; count++) {
			text.setLength(0);
			this.value = this.value+100;
			text.append(this.name).append(" = ").append(this.value+"\n");
			System.out.print(text.toString());		
		}
		text.setLength(0);	
		text.append("valor final ").append(name).append(" es ").append(this.value+"\n");
		System.out.print(text.toString());	
	}
	
}
