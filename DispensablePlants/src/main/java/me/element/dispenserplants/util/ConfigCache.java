package me.element.dispenserplants.util;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;

import me.element.dispenserplants.DispensablePlants;
import me.element.dispenserplants.enums.EnumConstants;
import me.element.dispenserplants.enums.Version;

public class ConfigCache {

	private HashMap<Material, Boolean> enabled;
	private DispensablePlants plugin;

	public ConfigCache(DispensablePlants plugin)
	{
		/*
		plantBlocks.put(Material.matchMaterial(WHEAT_SEEDS), new Pair<List<Material>, Material>(crop, Material.matchMaterial(WHEAT)));
		plantBlocks.put(Material.matchMaterial(CARROT), new Pair<List<Material>, Material>(crop, Material.matchMaterial(CARROTS)));
		plantBlocks.put(Material.matchMaterial(POTATO), new Pair<List<Material>, Material>(crop, Material.matchMaterial(POTATOES)));
		plantBlocks.put(Material.matchMaterial(MELON_SEEDS), new Pair<List<Material>, Material>(crop, Material.matchMaterial(MELON_STEM)));
		plantBlocks.put(Material.matchMaterial(PUMPKIN_SEEDS), new Pair<List<Material>, Material>(crop, Material.matchMaterial(PUMPKIN_STEM)));
		plantBlocks.put(Material.matchMaterial(SUGAR_CANE), new Pair<List<Material>, Material>(sugarcane, Material.matchMaterial(SUGAR_CANE)));
		plantBlocks.put(Material.matchMaterial(COCOA_BEANS), new Pair<List<Material>, Material>(cocoa, Material.matchMaterial(COCOA)));
		plantBlocks.put(Material.matchMaterial(CACTUS), new Pair<List<Material>, Material>(cactus, Material.matchMaterial(CACTUS)));
		plantBlocks.put(Material.matchMaterial(ACACIA_SAPLING), new Pair<List<Material>, Material>(sapling, Material.matchMaterial(ACACIA_SAPLING)));
		plantBlocks.put(Material.matchMaterial(BIRCH_SAPLING), new Pair<List<Material>, Material>(sapling, Material.matchMaterial(BIRCH_SAPLING)));
		plantBlocks.put(Material.matchMaterial(DARK_OAK_SAPLING), new Pair<List<Material>, Material>(sapling, Material.matchMaterial(DARK_OAK_SAPLING)));
		plantBlocks.put(Material.matchMaterial(SPRUCE_SAPLING), new Pair<List<Material>, Material>(sapling, Material.matchMaterial(SPRUCE_SAPLING)));
		plantBlocks.put(Material.matchMaterial(JUNGLE_SAPLING), new Pair<List<Material>, Material>(sapling, Material.matchMaterial(JUNGLE_SAPLING)));
		plantBlocks.put(Material.matchMaterial(OAK_SAPLING), new Pair<List<Material>, Material>(sapling, Material.matchMaterial(OAK_SAPLING)));
		 */
		this.plugin = plugin;
		enabled = new HashMap<Material, Boolean>();
		enabled.put(Material.matchMaterial(EnumConstants.ACACIA_SAPLING), plugin.getConfig().getBoolean("plantables.saplings.acacia"));
		enabled.put(Material.matchMaterial(EnumConstants.BIRCH_SAPLING), plugin.getConfig().getBoolean("plantables.saplings.birch"));
		enabled.put(Material.matchMaterial(EnumConstants.CACTUS), plugin.getConfig().getBoolean("plantables.crops.cactus"));
		enabled.put(Material.matchMaterial(EnumConstants.CARROT), plugin.getConfig().getBoolean("plantables.crops.carrots"));
		enabled.put(Material.matchMaterial(EnumConstants.COCOA_BEANS), plugin.getConfig().getBoolean("plantables.crops.cocoa_bean"));
		enabled.put(Material.matchMaterial(EnumConstants.DARK_OAK_SAPLING), plugin.getConfig().getBoolean("plantables.saplings.dark_oak"));
		enabled.put(Material.matchMaterial(EnumConstants.JUNGLE_SAPLING), plugin.getConfig().getBoolean("plantables.saplings.jungle"));
		enabled.put(Material.matchMaterial(EnumConstants.MELON_SEEDS), plugin.getConfig().getBoolean("plantables.crops.melons"));
		enabled.put(Material.matchMaterial(EnumConstants.OAK_SAPLING), plugin.getConfig().getBoolean("plantables.saplings.oak"));
		enabled.put(Material.matchMaterial(EnumConstants.POTATO), plugin.getConfig().getBoolean("plantables.crops.potatoes"));
		enabled.put(Material.matchMaterial(EnumConstants.PUMPKIN_SEEDS), plugin.getConfig().getBoolean("plantables.crops.pumpkins"));
		enabled.put(Material.matchMaterial(EnumConstants.SPRUCE_SAPLING), plugin.getConfig().getBoolean("plantables.saplings.spruce"));
		enabled.put(Material.matchMaterial(EnumConstants.SUGAR_CANE), plugin.getConfig().getBoolean("plantables.crops.sugarcane"));
		enabled.put(Material.matchMaterial(EnumConstants.WHEAT_SEEDS), plugin.getConfig().getBoolean("plantables.crops.wheat"));
		enabled.put(Material.matchMaterial(EnumConstants.NETHER_WART), plugin.getConfig().getBoolean("plantables.crops.nether_wart"));
		if (Version.isAtLeast(Version.V1_9_R1))
			enabled.put(Material.matchMaterial(EnumConstants.BEETROOT_SEEDS), plugin.getConfig().getBoolean("plantables.crops.beetroots"));
		if (Version.isAtLeast(Version.V1_14_R1))
			enabled.put(Material.matchMaterial(EnumConstants.SWEET_BERRIES), plugin.getConfig().getBoolean("plantables.crops.berries"));
		if (Version.isAtLeast(Version.V1_14_R1))
			enabled.put(Material.matchMaterial(EnumConstants.BAMBOO), plugin.getConfig().getBoolean("plantables.saplings.bamboo"));
	}

