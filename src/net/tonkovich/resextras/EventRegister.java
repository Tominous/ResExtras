package net.tonkovich.resextras;

import net.tonkovich.resextras.flags.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class EventRegister extends JavaPlugin {

    public void start(PluginManager pm){
        /*
         * Run through each config item and enable events when true
         * It's ugly until I figure out a different way
         */

        if(getConfig().getBoolean("bat", true)){
            pm.registerEvents(new bat(), this);
        }
        if(getConfig().getBoolean("blaze", true)){
            pm.registerEvents(new blaze(), this);
        }
        if(getConfig().getBoolean("blockdamage", true)){
            pm.registerEvents(new blockdamage(), this);
        }
        if(getConfig().getBoolean("cavespider", true)){
            pm.registerEvents(new cavespider(), this);
        }
        if(getConfig().getBoolean("chicken", true)){
            pm.registerEvents(new chicken(), this);
        }
        if(getConfig().getBoolean("commands", true)){
            pm.registerEvents(new commands(), this);
        }
        if(getConfig().getBoolean("cow", true)){
            pm.registerEvents(new cow(), this);
        }
        if(getConfig().getBoolean("eggs", true)){
            pm.registerEvents(new eggs(), this);
        }
        if(getConfig().getBoolean("enderman", true)){
            pm.registerEvents(new enderman(), this);
        }
        if(getConfig().getBoolean("falldamage", true)){
            pm.registerEvents(new falldamage(), this);
        }
        if(getConfig().getBoolean("fishing", true)){
            pm.registerEvents(new fishing(), this);
        }
        if(getConfig().getBoolean("ghast", true)){
            pm.registerEvents(new ghast(), this);
        }
        if(getConfig().getBoolean("god", true)){
            pm.registerEvents(new god(), this);
        }
        if(getConfig().getBoolean("grow", true)){
            pm.registerEvents(new grow(), this);
        }
        if(getConfig().getBoolean("hunger", true)){
            pm.registerEvents(new hunger(), this);
        }
        if(getConfig().getBoolean("irongolem", true)){
            pm.registerEvents(new irongolem(), this);
        }
        if(getConfig().getBoolean("lightning", true)){
            pm.registerEvents(new lightning(), this);
        }
        if(getConfig().getBoolean("magmacube", true)){
            pm.registerEvents(new magmacube(), this);
        }
        if(getConfig().getBoolean("mooshroom", true)){
            pm.registerEvents(new mooshroom(), this);
        }
        if(getConfig().getBoolean("ocelot", true)){
            pm.registerEvents(new ocelot(), this);
        }
        if(getConfig().getBoolean("pig", true)){
            pm.registerEvents(new pig(), this);
        }
        if(getConfig().getBoolean("pigsaddle", true)){
            pm.registerEvents(new pigsaddle(), this);
        }
        if(getConfig().getBoolean("pigzap", true)){
            pm.registerEvents(new pigzap(), this);
        }
        if(getConfig().getBoolean("portal", true)){
            pm.registerEvents(new portal(), this);
        }
        if(getConfig().getBoolean("shear", true)){
            pm.registerEvents(new shear(), this);
        }
        if(getConfig().getBoolean("sheep", true)){
            pm.registerEvents(new sheep(), this);
        }
        if(getConfig().getBoolean("silverfish", true)){
            pm.registerEvents(new silverfish(), this);
        }
        if(getConfig().getBoolean("skeleton", true)){
            pm.registerEvents(new skeleton(), this);
        }
        if(getConfig().getBoolean("slime", true)){
            pm.registerEvents(new slime(), this);
        }
        if(getConfig().getBoolean("slimesplit", true)){
            pm.registerEvents(new slimesplit(), this);
        }
        if(getConfig().getBoolean("sneak", true)){
            pm.registerEvents(new sneak(), this);
        }
        if(getConfig().getBoolean("snowgolem", true)){
            pm.registerEvents(new snowgolem(), this);
        }
        if(getConfig().getBoolean("spider", true)){
            pm.registerEvents(new spider(), this);
        }
        if(getConfig().getBoolean("sprint", true)){
            pm.registerEvents(new sprint(), this);
        }
        if(getConfig().getBoolean("squid", true)){
            pm.registerEvents(new squid(), this);
        }
        if(getConfig().getBoolean("villager", true)){
            pm.registerEvents(new villager(), this);
        }
        if(getConfig().getBoolean("witch", true)){
            pm.registerEvents(new witch(), this);
        }
        if(getConfig().getBoolean("wolf", true)){
            pm.registerEvents(new wolf(), this);
        }
        if(getConfig().getBoolean("zombie", true)){
            pm.registerEvents(new zombie(), this);
        }
        if(getConfig().getBoolean("zombiepigmen", true)){
            pm.registerEvents(new zombiepigmen(), this);
        }
    }
}
