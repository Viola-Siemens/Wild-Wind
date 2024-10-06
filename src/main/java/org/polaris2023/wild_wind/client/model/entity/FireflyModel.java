package org.polaris2023.wild_wind.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import org.jetbrains.annotations.NotNull;
import org.polaris2023.wild_wind.api.Const;
import org.polaris2023.wild_wind.client.animations.FireflyAnimation;
import org.polaris2023.wild_wind.common.entity.Firefly;

@SuppressWarnings({"unused", "FieldCanBeLocal"})
public class FireflyModel extends HierarchicalModel<Firefly> {
    public static final ModelLayerLocation LOCATION = new ModelLayerLocation(Const.location("firefly"), "main");
    public final ModelPart bug;
    public final ModelPart head;
    public final ModelPart antennae;
    public final ModelPart tail;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart tail3;
    private final ModelPart left_wing2;
    private final ModelPart right_wing2;
    private final ModelPart rightleg1;
    private final ModelPart rightleg2;
    private final ModelPart rightleg3;
    private final ModelPart leftleg1;
    private final ModelPart leftleg2;
    private final ModelPart leftleg3;
    private final ModelPart right_wing1;
    private final ModelPart left_wing1;
    public FireflyModel(ModelPart root) {
        this.bug = root.getChild("bug");
        this.head = this.bug.getChild("head");
        this.antennae = this.head.getChild("antennae");
        this.tail = this.bug.getChild("tail");
        this.tail1 = this.tail.getChild("tail1");
        this.tail2 = this.tail.getChild("tail2");
        this.tail3 = this.tail.getChild("tail3");
        this.left_wing2 = this.tail.getChild("left_wing2");
        this.right_wing2 = this.tail.getChild("right_wing2");
        this.rightleg1 = this.tail.getChild("rightleg1");
        this.rightleg2 = this.tail.getChild("rightleg2");
        this.rightleg3 = this.tail.getChild("rightleg3");
        this.leftleg1 = this.tail.getChild("leftleg1");
        this.leftleg2 = this.tail.getChild("leftleg2");
        this.leftleg3 = this.tail.getChild("leftleg3");
        this.right_wing1 = this.tail.getChild("right_wing1");
        this.left_wing1 = this.tail.getChild("left_wing1");
    }

    /**
     * Sets this entity's model rotation angles
     *
     * @param pEntity {@link Firefly}
     * @param pLimbSwing {@link Float}
     * @param pLimbSwingAmount {@link Float}
     * @param pAgeInTicks {@link Float}
     * @param pNetHeadYaw {@link Float}
     * @param pHeadPitch {@link Float}
     */
    @Override
    public void setupAnim(@NotNull Firefly pEntity,
                          float pLimbSwing,
                          float pLimbSwingAmount,
                          float pAgeInTicks,
                          float pNetHeadYaw,
                          float pHeadPitch) {
        animate(pEntity.idle, FireflyAnimation.idle, pAgeInTicks, 0.3f);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bug = partdefinition.addOrReplaceChild("bug", CubeListBuilder.create(), PartPose.offset(-0.5F, 20.5F, 0.0F));

        PartDefinition head = bug.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, -1.5F, -3.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(2, 36).addBox(-1.5F, -0.25F, -3.1F, 0.5F, 0.5F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 36).addBox(1.0F, -0.25F, -3.1F, 0.5F, 0.5F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -1.5F, 0.0F));

        PartDefinition antennae = head.addOrReplaceChild("antennae", CubeListBuilder.create(), PartPose.offset(0.0F, -1.5F, -3.0F));

        PartDefinition cube_r1 = antennae.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(7, 29).mirror().addBox(0.0F, -2.0F, -3.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, -0.1745F, 0.0F));

        PartDefinition cube_r2 = antennae.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(7, 29).addBox(0.0F, -2.0F, -3.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, 0.1745F, 0.0F));

        PartDefinition tail = bug.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.5F, -1.5F, 0.0F));

        PartDefinition tail1 = tail.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(15, 5).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(-0.005F)), PartPose.offset(0.0F, 0.5F, 3.0F));

        PartDefinition tail2 = tail.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(0, 11).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(-0.005F)), PartPose.offset(0.0F, 0.5F, 3.0F));

        PartDefinition tail3 = tail.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(-0.005F)), PartPose.offset(0.0F, 0.5F, 3.0F));

        PartDefinition left_wing2 = tail.addOrReplaceChild("left_wing2", CubeListBuilder.create().texOffs(15, 23).addBox(-2.0F, -5.5F, 0.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -1.5F, 0.0F));

        PartDefinition right_wing2 = tail.addOrReplaceChild("right_wing2", CubeListBuilder.create().texOffs(26, 23).addBox(-2.0F, -5.5F, 0.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -1.5F, 0.0F));

        PartDefinition rightleg1 = tail.addOrReplaceChild("rightleg1", CubeListBuilder.create().texOffs(0, 11).addBox(0.0F, -0.5F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 2.0F, 1.0F));

        PartDefinition rightleg2 = tail.addOrReplaceChild("rightleg2", CubeListBuilder.create().texOffs(3, 11).addBox(0.0F, -0.5F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 2.0F, 3.0F));

        PartDefinition rightleg3 = tail.addOrReplaceChild("rightleg3", CubeListBuilder.create().texOffs(15, 0).addBox(0.0F, -0.5F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 2.0F, 5.0F));

        PartDefinition leftleg1 = tail.addOrReplaceChild("leftleg1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -0.5F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 2.0F, 1.0F));

        PartDefinition leftleg2 = tail.addOrReplaceChild("leftleg2", CubeListBuilder.create().texOffs(3, 0).addBox(0.0F, -0.5F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 2.0F, 3.0F));

        PartDefinition leftleg3 = tail.addOrReplaceChild("leftleg3", CubeListBuilder.create().texOffs(30, 5).addBox(0.0F, -0.5F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 2.0F, 5.0F));

        PartDefinition right_wing1 = tail.addOrReplaceChild("right_wing1", CubeListBuilder.create().texOffs(15, 0).addBox(-0.5F, 0.0F, -2.0F, 6.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -1.5F, 2.0F));

        PartDefinition left_wing1 = tail.addOrReplaceChild("left_wing1", CubeListBuilder.create().texOffs(17, 18).addBox(-5.5F, 0.0F, -2.0F, 6.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -1.5F, 2.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack pPoseStack,
                               @NotNull VertexConsumer pBuffer,
                               int pPackedLight,
                               int pPackedOverlay,
                               int pColor) {
        bug.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pColor);
    }

    @Override
    public ModelPart root() {
        return this.bug;
    }


}
