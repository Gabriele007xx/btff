
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bttf.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.bttf.client.renderer.DMCRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BttfModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		//event.registerEntityRenderer(BttfModEntities.DMC.get(), DMCRenderer::new);
	}
}
