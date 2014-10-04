# INTTranslate
### About
Plugin for CraftBukkit (compiled for 1.7.9 or 1.7.10) which automaticaly translates messages in chat to players language. Plugin uses GeoIP to locate player and set him language. Each player see every message in own language. Plugin was originaly written around Spring 2014 for inteZZy.eu but it was useless for us since we are not multilanguage server anymore.

### Getting started
###### Installing
1. Download whole repository with button "Download ZIP" or with git clone.
2. Extract it.
3. Upload file "INTTranslate" from "bin" folder in ~/plugins. (To folder where you have other plugins)
4. Upload "GeoIP.dat" from "db" folder in ~/. (To folder where you have craftbukkit.jar)
6. Reload server 

###### Changing PHP translating script path (Optional)
1. Upload file "translate.php" from "php" folder anywhere.
2. Open src/eu/intezzy/inttranslate/api/Translate.java and edit variable "private String url" to URL to your translate.php
3. Recompile plugin
4. Upload plugin in server
5. Reload server
