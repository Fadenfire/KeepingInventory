package net.sparklepopprograms.keepinginventory;

import scala.Int;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod.EventHandler;

@Mod(modid = "KeepingInventory", name = "Keeping Inventory", version = "1.5")



public class KeepingInventoryMod {

	@EventHandler
	public void load(FMLInitializationEvent event) {
		
		ConfigHandler.initProps();
		
		FMLCommonHandler.instance().bus().register(new CustomConnectionHandler());
	}
}