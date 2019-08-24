
package nca.blocks.bunkerblocks;

import java.util.List;

import nca.Global;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TritiumLamp extends Block {

	//private static final double OFFSET = 0.375D;
	private static final AxisAlignedBB HIT_BOX = new AxisAlignedBB(0.25, 0, 0.25, 0.75, 0.75, 0.75);
	
	public TritiumLamp(String nameIn, Material material) {
		super(material);
		
		this.setLightLevel(1);
		this.setHardness(2F);
		setUnlocalizedName(Global.MOD_ID + "." + nameIn);
		setRegistryName(new ResourceLocation(Global.MOD_ID, nameIn));
		setHarvestLevel("Pickaxe", 1);
		setSoundType(blockSoundType.METAL); 
		
		
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
    public BlockRenderLayer getBlockLayer() {
    	return BlockRenderLayer.TRANSLUCENT;
    
   }   

   @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
    	return HIT_BOX;
    	
    }
 
    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
    		List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean isActualState) {
    	
    	super.addCollisionBoxToList(pos, entityBox, collidingBoxes, HIT_BOX);
    	
    }
    
}