
package net.beriff.chemistrycraft.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.beriff.chemistrycraft.item.TinDustItem;
import net.beriff.chemistrycraft.ChemcraftModElements;

@ChemcraftModElements.ModElement.Tag
public class ModTabItemGroup extends ChemcraftModElements.ModElement {
	public ModTabItemGroup(ChemcraftModElements instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmod_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(TinDustItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
