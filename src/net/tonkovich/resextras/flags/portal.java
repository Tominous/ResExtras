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
import org.bukkit.event.player.PlayerPortalEvent;

public class portal implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void Portal(PlayerPortalEvent event){
		Player player = event.getPlayer();
	    Location loc = event.getPlayer().getLocation();
		if(event.isCancelled())
			return;
		if (Utilities.isAdminMode(player))
			return;

		PermissionsArea area = ResidenceAPI.getPermissionsAreaByLocation(loc);
		String playername = player.getName();
		if(area!=null){
			if(!area.allowAction(playername, FlagManagerExtras.NETHERPORTING)){
				event.setCancelled(true);
				event.getPlayer().sendMessage(derpa + "You cannot use portals here!");
			}
		}
	}
	ChatColor derpa = ChatColor.RED;
}