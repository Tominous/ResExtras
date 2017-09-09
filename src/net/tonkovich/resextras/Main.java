package net.tonkovich.resextras;

import com.bekvon.bukkit.residence.protection.FlagPermissions;

import java.io.File;
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
import net.tonkovich.resextras.flags.bat;
import net.tonkovich.resextras.flags.blaze;
import net.tonkovich.resextras.flags.blockdamage;
import net.tonkovich.resextras.flags.cavespider;
import net.tonkovich.resextras.flags.chicken;
import net.tonkovich.resextras.flags.commands;
import net.tonkovich.resextras.flags.cow;
import net.tonkovich.resextras.flags.eggs;
import net.tonkovich.resextras.flags.enderman;
import net.tonkovich.resextras.flags.falldamage;
import net.tonkovich.resextras.flags.fishing;
import net.tonkovich.resextras.flags.ghast;
import net.tonkovich.resextras.flags.god;
import net.tonkovich.resextras.flags.grow;
import net.tonkovich.resextras.flags.hunger;
import net.tonkovich.resextras.flags.irongolem;
import net.tonkovich.resextras.flags.lightning;
import net.tonkovich.resextras.flags.magmacube;
import net.tonkovich.resextras.flags.mooshroom;
import net.tonkovich.resextras.flags.ocelot;
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
import net.tonkovich.resextras.flags.villager;
import net.tonkovich.resextras.flags.witch;
import net.tonkovich.resextras.flags.wolf;
import net.tonkovich.resextras.flags.zombie;
import net.tonkovich.resextras.flags.zombiepigmen;

public class Main extends JavaPlugin implements CommandExecutor {
    public static final String PLUGIN_NAME = "ResExtras";
    public static final String LOG_HEADER = "[" + PLUGIN_NAME + "] ";
    
    private Logger log;   
    
    
    @Override
    public void onLoad() {}

