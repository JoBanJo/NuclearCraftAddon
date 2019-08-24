package nca.items.food;

import java.util.List;

import nca.Global;
import nca.util.Reference;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class UraniumInfusedBeer extends ItemFood {
	
	private PotionEffect[] effects;

	public UraniumInfusedBeer(String nameIn, String lore [], int amount, boolean isWolfFood, PotionEffect... potionEffects) {
		super(amount, isWolfFood);
		setUnlocalizedName(Global.MOD_ID + "." + nameIn);
		setRegistryName(new ResourceLocation(Global.MOD_ID, nameIn));
		this.effects = potionEffects; 

	}

	public UraniumInfusedBeer(String nameIn, String string, int amount, float saturation, boolean isWolfFood,
			PotionEffect... potionEffects) {
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(Global.MOD_ID + "." + nameIn);
		setRegistryName(new ResourceLocation(Global.MOD_ID, nameIn));
		this.effects = potionEffects;

	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		for (PotionEffect effect : effects) {
			player.addPotionEffect(new PotionEffect(effect));

		}

	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.format("ง1Side effects may include ง4Blindness ง1and ง4Nausea"));
		
		/*
		 * ยง1 = Dark Blue 
		 * ยง4 = Dark Red
		 */

		
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.DRINK;

	}

}