package me.element.dispenserplants.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import me.element.dispenserplants.DispensablePlants;
import me.element.dispenserplants.enums.EnumConstants;
import me.mattstudios.mfgui.gui.components.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.Gui;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import net.md_5.bungee.api.ChatColor;

public class DispensablePlantsGui {

	private Gui gui;
	private Player player;
	
	public DispensablePlantsGui(Player player, DispensablePlants plugin)
	{
		this.player = player;
		gui = new Gui(3, "Enable or Disable a Plant");
		
		for (Material plant : new EnumConstants().getMap().keySet())
		{
			boolean isEnabled = plugin.cache.isEnabled(plant);
			
			String itemName = StringUtils.capitalize(plant.name().toLowerCase().replace("_", " "));
			
			List<String> lore = new ArrayList<String>();
			lore.add(ChatColor.translateAlternateColorCodes('&', "&7Currently " + (isEnabled ? "&aenabled" : "&cdisabled")));
			lore.add(ChatColor.translateAlternateColorCodes('&', "&7Select to enable/disable."));
			GuiItem guiPlant = new GuiItem(ItemBuilder.from(plant).setName(ChatColor.YELLOW + itemName).setLore(lore).build());
			
			guiPlant.setAction(event ->
			{
				event.setCancelled(true);
				
				plugin.cache.setEnabled(plant, !isEnabled);
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lDispensablePlants &7" + itemName + " is now " + (!isEnabled ? "enabled" : "disabled")));
				
				new DispensablePlantsGui(player, plugin).open();
			});
			
			gui.addItem(guiPlant);
		}
	}
	
	public void open()
	{
		gui.open(player);
	}
}
