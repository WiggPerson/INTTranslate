package eu.intezzy.inttranslate.api;

import java.io.IOException;

import com.maxmind.geoip.LookupService;

public class GeoIP {

	private String ip = null;
	
	public GeoIP(String ip) {
		this.ip = ip;	
	}
	
	public String getCountry() {	
		
		try {
			String sep = System.getProperty("file.separator");

			// windows
			String dir = System.getProperty("user.dir");

			String dbfile = dir + sep + "GeoIP.dat";		
			LookupService cl = new LookupService(dbfile,LookupService.GEOIP_MEMORY_CACHE);
			
			return cl.getCountry(this.ip).getName();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		return null;
	}
	
	public String getCode() {
		
		try {
			String sep = System.getProperty("file.separator");

			// windows
			String dir = System.getProperty("user.dir");

			// linux
			// String dir = "/usr/local/share/GeoIP";

			String dbfile = dir + sep + "GeoIP.dat";
			LookupService cl = new LookupService(dbfile,LookupService.GEOIP_MEMORY_CACHE);
			
			return cl.getCountry(this.ip).getCode();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
		
		return null;
	}
	
}
