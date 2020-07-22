package net.beriff.chemistrycraft.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Blocks;

import net.beriff.chemistrycraft.ChemcraftModElements;

import java.util.Map;

@ChemcraftModElements.ModElement.Tag
public class Clear2SlotsProcedure extends ChemcraftModElements.ModElement {
	public Clear2SlotsProcedure(ChemcraftModElements instance) {
		super(instance, 244);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Clear2Slots!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Clear2Slots!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Clear2Slots!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Clear2Slots!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		World world = (World) dependencies.get("world");
		{
			TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
			if (_ent != null) {
				final int _sltid = (int) (0);
				final ItemStack _setstack = new ItemStack(Blocks.AIR, (int) (1));
				_setstack.setCount((int) 1);
				_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		}
		{
			TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
			if (_ent != null) {
				final int _sltid = (int) (1);
				final ItemStack _setstack = new ItemStack(Blocks.AIR, (int) (1));
				_setstack.setCount((int) 1);
				_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		}
	}
}
