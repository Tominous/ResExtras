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
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

public class enderpearl implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void Enderpearl(PlayerTeleportEvent event){
		if(event.isCancelled())
			return;
		Location loc = event.getTo();
		Player player = event.getPlayer();
		boolean resadmin = Utilities.isAdminMode(player);
		PermissionsArea area = ResidenceAPI.getPermissionsAreaByLocation(loc);
		String playername = player.getName();
		if(area!=null){
			if(event.getCause()==TeleportCause.ENDER_PEARL && !area.allowAction(playername, FlagManagerExtras.ENDERPEARLS) && !resadmin){
					event.setCancelled(true);
					event.getPlayer().sendMessage(derpa + "You cannot use ender pearls here!");
			}
		}
	}
	ChatColor derpa = ChatColor.RED;
}