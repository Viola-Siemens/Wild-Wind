package org.polaris2023.wild_wind.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import org.jetbrains.annotations.NotNull;
import org.polaris2023.wild_wind.api.Const;
import org.polaris2023.wild_wind.common.entity.Firefly;

public class FireflyModel extends EntityModel<Firefly> {
    public static final ModelLayerLocation LOCATION = new ModelLayerLocation(Const.location("firefly"), "main");
    private final ModelPart bb_main;
    public FireflyModel(ModelPart modelPart) {
        bb_main = modelPart.getChild("bb_main");
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
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        PartDefinition bb_main = partDefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        return LayerDefinition.create(meshDefinition, 16, 16);
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack pPoseStack,
                               @NotNull VertexConsumer pBuffer,
                               int pPackedLight,
                               int pPackedOverlay,
                               int pColor) {
        bb_main.render(pPoseStack, pBuffer,pPackedLight, pPackedOverlay, pColor);
    }
}
