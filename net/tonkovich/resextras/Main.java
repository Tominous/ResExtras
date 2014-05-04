package net.tonkovich.resextras;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import net.tonkovich.resextras.Metrics;
import net.tonkovich.resextras.flags.animalkilling;
import net.tonkovich.resextras.flags.bat;
import net.tonkovich.resextras.flags.blaze;
import net.tonkovich.resextras.flags.blockdamage;
import net.tonkovich.resextras.flags.cavespider;
import net.tonkovich.resextras.flags.chicken;
import net.tonkovich.resextras.flags.commands;
import net.tonkovich.resextras.flags.cow;
import net.tonkovich.resextras.flags.creeperspawn;
import net.tonkovich.resextras.flags.drops;
import net.tonkovich.resextras.flags.eggs;
import net.tonkovich.resextras.flags.enderman;
import net.tonkovich.resextras.flags.enderpearl;
import net.tonkovich.resextras.flags.falldamage;
import net.tonkovich.resextras.flags.fishing;
import net.tonkovich.resextras.flags.form;
import net.tonkovich.resextras.flags.ghast;
import net.tonkovich.resextras.flags.god;
import net.tonkovich.resextras.flags.grow;
import net.tonkovich.resextras.flags.hunger;
import net.tonkovich.resextras.flags.irongolem;
import net.tonkovich.resextras.flags.lightning;
import net.tonkovich.resextras.flags.magmacube;
import net.tonkovich.resextras.flags.melt;
import net.tonkovich.resextras.flags.mobkilling;
import net.tonkovich.resextras.flags.mooshroom;
import net.tonkovich.resextras.flags.ocelot;
import net.tonkovich.resextras.flags.pickup;
import net.tonkovich.resextras.flags.pig;
import net.tonkovich.resextras.flags.pigsaddle;
import net.tonkovich.resextras.flags.pigzap;
import net.tonkovich.resextras.flags.portal;
import net.tonkovich.resextras.flags.shear;
import net.tonkovich.resextras.flags.sheep;
import net.tonkovich.resextras.flags.silverfish;
import net.tonkovich.resextras.flags.skeleton;
import net.tonkovich.resextras.flags.slime;
import net.tonkovich.resextras.flags.slimesplit;
import net.tonkovich.resextras.flags.sneak;
import net.tonkovich.resextras.flags.snowgolem;
import net.tonkovich.resextras.flags.spider;
import net.tonkovich.resextras.flags.sprint;
import net.tonkovich.resextras.flags.squid;
import net.tonkovich.resextras.flags.time;
import net.tonkovich.resextras.flags.trade;
import net.tonkovich.resextras.flags.vehicleprotect;
import net.tonkovich.resextras.flags.villager;
import net.tonkovich.resextras.flags.villagerkilling;
import net.tonkovich.resextras.flags.weather;
import net.tonkovich.resextras.flags.witch;
import net.tonkovich.resextras.flags.witherspawn;
import net.tonkovich.resextras.flags.wolf;
import net.tonkovich.resextras.flags.zombie;
import net.tonkovich.resextras.flags.zombiepigmen;

public class Main extends JavaPlugin implements CommandExecutor {
    public static final String PLUGIN_NAME = "ResExtras";
    public static final String LOG_HEADER = "[" + PLUGIN_NAME + "] ";
    
    private Logger log;   
    
    
    @Override
    public void onLoad()
    {
        FlagManagerExtras.initFlags();
    }
    
