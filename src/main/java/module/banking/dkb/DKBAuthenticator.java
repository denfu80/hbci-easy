package module.banking.dkb;


import java.util.Properties;
import javax.inject.Inject;

import module.banking.AuthPassport;
import module.banking.BankingAuthenticator;
import module.banking.HBCIPinTanConfiguration;
import module.banking.HBCIToken;
import org.kapott.hbci.manager.BankInfo;
import org.kapott.hbci.manager.HBCIUtils;
import org.kapott.hbci.manager.HBCIVersion;

public class DKBAuthenticator implements BankingAuthenticator {
	
	private final static String BLZ = "12030000";
	private final static HBCIVersion VERSION = HBCIVersion.HBCI_300;
	
	public DKBAuthenticator() {
	
	}
	
	@Override
	public HBCIToken authenticate(AuthPassport authPassport) {
		
		HBCIUtils.init(new Properties(), new DKBCallBack(authPassport));
		BankInfo info = HBCIUtils.getBankInfo(BLZ);
		
		authPassport.init(info, 443, "DE");
		
		return new HBCIToken(VERSION, authPassport);
	}
	
	
	@Override
	public void reset() {
	
	}
}
