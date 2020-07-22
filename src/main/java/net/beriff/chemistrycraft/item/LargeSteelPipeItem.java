
package net.beriff.chemistrycraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.beriff.chemistrycraft.itemgroup.ModTabItemGroup;
import net.beriff.chemistrycraft.ChemcraftModElements;

@ChemcraftModElements.ModElement.Tag
public class LargeSteelPipeItem extends ChemcraftModElements.ModElement {
	@ObjectHolder("chemcraft:large_steel_pipe")
	public static final Item block = null;
	public LargeSteelPipeItem(ChemcraftModElements instance) {
		super(instance, 218);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ModTabItemGroup.tab).maxStackSize(64));
			setRegistryName("large_steel_pipe");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
