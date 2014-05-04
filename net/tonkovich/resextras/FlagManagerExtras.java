package net.tonkovich.resextras;

import net.t00thpick1.residence.api.flags.Flag;
import net.t00thpick1.residence.api.flags.Flag.FlagType;
import net.t00thpick1.residence.api.flags.FlagManager;

public class FlagManagerExtras {

	// Monster spawn flags
	public static final Flag ZOMBIE_SPAWN = new Flag("zombie", FlagType.AREA_ONLY, FlagManager.MONSTERSPAWN, "Enables zombie spawn");
	public static final Flag SKELETON_SPAWN = new Flag("skeleton", FlagType.AREA_ONLY, FlagManager.MONSTERSPAWN, "Enables skeleton spawn");
	public static final Flag CREEPER_SPAWN = new Flag("creeperspawn", FlagType.AREA_ONLY, FlagManager.MONSTERSPAWN, "Enables creeper spawn");
	public static final Flag SPIDER_SPAWN = new Flag("spider", FlagType.AREA_ONLY, FlagManager.MONSTERSPAWN, "Enables spider spawn");
	public static final Flag CAVESPIDER_SPAWN = new Flag("cavespider", FlagType.AREA_ONLY, FlagManager.MONSTERSPAWN, "Enables cavespider spawn");
	public static final Flag SLIME_SPAWN = new Flag("slime", FlagType.AREA_ONLY, FlagManager.MONSTERSPAWN, "Enables slime spawn");
	public static final Flag BLAZE_SPAWN = new Flag("blaze", FlagType.AREA_ONLY, FlagManager.MONSTERSPAWN, "Enables blaze spawn");
	public static final Flag GHAST_SPAWN = new Flag("ghast", FlagType.AREA_ONLY, FlagManager.MONSTERSPAWN, "Enables ghast spawn");
	public static final Flag MAGMACUBE_SPAWN = new Flag("magmacube", FlagType.AREA_ONLY, FlagManager.MONSTERSPAWN, "Enables magmacube spawn");
	public static final Flag SILVERFISH_SPAWN = new Flag("silverfish", FlagType.AREA_ONLY, FlagManager.MONSTERSPAWN, "Enables silverfish spawn");
	public static final Flag ENDERMAN_SPAWN = new Flag("enderman", FlagType.AREA_ONLY, FlagManager.MONSTERSPAWN, "Enables enderman spawn");
	public static final Flag ZOMBIEPIGMEN_SPAWN = new Flag("zombiepigmen", FlagType.AREA_ONLY, FlagManager.MONSTERSPAWN, "Enables zombiepigmen spawn");
	public static final Flag WITCH_SPAWN = new Flag("witch", FlagType.AREA_ONLY, FlagManager.MONSTERSPAWN, "Enables witch spawn");
	public static final Flag WITHER_SPAWN = new Flag("witherspawn", FlagType.AREA_ONLY, FlagManager.MONSTERSPAWN, "Enables wither spawn");
	
	// Animal spawn flags
	public static final Flag SNOWGOLEM_SPAWN = new Flag("snowgolem", FlagType.AREA_ONLY, FlagManager.ANIMALSPAWN, "Enables snowgolem spawn");
	public static final Flag IRONGOLEM_SPAWN = new Flag("irongolem", FlagType.AREA_ONLY, FlagManager.ANIMALSPAWN, "Enables irongolem spawn");
	public static final Flag WOLF_SPAWN = new Flag("wolf", FlagType.AREA_ONLY, FlagManager.ANIMALSPAWN, "Enables wolf spawn");
	public static final Flag CHICKEN_SPAWN = new Flag("chicken", FlagType.AREA_ONLY, FlagManager.ANIMALSPAWN, "Enables chicken spawn");
	public static final Flag COW_SPAWN = new Flag("cow", FlagType.AREA_ONLY, FlagManager.ANIMALSPAWN, "Enables cow spawn");
	public static final Flag MOOSHROOM_SPAWN = new Flag("mooshroom", FlagType.AREA_ONLY, FlagManager.ANIMALSPAWN, "Enables mooshroom spawn");
	public static final Flag OCELOT_SPAWN = new Flag("ocelot", FlagType.AREA_ONLY, FlagManager.ANIMALSPAWN, "Enables ocelot spawn");
	public static final Flag PIG_SPAWN = new Flag("pig", FlagType.AREA_ONLY, FlagManager.ANIMALSPAWN, "Enables pig spawn");
	public static final Flag SHEEP_SPAWN = new Flag("sheep", FlagType.AREA_ONLY, FlagManager.ANIMALSPAWN, "Enables sheep spawn");
	public static final Flag SQUID_SPAWN = new Flag("squid", FlagType.AREA_ONLY, FlagManager.ANIMALSPAWN, "Enables squid spawn");
	public static final Flag VILLAGER_SPAWN = new Flag("villager", FlagType.AREA_ONLY, FlagManager.ANIMALSPAWN, "Enables villager spawn");
	public static final Flag BAT_SPAWN = new Flag("bat", FlagType.AREA_ONLY, FlagManager.ANIMALSPAWN, "Enables bat spawn");
	
