package net.tonkovich.resextras.utils;

import net.tonkovich.resextras.Main;
import net.tonkovich.resextras.flags.*;
import org.bukkit.plugin.PluginManager;

public class EventRegister {

    private Main main = Main.getInstance();
    public void start(PluginManager pm){
        /*
         * Run through each config item and enable events when true
         * It's ugly until I figure out a different way
         */
        if(main.getConfig().getBoolean("mobs", true)){
            pm.registerEvents(new mobs(), main);
        }
        if(main.getConfig().getBoolean("blockdamage", true)){
            pm.registerEvents(new blockdamage(), main);
        }
        if(main.getConfig().getBoolean("eggs", true)){
            pm.registerEvents(new eggs(), main);
        }
        if(main.getConfig().getBoolean("fishing", true)){
            pm.registerEvents(new fishing(), main);
        }
        if(main.getConfig().getBoolean("god", true)){
            pm.registerEvents(new god(), main);
        }
        if(main.getConfig().getBoolean("hunger", true)){
            pm.registerEvents(new hunger(), main);
        }
        if(main.getConfig().getBoolean("lightning", true)){
            pm.registerEvents(new lightning(), main);
        }
        if(main.getConfig().getBoolean("pigsaddle", true)){
            pm.registerEvents(new pigsaddle(), main);
        }
        if(main.getConfig().getBoolean("pigzap", true)){
            pm.registerEvents(new pigzap(), main);
        }
        if(main.getConfig().getBoolean("portal", true)){
            pm.registerEvents(new portal(), main);
        }
        if(main.getConfig().getBoolean("slimesplit", true)){
            pm.registerEvents(new slimesplit(), main);
        }
        if(main.getConfig().getBoolean("sneak", true)){
            pm.registerEvents(new sneak(), main);
        }
        if(main.getConfig().getBoolean("sprint", true)){
            pm.registerEvents(new sprint(), main);
        }
    }
}
