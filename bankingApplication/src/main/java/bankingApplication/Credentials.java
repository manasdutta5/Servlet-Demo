package bankingApplication;

import java.util.*;

public class Credentials {
	
	static Properties cred = new Properties();
	static Properties account = new Properties();
	static Hashtable<String,Double> balance = new Hashtable<>();
	
	public Credentials()
	{
		cred.put("Laura", "123");
		cred.put("Jenna", "456");
		cred.put("Max", "789");
		
		account.put("100500100","Laura");
		account.put("200500100", "Laura");
		account.put( "300500200","Jenna");
		account.put( "400500200","Max");
		account.put( "500500300","Max");
		
		balance.put("100500100", 7000.25);
		balance.put("200500100", 80500.4);
		balance.put("300500200", 5000582.56);
		balance.put("400500200", 94200.2);
		balance.put("500500300",8000456.65);
	}
	
	 public static String  getPassword(String username) {
	     return (String) cred.get(username);
	   }
	 
	 
	 public static String  getUserName(String accNumber) {
	     return (String) account.get(accNumber);
	   }
	 
	 public static Double  getBalance(String accountNum) {
	     return (Double) balance.get(accountNum);
	   }
	 
	 public static int getSize(String s)
	 {
		 if(s.equals("cred")) return cred.size();
		 else if(s.equals("balance")) return balance.size();
		 else return account.size();
	 }
	 
	 public static ArrayList<String> getBalanceInfo()
	 {
		 return new ArrayList<String>( balance.keySet() );
	 }

}
