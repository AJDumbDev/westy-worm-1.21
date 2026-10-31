package net.ajdumbdev.westyworm.entity.client;

import net.ajdumbdev.westyworm.WestyWorm;
import net.ajdumbdev.westyworm.entity.custom.WestyWormEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class WestyWormModel<T extends WestyWormEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer WESTYWORM = new EntityModelLayer(Identifier.of(WestyWorm.MOD_ID, "westy_worm"), "main");

    private final ModelPart westyworm;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart t1;
    private final ModelPart t2;
    private final ModelPart e1;
    private final ModelPart e2;
    private final ModelPart leftlegs;
    private final ModelPart l2;
    private final ModelPart l3;
    private final ModelPart l4;
    private final ModelPart l5;
    private final ModelPart l6;
    private final ModelPart l7;
    private final ModelPart rightlegs;
    private final ModelPart r2;
    private final ModelPart r3;
    private final ModelPart r4;
    private final ModelPart r5;
    private final ModelPart r6;
    private final ModelPart r7;
    private final ModelPart tail;
    public WestyWormModel(ModelPart root) {
        this.westyworm = root.getChild("westyworm");
        this.body = this.westyworm.getChild("body");
        this.head = this.westyworm.getChild("head");
        this.t1 = this.head.getChild("t1");
        this.t2 = this.head.getChild("t2");
        this.e1 = this.head.getChild("e1");
        this.e2 = this.head.getChild("e2");
        this.leftlegs = this.westyworm.getChild("leftlegs");
        this.l2 = this.leftlegs.getChild("l2");
        this.l3 = this.leftlegs.getChild("l3");
        this.l4 = this.leftlegs.getChild("l4");
        this.l5 = this.leftlegs.getChild("l5");
        this.l6 = this.leftlegs.getChild("l6");
        this.l7 = this.leftlegs.getChild("l7");
        this.rightlegs = this.westyworm.getChild("rightlegs");
        this.r2 = this.rightlegs.getChild("r2");
        this.r3 = this.rightlegs.getChild("r3");
        this.r4 = this.rightlegs.getChild("r4");
        this.r5 = this.rightlegs.getChild("r5");
        this.r6 = this.rightlegs.getChild("r6");
        this.r7 = this.rightlegs.getChild("r7");
        this.tail = this.westyworm.getChild("tail");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData westyworm = modelPartData.addChild("westyworm", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = westyworm.addChild("body", ModelPartBuilder.create().uv(54, 56).cuboid(-4.0F, -10.0F, -18.0F, 8.0F, 9.0F, 2.0F, new Dilation(0.0F))
                .uv(34, 41).cuboid(-5.0F, -12.0F, -16.0F, 10.0F, 11.0F, 4.0F, new Dilation(0.0F))
                .uv(38, 21).cuboid(-6.0F, -14.0F, -12.0F, 12.0F, 13.0F, 7.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-7.0F, -15.0F, -5.0F, 14.0F, 14.0F, 7.0F, new Dilation(0.0F))
                .uv(0, 21).cuboid(-6.0F, -14.0F, 2.0F, 12.0F, 13.0F, 7.0F, new Dilation(0.0F))
                .uv(0, 41).cuboid(-5.0F, -12.0F, 9.0F, 10.0F, 11.0F, 7.0F, new Dilation(0.0F))
                .uv(42, 0).cuboid(-4.0F, -10.0F, 16.0F, 8.0F, 9.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 59).cuboid(-3.0F, -9.0F, 20.0F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData head = westyworm.addChild("head", ModelPartBuilder.create().uv(34, 56).cuboid(-3.0F, -4.0F, -3.0F, 6.0F, 8.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.0F, -19.0F));

        ModelPartData t1 = head.addChild("t1", ModelPartBuilder.create(), ModelTransform.pivot(-2.0F, 3.0F, -3.0F));

        ModelPartData t1_r1 = t1.addChild("t1_r1", ModelPartBuilder.create().uv(54, 13).cuboid(0.0F, -1.0F, -2.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.2618F, 0.0F));

        ModelPartData t2 = head.addChild("t2", ModelPartBuilder.create(), ModelTransform.pivot(2.0F, 3.0F, -3.0F));

        ModelPartData t2_r1 = t2.addChild("t2_r1", ModelPartBuilder.create().uv(54, 13).cuboid(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.2618F, 0.0F));

        ModelPartData e1 = head.addChild("e1", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, -3.0F, -1.0F));

        ModelPartData e1_r1 = e1.addChild("e1_r1", ModelPartBuilder.create().uv(0, 70).cuboid(0.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

        ModelPartData e2 = head.addChild("e2", ModelPartBuilder.create(), ModelTransform.pivot(3.0F, -3.0F, -1.0F));

        ModelPartData e2_r1 = e2.addChild("e2_r1", ModelPartBuilder.create().uv(0, 70).cuboid(-2.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

        ModelPartData leftlegs = westyworm.addChild("leftlegs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData l2 = leftlegs.addChild("l2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, -14.0F));

        ModelPartData l2_r1 = l2.addChild("l2_r1", ModelPartBuilder.create().uv(76, 18).cuboid(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

        ModelPartData l3 = leftlegs.addChild("l3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, -8.0F));

        ModelPartData l3_r1 = l3.addChild("l3_r1", ModelPartBuilder.create().uv(76, 18).cuboid(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(6.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

        ModelPartData l4 = leftlegs.addChild("l4", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, -1.0F));

        ModelPartData l4_r1 = l4.addChild("l4_r1", ModelPartBuilder.create().uv(76, 18).cuboid(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(7.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

        ModelPartData l5 = leftlegs.addChild("l5", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 6.0F));

        ModelPartData l5_r1 = l5.addChild("l5_r1", ModelPartBuilder.create().uv(76, 18).cuboid(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(6.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

        ModelPartData l6 = leftlegs.addChild("l6", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 12.0F));

        ModelPartData l6_r1 = l6.addChild("l6_r1", ModelPartBuilder.create().uv(76, 18).cuboid(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

        ModelPartData l7 = leftlegs.addChild("l7", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 18.0F));

        ModelPartData l7_r1 = l7.addChild("l7_r1", ModelPartBuilder.create().uv(76, 18).cuboid(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

        ModelPartData rightlegs = westyworm.addChild("rightlegs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData r2 = rightlegs.addChild("r2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, -14.0F));

        ModelPartData r2_r1 = r2.addChild("r2_r1", ModelPartBuilder.create().uv(76, 18).cuboid(-1.0F, -3.0F, -1.0F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

        ModelPartData r3 = rightlegs.addChild("r3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, -8.0F));

        ModelPartData r3_r1 = r3.addChild("r3_r1", ModelPartBuilder.create().uv(76, 18).cuboid(-1.0F, -3.0F, -1.0F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-6.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

        ModelPartData r4 = rightlegs.addChild("r4", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, -1.0F));

        ModelPartData r4_r1 = r4.addChild("r4_r1", ModelPartBuilder.create().uv(76, 18).cuboid(-1.0F, -3.0F, -1.0F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

        ModelPartData r5 = rightlegs.addChild("r5", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 6.0F));

        ModelPartData r5_r1 = r5.addChild("r5_r1", ModelPartBuilder.create().uv(76, 18).cuboid(-1.0F, -3.0F, -1.0F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-6.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

        ModelPartData r6 = rightlegs.addChild("r6", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 12.0F));

        ModelPartData r6_r1 = r6.addChild("r6_r1", ModelPartBuilder.create().uv(76, 18).cuboid(-1.0F, -3.0F, -1.0F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

        ModelPartData r7 = rightlegs.addChild("r7", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 18.0F));

        ModelPartData r7_r1 = r7.addChild("r7_r1", ModelPartBuilder.create().uv(76, 18).cuboid(-1.0F, -3.0F, -1.0F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

        ModelPartData tail = westyworm.addChild("tail", ModelPartBuilder.create().uv(66, 0).cuboid(-2.0F, -18.0F, 21.0F, 4.0F, 5.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData t8_r1 = tail.addChild("t8_r1", ModelPartBuilder.create().uv(20, 64).cuboid(-1.0F, -9.0F, 3.0F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -21.0F, 9.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData t7_r1 = tail.addChild("t7_r1", ModelPartBuilder.create().uv(42, 13).cuboid(-2.0F, -6.0F, 2.0F, 4.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -22.0F, 9.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData t6_r1 = tail.addChild("t6_r1", ModelPartBuilder.create().uv(36, 68).cuboid(-2.0F, -1.0F, 0.0F, 4.0F, 5.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -23.0F, 9.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData t5_r1 = tail.addChild("t5_r1", ModelPartBuilder.create().uv(62, 41).cuboid(-2.0F, -6.0F, 0.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -22.0F, 19.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData t4_r1 = tail.addChild("t4_r1", ModelPartBuilder.create().uv(66, 0).cuboid(-2.0F, -5.0F, 0.0F, 4.0F, 5.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -20.0F, 21.0F, 1.0472F, 0.0F, 0.0F));

        ModelPartData t3_r1 = tail.addChild("t3_r1", ModelPartBuilder.create().uv(66, 0).cuboid(-2.0F, -5.0F, 0.0F, 4.0F, 5.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -17.0F, 21.0F, 0.2618F, 0.0F, 0.0F));

        ModelPartData t1_r2 = tail.addChild("t1_r2", ModelPartBuilder.create().uv(66, 0).cuboid(-2.0F, -5.0F, 0.0F, 4.0F, 5.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -9.0F, 20.0F, -0.2618F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void setAngles(WestyWormEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw,headPitch);

        this.animateMovement(WestyWormAnimation.ANIM_WESTYSWORM_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, WestyWormAnimation.ANIM_WESTYSWORM_IDLE, ageInTicks, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw,-30.0F,30.0F);
        headPitch = MathHelper.clamp(headPitch,-25.0F,45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        westyworm.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return westyworm;
    }
}
