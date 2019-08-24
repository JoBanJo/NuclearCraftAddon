package nca.blocks.bunkerblocks;

import nca.Global;
import nca.tabs.NCAddonTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BunkerBlocks extends Block {


public BunkerBlocks(String nameIn, Material material) {
	super(material);
	setUnlocalizedName(Global.MOD_ID + "." + nameIn);
	setRegistryName(new ResourceLocation(Global.MOD_ID, nameIn));
	setHarvestLevel("Pickaxe", 1);
	setSoundType(blockSoundType.STONE);
	this.setHardness(3F);
	}
}
