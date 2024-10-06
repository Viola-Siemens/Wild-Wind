package org.polaris2023.wild_wind.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.polaris2023.wild_wind.client.animations.FireflyAnimation;
import org.polaris2023.wild_wind.client.model.entity.FireflyModel;
import org.polaris2023.wild_wind.common.entity.Firefly;

import static org.polaris2023.wild_wind.api.Const.location;

public class FireflyRenderer extends MobRenderer<Firefly, FireflyModel> {
    private static final ResourceLocation FIREFLY_LOCATION = location("textures/entity/firefly.png");

    public FireflyRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new FireflyModel(pContext.bakeLayer(FireflyModel.LOCATION)), 0.4f);
    }


    @Override
    public ResourceLocation getTextureLocation(Firefly entity) {
        return FIREFLY_LOCATION;
    }

    @Override
    public void render(
            Firefly entity,
            float yaw,
            float partialTick,
            PoseStack transform,
            MultiBufferSource bufferSource,
            int packedLight
    ) {

        super.render(entity, yaw, partialTick, transform, bufferSource, packedLight);

    }
}