    //very long start up lolz
    @Override
    public void onEnable() {

        log = Logger.getLogger("Minecraft");           
        
        try {
            Metrics metrics = new Metrics(this);
            metrics.start();
        } catch (IOException e) {
            // Failed to submit the stats :-(
        }
        loadDefaults();
        PluginManager pm = getServer().getPluginManager();
        Plugin p = pm.getPlugin("Residence");
        if(p!=null) {
            if(p.isEnabled()) {
                logInfo("Enabled");
                pm.enablePlugin(p);
                if(getConfig().getBoolean("Zombie", true)){
                	pm.registerEvents(new zombie(), this);
                }
                if(getConfig().getBoolean("Skeleton", true)){
                	pm.registerEvents(new skeleton(), this);
                }
                if(getConfig().getBoolean("Creeperspawn", true)){
                	pm.registerEvents(new creeperspawn(), this);
                }
                if(getConfig().getBoolean("Spider", true)){
                	pm.registerEvents(new spider(), this);
                }
                if(getConfig().getBoolean("Cavespider", true)){
                	pm.registerEvents(new cavespider(), this);
                }
                if(getConfig().getBoolean("Slime", true)){
                	pm.registerEvents(new slime(), this);
                }
                if(getConfig().getBoolean("Ghast", true)){
                	pm.registerEvents(new ghast(), this);
                }
                if(getConfig().getBoolean("Blaze", true)){
                	pm.registerEvents(new blaze(), this);
                }
                if(getConfig().getBoolean("Magmacube", true)){
                	pm.registerEvents(new magmacube(), this);
                }
                if(getConfig().getBoolean("Silverfish", true)){
                	pm.registerEvents(new silverfish(), this);
                }
                if(getConfig().getBoolean("Snowgolem", true)){
                	pm.registerEvents(new snowgolem(), this);
                }
                if(getConfig().getBoolean("Irongolem", true)){
                	pm.registerEvents(new irongolem(), this);
                }
                if(getConfig().getBoolean("Enderman", true)){
                	pm.registerEvents(new enderman(), this);
                }
                if(getConfig().getBoolean("Chicken", true)){
                	pm.registerEvents(new chicken(), this);
                }
                if(getConfig().getBoolean("Cow", true)){
                	pm.registerEvents(new cow(), this);
                }
                if(getConfig().getBoolean("Wolf", true)){
                	pm.registerEvents(new wolf(), this);
                }
                if(getConfig().getBoolean("Mooshroom", true)){
                	pm.registerEvents(new mooshroom(), this);
                }
                if(getConfig().getBoolean("Ocelot", true)){
                	pm.registerEvents(new ocelot(), this);
                }
                if(getConfig().getBoolean("Zombiepigmen", true)){
                	pm.registerEvents(new zombiepigmen(), this);
                }
                if(getConfig().getBoolean("Pig", true)){
                	pm.registerEvents(new pig(), this);
                }
                if(getConfig().getBoolean("Sheep", true)){
                	pm.registerEvents(new sheep(), this);
                }
                if(getConfig().getBoolean("Squid", true)){
                	pm.registerEvents(new squid(), this);
                }
                if(getConfig().getBoolean("Villager", true)){
                	pm.registerEvents(new villager(), this);
                }
                if(getConfig().getBoolean("Bat", true)){
                	pm.registerEvents(new bat(), this);
                }
                if(getConfig().getBoolean("Witch", true)){
                	pm.registerEvents(new witch(), this);
                }
                if(getConfig().getBoolean("Witherspawn", true)){
                	pm.registerEvents(new witherspawn(), this);
                }
                if(getConfig().getBoolean("Melt", true)){
                	pm.registerEvents(new melt(), this);
                }
                if(getConfig().getBoolean("Form", true)){
                	pm.registerEvents(new form(), this);
                }
                if(getConfig().getBoolean("Animalkilling", true)){
                	pm.registerEvents(new animalkilling(), this);
                }
                if(getConfig().getBoolean("Mobkilling", true)){
                	pm.registerEvents(new mobkilling(), this);
                }
                if(getConfig().getBoolean("Drops", true)){
                	pm.registerEvents(new drops(), this);
                }
                if(getConfig().getBoolean("Pickup", true)){
                	pm.registerEvents(new pickup(), this);
                }
                if(getConfig().getBoolean("Commands", true)){
                	pm.registerEvents(new commands(), this);
                }
                if(getConfig().getBoolean("Enderpearl", true)){
                	pm.registerEvents(new enderpearl(), this);
                }
                if(getConfig().getBoolean("Falldamage", true)){
                	pm.registerEvents(new falldamage(), this);
                }
                if(getConfig().getBoolean("Portal", true)){
                	pm.registerEvents(new portal(), this);
                }
                if(getConfig().getBoolean("Villagerkilling", true)){
                	pm.registerEvents(new villagerkilling(), this);
                }
                if(getConfig().getBoolean("Vehicleprotect", true)){
                	pm.registerEvents(new vehicleprotect(), this);
                }
                if(getConfig().getBoolean("Lightning", true)){
                	pm.registerEvents(new lightning(), this);
                }
                if(getConfig().getBoolean("Grow", true)){
                	pm.registerEvents(new grow(), this);
                }
                if(getConfig().getBoolean("Hunger", true)){
                	pm.registerEvents(new hunger(), this);
                }
                if(getConfig().getBoolean("Sprint", true)){
                	pm.registerEvents(new sprint(), this);
                }
                if(getConfig().getBoolean("Fishing", true)){
                	pm.registerEvents(new fishing(), this);
                }
                if(getConfig().getBoolean("Eggs", true)){
                	pm.registerEvents(new eggs(), this);
                }
                if(getConfig().getBoolean("Sneak", true)){
                	pm.registerEvents(new sneak(), this);
                }
                if(getConfig().getBoolean("Pigzap", true)){
                	pm.registerEvents(new pigzap(), this);
                }
                if(getConfig().getBoolean("Slimesplit", true)){
                	pm.registerEvents(new slimesplit(), this);
                }
                if(getConfig().getBoolean("Shear", true)){
                	pm.registerEvents(new shear(), this);
                }
                if(getConfig().getBoolean("Pigsaddle", true)){
                	pm.registerEvents(new pigsaddle(), this);
                }
                if(getConfig().getBoolean("Trade", true)){
                	pm.registerEvents(new trade(), this);
                }
                if(getConfig().getBoolean("God", true)){
                	pm.registerEvents(new god(), this);
                }
                if(getConfig().getBoolean("Weather", true)){
                	pm.registerEvents(new weather(), this);
                }
                if(getConfig().getBoolean("Time", true)){
                	pm.registerEvents(new time(), this);
                }
                if(getConfig().getBoolean("BlockDamage", true)){
                	pm.registerEvents(new blockdamage(), this);
                }
                /*if(getConfig().getBoolean("CrystalProtect", true)){
                	pm.registerEvents(new crystalprotect(), this);
                }*/
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

    public void logError(String _message) {
        log.log(Level.SEVERE,String.format("%s %s",LOG_HEADER,_message));
    }
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
    	if (sender instanceof Player) {
    		if (args.length == 0) {
			if (cmd.getName().equalsIgnoreCase("resextras")){
				if (sender.hasPermission("ResExtras.help")){
					sender.sendMessage(ChatColor.GOLD + "----------------" + ChatColor.BLUE + "[ResExtras] Help Menu" + ChatColor.GOLD + "----------------");
					sender.sendMessage(ChatColor.RED + "/ResExtras" + ChatColor.GREEN + "     Displays help menu  ");
					sender.sendMessage(ChatColor.RED + "/ResExtras help" + ChatColor.GREEN + "     Displays help menu  ");
					sender.sendMessage(ChatColor.RED + "/ResExtras version" + ChatColor.GREEN + "     Displays version Number  ");
					sender.sendMessage(ChatColor.RED + "/ResExtras list" + ChatColor.GREEN + "     Displays flag list ");
					sender.sendMessage(ChatColor.GOLD + "---------------------------------------------------");
				}
			}
    		}
				if (args.length == 1) {
					if(args[0].equalsIgnoreCase("version")){
						if (sender.hasPermission("ResExtras.version")){
							sender.sendMessage(ChatColor.BLUE + "[ResExtras]" + ChatColor.GREEN + " v2.0.5 ");
					}
				}
					if(args[0].equalsIgnoreCase("list")){
						if (sender.hasPermission("ResExtras.list")){
							sender.sendMessage(ChatColor.BLUE + "[ResExtras]" + ChatColor.GREEN + " Flags");
							sender.sendMessage(ChatColor.WHITE + " Zombie, Skeleton, Spider, Creeperspawn, Blaze, Cavespider, Ghast, Slime, Magmacube, Silverfish, Snowgolem, Irongolem, Enderman, Zombiepigmen, Chicken, Cow, Mooshroom, Ocelot, Pig, Sheep, Squid, Villager, Wolf, Bat, Witherspawn, Witch, Form, Melt, Commands, FallDamage, Portal, Enderperal, Mobkilling, AnimalKilling, VillagerKilling, Drops, Pickup, VehicleProtect, Lightning, Grow, Hunger, Sprint, Fishing, Eggs, Sneak, PigZap, SlimeSplit, Shear, PigSaddle, Trade, God, Weather, Time, BlockDamage ");
					}
				}
					if(args[0].equalsIgnoreCase("help")){
						if (sender.hasPermission("ResExtras.help")){
							sender.sendMessage(ChatColor.GOLD + "----------------" + ChatColor.BLUE + "[ResExtras] Help Menu" + ChatColor.GOLD + "----------------");
							sender.sendMessage(ChatColor.RED + "/ResExtras" + ChatColor.GREEN + "     Displays help menu  ");
							sender.sendMessage(ChatColor.RED + "/ResExtras help" + ChatColor.GREEN + "     Displays help menu  ");
							sender.sendMessage(ChatColor.RED + "/ResExtras version" + ChatColor.GREEN + "     Displays version Number  ");
							sender.sendMessage(ChatColor.RED + "/ResExtras list" + ChatColor.GREEN + "     Displays flag list ");
							sender.sendMessage(ChatColor.GOLD + "---------------------------------------------------");
					}
				}
			}
		return true;   	
    }
		return true;
}
    //very long config
    //Going to make this shorter but I'm too lazy
    //To be honest I just made it like that way since it was in my other plugin so I just copy and pasta'd I'm really lazy :3
    //and I like making little stories in my code...I'm insane o.o
    /*I love ramen since its like the only thing I actually know how to make. I used to make
     * pancakes but I forgot how to make them which kinda pisses me off. Oh by the way I'm
     * only 17 :P. Its nice to know that someone has to read this (I think) since one of my friends
     * is on the DevBukkit team so its nice to meet you :D. You can even message me on Bukkit(Tonkovich) 
     * just so I know you read this. Well thats all I really know what to type since I kinda just typed
     * random stuff. I have a pokeball :3
     * 
     * Dafuq did you just read o.O
     */
    public void loadDefaults(){
    	FileConfiguration configG = getConfig();
    	File configFile = new File("plugins/ResExtras/config.yml");
    	config = YamlConfiguration.loadConfiguration(configFile);
        configG.options().header("This completely disables parts of ResExtras increasing efficiency.");
    	if(config.contains("Zombie")){
    	}
    	else {
        	getConfig().addDefault("Zombie", true);
    	}
    	if(config.contains("Skeleton")){
    	}
    	else {
        	getConfig().addDefault("Skeleton", true);
    	}
    	if(config.contains("Spider")){
    	}
    	else {
        	getConfig().addDefault("Spider", true);
    	}
    	if(config.contains("Creeperspawn")){
    	}
    	else {
        	getConfig().addDefault("Creeperspawn", true);
    	}
    	if(config.contains("Blaze")){
    	}
    	else {
        	getConfig().addDefault("Blaze", true);
    	}
    	if(config.contains("Cavespider")){
    	}
    	else {
        	getConfig().addDefault("Cavespider", true);
    	}
    	if(config.contains("Ghast")){
    	}
    	else {
        	getConfig().addDefault("Ghast", true);
    	}
    	if(config.contains("Slime")){
    	}
    	else {
        	getConfig().addDefault("Slime", true);
    	}
    	if(config.contains("Magmacube")){
    	}
    	else {
        	getConfig().addDefault("Magmacube", true);
    	}
    	if(config.contains("Silverfish")){
    	}
    	else {
        	getConfig().addDefault("Silverfish", true);
    	}
    	if(config.contains("Snowgolem")){
    	}
    	else {
        	getConfig().addDefault("Snowgolem", true);
    	}
    	if(config.contains("Irongolem")){
    	}
    	else {
        	getConfig().addDefault("Irongolem", true);
    	}
    	if(config.contains("Enderman")){
    	}
    	else {
        	getConfig().addDefault("Enderman", true);
    	}
    	if(config.contains("Zombiepigmen")){
    	}
    	else {
        	getConfig().addDefault("Zombiepigmen", true);
    	}
    	if(config.contains("Chicken")){
    	}
    	else {
        	getConfig().addDefault("Chicken", true);
    	}
    	if(config.contains("Cow")){
    	}
    	else {
        	getConfig().addDefault("Cow", true);
    	}
    	if(config.contains("Mooshroom")){
    	}
    	else {
        	getConfig().addDefault("Mooshroom", true);
    	}
    	if(config.contains("Ocelot")){
    	}
    	else {
        	getConfig().addDefault("Ocelot", true);
    	}
    	if(config.contains("Pig")){
    	}
    	else {
        	getConfig().addDefault("Pig", true);
    	}
    	if(config.contains("Sheep")){
    	}
    	else {
        	getConfig().addDefault("Sheep", true);
    	}
    	if(config.contains("Squid")){
    	}
    	else {
        	getConfig().addDefault("Squid", true);
    	}
    	if(config.contains("Villager")){
    	}
    	else {
        	getConfig().addDefault("Villager", true);
    	}
    	if(config.contains("Wolf")){
    	}
    	else {
        	getConfig().addDefault("Wolf", true);
    	}
    	if(config.contains("Bat")){
    	}
    	else {
        	getConfig().addDefault("Bat", true);
    	}
    	if(config.contains("Witherspawn")){
    	}
    	else {
        	getConfig().addDefault("Witherspawn", true);
    	}
    	if(config.contains("Witch")){
    	}
    	else {
        	getConfig().addDefault("Witch", true);
    	}
    	if(config.contains("Form")){
    	}
    	else {
        	getConfig().addDefault("Form", true);
    	}
    	if(config.contains("Melt")){
    	}
    	else {
        	getConfig().addDefault("Melt", true);
    	}
    	if(config.contains("Commands")){
    	}
    	else {
        	getConfig().addDefault("Commands", true);
    	}
    	if(config.contains("Falldamage")){
    	}
    	else {
        	getConfig().addDefault("Falldamage", true);
    	}
    	if(config.contains("Portal")){
    	}
    	else {
        	getConfig().addDefault("Portal", true);
    	}
    	if(config.contains("Enderpearl")){
    	}
    	else {
        	getConfig().addDefault("Enderpearl", true);
    	}
    	if(config.contains("Mobkilling")){
    	}
    	else {
        	getConfig().addDefault("Mobkilling", true);
    	}
    	if(config.contains("Animalkilling")){
    	}
    	else {
        	getConfig().addDefault("Animalkilling", true);
    	}
    	if(config.contains("Villagerkilling")){
    	}
    	else {
        	getConfig().addDefault("Villagerkilling", true);
    	}
    	if(config.contains("Drops")){
    	}
    	else {
        	getConfig().addDefault("Drops", true);
    	}
    	if(config.contains("Pickup")){
    	}
    	else {
        	getConfig().addDefault("Pickup", true);
    	}
    	if(config.contains("Vehicleprotect")){
    	}
    	else {
        	getConfig().addDefault("Vehicleprotect", true);
    	}
    	if(config.contains("Lightning")){
    	}
    	else {
        	getConfig().addDefault("Lightning", true);
    	}
    	if(config.contains("Grow")){
    	}
    	else {
        	getConfig().addDefault("Grow", true);
    	}
    	if(config.contains("Hunger")){
    	}
    	else {
        	getConfig().addDefault("Hunger", true);
    	}
    	if(config.contains("Sprint")){
    	}
    	else {
        	getConfig().addDefault("Sprint", true);
    	}
    	if(config.contains("Fishing")){
    	}
    	else {
        	getConfig().addDefault("Fishing", true);
    	}
    	if(config.contains("Eggs")){
    	}
    	else {
        	getConfig().addDefault("Eggs", true);
    	}
    	if(config.contains("Sneak")){
    	}
    	else {
        	getConfig().addDefault("Sneak", true);
    	}
    	if(config.contains("Pigzap")){
    	}
    	else {
        	getConfig().addDefault("Pigzap", true);
    	}
    	if(config.contains("Slimesplit")){
    	}
    	else {
        	getConfig().addDefault("Slimesplit", true);
    	}
    	if(config.contains("Shear")){
    	}
    	else {
        	getConfig().addDefault("Shear", true);
    	}
    	if(config.contains("Pigsaddle")){
    	}
    	else {
        	getConfig().addDefault("Pigsaddle", true);
    	}
    	if(config.contains("Trade")){
    	}
    	else {
        	getConfig().addDefault("Trade", true);
    	}
    	if(config.contains("God")){
    	}
    	else {
        	getConfig().addDefault("God", true);
    	}
    	if(config.contains("Time")){
    	}
    	else {
        	getConfig().addDefault("Time", true);
    	}
    	if(config.contains("Weather")){
    	}
    	else {
        	getConfig().addDefault("Weather", true);
    	}
    	if(config.contains("BlockDamage")){
    	}
    	else {
        	getConfig().addDefault("BlockDamage", true);
    	}
    	/*if(config.contains("CrystalProtect")){
    	}
    	else {
        	getConfig().addDefault("CrystalProtect", true);
    	}*/
    	configG.options().copyDefaults(true);
    	saveConfig();
    }
    public Configuration config;
}

