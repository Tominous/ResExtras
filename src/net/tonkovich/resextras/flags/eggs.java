package net.tonkovich.resextras.flags;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class eggs implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void Eggs(PlayerEggThrowEvent event){
		Player player = event.getPlayer();
		ClaimedResidence res = Residence.getInstance().getResidenceManager().getByLoc(event.getPlayer().getLocation());
		boolean resadmin = Residence.getInstance().isResAdminOn(player);
		String playername = player.getName();
		if(res!=null) {
			if(!res.getPermissions().playerHas(playername, "eggs", true) && !resadmin) {
				event.setHatching(false);
				event.getPlayer().sendMessage(derpa + "You cannot throw eggys!");
			}
		}
	}
	ChatColor derpa = ChatColor.RED;
}
