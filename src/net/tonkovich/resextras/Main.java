package net.tonkovich.resextras;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.bekvon.bukkit.residence.protection.FlagPermissions;
import net.tonkovich.resextras.utils.CommandLibrary;
import net.tonkovich.resextras.utils.ConfigCreator;
import net.tonkovich.resextras.utils.EventRegister;
import org.apache.commons.lang3.ArrayUtils;
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

    // Add nonMob flags here
    public static String[] nonMobFlagList = {"blockdamage","eggs","fishing","god","hunger", "lightning", "pigsaddle"
            ,"pizap","portal", "slimesplit", "sneak", "sprint"};

    // Add mob flags here
    public static String[] mobFlagList = {"bat", "blaze", "cave_spider", "chicken", "cow", "donkey"
            , "elder_guardian", "enderman", "endermite", "falling_block", "ghast", "guardian", "horse", "villager_golem"
            , "llama", "magma_cube", "mooshroom", "mule", "ocelot", "parrot", "pig"
            , "polar_bear", "rabbit", "sheep", "silverfish", "skeleton","skeleton_horse", "slime"
            , "snowman", "spider", "squid", "stray", "vex", "villager", "vindicator", "witch", "wither_skeleton"
            , "wolf", "zombie", "zombie_horse", "zombie_pigman", "zombie_villager"};

    // Will hold all enabled flags with a max length of possible
    public static String[] enabled = new String[mobFlagList.length];

    // Complete List of all flags
    public static String[] flagList = (String[]) ArrayUtils.addAll(mobFlagList,nonMobFlagList);

    // Count of enabled array
    int counter = 0;

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

                // Adds enabled nonMobFlags to residence
                for(int i = 0; i < nonMobFlagList.length; i++){
                    if(getConfig().getBoolean(nonMobFlagList[i], true)) {
                        FlagPermissions.addFlag(nonMobFlagList[i]);
                    }
				}
				// Adds enabled mobFlags and then puts them into an array
                // for mob.class to run through and check only those
				for(int i = 0; i < mobFlagList.length; i++){
                    if(getConfig().getBoolean(mobFlagList[i], true)){
                        FlagPermissions.addFlag(mobFlagList[i]);
                        setEnabledFlag(mobFlagList[i]);
                        counter++;
                    }
                }
                logInfo("Enabled"); // Done
            }
        }
        else {
            logInfo("Can't find plugin Residence!");
            this.setEnabled(false);
        }
    }
    public void onDisable(){
    	saveConfig();
    	counter = 0;
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

	// getter and setter for mob class
    public String[] getEnabledFlags(){
        return enabled;
    }
    public void setEnabledFlag(String item){
        enabled[counter] = item;
    }

    public void logInfo(String _message) {
        log.log(Level.INFO,String.format("%s %s",LOG_HEADER,_message));
    }
}