	// Ice forming/melting
	public static final Flag ICE_MELTING = new Flag("melt", FlagType.AREA_ONLY, null, "Enables ice melting");
	public static final Flag ICE_FORMING = new Flag("FORM", FlagType.AREA_ONLY, null, "Enables ice forming");

    // Items dropping/picking
	public static final Flag ITEM_DROPING = new Flag("drops", FlagType.ANY, null, "Allows items dropping");
	public static final Flag ITEM_PICKING = new Flag("pickups", FlagType.ANY, null, "Allows items pickup");
	
	// Mobs killing
	public static final Flag ANIMALKILLING = new Flag("animalkilling", FlagType.ANY, null, "Allows  animal killing");
	public static final Flag VILLAGERKILLING = new Flag("villagerkilling", FlagType.ANY, null, "Allows villager killing");
	public static final Flag MOBKILLING = new Flag("mobkilling", FlagType.ANY, null, "Allows mob killing");

	// Minecarts and boats protection
	public static final Flag VEHICLEPROTECT = new Flag("vehicleprotect", FlagType.ANY, null, "Allows breaking of boats and minecarts");
	
	// Various player actions
	public static final Flag SPRINT = new Flag("sprint", FlagType.ANY, null, "Allows sprinting");
	public static final Flag SNEAK = new Flag("sneak", FlagType.ANY, null, "Allows sneaking");
	public static final Flag FISHING = new Flag("fishing", FlagType.ANY, null, "Allows fishing");
	public static final Flag EGGS = new Flag("eggs", FlagType.ANY, null, "Allows eggs throwing");
	public static final Flag SHEAR = new Flag("shear", FlagType.ANY, null, "Allows sheeps shearing");
	public static final Flag PIGSADDLE = new Flag("pigsaddle", FlagType.ANY, null, "Allows sitting on saddled pigs");
	public static final Flag TRADE = new Flag("trade", FlagType.ANY, null, "Allows trading with villagers");
	public static final Flag NETHERPORTING = new Flag("portal", FlagType.ANY, null, "Allows nether portal usage");
	public static final Flag ENDERPEARLS = new Flag("enderpearl", FlagType.ANY, null, "Allows enderpearl usage");
	public static final Flag COMMANDS = new Flag("commands", FlagType.ANY, null, "Allows commands usage");
	
	// Various world events
	public static final Flag LIGHTNING = new Flag("lightning", FlagType.AREA_ONLY, null, "Enables lightning strikes");
	public static final Flag GROW = new Flag("grow", FlagType.AREA_ONLY, null, "Enables plants/trees growing");
	public static final Flag PIGZAP = new Flag("pigzap", FlagType.AREA_ONLY, null, "Enables pigs turning into pigman on lightning strike");
	public static final Flag SLIMESPLIT = new Flag("slimesplit", FlagType.AREA_ONLY, null, "Enables slime splitting");
	public static final Flag WEATHER = new Flag("weather", FlagType.AREA_ONLY, null, "Enables weather");
	
    // Day-night cycle control
	public static final Flag ALWAYS_DAY = new Flag("day", FlagType.AREA_ONLY, null, "Permanently turns day");
	public static final Flag ALWAYS_NIGHT = new Flag("night", FlagType.AREA_ONLY, null, "Permanently turns night");

