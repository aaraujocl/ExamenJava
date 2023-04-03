package com.ganaste.app.model;

public class AccountOperation {

	protected synchronized void operation(Account account) {
		Account sourceAccount;
		sourceAccount = account.anotherAccount;

		StringBuilder text = new StringBuilder();
		if(account.anotherAccount == null) {
			text.append("Hilo en espera de ").append(account.name);
			System.out.println(text.toString());
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int count=0; count <= 5;count++) {
			text.setLength(0);
			text.append("Valor del hilo ");
			account.value = account.value+100;
			text.append(account.name).append(" es ").append(account.value);
			System.out.println(text.toString());
		}
		text.setLength(0);
		text.append("Valor final del hilo ").append(account.name).append(" es ").append(account.value);
		System.out.println(text.toString());
		sourceAccount.anotherAccount = account;
		notifyAll();
		System.out.println("Despertar hilos");
	}
}
