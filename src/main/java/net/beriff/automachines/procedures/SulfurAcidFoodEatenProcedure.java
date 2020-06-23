package net.beriff.automachines.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.beriff.automachines.AutomachinesModElements;

@AutomachinesModElements.ModElement.Tag
public class SulfurAcidFoodEatenProcedure extends AutomachinesModElements.ModElement {
	public SulfurAcidFoodEatenProcedure(AutomachinesModElements instance) {
		super(instance, 34);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SulfurAcidFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, (int) 1, (int) 3));
	}
}
