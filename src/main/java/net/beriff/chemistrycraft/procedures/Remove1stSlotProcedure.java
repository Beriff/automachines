package net.beriff.chemistrycraft.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;

import net.beriff.chemistrycraft.ChemcraftModElements;

import java.util.Map;

@ChemcraftModElements.ModElement.Tag
public class Remove1stSlotProcedure extends ChemcraftModElements.ModElement {
	public Remove1stSlotProcedure(ChemcraftModElements instance) {
		super(instance, 238);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Remove1stSlot!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Remove1stSlot!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Remove1stSlot!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Remove1stSlot!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		World world = (World) dependencies.get("world");
		{
			TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
			if (_ent != null) {
				final int _sltid = (int) (1);
				final int _amount = (int) 1;
				_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						ItemStack _stk = capability.getStackInSlot(_sltid).copy();
						_stk.shrink(_amount);
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
					}
				});
			}
		}
		{
			TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
			int _amount = (int) 100;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
		}
		{
			TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
			int _amount = (int) 100;
			if (_ent != null)
				_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
						.ifPresent(capability -> capability.drain(_amount, IFluidHandler.FluidAction.EXECUTE));
		}
	}
}
