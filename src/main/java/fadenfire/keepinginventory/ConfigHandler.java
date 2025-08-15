package fadenfire.keepinginventory;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ConfigHandler {
	
	public static Boolean keepInventory;
	public static Boolean fireTick;
	public static Boolean mobGriefing;
	
	public static void init() {
		Configuration config = new Configuration(new File("config/KeepingInventory.cfg"));
		config.load();
		
		keepInventory = getNullableBoolean(
			config,
			"keepInventory", Configuration.CATEGORY_GENERAL,
			true,
			"Whether players keep their inventory on death. Set to null to leave the gamerule unchanged."
		);
		
		mobGriefing = getNullableBoolean(
			config,
			"mobGriefing", Configuration.CATEGORY_GENERAL,
			null,
			"Whether mobs can affect the terrain. Set to null to leave the gamerule unchanged."
		);
		
		fireTick = getNullableBoolean(
			config,
			"fireSpread", Configuration.CATEGORY_GENERAL,
			null,
			"Whether fire spreads. Set to null to leave the gamerule unchanged."
		);
		
		if (config.hasChanged()) config.save();
	}
	
	private static Boolean getNullableBoolean(
		Configuration config,
		String name,
		String category,
		Boolean defaultValue,
		String comment
	) {
		Property prop = config.get(category, name, String.valueOf(defaultValue));
		prop.setComment(comment + " [default: " + defaultValue + "]");
		
		switch (prop.getString().toLowerCase()) {
			case "true": return true;
			case "false": return false;
			case "null": return null;
			
			// If it isn't a valid bool then return the default
			default: return defaultValue;
		}
	}
}
