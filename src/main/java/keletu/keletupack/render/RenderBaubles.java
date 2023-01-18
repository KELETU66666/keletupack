package keletu.keletupack.render;

import baubles.api.BaublesApi;
import baubles.api.render.IRenderBauble;
import keletu.keletupack.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.lwjgl.opengl.GL11;
import org.zeith.thaumicadditions.init.ItemsTAR;
import thaumcraft.client.lib.UtilsFX;
import thaumicperiphery.Config;
import thaumicperiphery.crafting.PhantomInkRecipe;

import static thaumicperiphery.render.LayerExtraBaubles.focus_pouch;
import static thaumicperiphery.render.LayerExtraBaubles.renderIconIn3D;

public class RenderBaubles implements LayerRenderer<EntityPlayer> {

    protected final RenderPlayer renderer;

    public static final ResourceLocation traveler_belt = new ResourceLocation(Reference.MOD_ID, "textures/model/traveler_belt.png");
    public static final ResourceLocation striding_belt = new ResourceLocation(Reference.MOD_ID, "textures/model/striding_belt.png");
    public static final ResourceLocation meteor_belt = new ResourceLocation(Reference.MOD_ID, "textures/model/meteor_belt.png");
    public static final ResourceLocation shade_belt = new ResourceLocation(Reference.MOD_ID, "textures/model/shade_belt.png");
    public static final ResourceLocation light_belt = new ResourceLocation(Reference.MOD_ID, "textures/model/light_belt.png");
    public static final ResourceLocation suspension_belt = new ResourceLocation(Reference.MOD_ID, "textures/model/suspension_belt.png");

    public static final ResourceLocation mirrored_amulet = new ResourceLocation(Reference.MOD_ID, "textures/model/mirrored_amulet.png");
    public static final ResourceLocation fragnant_pendant = new ResourceLocation(Reference.MOD_ID, "textures/model/fragnant_amulet.png");

    public RenderBaubles(RenderPlayer renderPlayer) {
        this.renderer = renderPlayer;
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }

    protected static ModelBiped model;
    protected static ModelRenderer pouchModel;
    @Override
    public void doRenderLayer(EntityPlayer player, float limbSwing, float limbSwingAmount,
                              float partialTicks, float age, float netHeadYaw, float headPitch, float scale) {
        if (!baubles.common.Config.renderBaubles || player.getActivePotionEffect(MobEffects.INVISIBILITY) != null) return;

        int i = player.getBrightnessForRender();
        int j = i % 65536;
        int k = i / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j, (float) k);

