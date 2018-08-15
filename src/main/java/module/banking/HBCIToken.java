package module.banking;

import java.util.function.Function;

import org.kapott.hbci.manager.HBCIHandler;
import org.kapott.hbci.manager.HBCIVersion;
import org.kapott.hbci.passport.HBCIPassport;

public class HBCIToken {
	
	private final HBCIVersion version;
	private final AuthPassport authPassport;
	private final HBCIHandler hbciHandler;
	
	
	public HBCIToken(HBCIVersion version, AuthPassport authPassport) {
		this.version = version;
		this.authPassport = authPassport;
		hbciHandler = new HBCIHandler(version.getId(), authPassport.getPassport());
	}
	
	public HBCIPassport passport() {
		return authPassport.getPassport();
	}
	
	
	public HBCIHandler handle() {
		return hbciHandler;
	}
}
