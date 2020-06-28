package net.beriff.chemistrycraft.procedures;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Blocks;

import net.beriff.chemistrycraft.ChemcraftModElements;

import java.util.Random;

@ChemcraftModElements.ModElement.Tag
public class StickRotatorRightClickedOnBlockProcedure extends ChemcraftModElements.ModElement {
	public StickRotatorRightClickedOnBlockProcedure(ChemcraftModElements instance) {
		super(instance, 96);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure StickRotatorRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure StickRotatorRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure StickRotatorRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure StickRotatorRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure StickRotatorRightClickedOnBlock!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		World world = (World) dependencies.get("world");
		if (((!((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock()))
				&& ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock()))) {
			{
				ItemStack _ist = (itemstack);
				if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
			if ((Math.random() <= 0.5)) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), Blocks.FIRE.getDefaultState(), 3);
			}
		}
	}
}
