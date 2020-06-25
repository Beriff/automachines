
package net.beriff.automachines.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.beriff.automachines.itemgroup.ModTabItemGroup;
import net.beriff.automachines.AutomachinesModElements;

@AutomachinesModElements.ModElement.Tag
public class StoneHoeItem extends AutomachinesModElements.ModElement {
	@ObjectHolder("automachines:stone_hoe")
	public static final Item block = null;
	public StoneHoeItem(AutomachinesModElements instance) {
		super(instance, 75);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
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
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().group(ModTabItemGroup.tab)) {
		}.setRegistryName("stone_hoe"));
	}
}
