package module.banking.revenue;

import module.banking.HBCIToken;
import module.banking.account.BankAccount;
import org.kapott.hbci.GV.HBCIJob;
import org.kapott.hbci.GV_Result.GVRKUms;
import org.kapott.hbci.GV_Result.HBCIJobResult;
import org.kapott.hbci.status.HBCIExecStatus;

public class RevenueAccessor {
	
	private BankAccount account;
	private HBCIToken token;
	
	
	public RevenueAccessor(BankAccount account, HBCIToken token) {
		this.account = account;
		this.token = token;
	}
	
	
	public Revenue get() {
		HBCIJobResult hbciJobResult = account.executeJob("KUmsAll", account.getKonto(), token);
		if (!hbciJobResult.isOK()) {
			throw new RuntimeException(hbciJobResult.toString());
		}
		return new Revenue((GVRKUms) hbciJobResult);
	}
}
