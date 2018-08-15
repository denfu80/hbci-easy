package module.banking;

import org.kapott.hbci.manager.BankInfo;
import org.kapott.hbci.manager.HBCIUtils;
import org.kapott.hbci.passport.AbstractHBCIPassport;
import org.kapott.hbci.passport.HBCIPassport;


public class AuthPassportImpl implements AuthPassport {
	
	private PassportHandle passportHandle;
	
	private HBCIPassport passport;
	
	
	public AuthPassportImpl(PassportHandle passportHandle) {
		this.passportHandle = passportHandle;
	}
	
	
	@Override
	public void handleCallback(int reason, String msg, int datatype, StringBuffer retData) {
		passportHandle.handleCallback(reason, msg, datatype, retData);
	}
	
	
	@Override
	public void init(BankInfo info, int port, String locale) {

		HBCIUtils.setParam("client.passport.default","PinTan"); // Legt als Verfahren PIN/TAN fest.
		HBCIUtils.setParam("client.passport.PinTan.filename", passportHandle.getAbsolutePath());
		HBCIUtils.setParam("client.passport.PinTan.init","1");

		this.passport = AbstractHBCIPassport.getInstance();
		passport.setCountry(locale);//TODO: either by parameter or by info object
		passport.setHost(info.getPinTanAddress());
		passport.setPort(port);
		passport.setFilterType(passportHandle.getFilterType());
	}
	
	
	@Override
	public HBCIPassport getPassport() {
		if (passport == null) {
			throw new RuntimeException("Wrong usage");//TODO: better message referring to pack-info or such
		}
		return passport;
	}
}
