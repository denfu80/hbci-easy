package module.banking.account;

import module.banking.HBCIToken;

public class AccountAccessor {
	
	private HBCIToken token;
	
	
	public AccountAccessor(HBCIToken token) {
		this.token = token;
	}
	
	
	public BankAccount getById(String accountId) {
		return new BankAccount(token.passport().getAccount(accountId));
	}
}
