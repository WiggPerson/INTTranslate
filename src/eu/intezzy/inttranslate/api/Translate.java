/* Copyright © 2014 WiggPerson
 * All rights reserved.
 */

package eu.intezzy.inttranslate.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Translate {

	private String Url = "http://bukkit.sk/translate.php";
	private String scriptUrl = new String("");
	
	public Translate(String from, String to, String text) {
		try {
			this.scriptUrl = this.Url + "?from=" + from + "&to=" + to + "&text=" + URLEncoder.encode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
	}
	
	public String translate() {
		return this.readUrl();
	}
	
	public String readUrl() {
        URL u;
        String str = new String("");
        try {
            u = new URL(this.scriptUrl);
            try {
                BufferedReader theHTML = new BufferedReader(new InputStreamReader(u.openStream(),"UTF-8"));
                str = theHTML.readLine();
            }
            catch (Exception e) {
                System.err.println(e);
            }
        } catch (MalformedURLException e) {
            System.err.println(e);
        }
        return str;
	}
	
}
