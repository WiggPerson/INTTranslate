package eu.intezzy.inttranslate.enums;

import java.util.HashMap;

public class Language {

	public HashMap<String, String> languages = new HashMap<>();
	
	public Language() {
		int i = 0;
		
		for(String key : LanguageShortName) {
			languages.put(key, LanguageName[i]);
			i++;
		}
		
		System.out.println("[INTTranslator] Languages initialized!");
	}
	

	public String[] LanguageName = {
		
		// Visehrad V4
		
		"SLOVAK",
		"CZECH",
		"HUNGARIAN",
		"POLISH",
		
		
		// English
		
		"ENGLISH",
		
		// Rest of Europe
		
		"GERMAN",
		"UKRAIAN",
		"SLOVENE",
		"CROATIAN",
		"RUSSIAN",
		"BELARUSIAN",
		"ROMANIAN",
		"BULGARIAN",
		"ITALIAN",
		"GREEK",
		"FRENCH",
		"SPANISH",
		"PORTUGUESE",
		"NORWEGIAN",
		"SWEDISH",
		"FINNISH"
	};
	
	public String[] LanguageShortName = {
		
		// Visehrad V4
		
		"SK", // ok
		"CS", // cz
		"HU", // ok
		"PL", // ok
		
		// English
		
		"EN", // gb,us
		
		// Rest of Europe
		
		"DE", // ok
		"UK", // ua
		"SL", // ok
		"HR", // ok
		"RU", // ok
		"BE", // ok
		"RO", // ok
		"BG", // ok
		"IT", // ok
		"EL", // gr
		"FR", // ok
		"ES", // ok
		"PT", // ok
		"NO", // ok
		"SV", // ok
		"FI" // ok
	};
	
}
