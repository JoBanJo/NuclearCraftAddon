package nca.proxy;

import nc.handler.TooltipHandler;
import nc.render.BlockHighlightHandler;
import nca.Global;
import nca.NuclearCraftAddon;
import nca.config.NCAConfig;
import nca.init.ModArmor;
import nca.init.ModBlocks;
import nca.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ClientProxy extends CommonProxy {

private final Minecraft mc = Minecraft.getMinecraft();
	
	@Override
	public void preInit(FMLPreInitializationEvent preEvent) {
		super.preInit(preEvent);
		
		NCAConfig.clientPreInit();
			
		ModItems.registerRenders();
		ModBlocks.registerRenders();
		ModArmor.registerRenders();
		
	
		
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}

	@Override
	public void postInit(FMLPostInitializationEvent postEvent) {
		super.postInit(postEvent);
		
	}
}