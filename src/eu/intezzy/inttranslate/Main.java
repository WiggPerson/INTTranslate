/* Copyright © 2014 WiggPerson
 * All rights reserved.
 */

package eu.intezzy.inttranslate;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import eu.intezzy.inttranslate.api.Data;
import eu.intezzy.inttranslate.enums.Language;

public class Main extends JavaPlugin {

	protected final String prefix = "[INTTranslate]";
	protected final Logger logger = Logger.getLogger("Minecraft");
	
	protected static Data data = null;
	protected static Language lang = null;
	
	public void onEnable() {
		
		logger.info("Starting to initialize plugin...");
		logger.info("Configuring...");
		
		Bukkit.getServer().getPluginManager().registerEvents(new Events(), this);
		data = new Data();
		lang = new Language();
		
		logger.info("Plugin started!");
	}
	
	public void onDisabled() {
		
		logger.info("Shuting plugin down...");
		logger.info("Plugin shut down.");	
		
	}
}
