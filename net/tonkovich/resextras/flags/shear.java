package net.tonkovich.resextras.flags;

import net.t00thpick1.residence.api.ResidenceAPI;
import net.t00thpick1.residence.api.areas.PermissionsArea;
import net.t00thpick1.residence.utils.Utilities;
import net.tonkovich.resextras.FlagManagerExtras;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;

public class shear implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void Shear(PlayerShearEntityEvent event){
	    if(event.isCancelled())
	        return;
		Player player = event.getPlayer();
		PermissionsArea area = ResidenceAPI.getPermissionsAreaByLocation(event.getEntity().getLocation());
	    boolean resadmin = Utilities.isAdminMode(player);
		String playername = player.getName();
		if(area!=null && !area.allowAction(playername, FlagManagerExtras.SHEAR) &&!resadmin){
			event.setCancelled(true);
			event.getPlayer().sendMessage(derpa + "You cannot shear here!");
		}
	}
	ChatColor derpa = ChatColor.RED;
}