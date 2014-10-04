package eu.intezzy.inttranslate.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.bukkit.entity.Player;


public class Data {
	
	protected HashMap<String, String> playerData = new HashMap<>();
	
	public Data() {
		System.out.println("[INTTranslator] Data initialized!");		
	}
	
	public void setPlayerLang(Player p, String lsn) {
		playerData.put(p.getName(), lsn);
	}
	
	public String getPlayerLang(Player p) {
		return playerData.get(p.getName());
	}

	public String[] getPlayersWithLang(String lsn) {
		List<String> l = new ArrayList<>();
		
		for(Entry<String, String> entry : playerData.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue();
			
			if(val.toString().equals(lsn.toString()) == true) {
				l.add(key);				
			}
			
		}
		
		return l.toArray(new String[l.size()]);
	}
	
}
