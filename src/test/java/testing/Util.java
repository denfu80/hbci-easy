package testing;

import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;


public class Util {
	
	public static String getUsrId() {
		try {
			Path path = Paths.get(Util.class.getClassLoader().getResource("user.template").toURI());
			return Files.readAllLines(path, Charset.defaultCharset()).get(0);
		} catch (Exception e) {
			throw new RuntimeException("", e);//TODO
		}
		
	}
	
	
	public static String getPin() {
		try {
			Path path = Paths.get(Util.class.getClassLoader().getResource("pin.template").toURI());
			return Files.readAllLines(path, Charset.defaultCharset()).get(0);
		} catch (Exception e) {
			throw new RuntimeException("", e);//TODO
		}
	}
}
