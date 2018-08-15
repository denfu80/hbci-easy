package module.banking;

public interface PassportHandle {
	
	String getAbsolutePath();
	
	void handleCallback(int reason, String msg, int datatype, StringBuffer retData);
	
	String getFilterType();
}
