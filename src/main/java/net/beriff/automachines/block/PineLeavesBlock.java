
package net.beriff.automachines.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.beriff.automachines.itemgroup.ModTabItemGroup;
import net.beriff.automachines.AutomachinesModElements;

import java.util.List;
import java.util.Collections;

@AutomachinesModElements.ModElement.Tag
public class PineLeavesBlock extends AutomachinesModElements.ModElement {
	@ObjectHolder("automachines:pine_leaves")
	public static final Block block = null;
	public PineLeavesBlock(AutomachinesModElements instance) {
		super(instance, 63);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ModTabItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.LEAVES).sound(SoundType.PLANT).hardnessAndResistance(1f, 10f).lightValue(0));
			setRegistryName("pine_leaves");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(SaplingBlock.block, (int) (1)));
		}
	}
}
