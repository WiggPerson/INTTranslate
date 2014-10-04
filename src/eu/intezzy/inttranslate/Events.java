package eu.intezzy.inttranslate;


import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import eu.intezzy.inttranslate.api.GeoIP;
import eu.intezzy.inttranslate.api.Translate;


public class Events implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		String countryCode = new GeoIP(e.getPlayer().getAddress().getAddress().getHostAddress()).getCode();
		String lang = new String("");
		
		
		if(countryCode.equals("CZ") == true) {
			lang = "SK";
		} else if(countryCode.equals("GB") == true || countryCode.equals("US") == true) {
			lang = "EN";
		} else if(countryCode.equals("UA") == true) {
			lang = "UK";
		} else if(countryCode.equals("GR") == true) {
			lang = "EL";
		} else {
			
			for(String code : Main.lang.LanguageShortName) {
				if(code.equals(countryCode) == true) {
					lang = code;
					break;
				}
			}
			
			if(lang.isEmpty() == true) {
				lang = "EN";
			}
			
		}			
		
		Main.data.setPlayerLang(e.getPlayer(), lang);
		
		e.getPlayer().sendMessage(ChatColor.GREEN + "[INTTranslate] " + ChatColor.WHITE + new Translate("sk",Main.data.getPlayerLang(e.getPlayer()).toLowerCase(), "Tvôj jazyk bol nastavený na " + new Translate("en","sk", Main.lang.languages.get(Main.data.getPlayerLang(e.getPlayer()))).translate()).translate() + ".");
		
	}
	
}
