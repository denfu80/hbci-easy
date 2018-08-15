package module.banking.revenue;

import java.util.Date;

import org.kapott.hbci.GV_Result.GVRKUms;

public class Booking implements Comparable<Booking> {
	
	private GVRKUms.UmsLine umsLine;
	
	
	public Booking(GVRKUms.UmsLine umsLine) {
		this.umsLine = umsLine;
	}
	
	
	@Override
	public int compareTo(Booking booking) {
		return booking.umsLine.bdate.compareTo(umsLine.bdate);
	}
	
	
	public Date getBDate() {
		return umsLine.bdate;
	}
}
