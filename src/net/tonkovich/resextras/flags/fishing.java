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
import org.bukkit.event.player.PlayerFishEvent;

public class fishing implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void Fishing(PlayerFishEvent event){
	    if(event.isCancelled())
	        return;
	    Player player = event.getPlayer();
	    boolean resadmin = Utilities.isAdminMode(player);
	    PermissionsArea area = ResidenceAPI.getPermissionsAreaByLocation(player.getLocation());
		String playername = player.getName();
	    if(area!=null) {
	        if(!area.allowAction(playername, FlagManagerExtras.FISHING) && !resadmin) {
	            event.setCancelled(true);
	            event.getPlayer().sendMessage(derpa + "You cannot fish here!");
	        }
	    }
	}
	ChatColor derpa = ChatColor.RED;
}
