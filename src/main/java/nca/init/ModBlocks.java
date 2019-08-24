package nca.init;


import nca.blocks.BasicBlock;
import nca.blocks.MoissaniteBlock;
import nca.blocks.bunkerblocks.BunkerBlocks;
import nca.blocks.bunkerblocks.MoissaniteOre;
import nca.blocks.bunkerblocks.TritiumLamp;
import nca.blocks.bunkerblocks.TritiumLightFrame;
import nca.tabs.NCAddonTab;
import nca.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

@Mod.EventBusSubscriber(modid=Reference.MODID)
public class ModBlocks {

	
	public static Block fakediamond;
	public static Block moissaniteore;

	//Bunker Blocks
	public static Block oldconcrete; 
	public static Block tritiumlightframe;
	
	public static Block tritiumlampr;
	public static Block tritiumlampg;
	public static Block tritiumlampb;
	public static Block tritiumlampy;
	public static Block tritiumlampp;
	public static Block tritiumlampo;
	public static Block brick;
	
	//Fluid Blocks
	public static Block molten_silicon_fluid;
	


	public static void init() {
		fakediamond = new MoissaniteBlock("fake_diamond", Material.IRON);
		brick = new BasicBlock("mixed_brick", Material.ROCK); 
		
	
		//Ores
		moissaniteore = new MoissaniteOre("moissanite_ore", Material.ROCK); 
		moissaniteore.setHardness(2f);
		
		
		//Bunker Blocks
		oldconcrete = new BunkerBlocks("old_concrete", Material.ROCK);  
		tritiumlightframe = new TritiumLightFrame("tritium_light_frame", Material.IRON);

		tritiumlampr = new TritiumLamp("tritium_lamp_r", Material.IRON);
		tritiumlampg = new TritiumLamp("tritium_lamp_g", Material.IRON);
		tritiumlampb = new TritiumLamp("tritium_lamp_b", Material.IRON);
		tritiumlampy = new TritiumLamp("tritium_lamp_y", Material.IRON);
		tritiumlampp = new TritiumLamp("tritium_lamp_p", Material.IRON);
		tritiumlampo = new TritiumLamp("tritium_lamp_o", Material.IRON);
		
		
		//Creative Tab
		fakediamond.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
		moissaniteore.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
		brick.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
	 
		//Bunker Blocks
		oldconcrete.setCreativeTab(NCAddonTab.NC_ADDON_TAB); 
		
		tritiumlightframe.setCreativeTab(NCAddonTab.NC_ADDON_TAB); 
		tritiumlampr.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
		tritiumlampg.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
		tritiumlampb.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
		tritiumlampy.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
		tritiumlampp.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
		tritiumlampo.setCreativeTab(NCAddonTab.NC_ADDON_TAB);
		
	}

	
	public static void register() {
		registerBlock(fakediamond);
		registerBlock(moissaniteore);  
		registerBlock(brick); 

		
		//Bunker Blocks
		registerBlock(oldconcrete);
		registerBlock(tritiumlightframe);
		registerBlock(tritiumlampr);
		registerBlock(tritiumlampg);
		registerBlock(tritiumlampb);
		registerBlock(tritiumlampy);
		registerBlock(tritiumlampp);
		registerBlock(tritiumlampo);
		
	}

	public static void registerRenders() {
		registerRender(fakediamond);
		registerRender(moissaniteore);;
		registerRender(brick);

		//Bunker Blocks
		registerRender(oldconcrete);
		registerRender(tritiumlightframe);

		registerRender(tritiumlampr);
		registerRender(tritiumlampg);
		registerRender(tritiumlampb);
		registerRender(tritiumlampy);
		registerRender(tritiumlampp);
		registerRender(tritiumlampo);

	}

	public static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}

	public static void registerBlock(Block block) {
		ForgeRegistries.BLOCKS.register(block);
		ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		
	}	
	
}



