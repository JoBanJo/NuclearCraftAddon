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

public class NuclearBread extends ItemFood {
	
	private PotionEffect[] effects;

	public NuclearBread(String nameIn, String lore [], int amount, boolean isWolfFood, PotionEffect... potionEffects) {
		super(amount, isWolfFood);
		setUnlocalizedName(Global.MOD_ID + "." + nameIn);
		setRegistryName(new ResourceLocation(Global.MOD_ID, nameIn));
		this.effects = potionEffects; 

		
		setUnlocalizedName(Global.MOD_ID + "." + nameIn);
		setRegistryName(new ResourceLocation(Global.MOD_ID, nameIn));
	}
	

	public NuclearBread(String nameIn, String string, int amount, float saturation, boolean isWolfFood,
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
		super.addInformation(stack, worldIn, tooltip, flagIn);

		tooltip.add(I18n.format("§9Side effects may include §fGlowing"));
		
		/*
		 * Â§9 = Dark Blue 
		 * Â§f = white 
		 */

	}

}