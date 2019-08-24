package nca.items;

import nca.Global;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class BasicItem extends Item{

	public BasicItem(String nameIn) {
		setUnlocalizedName(Global.MOD_ID + "." + nameIn);
		setRegistryName(new ResourceLocation(Global.MOD_ID, nameIn));
	}
}
