package nca.init;

import nc.util.Lang;
import nca.items.ItemModArmor;
import nca.tabs.NCAddonTab;
import nca.util.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;



@EventBusSubscriber

public class ModArmor {

	public static ArmorMaterial MATERIALNAME = EnumHelper.addArmorMaterial("hazmatsuit", Reference.MODID+":hazmatsuit", 50, new int[] 
			{0,1,2,0}, 14, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 1.0f);

	public static ItemArmor HELMET_HAZMAT;
	public static ItemArmor CHESTPLATE_HAZMAT;
	public static ItemArmor LEGGINGS_HAZMAT;
	public static ItemArmor BOOTS_HAZMAT;

	public static void init(){
		HELMET_HAZMAT = new ItemModArmor("helmet_hazmat", MATERIALNAME,Lang.localise("info.helmet_hazmat"), 1, EntityEquipmentSlot.HEAD, "helmet_hazmat");
		CHESTPLATE_HAZMAT = new ItemModArmor("chestplate_hazmat", MATERIALNAME,Lang.localise("info.chest_hazmat") , 1, EntityEquipmentSlot.CHEST, "chestplate_hazmat");
		LEGGINGS_HAZMAT = new ItemModArmor("leggings_hazmat", MATERIALNAME,Lang.localise("info.leggings_hazmat") , 2, EntityEquipmentSlot.LEGS, "leggings_hazmat");
		BOOTS_HAZMAT = new ItemModArmor("boots_hazmat", MATERIALNAME,Lang.localise("info.boots_hazmat") ,1, EntityEquipmentSlot.FEET, "boots_hazmat");

		
		HELMET_HAZMAT.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
		CHESTPLATE_HAZMAT.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
		LEGGINGS_HAZMAT.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
		BOOTS_HAZMAT.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
	
	}

	public static void register() {
		registerItem(BOOTS_HAZMAT);
		registerItem(CHESTPLATE_HAZMAT);
		registerItem(HELMET_HAZMAT);
		registerItem(LEGGINGS_HAZMAT);
			
	}

	public static void registerRenders(){
		registerRender(HELMET_HAZMAT);
		registerRender(CHESTPLATE_HAZMAT);
		registerRender(LEGGINGS_HAZMAT);
		registerRender(BOOTS_HAZMAT);
	}


	public static void registerItem(Item item) {
		ForgeRegistries.ITEMS.register(item);
	
	}
		
	public static void registerRender(Item item){
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}
