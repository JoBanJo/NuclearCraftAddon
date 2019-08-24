package nca.radation;

import nc.radiation.RadArmor;
import nc.radiation.RadSources;
import nca.init.ModArmor;
import nca.init.ModItems;
import net.minecraft.client.util.RecipeItemHelper;
import net.minecraft.item.ItemStack;

public class RadationHandler {

	public static void radation(){
		RadSources.addToFoodMaps(new ItemStack(ModItems.nuclearbread), 600, 0);
		RadSources.addToFoodMaps(new ItemStack(ModItems.uraniuminfusedbeer), 200, 0);
		
		RadArmor.ARMOR_RAD_RESISTANCE_MAP.put(RecipeItemHelper.pack(new ItemStack(ModArmor.BOOTS_HAZMAT)), 1.5);
		RadArmor.ARMOR_RAD_RESISTANCE_MAP.put(RecipeItemHelper.pack(new ItemStack(ModArmor.CHESTPLATE_HAZMAT)), 2.8);
		RadArmor.ARMOR_RAD_RESISTANCE_MAP.put(RecipeItemHelper.pack(new ItemStack(ModArmor.HELMET_HAZMAT)), 1.6);
		RadArmor.ARMOR_RAD_RESISTANCE_MAP.put(RecipeItemHelper.pack(new ItemStack(ModArmor.LEGGINGS_HAZMAT)), 1.8);
	}
	
}
