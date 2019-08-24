package nca.proxy;

import nca.init.ModArmor;
import nca.init.ModBlocks;
import nca.init.ModItems;
import nca.radation.RadationHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent preEvent) {
		ModItems.init();
		ModBlocks.init();
		ModArmor.init();
	
	
		ModItems.register();
		ModBlocks.register();
		ModArmor.register();
		
		
		
	}

	public void init(FMLInitializationEvent event) {

	}

	public void postInit(FMLPostInitializationEvent postEvent) {

		RadationHandler.radation(); 
		
	}

	public void registerRenders() {

	}
}