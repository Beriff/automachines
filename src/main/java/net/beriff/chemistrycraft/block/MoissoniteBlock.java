
package net.beriff.chemistrycraft.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.fluid.IFluidState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.beriff.chemistrycraft.procedures.MoissoniteBlockDestroyedByPlayerProcedure;
import net.beriff.chemistrycraft.itemgroup.ModTabItemGroup;
import net.beriff.chemistrycraft.item.SiliconCarbideItem;
import net.beriff.chemistrycraft.ChemcraftModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

@ChemcraftModElements.ModElement.Tag
public class MoissoniteBlock extends ChemcraftModElements.ModElement {
	@ObjectHolder("chemcraft:moissonite")
	public static final Block block = null;
	public MoissoniteBlock(ChemcraftModElements instance) {
		super(instance, 254);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ModTabItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1f, 10f).lightValue(0).harvestLevel(3)
					.harvestTool(ToolType.PICKAXE));
			setRegistryName("moissonite");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(SiliconCarbideItem.block, (int) (1)));
		}

		@Override
		public boolean removedByPlayer(BlockState state, World world, BlockPos pos, PlayerEntity entity, boolean willHarvest, IFluidState fluid) {
			boolean retval = super.removedByPlayer(state, world, pos, entity, willHarvest, fluid);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				MoissoniteBlockDestroyedByPlayerProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
