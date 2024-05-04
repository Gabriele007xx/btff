
package net.mcreator.bttf.client.renderer;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.bttf.BttfMod;
import net.mcreator.bttf.client.model.DMCModel;
import net.mcreator.bttf.entity.DMCEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DMCRenderer extends GeoEntityRenderer<DMCEntity> {
	public DMCRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new DMCModel());
	}
	@Override
	public ResourceLocation getTextureLocation(DMCEntity entity) {
		return new ResourceLocation(BttfMod.MODID, "textures/entities/dmc.png");
	}
	@Override
	public RenderType getRenderType(DMCEntity entity, float ticks, PoseStack pose, MultiBufferSource render, VertexConsumer vertex, int light, ResourceLocation tex)
	{
		pose.scale(0.8f,0.8f,0.8f);
		return super.getRenderType(entity,ticks,pose,render,vertex,light,tex);
	}

}
