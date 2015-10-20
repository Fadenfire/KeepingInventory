package net.sparklepopprograms.keepinginventory;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
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
			
			FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(new ChatComponentTranslation("[KeepingInventory] " + EnumChatFormatting.BLUE + "Your inventory will be kept on death."));
		} else if (ConfigHandler.KeepInventory == false) {
			
			MinecraftServer.getServer().worldServerForDimension(0).getGameRules().setOrCreateGameRule("keepInventory", "false");
			
			FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(new ChatComponentTranslation("[KeepingInventory] " + EnumChatFormatting.BLUE + "Your inventory will not be kept on death."));
		}

if (ConfigHandler.MobGriefing == true) {
	
	MinecraftServer.getServer().worldServerForDimension(0).getGameRules().setOrCreateGameRule("mobGriefing", "true");

	FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(new ChatComponentTranslation("[KeepingInventory] " + EnumChatFormatting.BLUE + "Creepers will destory blocks."));
} else if (ConfigHandler.MobGriefing == false) {
	
	MinecraftServer.getServer().worldServerForDimension(0).getGameRules().setOrCreateGameRule("mobGriefing", "false");
	
	FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(new ChatComponentTranslation("[KeepingInventory] " + EnumChatFormatting.BLUE + "Creepers will not destory blocks."));
	
}
    }
}
