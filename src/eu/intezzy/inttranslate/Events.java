package eu.intezzy.inttranslate;


import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
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
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		
		System.out.println("ha");
		
		String msg = e.getMessage();
		
		if(msg.startsWith("/")) return;
		
		HashMap<Player, String> messages = new HashMap<Player, String>();
		
		for(Player p : Bukkit.getOnlinePlayers()) {
			String playerMessage = new String("");
			if(Main.data.getPlayerLang(e.getPlayer()).equals(Main.data.getPlayerLang(p))) {
				System.out.println("ha");
				playerMessage = ChatColor.WHITE + "<" + p.getDisplayName() + ChatColor.WHITE + "> " + msg;
			} else {			
				playerMessage = ChatColor.WHITE + "<" + p.getDisplayName() + ChatColor.WHITE + "> " + new Translate(Main.data.getPlayerLang(e.getPlayer()), Main.data.getPlayerLang(p), msg).translate();
			}
			messages.put(p, playerMessage);
		}
		
		for(Map.Entry<Player, String> entry : messages.entrySet()) {
			Player p = entry.getKey();
			String msg_ = entry.getValue();
			
			p.sendMessage(msg_);
		}
		
		System.out.println("ha");
		e.setCancelled(true);
	}
	
}
