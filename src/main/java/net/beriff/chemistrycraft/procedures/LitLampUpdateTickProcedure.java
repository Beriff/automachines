package net.beriff.chemistrycraft.procedures;

import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.Block;

import net.beriff.chemistrycraft.block.LampHolderBlock;
import net.beriff.chemistrycraft.block.LampBlock;
import net.beriff.chemistrycraft.ChemcraftModElements;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

@ChemcraftModElements.ModElement.Tag
public class LitLampUpdateTickProcedure extends ChemcraftModElements.ModElement {
	public LitLampUpdateTickProcedure(ChemcraftModElements instance) {
		super(instance, 268);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure LitLampUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure LitLampUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure LitLampUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure LitLampUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		World world = (World) dependencies.get("world");
		{
			TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
			int _amount = (int) 1;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
		}
		if (((new Object() {
			public int getEnergyStored(BlockPos pos) {
				AtomicInteger _retval = new AtomicInteger(0);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
				return _retval.get();
			}
		}.getEnergyStored(new BlockPos((int) x, (int) y, (int) z))) <= 0)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), LampBlock.block.getDefaultState(), 3);
		}
		if ((!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == LampHolderBlock.block.getDefaultState()
				.getBlock()))) {
			Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), world, new BlockPos((int) x, (int) y, (int) z));
			world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
		}
	}
}
