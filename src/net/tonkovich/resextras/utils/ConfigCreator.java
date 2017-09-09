package net.tonkovich.resextras.utils;

import net.tonkovich.resextras.Main;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigCreator {
    private Main main = Main.getInstance();
    public void run(String[] flagList) {
        File cFile = new File("plugins/ResExtras/config.yml");
        Configuration config = YamlConfiguration.loadConfiguration(cFile);

        for (int i = 0; i < flagList.length; i++) {
            if (!config.contains(flagList[i])) { // Config value not detected, so add
                main.getConfig().set(flagList[i], true);
            }
        }
        config.options().copyDefaults(true);
        main.saveConfig();
    }
}
