package me.element.dispenserplants.listeners;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Dispenser;
import org.bukkit.block.data.Directional;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.ItemStack;

import me.element.dispenserplants.DispensablePlants;
import me.element.dispenserplants.enums.EnumConstants;
import me.element.dispenserplants.util.LocationUtil;

public class DispenseListener implements Listener {

	private DispensablePlants plugin;

	public DispenseListener(DispensablePlants plugin)
	{
		this.plugin = plugin;
	}

	@EventHandler
	public void onDispense(BlockDispenseEvent event)
	{
		ItemStack item = event.getItem();
		EnumConstants map = new EnumConstants();

		if (map.getMap().keySet().contains(item.getType()))
		{
			if (plugin.cache.isEnabled(item.getType()))
			{
				boolean cocoa = item.getType() == Material.matchMaterial(EnumConstants.COCOA_BEANS);

				List<Material> plantable = map.getMap().get(item.getType()).getFirst();
				Material toPlant = map.getMap().get(item.getType()).getSecond();

				Block block = event.getBlock();

				Dispenser dispenser = (Dispenser) block.getState();
				BlockFace face = ((Directional) block.getBlockData()).getFacing();

				Location plantLocation = LocationUtil.fromFace(face, block.getLocation(), cocoa);

				if (plantable.contains(cocoa ? LocationUtil.fromFace(face, block.getLocation(), false).getBlock().getType() : LocationUtil.getGroundBlock(plantLocation).getBlock().getType()))
				{
					event.setCancelled(true);

					if (LocationUtil.canPlant(plantLocation, toPlant))
					{
						LocationUtil.setBlock(plantLocation.getBlock(), toPlant, face);
						Bukkit.getScheduler().runTaskLater(plugin, () -> dispenser.getInventory().removeItem(item), 1L);
					}
				}
			}
		}
	}
}