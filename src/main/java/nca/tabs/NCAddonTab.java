package nca.tabs;

import java.util.Comparator;

import nca.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class NCAddonTab extends CreativeTabs {

	public NCAddonTab() {
		super("NC_Addon_Tab");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.uraniuminfusedbeer);

	}

	@Override
	public void displayAllRelevantItems(NonNullList<ItemStack> p_78018_1_) {
		super.displayAllRelevantItems(p_78018_1_);
		p_78018_1_.sort(new Comparator<ItemStack>() {

			@Override
			public int compare(ItemStack o1, ItemStack o2) {

				return o1.getDisplayName().compareTo(o2.getDisplayName());

			}
		});
	}

	public static final CreativeTabs NC_ADDON_TAB = new NCAddonTab();
}
