package me.element.dispenserplants.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;

import me.element.dispenserplants.util.Pair;

public class EnumConstants {

	private HashMap<Material, Pair<List<Material>, Material>> plantBlocks = new HashMap<Material, Pair<List<Material>, Material>>();
	public static final String WHEAT_SEEDS = "WHEAT_SEEDS";
	public static final String CARROT = "CARROT";
	public static final String POTATO = "POTATO";
	public static final String MELON_SEEDS = "MELON_SEEDS";
	public static final String PUMPKIN_SEEDS = "PUMPKIN_SEEDS";
	public static final String COCOA_BEANS = "COCOA_BEANS";
	public static final String SUGAR_CANE = "SUGAR_CANE";
	public static final String BEETROOT_SEEDS = "BEETROOT_SEEDS";
	public static final String SWEET_BERRIES = "SWEET_BERRIES";
	public static final String BAMBOO = "BAMBOO";
	public static final String CACTUS = "CACTUS";
	public static final String ACACIA_SAPLING = "ACACIA_SAPLING";
	public static final String BIRCH_SAPLING = "BIRCH_SAPLING";
	public static final String DARK_OAK_SAPLING = "DARK_OAK_SAPLING";
	public static final String JUNGLE_SAPLING = "JUNGLE_SAPLING";
	public static final String OAK_SAPLING = "OAK_SAPLING";
	public static final String SPRUCE_SAPLING = "SPRUCE_SAPLING";
	public static final String NETHER_WART = "NETHER_WART";
	
	public static final String COARSE_DIRT = "COARSE_DIRT";
	public static final String FARMLAND = "FARMLAND";
	public static final String PODZOL = "PODZOL";
	public static final String SAND = "SAND";
	public static final String RED_SAND = "RED_SAND";
	public static final String DIRT = "DIRT";
	public static final String GRASS_BLOCK = "GRASS_BLOCK";
	public static final String JUNGLE_LOG = "JUNGLE_LOG";
	public static final String MYCELIUM = "MYCELIUM";
	public static final String GRAVEL = "GRAVEL";
	public static final String SOUL_SAND = "SOUL_SAND";
	
	public static final String WHEAT = "WHEAT";
	public static final String POTATOES = "POTATOES";
	public static final String MELON_STEM = "MELON_STEM";
	public static final String PUMPKIN_STEM = "PUMPKIN_STEM";
	public static final String CARROTS = "CARROTS";
	public static final String COCOA = "COCOA";
	public static final String BAMBOO_SAPLING = "BAMBOO_SAPLING";
	public static final String SWEET_BERRY_BUSH = "SWEET_BERRY_BUSH";
	public static final String BEETROOTS = "BEETROOTS";
	
	public EnumConstants()
	{
		List<Material> crop = new ArrayList<Material>(); // farmland
		crop.add(Material.matchMaterial(FARMLAND));
		
		List<Material> cactus = new ArrayList<Material>();
		cactus.add(Material.matchMaterial(SAND));
		cactus.add(Material.matchMaterial(RED_SAND));
		
		List<Material> sugarcane = new ArrayList<Material>(); // grass block, dirt, coarse dirt, podzol, sand, or red sand
		sugarcane.add(Material.matchMaterial(GRASS_BLOCK));
		sugarcane.add(Material.matchMaterial(DIRT));
		sugarcane.add(Material.matchMaterial(SAND));
		sugarcane.add(Material.matchMaterial(RED_SAND));
		if (Version.isAtLeast(Version.V1_13_R1))
			sugarcane.add(Material.matchMaterial(COARSE_DIRT));
		if (Version.isAtLeast(Version.V1_13_R1))
			sugarcane.add(Material.matchMaterial(PODZOL));
		
		List<Material> sapling = new ArrayList<Material>(); // dirt, podzol or a grass block
		sapling.add(Material.matchMaterial(GRASS_BLOCK));
		sapling.add(Material.matchMaterial(DIRT));
		if (Version.isAtLeast(Version.V1_13_R1))
			sugarcane.add(Material.matchMaterial(PODZOL));

		List<Material> cocoa = new ArrayList<Material>(); // jungle log
		cocoa.add(Material.matchMaterial(JUNGLE_LOG));
		
		List<Material> bamboo = new ArrayList<Material>(); // grass blocks, dirt, coarse dirt, gravel, mycelium, podzol, sand, or red sand
		bamboo.add(Material.matchMaterial(GRASS_BLOCK));
		bamboo.add(Material.matchMaterial(DIRT));
		bamboo.add(Material.matchMaterial(SAND));
		bamboo.add(Material.matchMaterial(RED_SAND));
		bamboo.add(Material.matchMaterial(GRAVEL));
		bamboo.add(Material.matchMaterial(MYCELIUM));
		if (Version.isAtLeast(Version.V1_13_R1))
			sugarcane.add(Material.matchMaterial(COARSE_DIRT));
		if (Version.isAtLeast(Version.V1_13_R1))
			sugarcane.add(Material.matchMaterial(PODZOL));
		
		List<Material> berries = new ArrayList<Material>(); // grass block, dirt, podzol, coarse dirt, or farmland
		berries.add(Material.matchMaterial(GRASS_BLOCK));
		berries.add(Material.matchMaterial(DIRT));
		berries.add(Material.matchMaterial(FARMLAND));
		if (Version.isAtLeast(Version.V1_13_R1))
			berries.add(Material.matchMaterial(COARSE_DIRT));
		if (Version.isAtLeast(Version.V1_13_R1))
			berries.add(Material.matchMaterial(PODZOL));
		
		List<Material> netherWart = new ArrayList<Material>(); // soul sand
		netherWart.add(Material.matchMaterial(SOUL_SAND));
		
		plantBlocks.put(Material.matchMaterial(NETHER_WART), new Pair<List<Material>, Material>(netherWart, Material.matchMaterial(NETHER_WART)));
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
		
		if (Version.isAtLeast(Version.V1_14_R1))
			plantBlocks.put(Material.matchMaterial(BAMBOO), new Pair<List<Material>, Material>(bamboo, Material.matchMaterial(BAMBOO_SAPLING)));
		if (Version.isAtLeast(Version.V1_14_R1))
			plantBlocks.put(Material.matchMaterial(SWEET_BERRIES), new Pair<List<Material>, Material>(berries, Material.matchMaterial(SWEET_BERRY_BUSH)));
		if (Version.isAtLeast(Version.V1_9_R1))
			plantBlocks.put(Material.matchMaterial(BEETROOT_SEEDS), new Pair<List<Material>, Material>(crop, Material.matchMaterial(BEETROOTS)));
	}
	
	public HashMap<Material, Pair<List<Material>, Material>> getMap()
	{
		return plantBlocks;
	}
}
