package net.tonkovich.resextras;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.bekvon.bukkit.residence.protection.FlagPermissions;
import net.tonkovich.resextras.utils.CommandLibrary;
import net.tonkovich.resextras.utils.ConfigCreator;
import net.tonkovich.resextras.utils.EventRegister;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor {

    // Used to pass Main instance to other classes
    private static Main instance;
    public static Main getInstance(){
        return instance;
    }

    public static final String PLUGIN_NAME = "ResExtras";
    public static final String LOG_HEADER = "[" + PLUGIN_NAME + "] ";

    public static String[] flagList = {"bat","blaze","blockdamage","cavespider","chicken","cow","eggs"
										,"enderman","fishing","ghast","god","hunger","irongolem", "lightning"
                                        , "magmacube", "mooshroom", "ocelot", "pig", "pigsaddle","pizap"
    									, "portal", "sheep", "silverfish", "skeleton", "slime", "slimesplit"
    									, "sneak", "snowgolem", "spider", "sprint", "squid", "villager", "witch"
                                        , "wolf", "zombie", "zombiepigmen"};
	CommandLibrary cmdLibrary = new CommandLibrary();

    private Logger log;

    @Override
    public void onEnable() {
        instance = this;
        log = Logger.getLogger("Minecraft");
        PluginManager pm = getServer().getPluginManager();
        Plugin p = pm.getPlugin("Residence");
        if(p!=null) {
            if(p.isEnabled()) {
                pm.enablePlugin(p);
                EventRegister callRegister = new EventRegister();
                callRegister.start(pm);
                loadDefaults(); // Load config
				logInfo("Enabled");

                // Add flags to residence
				// TODO: Only add ones that are enabled
                for(int i = 0; i < flagList.length; i++){
                	FlagPermissions.addFlag(flagList[i]);
				}
            }
        }
        else {
            logInfo("Can't find plugin Residence!");
            this.setEnabled(false);
        }
    }
    public void onDisable(){
    	saveConfig();
    }
	
    public void logInfo(String _message) {
        log.log(Level.INFO,String.format("%s %s",LOG_HEADER,_message));
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
		cmdLibrary.run(sender, cmd, label, args, flagList); // Keeps main class clean
		return true;
	}


    public void loadDefaults(){
        ConfigCreator creator = new ConfigCreator();
        creator.run(flagList);
	}

}

