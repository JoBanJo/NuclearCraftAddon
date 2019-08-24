package nca.init;

import nc.recipe.NCRecipes;
import nc.recipe.ingredient.FluidIngredient;
import nc.util.FluidRegHelper;

public class NCARecipes {

	public static FluidIngredient fluidStack(String fluidName, int stackSize) {
		if (!FluidRegHelper.fluidExists(fluidName)) return null;
		return new FluidIngredient(fluidName, stackSize);
	}

	private static Object itemStack(String string, int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void init() {
		   //GameRegistry.addSmelting(ModItems.cornseeds, new ItemStack(ModItems.popcorn, 1), 1f);

		   NCRecipes.infuser.addRecipe(ModBlocks.tritiumlightframe, fluidStack("tritium", 2000), ModBlocks.tritiumlampg);

		   		//TODO add fluids for beer 
		   //NCRecipes.Type.EXTRACTOR.getRecipeHandler().addRecipe(Items.WHEAT, new EmptyItemIngredient(), fluidStack("water", 1000));
		   //NCRecipes.Type.DISSOLVER.getRecipeHandler().addRecipe(ModItems.cornseeds, fluidStack("water", 1000), fluidStack("lava", 1000) );
				
	}
}
