package fadenfire.keepinginventory;

import net.minecraft.world.GameRules;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = KeepingInventory.modid, name = "Keeping Inventory", version = "3.0", acceptableRemoteVersions = "*")
public class KeepingInventory {
	
	public static final String modid = "keepinginventory";
	
	public static final Logger logger = LogManager.getLogger(modid);

	@EventHandler
	public void load(FMLPreInitializationEvent event) {
		ConfigHandler.init();
	}
	
	@EventHandler
	public void serverStarted(FMLServerStartedEvent event) {
		GameRules gr = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(0).getGameRules();
		
		if (ConfigHandler.keepInventory != null) {
			logger.debug("Setting keepInventory gamerule to {}", ConfigHandler.keepInventory);
			
			gr.setOrCreateGameRule("keepInventory", Boolean.toString(ConfigHandler.keepInventory));
		}
		
		if (ConfigHandler.mobGriefing != null) {
			logger.debug("Setting mobGriefing gamerule to {}", ConfigHandler.mobGriefing);
			
			gr.setOrCreateGameRule("mobGriefing", Boolean.toString(ConfigHandler.mobGriefing));
		}
		
		if (ConfigHandler.fireTick != null) {
			logger.debug("Setting doFireTick gamerule to {}", ConfigHandler.fireTick);
			
			gr.setOrCreateGameRule("doFireTick", Boolean.toString(ConfigHandler.fireTick));
		}
	}
}
