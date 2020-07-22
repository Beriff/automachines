
package net.beriff.chemistrycraft.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.beriff.chemistrycraft.itemgroup.ModTabItemGroup;
import net.beriff.chemistrycraft.ChemcraftModElements;

import java.util.List;
import java.util.Collections;

@ChemcraftModElements.ModElement.Tag
public class BronzeShellBlock extends ChemcraftModElements.ModElement {
	@ObjectHolder("chemcraft:bronze_shell")
	public static final Block block = null;
	public BronzeShellBlock(ChemcraftModElements instance) {
		super(instance, 207);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ModTabItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(1.1f, 10f).lightValue(0).harvestLevel(3)
					.harvestTool(ToolType.PICKAXE));
			setRegistryName("bronze_shell");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
