package module.banking.dkb;

import com.google.inject.AbstractModule;
import module.banking.BankingAuthenticator;
import org.kapott.hbci.callback.HBCICallback;

public class DKBModule extends AbstractModule {
	
	@Override
	protected void configure() {
		bind(BankingAuthenticator.class).to(DKBAuthenticator.class);
		bind(HBCICallback.class).to(DKBCallBack.class);
	}
}
