
package net.beriff.chemistrycraft.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;

import net.beriff.chemistrycraft.itemgroup.ModTabItemGroup;
import net.beriff.chemistrycraft.ChemcraftModElements;

@ChemcraftModElements.ModElement.Tag
public class KevlarVestItem extends ChemcraftModElements.ModElement {
	@ObjectHolder("chemcraft:kevlar_vesthelmet")
	public static final Item helmet = null;
	@ObjectHolder("chemcraft:kevlar_vestbody")
	public static final Item body = null;
	@ObjectHolder("chemcraft:kevlar_vestlegs")
	public static final Item legs = null;
	@ObjectHolder("chemcraft:kevlar_vestboots")
	public static final Item boots = null;
	public KevlarVestItem(ChemcraftModElements instance) {
		super(instance, 313);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 500;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 5, 117, 2}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 1;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(KevlarItem.block, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "kevlar_vest";
			}

			public float getToughness() {
				return 5f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(ModTabItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "chemcraft:textures/kevlar_black.png";
			}
		}.setRegistryName("kevlar_vestbody"));
	}
}
