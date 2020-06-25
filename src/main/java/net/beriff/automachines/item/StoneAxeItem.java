
package net.beriff.automachines.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.beriff.automachines.AutomachinesModElements;

@AutomachinesModElements.ModElement.Tag
public class StoneAxeItem extends AutomachinesModElements.ModElement {
	@ObjectHolder("automachines:stone_axe")
	public static final Item block = null;
	public StoneAxeItem(AutomachinesModElements instance) {
		super(instance, 82);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 50;
			}

			public float getEfficiency() {
				return 2f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 0;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("stone_axe"));
	}
}
