package module.banking.account;

import module.banking.HBCIToken;
import org.kapott.hbci.GV.HBCIJob;
import org.kapott.hbci.GV_Result.HBCIJobResult;
import org.kapott.hbci.manager.HBCIHandler;
import org.kapott.hbci.status.HBCIExecStatus;
import org.kapott.hbci.structures.Konto;

public class BankAccount {
	
	private Konto konto;
	
	
	public BankAccount(Konto konto) {
		this.konto = konto;
	}
	
	
	public Konto getKonto() {
		return konto;
	}
	
	
	public HBCIJobResult executeJob(String parameter, Konto konto, HBCIToken token) {
		HBCIHandler handle = token.handle();
		HBCIJob umsatzJob = handle.newJob(parameter);
		umsatzJob.setParam("my",konto); // festlegen, welches Konto abgefragt werden soll.
		umsatzJob.addToQueue(); // Zur Liste der auszufuehrenden Auftraege hinzufuegen
		HBCIExecStatus status = handle.execute();
		if (!status.isOK()) {
			throw new RuntimeException("Unresolved error");
		}
		return umsatzJob.getJobResult();
	}
}
