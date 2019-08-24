
package nca.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.items.IItemHandler;

public class Utils {

	private static Logger logger; 
public static Logger getLogger() {
	if(logger == null) {
		logger = LogManager.getFormatterLogger(nca.util.Reference.MODID); 
		
		}
	
	return logger;
	}

public static int calculateRedstone(IItemHandler handler) {
	int i = 0;
	float f = 0.0F;
	for (int j = 0; j < handler.getSlots(); j++) {
		ItemStack stack = handler.getStackInSlot(j);
		if (!stack.isEmpty()) {
			f += (float) stack.getCount() / (float) Math.min(handler.getSlotLimit(j), stack.getMaxStackSize());
			i++;
		}
	}
	f = f / (float) handler.getSlots();
	return MathHelper.floor(f * 14.0F) + (i > 0 ? 1 : 0);

	}

}