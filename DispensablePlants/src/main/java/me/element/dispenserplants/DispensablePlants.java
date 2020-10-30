package me.element.dispenserplants;

import org.bstats.bukkit.Metrics;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import me.element.dispenserplants.commands.GuiCommand;
import me.element.dispenserplants.enums.EnumConstants;
import me.element.dispenserplants.enums.Version;
import me.element.dispenserplants.listeners.DispenseListener;
import me.element.dispenserplants.listeners.InventoryClickListener;
import me.element.dispenserplants.util.ConfigCache;

public class DispensablePlants extends JavaPlugin {

	public ConfigCache cache;
	private static final int PLUGIN_ID = 8913;

	@Override
	public void onEnable()
	{
		saveDefaultConfig();
		cache = new ConfigCache(this);
		hookBStats(PLUGIN_ID);
		register();
	}

	private void register()
	{
		getServer().getPluginManager().registerEvents(new DispenseListener(this), this);
		getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
		getCommand("dispensableplants").setExecutor(new GuiCommand(this));
		getLogger().info("Enabling material support for " + Version.getServerVersion().toString());
	}

	private void hookBStats(int pluginId)
	{
		Metrics metrics = new Metrics(this, pluginId);
		
		for (Material material : new EnumConstants().getMap().keySet())
		{
			String key = material.name().toLowerCase();
			metrics.addCustomChart(new Metrics.SimplePie(key, () -> cache.isEnabled(material) ? "enabled" : "disabled"));
		}
	}
}