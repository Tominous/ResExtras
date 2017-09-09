package net.tonkovich.resextras.flags;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.FlagPermissions;
import org.bukkit.entity.Endermite;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;


public class endermite implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void Endermite(CreatureSpawnEvent event)
    {
        FlagPermissions FlagPermissions = Residence.getInstance().getPermsByLoc(event.getLocation());
        if (FlagPermissions == null)
            return;
        LivingEntity Entity = event.getEntity();
        if (Entity instanceof Endermite)
        {
            if (FlagPermissions.has("endermite", true))
                return;
            event.setCancelled(true);
        }
    }
}
