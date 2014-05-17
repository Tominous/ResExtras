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

public class sprint implements Listener {
	@EventHandler(priority = EventPriority.MONITOR)
	public void Sprint(PlayerMoveEvent event){
	    if(event.isCancelled())
	        return;
		Player player = event.getPlayer();
		String playername = player.getName();
		boolean resadmin = Utilities.isAdminMode(player);
		if (resadmin) {
			return;
		}
	    if(!player.isSprinting() && (!player.isSneaking()))
	    	return;
	    PermissionsArea area = ResidenceAPI.getPermissionsAreaByLocation(player.getLocation());
	    if(area!=null) {
	        if(!area.allowAction(playername, FlagManagerExtras.SPRINT) && player.isSprinting()) {
	            event.setCancelled(true);
	            long currentTime = System.currentTimeMillis();
	            if(currentTime%2000>=0 && currentTime%2000<=100){
	            event.getPlayer().sendMessage(derpa + "You cannot sprint here!");
	           return;
	        }
	       }
	    }
	}
	ChatColor derpa = ChatColor.RED;
}