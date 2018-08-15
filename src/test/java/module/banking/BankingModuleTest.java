package module.banking;


import com.google.inject.Guice;
import module.banking.dkb.DKBModule;
import org.testng.annotations.BeforeSuite;

abstract public class BankingModuleTest {
	
	@BeforeSuite
	final void setUp() {
		Guice
			.createInjector(new BankingModule())
			.injectMembers(this);
	}
	
}
