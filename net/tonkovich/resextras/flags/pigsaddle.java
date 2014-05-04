package net.tonkovich.resextras.flags;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class pigsaddle implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void PiggySaddle(PlayerInteractEntityEvent event){
	    if(event.isCancelled())
	        return;
	    Entity pig = event.getRightClicked();
	    Player player = event.getPlayer();
	    ClaimedResidence res = Residence.getResidenceManager().getByLoc(event.getPlayer().getLocation());
	    boolean resadmin = Residence.isResAdminOn(player);
		String playername = player.getName();
	    if(res!=null) {
	        if(!res.getPermissions().playerHas(playername, "pigsaddle", true)&&!resadmin) {
	            if(pig.getType() == EntityType.PIG){
	        	event.setCancelled(true);
	        	event.getPlayer().sendMessage(derpa + "You cannot derp here!");
	        }
	        }
	}
	}
	ChatColor derpa = ChatColor.RED;
}