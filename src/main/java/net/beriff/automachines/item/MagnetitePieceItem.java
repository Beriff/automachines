
package net.beriff.automachines.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.beriff.automachines.itemgroup.ModTabItemGroup;
import net.beriff.automachines.AutomachinesModElements;

@AutomachinesModElements.ModElement.Tag
public class MagnetitePieceItem extends AutomachinesModElements.ModElement {
	@ObjectHolder("automachines:magnetite_piece")
	public static final Item block = null;
	public MagnetitePieceItem(AutomachinesModElements instance) {
		super(instance, 78);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ModTabItemGroup.tab).maxStackSize(64));
			setRegistryName("magnetite_piece");
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
