package nca;

import nc.handler.GuiHandler;
import nca.config.NCAConfig;
import nca.init.NCARecipes;
import nca.worldgen.OreGen;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;


@Mod(modid = nca.util.Reference.MODID, name = nca.util.Reference.NAME, version = nca.util.Reference.VERSION,  guiFactory = Global.GUI_FACTORY)
public class NuclearCraftAddon {

	static { FluidRegistry.enableUniversalBucket(); }

	@Instance
	public static NuclearCraftAddon instance; 

	@SidedProxy(clientSide = "nca.proxy.ClientProxy", serverSide = "nca.proxy.CommonProxy")
	public static nca.proxy.CommonProxy proxy;

	
	@EventHandler
	public void preInit(FMLPreInitializationEvent preEvent) {
		//FluidInit.registerFluids();
		NCAConfig.preInit();
		proxy.preInit(preEvent);
		

		MinecraftForge.EVENT_BUS.register(new NCARecipes());
		


	}

	@EventHandler
	public void Init(FMLInitializationEvent event) {
		proxy.init(event); 
		
		NCARecipes.init();

		GameRegistry.registerWorldGenerator(new OreGen(), 0);
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		
	}

	@EventHandler
	public void PostInit(FMLPostInitializationEvent postEvent) {
		proxy.postInit(postEvent);
		
	}

}
