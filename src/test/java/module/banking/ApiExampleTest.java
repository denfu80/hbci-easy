package module.banking;


import module.banking.account.AccountAccessor;
import module.banking.account.BankAccount;
import module.banking.dkb.DKBAuthenticator;
import module.banking.revenue.Revenue;
import module.banking.revenue.RevenueAccessor;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import testing.Util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static testing.Util.getPin;
import static testing.Util.getUsrId;

public class ApiExampleTest {// How i'd like to use the api
	
	
	@Test
	public void printRevenue() {
		//arrange
		PassportBuilder passportBuilder = PassportBuilder.getBuilderFor(PassportBuilder.BANK.DKB);
		
		assertThat(passportBuilder).isNotNull();
		
		AuthPassport authPassport = passportBuilder.createByCredentials(getUsrId(), getPin());
		
		assertThat(authPassport).isNotNull();
		
		BankingAuthenticator authenticator = new DKBAuthenticator();
		
		HBCIToken token = authenticator.authenticate(authPassport);
		
		AccountAccessor accountAccessor = new AccountAccessor(token);
		BankAccount account = accountAccessor.getById("1036988358");
		
		assertThat(account).isNotNull();
		
		RevenueAccessor revenueAccessor = new RevenueAccessor(account, token);
		
		Revenue revenue = revenueAccessor.get();
		assertThat(revenue).isNotNull();
		
		//act
		revenue.list().stream().map(b -> b.getBDate()).forEach(System.out::println);
	}
	
}
