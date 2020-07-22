package net.beriff.chemistrycraft.procedures;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.BlockState;

import net.beriff.chemistrycraft.block.FireboxBlock;
import net.beriff.chemistrycraft.ChemcraftModElements;

import java.util.Map;

@ChemcraftModElements.ModElement.Tag
public class LitFireboxUpdateTickProcedure extends ChemcraftModElements.ModElement {
	public LitFireboxUpdateTickProcedure(ChemcraftModElements instance) {
		super(instance, 164);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure LitFireboxUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure LitFireboxUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure LitFireboxUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure LitFireboxUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("count", ((new Object() {
					public double getValue(BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(new BlockPos((int) x, (int) y, (int) z), "count")) + 1));
			world.notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (((new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "count")) >= 1200)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), FireboxBlock.block.getDefaultState(), 3);
		}
	}
}
