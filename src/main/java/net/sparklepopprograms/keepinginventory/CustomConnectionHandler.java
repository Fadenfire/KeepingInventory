package net.sparklepopprograms.keepinginventory;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.IFMLSidedHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ClientConnectedToServerEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomConnectionHandler {
	@SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
    	
if (ConfigHandler.KeepInventory == true) {
			
			MinecraftServer.getServer().worldServerForDimension(0).getGameRules().setOrCreateGameRule("keepInventory", "true");
        
		} else if (ConfigHandler.KeepInventory == false) {
			
			MinecraftServer.getServer().worldServerForDimension(0).getGameRules().setOrCreateGameRule("keepInventory", "false");
			
		}

if (ConfigHandler.MobGriefing == true) {
	
	MinecraftServer.getServer().worldServerForDimension(0).getGameRules().setOrCreateGameRule("mobGriefing", "true");

} else if (ConfigHandler.MobGriefing == false) {
	
	MinecraftServer.getServer().worldServerForDimension(0).getGameRules().setOrCreateGameRule("mobGriefing", "false");
	
}
    }
}