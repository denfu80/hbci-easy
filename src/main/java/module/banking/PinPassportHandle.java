package module.banking;

import java.io.File;

import static org.kapott.hbci.callback.HBCICallback.HAVE_ERROR;
import static org.kapott.hbci.callback.HBCICallback.NEED_BLZ;
import static org.kapott.hbci.callback.HBCICallback.NEED_CUSTOMERID;
import static org.kapott.hbci.callback.HBCICallback.NEED_PASSPHRASE_LOAD;
import static org.kapott.hbci.callback.HBCICallback.NEED_PASSPHRASE_SAVE;
import static org.kapott.hbci.callback.HBCICallback.NEED_PT_PIN;
import static org.kapott.hbci.callback.HBCICallback.NEED_USERID;

public class PinPassportHandle implements PassportHandle {
	
	
	private String usr;
	private final String pin;
	
	final File passportFile = new File("testpassport.dat");
	
	public PinPassportHandle(String usr, String pin) {
		this.usr = usr;
		this.pin = pin;
	}
	
	
	@Override
	public String getAbsolutePath() {
		return passportFile.getAbsolutePath();
	}
	
	
	@Override
	public void handleCallback(int reason, String msg, int datatype, StringBuffer retData) {
		switch (reason)
		{
			case NEED_PASSPHRASE_LOAD:
			case NEED_PASSPHRASE_SAVE:
				retData.replace(0, retData.length(), pin);
				break;
			case NEED_PT_PIN:
				retData.replace(0, retData.length(), pin);
				break;
			case NEED_USERID:
				retData.replace(0, retData.length(), usr);
				break;
			case NEED_CUSTOMERID:
				retData.replace(0,retData.length(), usr);
				break;
			default:
				break;
			
		}
	}
	
	
	@Override
	public String getFilterType() {
		return "Base64";
	}
}
