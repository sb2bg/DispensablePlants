package me.element.dispenserplants.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.element.dispenserplants.DispensablePlants;
import me.element.dispenserplants.util.DispensablePlantsGui;

public class GuiCommand implements CommandExecutor {

	private DispensablePlants plugin;
	
	public GuiCommand(DispensablePlants plugin)
	{
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (sender instanceof Player)
		{
			Player player = (Player) sender;
			
			if (player.hasPermission("dispensableplants.gui"))
			{
				new DispensablePlantsGui(player, plugin).open();
			}
		}
		return false;
	}
}
