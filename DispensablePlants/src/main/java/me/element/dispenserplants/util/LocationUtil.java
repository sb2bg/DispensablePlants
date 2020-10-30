package me.element.dispenserplants.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Axis;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.Orientable;
import org.bukkit.block.data.Rotatable;

import me.element.dispenserplants.enums.EnumConstants;

public class LocationUtil {

	public static Location fromFace(BlockFace face, Location location, boolean cocoa)
	{
		int offset = cocoa ? 2 : 1;

		switch (face)
		{
		case EAST:
			location = new Location(location.getWorld(), location.getBlockX() + offset, location.getBlockY(), location.getBlockZ());
			break;
			
		case NORTH:
			location = new Location(location.getWorld(), location.getBlockX(), location.getBlockY(), location.getBlockZ() - offset);
			break;
			
		case SOUTH:
			location = new Location(location.getWorld(), location.getBlockX(), location.getBlockY(), location.getBlockZ() + offset);
			break;
			
		case WEST:
			location = new Location(location.getWorld(), location.getBlockX() - offset, location.getBlockY(), location.getBlockZ());
			break;
			
		case UP:
			if (!cocoa) location = new Location(location.getWorld(), location.getBlockX(), location.getBlockY() + 2, location.getBlockZ());
			break;
			
		case DOWN:
			if (!cocoa) location = new Location(location.getWorld(), location.getBlockX(), location.getBlockY() - offset, location.getBlockZ());
			break;
			
		default:
			location = new Location(location.getWorld(), location.getBlockX(), location.getBlockY(), location.getBlockZ());
		}

		return location;
	}

	public static Location getGroundBlock(Location location)
	{
		return new Location(location.getWorld(), location.getX(), location.getY() - 1, location.getZ());
	}

	public static boolean canPlant(Location plantLocation, Material plant)
	{
		if (plantLocation.getBlock().getType() != Material.AIR)
		{
			return false;
		}

		if (plant == Material.matchMaterial(EnumConstants.CACTUS))
		{
			for (Material material : getAdjacentBlocks(plantLocation, true))
			{
				if (material != Material.AIR)
					return false;
			}
		}
		else if (plant == Material.matchMaterial(EnumConstants.SUGAR_CANE))
		{
			if (!getAdjacentBlocks(plantLocation, false).contains(Material.WATER))
				return false;
		}

		return true;
	}

	public static void setBlock(Block block, Material material, BlockFace blockFace) 
	{
		HashMap<BlockFace, BlockFace> oppositeFace = new HashMap<BlockFace, BlockFace>();
		oppositeFace.put(BlockFace.NORTH, BlockFace.SOUTH);
		oppositeFace.put(BlockFace.SOUTH, BlockFace.NORTH);
		oppositeFace.put(BlockFace.WEST, BlockFace.EAST);
		oppositeFace.put(BlockFace.EAST, BlockFace.WEST);
		BlockFace face = oppositeFace.get(blockFace);
		
	    block.setType(material);
	    BlockData blockData = block.getBlockData();
	    
	    if (blockData instanceof Directional) 
	    {
	        ((Directional) blockData).setFacing(face);
	        block.setBlockData(blockData);
	    }
	    if (blockData instanceof Orientable) 
	    {
	        ((Orientable) blockData).setAxis(convertBlockFaceToAxis(face));
	        block.setBlockData(blockData);
	    }
	    if (blockData instanceof Rotatable) 
	    {
	        ((Rotatable) blockData).setRotation(face);
	        block.setBlockData(blockData);
	    }
	}
	
	private static Axis convertBlockFaceToAxis(BlockFace face) 
	{
		switch (face) 
		{
		case NORTH:
		case SOUTH:
			return Axis.Z;
			
		case EAST:
		case WEST:
			return Axis.X;
			
		case UP:
		case DOWN:
			return Axis.Y;
			
		default:
			return Axis.X;
		}
	}

	private static List<Material> getAdjacentBlocks(Location plantLocation, boolean up)
	{
		List<Material> materials = new ArrayList<Material>();
		BlockFace[] faces = { BlockFace.EAST, BlockFace.NORTH, BlockFace.SOUTH, BlockFace.WEST };
		Location location = new Location(plantLocation.getWorld(), plantLocation.getBlockX(), plantLocation.getBlockY() - 1, plantLocation.getBlockZ());

		if (up)
			for (BlockFace face : faces)
				materials.add(plantLocation.getBlock().getRelative(face).getType());
		else
			for (BlockFace face : faces)
				materials.add(location.getBlock().getRelative(face).getType());

		return materials;
	}
}
