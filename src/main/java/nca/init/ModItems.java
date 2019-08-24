package nca.init;

import nc.util.Lang;
import nca.items.BeerCan;
import nca.items.food.NuclearBread;
import nca.items.food.UraniumInfusedBeer;
import nca.tabs.NCAddonTab;
import nca.util.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class ModItems {

	public static Item beercan;
	public static Item uraniuminfusedbeer;
	public static Item reactordoor;
	public static Item nuclearbread;
	
	public static Item diamondingot;
	
	//Temp	
	public static Item siccfiber; 

	

	// Initialize
	public static void init() {	
		
	//basic item
		beercan = new BeerCan("beer_can");

	// Item Foods
		uraniuminfusedbeer = new UraniumInfusedBeer("uranium_infused_beer", Lang.localise("info.uraniumin_fused_beer"),
				3, 4, false, new PotionEffect(MobEffects.BLINDNESS, 600, 2),
				new PotionEffect(MobEffects.NAUSEA, 550, 2, false, false));
		nuclearbread = new NuclearBread("nuclear_bread", Lang.localise("info.nuclearbread"), 15, 15, false,
				new PotionEffect(MobEffects.GLOWING, 600, 3));

		
	// CreativeTabs Item Register
		beercan.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
		uraniuminfusedbeer.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
		nuclearbread.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
		
 
		
	}

	// Register
	public static void register() {
		registerItem(beercan);
		registerItem(nuclearbread);
		registerItem(uraniuminfusedbeer);

	}

	public static void registerRenders() {
		registerRender(beercan);
		registerRender(uraniuminfusedbeer);
		registerRender(nuclearbread);;
		
	}

	public static void registerItem(Item item) {
		ForgeRegistries.ITEMS.register(item);
	
	}
		
	public static void registerRender(Item item ) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));

	}

}
