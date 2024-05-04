package net.mcreator.bttf.client.model;

import net.mcreator.bttf.BttfMod;
import net.mcreator.bttf.entity.DMCEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DMCModel extends AnimatedGeoModel<DMCEntity> {
	@Override
	public ResourceLocation getModelLocation(DMCEntity entiity) {
		return new ResourceLocation(BttfMod.MODID, "geo/car.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(DMCEntity entity) {
		return new ResourceLocation(BttfMod.MODID, "textures/entities/dmc.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(DMCEntity entity) {
		return new ResourceLocation(BttfMod.MODID, "animations/car.animation.json");
	}
}