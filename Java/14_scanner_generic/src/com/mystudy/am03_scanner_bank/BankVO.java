package com.mystudy.am03_scanner_bank;

import java.util.ArrayList;
import java.util.List;

public class BankVO {
	private String name;
	private String accNum;
	private int psw;
	private int money;
	
	public BankVO () {};
	
	public BankVO (String accNum, String name, int psw, int money) {
		this.accNum = accNum;
		this.name = name;
		this.psw = psw;
		this.money = money;
	}
	
	public BankVO (String accNum, String name, int psw) {
		this.accNum = accNum;
		this.name = name;
		this.psw = psw;
		this.money = 0;
	}
	
	public void newAcc () {
		
	}
	
	public int getMoney() {
		return money;
	}
	
	public int getMoney(int money) {
		this.money += money;
		return this.money;
	}
	
	public int outMoney(int money) {
		this.money -= money;
		return this.money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "BankVO [name=" + name + ", accNum=" + accNum + ", psw=" + psw + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccNum() {
		return accNum;
	}
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	public int getPsw() {
		return psw;
	}
	public void setPsw(int psw) {
		this.psw = psw;
	}
	
}
