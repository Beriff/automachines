
package net.beriff.chemistrycraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.beriff.chemistrycraft.itemgroup.ModTabItemGroup;
import net.beriff.chemistrycraft.ChemcraftModElements;

@ChemcraftModElements.ModElement.Tag
public class PileOfImpureRheniumItem extends ChemcraftModElements.ModElement {
	@ObjectHolder("chemcraft:pile_of_impure_rhenium")
	public static final Item block = null;
	public PileOfImpureRheniumItem(ChemcraftModElements instance) {
		super(instance, 297);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ModTabItemGroup.tab).maxStackSize(64));
			setRegistryName("pile_of_impure_rhenium");
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
