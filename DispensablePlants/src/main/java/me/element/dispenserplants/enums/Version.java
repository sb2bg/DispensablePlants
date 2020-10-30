package me.element.dispenserplants.enums;

import org.bukkit.Bukkit;

public enum Version {

	// 1.8
	V1_8_R1(0), V1_8_R2(1), V1_8_R3(2),
	
	// 1.9
	V1_9_R1(3), V1_9_R2(4),
	
	// 1.10
	V1_10_R1(5),
	
	// 1.11
	V1_11_R1(6),
	
	// 1.12
	V1_12_R1(7), 
	
	// 1.13
	V1_13_R1(8), V1_13_R2(9),
	
	// 1.14
	V1_14_R1(10),
	
	// 1.15
	V1_15_R1(11),
	
	// 1.16
	V1_16_R1(12), V1_16_R2(13),
	
	// Other
	OTHER(-1);
	
	private int index;
	
	private Version(int index)
	{
		this.index = index;
	}
	
	private int getVersion()
	{
		return index;
	}

	public static boolean isAbove(Version version)
	{
		return version.getVersion() > getServerVersion().getVersion();
	}
	
	public static boolean isAtLeast(Version version)
	{
		return version.getVersion() <= getServerVersion().getVersion();
	}
	
	public static boolean isBelow(Version version)
	{
		return version.getVersion() < getServerVersion().getVersion();
	}
	
	public static boolean isBetween(Version low, Version high)
	{
		return low.getVersion() < getServerVersion().getVersion() && high.getVersion() > getServerVersion().getVersion();
	}
	
	public static Version getServerVersion()
	{
		String className = Bukkit.getServer().getClass().getPackage().getName();
		String version = className.substring(className.lastIndexOf('.') + 1);
		
		if (version.equals("v1_8_R1")) 		 return V1_8_R1;
		else if (version.equals("v1_8_R2"))  return V1_8_R2;
		else if (version.equals("v1_8_R3"))  return V1_8_R3;
		else if (version.equals("v1_9_R1"))  return V1_9_R1;
		else if (version.equals("v1_9_R2"))  return V1_9_R2;
		else if (version.equals("v1_10_R1")) return V1_10_R1;
		else if (version.equals("v1_11_R1")) return V1_11_R1;
		else if (version.equals("v1_12_R1")) return V1_12_R1;
		else if (version.equals("v1_13_R1")) return V1_13_R1;
		else if (version.equals("v1_13_R2")) return V1_13_R2;
		else if (version.equals("v1_14_R1")) return V1_14_R1;
		else if (version.equals("v1_15_R2")) return V1_15_R1;
		else if (version.equals("v1_16_R1")) return V1_16_R1;
		else if (version.equals("v1_16_R2")) return V1_16_R2;
		
		return OTHER;
	}
}
