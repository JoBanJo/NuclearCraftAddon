package nca.blocks.bunkerblocks;

import java.util.Random;

import nca.Global;
import nca.init.ModItems;
import nca.tabs.NCAddonTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class MoissaniteOre extends Block {
 
		public MoissaniteOre(String nameIn, Material material) {
			super(material);
			setUnlocalizedName(Global.MOD_ID + "." + nameIn);
			setRegistryName(new ResourceLocation(Global.MOD_ID, nameIn));
			setHarvestLevel("Pickaxe", 1);
			setSoundType(blockSoundType.STONE);
			this.setHardness(3F);
			}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {

		return ModItems.diamondingot;
	}

	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		if(random.nextFloat()<0.7){
			return 1;
		} else {
			return 2;
		}
	}

}

