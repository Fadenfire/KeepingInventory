package net.sparklepopprograms.keepinginventory;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.GameRules;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class ConnectionHandler {
	@SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
		
		GameRules gameRules = MinecraftServer.getServer().worldServerForDimension(0).getGameRules();
    	
		if (ConfigHandler.KeepInventory == true) {
			
			gameRules.setOrCreateGameRule("keepInventory", "true");
			event.player.addChatMessage(new ChatComponentTranslation("[KeepingInventory] " + EnumChatFormatting.BLUE + "Your inventory will be kept on death."));
			
		} else if (ConfigHandler.KeepInventory == false) {
			
			gameRules.setOrCreateGameRule("keepInventory", "false");
			event.player.addChatMessage(new ChatComponentTranslation("[KeepingInventory] " + EnumChatFormatting.BLUE + "Your inventory will not be kept on death."));
		}

		if (ConfigHandler.MobGriefing == true) {
	
			gameRules.setOrCreateGameRule("mobGriefing", "true");
			event.player.addChatMessage(new ChatComponentTranslation("[KeepingInventory] " + EnumChatFormatting.BLUE + "Creepers will destroy blocks."));

		} else if (ConfigHandler.MobGriefing == false) {
	
			gameRules.setOrCreateGameRule("mobGriefing", "false");
			event.player.addChatMessage(new ChatComponentTranslation("[KeepingInventory] " + EnumChatFormatting.BLUE + "Creepers will not destroy blocks."));
	
		}
    }
}
