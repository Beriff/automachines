
package net.beriff.chemistrycraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.beriff.chemistrycraft.itemgroup.ModTabItemGroup;
import net.beriff.chemistrycraft.ChemcraftModElements;

@ChemcraftModElements.ModElement.Tag
public class ChiselItem extends ChemcraftModElements.ModElement {
	@ObjectHolder("chemcraft:chisel")
	public static final Item block = null;
	public ChiselItem(ChemcraftModElements instance) {
		super(instance, 195);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ModTabItemGroup.tab).maxDamage(40));
			setRegistryName("chisel");
		}

		@Override
		public boolean hasContainerItem() {
			return true;
		}

		@Override
		public ItemStack getContainerItem(ItemStack itemstack) {
			ItemStack retval = new ItemStack(this);
			retval.setDamage(itemstack.getDamage() + 1);
			if (retval.getDamage() >= retval.getMaxDamage()) {
				return ItemStack.EMPTY;
			}
			return retval;
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
