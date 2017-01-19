package silly511.keepinginventory;

import net.minecraft.world.GameRules;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;

@Mod(modid = KeepingInventory.modid, name = "Keeping Inventory", version = "2.2", acceptableRemoteVersions = "*")
public class KeepingInventory {
	
	public static final String modid = "keepinginventory";

	@EventHandler
	public void load(FMLPreInitializationEvent event) {
		ConfigHandler.init();
	}
	
	@EventHandler
	public void serverStarted(FMLServerStartedEvent event) {
		GameRules gr = FMLCommonHandler.instance().getMinecraftServerInstance().worlds[0].getGameRules();
		
		if (gr.getBoolean("doFireTick") != ConfigHandler.fireTick)
			gr.setOrCreateGameRule("doFireTick", Boolean.toString(ConfigHandler.fireTick));
		if (gr.getBoolean("keepInventory") != ConfigHandler.keepInventory)
			gr.setOrCreateGameRule("keepInventory", Boolean.toString(ConfigHandler.keepInventory));
		if (gr.getBoolean("keepInventory") != ConfigHandler.mobGriefing)
			gr.setOrCreateGameRule("mobGriefing", Boolean.toString(ConfigHandler.mobGriefing));
	}
	
}