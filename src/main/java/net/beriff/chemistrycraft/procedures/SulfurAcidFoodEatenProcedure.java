package net.beriff.chemistrycraft.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.beriff.chemistrycraft.ChemcraftModElements;

import java.util.Map;

@ChemcraftModElements.ModElement.Tag
public class SulfurAcidFoodEatenProcedure extends ChemcraftModElements.ModElement {
	public SulfurAcidFoodEatenProcedure(ChemcraftModElements instance) {
		super(instance, 34);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SulfurAcidFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, (int) 1, (int) 3));
	}
}
