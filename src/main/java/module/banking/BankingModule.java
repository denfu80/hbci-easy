package module.banking;

import com.google.inject.AbstractModule;
import module.banking.dkb.DKBModule;

public class BankingModule extends AbstractModule {
	
	@Override
	protected void configure() {
		install(new DKBModule());
		
		bind(HBCIPinTanConfiguration.class);
	}
}
