package net.ajdumbdev.westyworm.entity.client;

import net.ajdumbdev.westyworm.WestyWorm;
import net.ajdumbdev.westyworm.entity.custom.WestyWormEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class WestyWormRender extends MobEntityRenderer<WestyWormEntity, WestyWormModel<WestyWormEntity>> {
    public WestyWormRender(EntityRendererFactory.Context context) {
        super(context, new WestyWormModel<>(context.getPart(WestyWormModel.WESTYWORM)), 1f);
    }

    @Override
    public Identifier getTexture(WestyWormEntity entity) {
        return Identifier.of(WestyWorm.MOD_ID, "textures/entity/westy_worm/westyworm.png");
    }

    @Override
    public void render(WestyWormEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {



        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
