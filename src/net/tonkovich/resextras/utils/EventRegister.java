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

        if(main.getConfig().getBoolean("bat", true)){
            pm.registerEvents(new bat(), main);
        }
        if(main.getConfig().getBoolean("blaze", true)){
            pm.registerEvents(new blaze(), main);
        }
        if(main.getConfig().getBoolean("blockdamage", true)){
            pm.registerEvents(new blockdamage(), main);
        }
        if(main.getConfig().getBoolean("cavespider", true)){
            pm.registerEvents(new cavespider(), main);
        }
        if(main.getConfig().getBoolean("chicken", true)){
            pm.registerEvents(new chicken(), main);
        }
        if(main.getConfig().getBoolean("commands", true)){
            pm.registerEvents(new commands(), main);
        }
        if(main.getConfig().getBoolean("cow", true)){
            pm.registerEvents(new cow(), main);
        }
        if(main.getConfig().getBoolean("eggs", true)){
            pm.registerEvents(new eggs(), main);
        }
        if(main.getConfig().getBoolean("enderman", true)){
            pm.registerEvents(new enderman(), main);
        }
        if(main.getConfig().getBoolean("fishing", true)){
            pm.registerEvents(new fishing(), main);
        }
        if(main.getConfig().getBoolean("ghast", true)){
            pm.registerEvents(new ghast(), main);
        }
        if(main.getConfig().getBoolean("god", true)){
            pm.registerEvents(new god(), main);
        }
        if(main.getConfig().getBoolean("hunger", true)){
            pm.registerEvents(new hunger(), main);
        }
        if(main.getConfig().getBoolean("irongolem", true)){
            pm.registerEvents(new irongolem(), main);
        }
        if(main.getConfig().getBoolean("lightning", true)){
            pm.registerEvents(new lightning(), main);
        }
        if(main.getConfig().getBoolean("magmacube", true)){
            pm.registerEvents(new magmacube(), main);
        }
        if(main.getConfig().getBoolean("mooshroom", true)){
            pm.registerEvents(new mooshroom(), main);
        }
        if(main.getConfig().getBoolean("ocelot", true)){
            pm.registerEvents(new ocelot(), main);
        }
        if(main.getConfig().getBoolean("pig", true)){
            pm.registerEvents(new pig(), main);
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
        if(main.getConfig().getBoolean("shear", true)){
            pm.registerEvents(new shear(), main);
        }
        if(main.getConfig().getBoolean("sheep", true)){
            pm.registerEvents(new sheep(), main);
        }
        if(main.getConfig().getBoolean("silverfish", true)){
            pm.registerEvents(new silverfish(), main);
        }
        if(main.getConfig().getBoolean("skeleton", true)){
            pm.registerEvents(new skeleton(), main);
        }
        if(main.getConfig().getBoolean("slime", true)){
            pm.registerEvents(new slime(), main);
        }
        if(main.getConfig().getBoolean("slimesplit", true)){
            pm.registerEvents(new slimesplit(), main);
        }
        if(main.getConfig().getBoolean("sneak", true)){
            pm.registerEvents(new sneak(), main);
        }
        if(main.getConfig().getBoolean("snowgolem", true)){
            pm.registerEvents(new snowgolem(), main);
        }
        if(main.getConfig().getBoolean("spider", true)){
            pm.registerEvents(new spider(), main);
        }
        if(main.getConfig().getBoolean("sprint", true)){
            pm.registerEvents(new sprint(), main);
        }
        if(main.getConfig().getBoolean("squid", true)){
            pm.registerEvents(new squid(), main);
        }
        if(main.getConfig().getBoolean("villager", true)){
            pm.registerEvents(new villager(), main);
        }
        if(main.getConfig().getBoolean("witch", true)){
            pm.registerEvents(new witch(), main);
        }
        if(main.getConfig().getBoolean("wolf", true)){
            pm.registerEvents(new wolf(), main);
        }
        if(main.getConfig().getBoolean("zombie", true)){
            pm.registerEvents(new zombie(), main);
        }
        if(main.getConfig().getBoolean("zombiepigmen", true)){
            pm.registerEvents(new zombiepigmen(), main);
        }
    }
}
