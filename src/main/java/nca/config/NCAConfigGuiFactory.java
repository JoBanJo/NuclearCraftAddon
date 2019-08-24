package nca.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import nca.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.DummyConfigElement.DummyCategoryElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.GuiConfigEntries;
import net.minecraftforge.fml.client.config.GuiConfigEntries.CategoryEntry;
import net.minecraftforge.fml.client.config.IConfigElement;

public class NCAConfigGuiFactory implements IModGuiFactory {

	@Override
	public void initialize(Minecraft minecraftInstance) {

	}

	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
		return null;
	}

	public static class NCAConfigGui extends GuiConfig {

		public NCAConfigGui(GuiScreen parentScreen) {
			super(parentScreen, getConfigElements(), Reference.MODID, false, false,
					I18n.format("gui.config.main_title"));
		}

		private static List<IConfigElement> getConfigElements() {
			List<IConfigElement> list = new ArrayList<IConfigElement>();
			list.add(new DummyCategoryElement(I18n.format("gui.config.category.blocks"), "gui.config.category.blocks",
					CategoryEntryBlocks.class));
			// Add another one of these for any other categories
			return list;

		}

		public static class CategoryEntryBlocks extends CategoryEntry {

			public CategoryEntryBlocks(GuiConfig owningScreen, GuiConfigEntries owningEntryList,
					IConfigElement configElement) {
				super(owningScreen, owningEntryList, configElement);

			}

			@Override
			protected GuiScreen buildChildScreen() {
				Configuration config = NCAConfig.getConfig();
				ConfigElement categoryBlocks = new ConfigElement(config.getCategory(NCAConfig.CATEGORY_NAME_OTHER));
				List<IConfigElement> propertiesOnScreen = categoryBlocks.getChildElements();
				String windowTitle = I18n.format("gui.config.category.other");
				return new GuiConfig(owningScreen, propertiesOnScreen, owningScreen.modID,
						this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
						this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart, windowTitle);
			}
		}
	}

	@Override
	public boolean hasConfigGui() {
		return true;
	}

	@Override
	public GuiScreen createConfigGui(GuiScreen parentScreen) {
		return new NCAConfigGui(parentScreen);
	}
}
