package bank;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Account.java
//  @ Date : 2019-05-������
//  @ Author : 
//
public class Account {
  private String name;
  private long number;
  private String accountType;
  private int password;
  private long limit;
  private boolean internetBanking;
  private int cardCount;
  private String bankName;
  private long balance;
  
  Account(){
	  this.bankName = "��Ƽķ�۽�����";
	  this.balance=0;
	  this.internetBanking= false;
	  this.cardCount=0;
  }
  public void minusBalance(long a) {
	  this.balance -= a;
  }
  
  public void plusBalance(long a) {
	  this.balance += a;
  }
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getNumber() {
	return number;
}
public void setNumber(long number) {
	this.number = number;
}
public String getAccountType() {
	return accountType;
}
public void setAccountType(String accountType) {
	this.accountType = accountType;
}
public int getPassword() {
	return password;
}
public void setPassword(int password) {
	this.password = password;
}
public long getLimit() {
	return limit;
}
public void setLimit(long limit) {
	this.limit = limit;
}
public boolean isInternetBanking() {
	return internetBanking;
}
public void setInternetBanking(boolean internetBanking) {
	this.internetBanking = internetBanking;
}
public int getCardCount() {
	return cardCount;
}
public void setCardCount(int cardCount) {
	this.cardCount = cardCount;
}
public String getBankName() {
	return bankName;
}
public void setBankName(String bankName) {
	this.bankName = bankName;
}
public long getBalance() {
	return balance;
}
@Override
public String toString() {
	return "Account [name=" + name + ", number=" + number + ", accountType=" + accountType + ", password=" + password
			+ ", limit=" + limit + ", internetBanking=" + internetBanking + ", cardCount=" + cardCount + ", bankName="
			+ bankName + ", balance=" + balance + "]";
}  
  
}
