package nca.items;

import java.util.List;

import nca.Global;
import nca.util.Reference;
import net.minecraft.block.BlockLog;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemModFood extends ItemFood {

	private PotionEffect[] effects;

	public ItemModFood(String nameIn, String lore [], int amount, boolean isWolfFood) {
		super(amount, isWolfFood);
		setUnlocalizedName(Global.MOD_ID + "." + nameIn);
		setRegistryName(new ResourceLocation(Global.MOD_ID, nameIn));
		
	}

	public ItemModFood(String nameIn, String string, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(Global.MOD_ID + "." + nameIn);
		setRegistryName(new ResourceLocation(Global.MOD_ID, nameIn));
		
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		for (PotionEffect effect : effects) {
			player.addPotionEffect(new PotionEffect(effect));

		}

	}

}
