package nca.items;

import java.util.List;

import nca.Global;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemModArmor extends ItemArmor {

	public ItemModArmor(String nameIn, ArmorMaterial materialIn, String lore, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn,
			String name) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(Global.MOD_ID + "." + nameIn);
		setRegistryName(new ResourceLocation(Global.MOD_ID, nameIn));
		setMaxStackSize(1);
		   
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);

		tooltip.add(I18n.format("§1May proctect player from §4Radiation"));

		/*		
		 * §1 = Dark Blue 
		 * §4 = white
		 * 
		 */

	}
}
