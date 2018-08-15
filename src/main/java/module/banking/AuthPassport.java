package module.banking;

import org.kapott.hbci.manager.BankInfo;
import org.kapott.hbci.passport.HBCIPassport;

public interface AuthPassport {
	
	void handleCallback(int reason, String msg, int datatype, StringBuffer retData);
	
	void init(BankInfo info, int i, String locale);
	
	HBCIPassport getPassport();
}