    @Override
    public void onEnable() {

        log = Logger.getLogger("Minecraft");

        loadDefaults();
        PluginManager pm = getServer().getPluginManager();
        Plugin p = pm.getPlugin("Residence");
        if(p!=null) {
            if(p.isEnabled()) {
                logInfo("Enabled");
                pm.enablePlugin(p);
				FlagPermissions.addFlag("zombie");
				FlagPermissions.addFlag("skeleton");
				FlagPermissions.addFlag("spider");
				FlagPermissions.addFlag("cavespider");
				FlagPermissions.addFlag("slime");
				FlagPermissions.addFlag("ghast");
				FlagPermissions.addFlag("blaze");
				FlagPermissions.addFlag("magmacube");
				FlagPermissions.addFlag("silverfish");
				FlagPermissions.addFlag("snowgolem");
				FlagPermissions.addFlag("irongolem");
				FlagPermissions.addFlag("enderman");
				FlagPermissions.addFlag("wolf");
				FlagPermissions.addFlag("zombiepigmen");
				FlagPermissions.addFlag("chicken");
				FlagPermissions.addFlag("cow");
				FlagPermissions.addFlag("mooshroom");
				FlagPermissions.addFlag("ocelot");
				FlagPermissions.addFlag("pig");
				FlagPermissions.addFlag("sheep");
				FlagPermissions.addFlag("squid");
				FlagPermissions.addFlag("villager");
				FlagPermissions.addFlag("bat");
				FlagPermissions.addFlag("witch");
				FlagPermissions.addFlag("falldamage");
				FlagPermissions.addFlag("commands");
				FlagPermissions.addFlag("portal");
				FlagPermissions.addFlag("lightning");
				FlagPermissions.addFlag("grow");
				FlagPermissions.addFlag("hunger");
				FlagPermissions.addFlag("sprint");
				FlagPermissions.addFlag("fishing");
				FlagPermissions.addFlag("eggs");
				FlagPermissions.addFlag("sneak");
				FlagPermissions.addFlag("pigzap");
				FlagPermissions.addFlag("slimesplit");
				FlagPermissions.addFlag("shear");
				FlagPermissions.addFlag("pigsaddle");
				FlagPermissions.addFlag("god");
                if(getConfig().getBoolean("Zombie", true)){
                	pm.registerEvents(new zombie(), this);
                }
                if(getConfig().getBoolean("Skeleton", true)){
                	pm.registerEvents(new skeleton(), this);
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
                if(getConfig().getBoolean("Commands", true)){
                	pm.registerEvents(new commands(), this);
                }
                if(getConfig().getBoolean("Falldamage", true)){
                	pm.registerEvents(new falldamage(), this);
                }
                if(getConfig().getBoolean("Portal", true)){
                	pm.registerEvents(new portal(), this);
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
                if(getConfig().getBoolean("God", true)){
                	pm.registerEvents(new god(), this);
                }
                if(getConfig().getBoolean("BlockDamage", true)){
                	pm.registerEvents(new blockdamage(), this);
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
							sender.sendMessage(ChatColor.WHITE + " Zombie, Skeleton, Spider, Blaze, Cavespider, Ghast, Slime, Magmacube, Silverfish, Snowgolem, " +
									"Irongolem, Enderman, Zombiepigmen, Chicken, Cow, Mooshroom, Ocelot, Pig, Sheep, Squid, Villager, Wolf, Bat, Witch, Commands, " +
									"FallDamage, Portal, Lightning, Grow, Hunger, Sprint, Fishing, Eggs, Sneak, PigZap, SlimeSplit, Shear, PigSaddle, God, BlockDamage ");
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
    // Generates config, sorta unnecessary
    public void loadDefaults(){
    	FileConfiguration configG = getConfig();
    	File configFile = new File("plugins/ResExtras/config.yml");
    	config = YamlConfiguration.loadConfiguration(configFile);
        configG.options().header("This completely disables parts of ResExtras increasing efficiency.");
    	if(!config.contains("Zombie")){
			getConfig().addDefault("Zombie", true);
    	}
    	if(!config.contains("Skeleton")){
			getConfig().addDefault("Skeleton", true);
    	}
    	if(!config.contains("Spider")){
			getConfig().addDefault("Spider", true);
    	}
    	if(!config.contains("Blaze")){
			getConfig().addDefault("Blaze", true);
    	}
    	if(!config.contains("Cavespider")){
			getConfig().addDefault("Cavespider", true);
    	}
    	if(!config.contains("Ghast")){
			getConfig().addDefault("Ghast", true);
    	}
    	if(!config.contains("Slime")){
			getConfig().addDefault("Slime", true);
    	}
    	if(!config.contains("Magmacube")){
			getConfig().addDefault("Magmacube", true);
    	}
    	if(!config.contains("Silverfish")){
			getConfig().addDefault("Silverfish", true);
    	}
    	if(!config.contains("Snowgolem")){
			getConfig().addDefault("Snowgolem", true);
    	}
    	if(!config.contains("Irongolem")){
			getConfig().addDefault("Irongolem", true);
    	}
    	if(!config.contains("Enderman")){
			getConfig().addDefault("Enderman", true);
    	}
    	if(!config.contains("Zombiepigmen")){
			getConfig().addDefault("Zombiepigmen", true);
    	}
    	if(!config.contains("Chicken")){
			getConfig().addDefault("Chicken", true);
    	}
    	if(!config.contains("Cow")){
			getConfig().addDefault("Cow", true);
    	}
    	if(!config.contains("Mooshroom")){
			getConfig().addDefault("Mooshroom", true);
    	}
    	if(!config.contains("Ocelot")){
			getConfig().addDefault("Ocelot", true);
    	}
    	if(!config.contains("Pig")){
			getConfig().addDefault("Pig", true);
    	}
    	if(!config.contains("Sheep")){
			getConfig().addDefault("Sheep", true);
    	}
    	if(!config.contains("Squid")){
			getConfig().addDefault("Squid", true);
    	}
    	if(!config.contains("Villager")){
			getConfig().addDefault("Villager", true);
    	}
    	if(!config.contains("Wolf")){
			getConfig().addDefault("Wolf", true);
    	}
    	if(!config.contains("Bat")){
			getConfig().addDefault("Bat", true);
    	}
    	if(!config.contains("Witch")){
			getConfig().addDefault("Witch", true);
    	}
    	if(!config.contains("Commands")){
			getConfig().addDefault("Commands", true);
    	}
    	if(!config.contains("Falldamage")){
			getConfig().addDefault("Falldamage", true);
    	}
    	if(!config.contains("Portal")){
			getConfig().addDefault("Portal", true);
    	}
    	if(!config.contains("Pickup")){
			getConfig().addDefault("Pickup", true);
    	}
    	if(!config.contains("Lightning")){
			getConfig().addDefault("Lightning", true);
    	}
    	if(!config.contains("Grow")){
			getConfig().addDefault("Grow", true);
    	}
    	if(!config.contains("Hunger")){
			getConfig().addDefault("Hunger", true);
    	}
    	if(!config.contains("Sprint")){
			getConfig().addDefault("Sprint", true);
    	}
    	if(!config.contains("Fishing")){
			getConfig().addDefault("Fishing", true);
    	}
    	if(!config.contains("Eggs")){
			getConfig().addDefault("Eggs", true);
    	}
    	if(!config.contains("Sneak")){
			getConfig().addDefault("Sneak", true);
    	}
    	if(!config.contains("Pigzap")){
			getConfig().addDefault("Pigzap", true);
    	}
    	if(!config.contains("Slimesplit")){
			getConfig().addDefault("Slimesplit", true);
    	}
    	if(!config.contains("Shear")){
			getConfig().addDefault("Shear", true);
    	}
    	if(!config.contains("Pigsaddle")){
			getConfig().addDefault("Pigsaddle", true);
    	}
    	if(!config.contains("Trade")){
			getConfig().addDefault("Trade", true);
    	}
    	if(!config.contains("God")){
			getConfig().addDefault("God", true);
    	}
    	if(!config.contains("BlockDamage")){
			getConfig().addDefault("BlockDamage", true);
    	}
    	config.options().copyDefaults(true);
    	saveConfig();
    }
    public Configuration config;
}

