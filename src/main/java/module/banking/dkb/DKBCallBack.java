package module.banking.dkb;

import java.util.Date;

import javax.inject.Inject;

import module.banking.AuthPassport;
import org.kapott.hbci.callback.AbstractHBCICallback;
import org.kapott.hbci.passport.HBCIPassport;
import org.apache.log4j.Logger;

public class DKBCallBack extends AbstractHBCICallback {
	
	final static Logger LOGGER = Logger.getLogger(DKBCallBack.class);
	
	
	/**
	 * Die BLZ deiner Bank.
	 */
	private final static String BLZ = "12030000";
	
	private AuthPassport authPassport;
	
	
	@Inject
	public DKBCallBack(AuthPassport authPassport) {
		super();
		this.authPassport = authPassport;
	}
	
	@Override
	public void log(String msg, int level, Date date, StackTraceElement trace) {
		LOGGER.error(msg);
	}
	
	
	@Override
	public void callback(HBCIPassport passport, int reason, String msg, int datatype, StringBuffer retData) {
		DKBCallBack.this.authPassport.handleCallback(reason, msg, datatype, retData);
		
		switch (reason)
		{
			case NEED_BLZ:
				retData.replace(0, retData.length(), BLZ);
				break;
			case HAVE_ERROR:
				break;
			default:
				break;
			
		}
	}
	
	
	@Override
	public void status(HBCIPassport passport, int statusTag, Object[] o) {
		LOGGER.debug("status update:" + statusTag);
		LOGGER.debug("status object:" + o);
	}
}
