package nca.blocks.bunkerblocks;

import nca.Global;
import nca.tabs.NCAddonTab;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TritiumLightFrame extends Block {


	public TritiumLightFrame(String nameIn, Material material) {
		super(material);
		setUnlocalizedName(Global.MOD_ID + "." + nameIn);
		setRegistryName(new ResourceLocation(Global.MOD_ID, nameIn));
		setHarvestLevel("Pickaxe", 1);
		setSoundType(blockSoundType.METAL);
		this.setHardness(2F);
		
	}

		@Override
		public boolean isFullCube(IBlockState state) {
			return false;
		}

		@Override
		public boolean isOpaqueCube(IBlockState state) {
			return false;
		
		}

	    @Override
	    @SideOnly(Side.CLIENT)
	    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess world, BlockPos pos, EnumFacing side) {
	        IBlockState otherState = world.getBlockState(pos.offset(side));
	        Block block = otherState.getBlock();
	        
	        if (blockState != otherState) return true;
	        
	        return block == this ? false : super.shouldSideBeRendered(blockState, world, pos, side);
	    }

	    @Override
	    @SideOnly(Side.CLIENT)
	    public BlockRenderLayer getBlockLayer() {
	    	return BlockRenderLayer.CUTOUT;
	    }    
	}