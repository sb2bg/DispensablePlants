package me.element.dispenserplants.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event)
	{
		if (event.getView().getTitle().equals("Enable or Disable a Plant"))
		{
			event.setCancelled(true);
		}
	}
}
