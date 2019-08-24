package nca.items;

import nca.Global;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;


public class BeerCan extends Item {

	public BeerCan(String nameIn) {
		setUnlocalizedName(Global.MOD_ID + "." + nameIn);
		setRegistryName(new ResourceLocation(Global.MOD_ID, nameIn));
	}
}