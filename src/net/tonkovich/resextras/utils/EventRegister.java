package net.tonkovich.resextras.utils;

import net.tonkovich.resextras.Main;
import net.tonkovich.resextras.flags.*;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

import java.util.HashMap;
import java.util.Map;

public class EventRegister {

    private Main main = Main.getInstance();

    public void start(PluginManager pm){
        
        String[] nonMobFlagList = main.getNonMobFlagList();

        Map<String, Listener> event = new HashMap<String, Listener>()
        {{
            // Add new events here
            put("mobs", new mobs());
            put("blockdamage", new blockdamage());
            put("eggs", new eggs());
            put("fishing", new fishing());
            put("god", new god());
            put("hunger", new hunger());
            put("lightning", new lightning());
            put("pigsaddle", new pigsaddle());
            put("pigzap", new pigzap());
            put("portal", new portal());
            put("slimesplit", new slimesplit());
            put("sneak", new sneak());
            put("sprint", new sprint());
        }};
        for(String item: nonMobFlagList){
            if(main.getConfig().getBoolean(item, true)){
                pm.registerEvents(event.get(item), main);
                System.out.println("success" + " on " + item);
            }
        }
        // Register all mobs
        if(main.getConfig().getBoolean("mobs", true)){
            pm.registerEvents(event.get("mobs"), main);
        }
    }
}
