package keletu.keletupack.compat;


import keletu.keletupack.entity.EntityChocow;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderChocolateCow extends RenderLiving<EntityChocow> {
    private static final ResourceLocation COW_TEXTURES = new ResourceLocation("keletupack", "textures/entity/chocow.png");

    public RenderChocolateCow(RenderManager p_i47210_1_)
    {
        super(p_i47210_1_, new ModelCow(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityChocow entity)
    {
        return COW_TEXTURES;
    }
}