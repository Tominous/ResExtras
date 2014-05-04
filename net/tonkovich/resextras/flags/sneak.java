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
import org.bukkit.event.player.PlayerMoveEvent;

public class sneak implements Listener {
	@EventHandler(priority = EventPriority.MONITOR)
	public void Sneak(PlayerMoveEvent event){
	    if(event.isCancelled())
	        return;
		Player player = event.getPlayer();
	    if(!player.isSprinting() && (!player.isSneaking()))
	    	return;
	    boolean resadmin = Utilities.isAdminMode(player);
		if (resadmin) {
			return;
		}
		PermissionsArea area = ResidenceAPI.getPermissionsAreaByLocation(player.getLocation());
		String playername = player.getName();
	    if(area!=null) {
	        if(!area.allowAction(playername, FlagManagerExtras.SNEAK) && player.isSneaking()) {
	            long currentTime = System.currentTimeMillis();
	            if(currentTime%2000>=0 && currentTime%2000<=100){
	            event.setCancelled(true);
	            player.sendMessage(derpa + "You cannot sneak here!");
	            return;
	        }
	        }
	    }
	}
	ChatColor derpa = ChatColor.RED;
}