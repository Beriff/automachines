
package net.beriff.automachines.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.beriff.automachines.itemgroup.ModTabItemGroup;
import net.beriff.automachines.AutomachinesModElements;

@AutomachinesModElements.ModElement.Tag
public class SulfurItem extends AutomachinesModElements.ModElement {
	@ObjectHolder("automachines:sulfur")
	public static final Item block = null;
	public SulfurItem(AutomachinesModElements instance) {
		super(instance, 31);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ModTabItemGroup.tab).maxStackSize(64));
			setRegistryName("sulfur");
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
