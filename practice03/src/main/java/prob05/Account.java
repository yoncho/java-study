package prob05;

public class Account {
	private String accountNo;
	private int balance;
	
	
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Account(String account)
	{
		setAccountNo(account);
		System.out.println(getAccountNo() +"계좌가 개설되었습니다.");
	}
	
	public void save(int save)
	{
		this.balance += save;
		System.out.println(getAccountNo() + "계좌에 " + save +"만원이 입금되었습니다.");
	}
	
	public void deposit(int deposit)
	{
		if(this.balance >= deposit)
		{
			this.balance -= deposit;
			System.out.println(getAccountNo() + "계좌에 " + deposit +"만원이 출금되었습니다.");
		}
		else
		{
			System.out.println("잔액이 부족합니다. 현재 잔액은 :" + this.balance + "원 입니다.");
		}
	}
}
