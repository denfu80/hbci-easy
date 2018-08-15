package module.banking;

public class PassportBuilder {
	
	
	
	public static PassportBuilder getBuilderFor(BANK bank) {
		switch (bank) {
			case DKB:
				return new PassportBuilder();
			default:
				throw new RuntimeException("Not yet implemented");
		}
	}
	
	
	public AuthPassport createByCredentials(String usr, String pin) {
		return new AuthPassportImpl(new PinPassportHandle(usr, pin));
	}
	
	
	public enum BANK {
		DKB
	}
	
	private PassportBuilder() {
	
	}
}
