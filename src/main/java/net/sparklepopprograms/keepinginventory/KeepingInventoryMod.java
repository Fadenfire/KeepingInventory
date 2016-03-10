package net.sparklepopprograms.keepinginventory;

import scala.Int;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "KeepingInventory", name = "Keeping Inventory", version = "1.9")
public class KeepingInventoryMod {

	@EventHandler
	public void load(FMLInitializationEvent event) {
		
		ConfigHandler.initProps();
		
		FMLCommonHandler.instance().bus().register(new ConnectionHandler());
	}
}