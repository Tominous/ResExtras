package net.tonkovich.resextras.flags;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.FlagPermissions;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.PolarBear;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;


public class polarbear implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void Polarbear(CreatureSpawnEvent event)
    {
        FlagPermissions fp = Residence.getInstance().getPermsByLoc(event.getLocation());
        if (fp == null)
            return;
        LivingEntity Entity = event.getEntity();
        if (Entity instanceof PolarBear)
        {
            if (fp.has("polarbear", true))
                return;
            event.setCancelled(true);
        }
    }
}
