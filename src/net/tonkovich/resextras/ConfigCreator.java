package net.tonkovich.resextras;

import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * Created by Tonk on 9/9/2017.
 */
public class ConfigCreator extends JavaPlugin {
    public Configuration config;
    public void run(String[] flagList) {
        FileConfiguration configF = getConfig();
        File configFile = new File("plugins/ResExtras/config.yml");
        config = YamlConfiguration.loadConfiguration(configFile);
        configF.options().header("This completely disables parts of ResExtras increasing efficiency.");

        for(int i = 0; i < flagList.length; i++){
            if(!config.contains(flagList[i])){ // Config value not detected, so add
                getConfig().addDefault(flagList[i], true);
            }
        }
        configF.options().copyDefaults(true);
        saveConfig();
    }
}

