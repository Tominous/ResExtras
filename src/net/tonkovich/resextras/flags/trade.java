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

public class trade implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void Trade(PlayerInteractEntityEvent event)
	{
		Entity uglyguy = event.getRightClicked();
	    if(uglyguy.getType() == EntityType.VILLAGER){
	    	Player player = (Player)event.getPlayer();
	    	PermissionsArea area = ResidenceAPI.getPermissionsAreaByLocation(player.getLocation());
	    	boolean resadmin = Utilities.isAdminMode(player);
	    	String playername = player.getName();
	        if(area!=null) {
	    		if(!area.allowAction(playername, FlagManagerExtras.TRADE)&&!resadmin){
	    		event.setCancelled(true);
	    		event.getPlayer().sendMessage(derpa + "You cannot trade here!");
	    	}
	    }
	    }
	}
	ChatColor derpa = ChatColor.RED;
}
