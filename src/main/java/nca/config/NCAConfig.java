package nca.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import nc.network.PacketHandler;
import nc.util.Lang;
import nca.util.Reference;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class NCAConfig {
	private static Configuration config = null;

	public static final String CATEGORY_NAME_OTHER = "other";

	public static boolean[] register_processor;

	public static void preInit() {
		File configFile = new File(Loader.instance().getConfigDir(), "nuclearcraftaddon.cfg");
		config = new Configuration(configFile);
		syncFromFiles();

	}

	public static Configuration getConfig() {
		return config;

	}

	public static void clientPreInit() {
		MinecraftForge.EVENT_BUS.register(new ConfigEventHandler());

	}

	public static void syncFromFiles() {
		syncConfig(true, true);

	}

	public static void syncFromGui() {
		syncConfig(false, true);

	}

	public static void syncFromFields() {
		syncConfig(false, false);

	}

	private static void syncConfig(boolean loadFromFile, boolean setFromConfig) {
		if (loadFromFile)
			config.load();

		Property propertyRegisterProcessor = config.get(CATEGORY_NAME_OTHER, "register_processor",
				new boolean[] { true }, Lang.localise("gui.config.other.register_processor.comment"));
		propertyRegisterProcessor.setLanguageKey("gui.config.other.register_processor");

		List<String> propertyOrderOther = new ArrayList<String>();
		propertyOrderOther.add(propertyRegisterProcessor.getName());
		config.setCategoryPropertyOrder(CATEGORY_NAME_OTHER, propertyOrderOther);

		if (setFromConfig) {

			register_processor = propertyRegisterProcessor.getBooleanList();

		}

		propertyRegisterProcessor.set(register_processor);

		if (config.hasChanged())
			config.save();

	}

	public static class ConfigEventHandler {

		@SubscribeEvent(priority = EventPriority.LOWEST)
		public void onEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(Reference.MODID)) {
				syncFromGui();
			
			}
		}
	}
}