        if (Config.tcBaubleRenderer) {
            ItemStack belt = BaublesApi.getBaublesHandler(player).getStackInSlot(3);
            if (!belt.isEmpty()) {
                if (belt.getItem() == ItemsTAR.TRAVELLER_BELT && !hasPhantomInk(belt)) {
                    renderBelt(player, partialTicks, traveler_belt);
                }
                else if (belt.getItem() == ItemsTAR.STRIDING_BELT && !hasPhantomInk(belt)) {
                    renderBelt(player, partialTicks, striding_belt);
                }
                else if (belt.getItem() == ItemsTAR.METEOR_BELT && !hasPhantomInk(belt)) {
                    renderBelt(player, partialTicks, meteor_belt);
                }
                else if (belt.getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation("tg", "belt_shade")) && !hasPhantomInk(belt)) {
                    renderBelt(player, partialTicks, shade_belt);
                }
                else if (belt.getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation("tg", "belt_light")) && !hasPhantomInk(belt)) {
                    renderBelt(player, partialTicks, light_belt);
                }
                else if (belt.getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation("planarartifice", "belt_of_suspension")) && !hasPhantomInk(belt)) {
                    renderBelt(player, partialTicks, suspension_belt);
                }
                else if (belt.getItem() ==  ForgeRegistries.ITEMS.getValue(new ResourceLocation("ichoriumkit", "focus_pouch")) && !hasPhantomInk(belt)) {
                    renderPouch(player, partialTicks, focus_pouch);
                }
            }
            ItemStack amulet = BaublesApi.getBaublesHandler(player).getStackInSlot(0);
            if (!amulet.isEmpty()) {
                if (amulet.getItem() == ItemsTAR.FRAGNANT_PENDANT && !hasPhantomInk(amulet)) {
                    renderAmulet(player, partialTicks, 5, 6, fragnant_pendant, null);
                } else if (amulet.getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation("planarartifice", "mirrored_amulet")) && !hasPhantomInk(amulet)) {
                    boolean found = amulet.getMetadata() == 0;
                    renderAmulet(player, partialTicks, 5, 5, mirrored_amulet, null);
                }
            }
        }
    }

    protected void renderBelt(EntityPlayer player, float partialTicks, ResourceLocation belt) {
        GlStateManager.pushMatrix();
        GL11.glColor3ub((byte) 255, (byte) 255, (byte) 255);
        GlStateManager.color(1F, 1F, 1F, 1F);

        Minecraft.getMinecraft().renderEngine.bindTexture(belt);
        IRenderBauble.Helper.rotateIfSneaking(player);

        GlStateManager.translate(0F, 0.2F, 0F);

        float s = 1.05F / 16F;
        GlStateManager.scale(s, s, s);

        if (model == null) model = new ModelBiped();
        model.bipedBody.render(1F);

        GlStateManager.popMatrix();
    }

    protected void renderPouch(EntityPlayer player, float partialTicks, ResourceLocation texture) {
        GlStateManager.pushMatrix();
        GL11.glColor3ub((byte) 255, (byte) 255, (byte) 255);
        GlStateManager.color(1F, 1F, 1F, 1F);

        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        IRenderBauble.Helper.rotateIfSneaking(player);

        GlStateManager.translate(0F, 0.2F, 0F);

        float s = 1.05F / 16F;
        GlStateManager.scale(s, s, s);

        if (model == null) model = new ModelBiped();
        if (pouchModel == null) {
            pouchModel = new ModelRenderer(model, 0, 11);
            pouchModel.addBox(1.25F, 6.5F, -3F, 3, 3, 1);
        }

        model.bipedBody.render(1.0F);
        pouchModel.render(1.0F);

        GlStateManager.popMatrix();
    }

    protected void renderAmulet(EntityPlayer player, float partialTicks, int width, int height, ResourceLocation amulet, TextureAtlasSprite amuletSprite) {
        GlStateManager.pushMatrix();
        GL11.glColor3ub((byte) 255, (byte) 255, (byte) 255);
        GlStateManager.color(1F, 1F, 1F, 1F);

        Minecraft.getMinecraft().renderEngine.bindTexture(amulet);
        IRenderBauble.Helper.rotateIfSneaking(player);

        GlStateManager.translate(0F, -0.0005F, 0F);

        float s = 1.05F / 16F;
        GlStateManager.scale(s, s, s);

        if (model == null) model = new ModelBiped();
        model.bipedBody.render(1F);

        GlStateManager.scale(0.5f * width, -0.5f * height, 2.5f);
        GlStateManager.translate(-0.5F, -1 - ((14 - height) / 16F), -0.725F);

        if (amuletSprite != null) {
            Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);

            float minU = amuletSprite.getMinU();
            float maxU = amuletSprite.getMaxU();
            float minV = amuletSprite.getMinV();
            float maxV = amuletSprite.getMaxV();

            float diffU = maxU - minU;
            float diffV = maxV - minV;

            maxU = minU + (diffU * (width / 16F));
            maxV = minV + (diffV * (height / 16F));

            renderIconIn3D(Tessellator.getInstance(), minU, minV, maxU, maxV, width, height, 0.25F);
        } else {
            UtilsFX.renderTextureIn3D(1 - (width / 128F), 0.0F, 1.0F, height / 64F, width, height, 0.25F);
        }
        GlStateManager.popMatrix();
    }

    public static boolean hasPhantomInk(ItemStack stack) {
        return stack.hasTagCompound() && stack.getTagCompound().hasKey(PhantomInkRecipe.TAG_PHANTOM_INK);
    }
}
