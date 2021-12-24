package application;

import java.util.Locale;
import java.util.Scanner;

import Exceptions.BusinessException;
import entities.Account;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		String holder = sc.next();
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.println("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();
		
		Account account = new Account(number, holder, balance, withdrawLimit);
		
		System.out.println();
		System.out.println("Enter amount for withdraw: ");
		double amount = sc.nextDouble();
		
		try{
			account.withdraw(amount);
			System.out.println("New balance: %.2f%n" + account.getBalance());
		}
		catch(BusinessException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
}
