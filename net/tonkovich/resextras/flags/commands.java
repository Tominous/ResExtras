package net.tonkovich.resextras.flags;

import net.t00thpick1.residence.api.ResidenceAPI;
import net.t00thpick1.residence.api.areas.PermissionsArea;
import net.t00thpick1.residence.utils.Utilities;
import net.tonkovich.resextras.FlagManagerExtras;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class commands implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void Commands(PlayerCommandPreprocessEvent event){
		Player player = event.getPlayer();
		Location loc = event.getPlayer().getLocation();
		boolean resadmin = Utilities.isAdminMode(player);
		PermissionsArea area = ResidenceAPI.getPermissionsAreaByLocation(loc);
		String playername = player.getName();
			if(area!=null && !area.allowAction(playername, FlagManagerExtras.COMMANDS) && !resadmin){
				event.setCancelled(true);
				event.getPlayer().sendMessage(derpa + "You cannot use commands here!");
			} 
	}
	ChatColor derpa = ChatColor.RED;
}
