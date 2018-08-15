package module.banking;

public interface BankingAuthenticator {
	
	HBCIToken authenticate(AuthPassport authPassport);
	
	void reset();
}
