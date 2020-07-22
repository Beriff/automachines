package net.beriff.chemistrycraft.procedures;

import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;

import net.beriff.chemistrycraft.ChemcraftModElements;

import java.util.Map;

@ChemcraftModElements.ModElement.Tag
public class CreativeEnergySourceUpdateTickProcedure extends ChemcraftModElements.ModElement {
	public CreativeEnergySourceUpdateTickProcedure(ChemcraftModElements instance) {
		super(instance, 217);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure CreativeEnergySourceUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure CreativeEnergySourceUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure CreativeEnergySourceUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure CreativeEnergySourceUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		World world = (World) dependencies.get("world");
		{
			TileEntity _ent = world.getTileEntity(new BlockPos((int) (x + 1), (int) y, (int) z));
			int _amount = (int) 10000;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.receiveEnergy(_amount, false));
		}
		{
			TileEntity _ent = world.getTileEntity(new BlockPos((int) (x - 1), (int) y, (int) z));
			int _amount = (int) 10000;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.receiveEnergy(_amount, false));
		}
		{
			TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) (y + 1), (int) z));
			int _amount = (int) 10000;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.receiveEnergy(_amount, false));
		}
		{
			TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) (y - 1), (int) z));
			int _amount = (int) 10000;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.receiveEnergy(_amount, false));
		}
		{
			TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) (z + 1)));
			int _amount = (int) 10000;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.receiveEnergy(_amount, false));
		}
		{
			TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) (z - 1)));
			int _amount = (int) 10000;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.receiveEnergy(_amount, false));
		}
	}
}
