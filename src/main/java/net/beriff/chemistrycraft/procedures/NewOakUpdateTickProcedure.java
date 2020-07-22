package net.beriff.chemistrycraft.procedures;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.DirectionProperty;
import net.minecraft.block.BlockState;

import net.beriff.chemistrycraft.block.TreeBranchBlock;
import net.beriff.chemistrycraft.ChemcraftModElements;

import java.util.Map;

@ChemcraftModElements.ModElement.Tag
public class NewOakUpdateTickProcedure extends ChemcraftModElements.ModElement {
	public NewOakUpdateTickProcedure(ChemcraftModElements instance) {
		super(instance, 62);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure NewOakUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure NewOakUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure NewOakUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure NewOakUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((Math.random() < 0.1)) {
			if (((Math.round(Math.random()) < 1) && (!((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))))
					.getBlock() == TreeBranchBlock.block.getDefaultState().getBlock())))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), TreeBranchBlock.block.getDefaultState(), 3);
				try {
					BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)));
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)),
							_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.EAST), 3);
				} catch (Exception e) {
				}
			} else if ((!((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == TreeBranchBlock.block.getDefaultState()
					.getBlock()))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), TreeBranchBlock.block.getDefaultState(), 3);
				try {
					BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)));
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)),
							_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.WEST), 3);
				} catch (Exception e) {
				}
			}
		}
	}
}
