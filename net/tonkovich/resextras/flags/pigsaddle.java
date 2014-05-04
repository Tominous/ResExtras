package net.tonkovich.resextras.flags;

import net.t00thpick1.residence.api.ResidenceAPI;
import net.t00thpick1.residence.api.areas.PermissionsArea;
import net.t00thpick1.residence.utils.Utilities;
import net.tonkovich.resextras.FlagManagerExtras;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class pigsaddle implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void PiggySaddle(PlayerInteractEntityEvent event){
	    if(event.isCancelled())
	        return;
	    Entity pig = event.getRightClicked();
	    Player player = event.getPlayer();
	    boolean resadmin = Utilities.isAdminMode(player);
	    PermissionsArea area = ResidenceAPI.getPermissionsAreaByLocation(player.getLocation());
		String playername = player.getName();
	    if(area!=null) {
	        if(!area.allowAction(playername, FlagManagerExtras.PIGSADDLE) && !resadmin) {
	            if(pig.getType() == EntityType.PIG){
	        	event.setCancelled(true);
	        	event.getPlayer().sendMessage(derpa + "You cannot derp here!");
	        }
	        }
	}
	}
	ChatColor derpa = ChatColor.RED;
}