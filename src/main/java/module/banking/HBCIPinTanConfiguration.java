package module.banking;

import java.io.File;
import java.util.Properties;
import javax.inject.Inject;

import org.kapott.hbci.callback.HBCICallback;
import org.kapott.hbci.manager.HBCIUtils;
import org.kapott.hbci.passport.AbstractHBCIPassport;
import org.kapott.hbci.passport.HBCIPassport;

public class HBCIPinTanConfiguration {
	
	private static final File PASSPORT_FILE = new File("testpassport.dat");
	
	private final Properties props = new Properties();
	
	private HBCIPassport passport;
	
	@Inject
	private HBCICallback callBack;
	
	
	public HBCIPinTanConfiguration() {
	
	}
	
	@Inject
	public HBCIPinTanConfiguration(HBCICallback callBack) {
			this.callBack = callBack;
			HBCIUtils.init(props, callBack);
			
			HBCIUtils.setParam("client.passport.default", "PinTan");
			HBCIUtils.setParam("client.passport.PinTan.filename", PASSPORT_FILE.getAbsolutePath());
			HBCIUtils.setParam("client.passport.PinTan.init", "1");
			
			passport = AbstractHBCIPassport.getInstance();
		}
	
	
	public void initConfiguration() {
		this.callBack = callBack;
		HBCIUtils.init(props, callBack);
		
		HBCIUtils.setParam("client.passport.default","PinTan");
		HBCIUtils.setParam("client.passport.PinTan.filename", PASSPORT_FILE.getAbsolutePath());
		HBCIUtils.setParam("client.passport.PinTan.init","1");
		
		passport = AbstractHBCIPassport.getInstance();
	}
	
	public HBCIPassport getPassport() {
		return passport;
	}
}
