package silly511.keepinginventory;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	
	public static boolean keepInventory;
	public static boolean fireTick;
	public static boolean mobGriefing;
	
	public static void init() {
		Configuration config = new Configuration(new File("config/KeepingInventory.cfg"));
		config.load();
		
		keepInventory = config.getBoolean("keepInventory", Configuration.CATEGORY_GENERAL, true, "Whether players keep their inventory on death.");
		fireTick = config.getBoolean("fireSpread", Configuration.CATEGORY_GENERAL, true, "Whether fire spreads.");
		mobGriefing = config.getBoolean("mobGriefing", Configuration.CATEGORY_GENERAL, false, "Whether mobs can effect the terrain.");
		
		if (config.hasChanged()) config.save();
	}

}