	public boolean isEnabled(Material type)
	{
		try
		{
			return enabled.get(type);
		}
		catch (NullPointerException e)
		{
			Bukkit.getLogger().warning("[DispensablePlants] " + type.toString() + " is not defined. Please report this to the author.");
			return false;
		}
	}

	public void setEnabled(Material type, boolean setEnabled)
	{
		enabled.put(type, setEnabled);

		Bukkit.getScheduler().runTaskAsynchronously(plugin, () ->
		{
			if (type == Material.matchMaterial(EnumConstants.ACACIA_SAPLING))
				plugin.getConfig().set("plantables.saplings.acacia", setEnabled);
			else if (type == Material.matchMaterial(EnumConstants.BIRCH_SAPLING)) 
				plugin.getConfig().set("plantables.saplings.birch", setEnabled);
			else if (type == Material.matchMaterial(EnumConstants.CACTUS)) 
				plugin.getConfig().set("plantables.crops.cactus", setEnabled);
			else if (type == Material.matchMaterial(EnumConstants.CARROT))
				plugin.getConfig().set("plantables.crops.carrots", setEnabled);
			else if (type == Material.matchMaterial(EnumConstants.COCOA_BEANS)) 
				plugin.getConfig().set("plantables.crops.cocoa_bean", setEnabled);
			else if (type == Material.matchMaterial(EnumConstants.DARK_OAK_SAPLING)) 
				plugin.getConfig().set("plantables.saplings.dark_oak", setEnabled);
			else if (type == Material.matchMaterial(EnumConstants.MELON_SEEDS)) 
				plugin.getConfig().set("plantables.crops.melons", setEnabled);
			else if (type == Material.matchMaterial(EnumConstants.OAK_SAPLING)) 
				plugin.getConfig().set("plantables.saplings.oak", setEnabled);
			else if (type == Material.matchMaterial(EnumConstants.POTATO)) 
				plugin.getConfig().set("plantables.crops.potatoes", setEnabled);
			else if (type == Material.matchMaterial(EnumConstants.JUNGLE_SAPLING)) 
				plugin.getConfig().set("plantables.saplings.jungle", setEnabled);
			else if (type == Material.matchMaterial(EnumConstants.PUMPKIN_SEEDS)) 
				plugin.getConfig().set("plantables.crops.pumpkins", setEnabled);
			else if (type == Material.matchMaterial(EnumConstants.SPRUCE_SAPLING)) 
				plugin.getConfig().set("plantables.saplings.spruce", setEnabled);
			else if (type == Material.matchMaterial(EnumConstants.SUGAR_CANE)) 
				plugin.getConfig().set("plantables.saplings.spruce", setEnabled);
			else if (type == Material.matchMaterial(EnumConstants.WHEAT_SEEDS)) 
				plugin.getConfig().set("plantables.crops.wheat", setEnabled);
			else if (type == Material.matchMaterial(EnumConstants.BEETROOT_SEEDS)) 
				plugin.getConfig().set("plantables.crops.beetroots", setEnabled);
			else if (type == Material.matchMaterial(EnumConstants.SWEET_BERRIES)) 
				plugin.getConfig().set("plantables.crops.berries", setEnabled);
			else if (type == Material.matchMaterial(EnumConstants.BAMBOO)) 
				plugin.getConfig().set("plantables.saplings.bamboo", setEnabled);

			plugin.saveConfig();
		});
	}
}
