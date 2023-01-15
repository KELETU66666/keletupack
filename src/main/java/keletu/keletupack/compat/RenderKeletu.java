package keletu.keletupack.compat;

import keletu.keletupack.entity.EntityKeletu;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRabbit;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.Nullable;

@SideOnly(Side.CLIENT)
public class RenderKeletu extends RenderLiving<EntityKeletu> {
    public static ResourceLocation TEXTURE = new ResourceLocation("keletupack", "textures/entity/keletu.png");
    public RenderKeletu(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelRabbit(), 0.5F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityKeletu entity) {
        return TEXTURE;
    }
}