package net.tonkovich.resextras.flags;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class hunger implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void Hunger(FoodLevelChangeEvent event){
		ClaimedResidence res = Residence.getInstance().getResidenceManager().getByLoc(event.getEntity().getLocation());
		if(res!=null) {
			if(!res.getPermissions().has("hunger", true)) {
				int current = event.getFoodLevel() + 1;
				event.setFoodLevel(current);
			}
		}
	}
}