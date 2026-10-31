package net.ajdumbdev.westyworm;

import net.ajdumbdev.westyworm.entity.ModEntities;
import net.ajdumbdev.westyworm.entity.client.WestyWormModel;
import net.ajdumbdev.westyworm.entity.client.WestyWormRender;
import net.ajdumbdev.westyworm.entity.custom.WestyWormEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModel;

public class WestyWormClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(WestyWormModel.WESTYWORM, WestyWormModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.WESTY_WORM, WestyWormRender::new);
    }
}
