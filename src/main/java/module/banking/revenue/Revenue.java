package module.banking.revenue;

import java.util.List;
import java.util.stream.Collectors;

import org.kapott.hbci.GV_Result.GVRKUms;
import org.kapott.hbci.structures.Value;

public class Revenue {
	
	private GVRKUms hbciJobResult;
	private List<Booking> bookings;
	
	public Revenue(GVRKUms gvrkUms) {
		this.hbciJobResult = gvrkUms;
	}
	
	public List<Booking> list() {
		if (bookings != null) {
			return bookings;
		}
		
		bookings = hbciJobResult.getFlatData()
			.parallelStream()
			.map(Booking::new)
			.collect(Collectors.toList());
		
		return bookings;
		
	}
	
	public String prettyPrint() {
		List<GVRKUms.UmsLine> buchungen = hbciJobResult.getFlatData();
		StringBuilder sb = new StringBuilder();
		for (GVRKUms.UmsLine buchung:buchungen)
		{
			sb.append(buchung.valuta);
			Value v = buchung.value;
			if (v != null)
			{
				sb.append(": ");
				sb.append(v);
			}
			
			List<String> zweck = buchung.usage;
			if (zweck != null && zweck.size() > 0)
			{
				sb.append(" - ");
				// Die erste Zeile des Verwendungszwecks ausgeben
				for (String z : zweck) {
					sb.append(z);
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
