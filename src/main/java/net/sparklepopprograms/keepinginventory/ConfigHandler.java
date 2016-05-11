package net.sparklepopprograms.keepinginventory;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ConfigHandler {
	
	public static boolean KeepInventory;
	public static boolean CreeperExplosions;
	
	public static void initProps() {
		File mainFile = new File("config/Silly511/KeepingInventory.cfg");
		
		Configuration config = new Configuration(mainFile);
		config.load();
		
		
		 KeepInventory = config.get(Configuration.CATEGORY_GENERAL, "KeepInventory", true).getBoolean(true);
		 CreeperExplosions = config.get(Configuration.CATEGORY_GENERAL, "CreeperExplosions", false).getBoolean(false);
		
		if (config.hasChanged()) {
			config.save();
		}
	}
	

}
