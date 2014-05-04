package net.tonkovich.resextras.flags;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleDestroyEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class vehicleprotect implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void onVehicleDestroy(VehicleDestroyEvent event){
		if(event.isCancelled())
			return;
		try {
		Location loc = event.getVehicle().getLocation();
		Entity attacker = event.getAttacker();
		Vehicle vehicle = event.getVehicle();
		Player player;
		player = (Player)attacker;
		ClaimedResidence res = Residence.getResidenceManager().getByLoc(loc);
		boolean resadmin = Residence.isResAdminOn(player);
		String playername = player.getName();
		if(res!=null){
			if(res.getPermissions().playerHas(playername, "vehicleprotect", false) && !resadmin && (vehicle instanceof Minecart || vehicle instanceof Boat) && (attacker instanceof Player || attacker instanceof Monster)){
				event.setCancelled(true);
				player.sendMessage(derpa + "You cannot destroy vehicles here!");
				return;
			}
		}
		} catch (Exception ex) {
			
		}
	}
	@EventHandler(priority = EventPriority.NORMAL)
	public void onVehicleDestroyEntity(VehicleDestroyEvent event){
		if(event.isCancelled())
			return;
		Location loc = event.getVehicle().getLocation();
		Entity attacker = event.getAttacker();
		Vehicle vehicle = event.getVehicle();
		ClaimedResidence res = Residence.getResidenceManager().getByLoc(loc);
		if(res!=null){
			if(res.getPermissions().has("vehicleprotect", false) && (vehicle instanceof Minecart || vehicle instanceof Boat) && attacker instanceof Monster){
				event.setCancelled(true);
				return;
			}
		}
	}
	ChatColor derpa = ChatColor.RED;
}