	public static final Flag GOD = new Flag("god", FlagType.ANY, null, "Prevents users/groups from taking damage and displays sparkles if damaged");
	public static final Flag HUNGER = new Flag("hunger", FlagType.ANY, null, "Prevents users/groups from losing hunger");
	
	public static final Flag FALLDAMAGE = new Flag("falldamage", FlagType.ANY, null, "Prevents users/groups taking falldamage ");
	public static final Flag BLOCKDAMAGE = new Flag("blockdamage", FlagType.ANY, null, "Prevents entities from harming blocks but still damages other entities");
	
    public static void initFlags() {
    	// Monster spawn flags
    	FlagManager.addFlag(ZOMBIE_SPAWN);
    	FlagManager.addFlag(SKELETON_SPAWN);
    	FlagManager.addFlag(CREEPER_SPAWN);
    	FlagManager.addFlag(SPIDER_SPAWN);
    	FlagManager.addFlag(CAVESPIDER_SPAWN);
    	FlagManager.addFlag(SLIME_SPAWN);
    	FlagManager.addFlag(BLAZE_SPAWN);
    	FlagManager.addFlag(GHAST_SPAWN);
    	FlagManager.addFlag(MAGMACUBE_SPAWN);
    	FlagManager.addFlag(SILVERFISH_SPAWN);
    	FlagManager.addFlag(ENDERMAN_SPAWN);
    	FlagManager.addFlag(ZOMBIEPIGMEN_SPAWN);
    	FlagManager.addFlag(WITCH_SPAWN);
    	FlagManager.addFlag(WITHER_SPAWN);
    	
    	// Animal spawn flags
    	FlagManager.addFlag(SNOWGOLEM_SPAWN);
    	FlagManager.addFlag(IRONGOLEM_SPAWN);
    	FlagManager.addFlag(WOLF_SPAWN);
    	FlagManager.addFlag(CHICKEN_SPAWN);
    	FlagManager.addFlag(COW_SPAWN);
    	FlagManager.addFlag(MOOSHROOM_SPAWN);
    	FlagManager.addFlag(OCELOT_SPAWN);
    	FlagManager.addFlag(PIG_SPAWN);
    	FlagManager.addFlag(SHEEP_SPAWN);
    	FlagManager.addFlag(SQUID_SPAWN);
    	FlagManager.addFlag(VILLAGER_SPAWN);
    	FlagManager.addFlag(BAT_SPAWN);
    	
    	// Ice forming/melting
    	FlagManager.addFlag(ICE_MELTING);
    	FlagManager.addFlag(ICE_FORMING);

        // Items dropping/picking
    	FlagManager.addFlag(ITEM_DROPING);
    	FlagManager.addFlag(ITEM_PICKING);
    	
    	// Mobs killing
    	FlagManager.addFlag(ANIMALKILLING);
    	FlagManager.addFlag(VILLAGERKILLING);
    	FlagManager.addFlag(MOBKILLING);

    	// Minecarts and boats protection
    	FlagManager.addFlag(VEHICLEPROTECT);
    	
    	// Various player actions
    	FlagManager.addFlag(SPRINT);
    	FlagManager.addFlag(SNEAK);
    	FlagManager.addFlag(FISHING);
    	FlagManager.addFlag(EGGS);
    	FlagManager.addFlag(SHEAR);
    	FlagManager.addFlag(PIGSADDLE);
    	FlagManager.addFlag(TRADE);
    	FlagManager.addFlag(NETHERPORTING);
    	FlagManager.addFlag(ENDERPEARLS);
    	FlagManager.addFlag(COMMANDS);
    	
    	// Various world events
    	FlagManager.addFlag(LIGHTNING);
    	FlagManager.addFlag(GROW);
    	FlagManager.addFlag(PIGZAP);
    	FlagManager.addFlag(SLIMESPLIT);
    	FlagManager.addFlag(WEATHER);
    	
        // Day-night cycle control
    	FlagManager.addFlag(ALWAYS_DAY);
    	FlagManager.addFlag(ALWAYS_NIGHT);

    	FlagManager.addFlag(GOD);
    	FlagManager.addFlag(HUNGER);
    	
    	FlagManager.addFlag(FALLDAMAGE);
    	FlagManager.addFlag(BLOCKDAMAGE);
    }
}
