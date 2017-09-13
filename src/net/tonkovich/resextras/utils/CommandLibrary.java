package net.tonkovich.resextras.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CommandLibrary {
    public void run(CommandSender sender, Command cmd, String label, String[] args, String[] flagList){
        if (sender instanceof Player) {
            if (args.length == 0) {
                if (cmd.getName().equalsIgnoreCase("resextras")){
                    if (sender.hasPermission("ResExtras.help")){
                        sender.sendMessage(ChatColor.GOLD + "----------------" + ChatColor.BLUE + "[ResExtras] Help Menu" + ChatColor.GOLD + "----------------");
                        sender.sendMessage(ChatColor.RED + "/ResExtras version" + ChatColor.GREEN + "     Displays version Number  ");
                        sender.sendMessage(ChatColor.RED + "/ResExtras list" + ChatColor.GREEN + "     Displays flag list ");
                        sender.sendMessage(ChatColor.GOLD + "---------------------------------------------------");
                    }
                }
            }
            if (args.length == 1) {
                if(args[0].equalsIgnoreCase("version")){
                    if (sender.hasPermission("ResExtras.version")){
                        sender.sendMessage(ChatColor.BLUE + "[ResExtras]" + ChatColor.GREEN + " 3.1.3 ");
                    }
                }
                if(args[0].equalsIgnoreCase("list")){
                    if (sender.hasPermission("ResExtras.list")){
                        StringBuilder str = new StringBuilder();
                        for(String item: flagList){
                            str.append(item + ", ");
                        }
                        sender.sendMessage(ChatColor.BLUE + "[ResExtras]" + ChatColor.GREEN + " Flags");
                        sender.sendMessage(ChatColor.WHITE + " " + str.toString());
                    }
                }
            }
        }
    }
}
