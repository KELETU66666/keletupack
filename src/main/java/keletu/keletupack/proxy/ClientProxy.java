package keletu.keletupack.proxy;

import keletu.keletupack.compat.RenderChocolateCow;
import keletu.keletupack.compat.RenderGoldChicken;
import keletu.keletupack.compat.RenderKeletu;
import keletu.keletupack.entity.EntityChocow;
import keletu.keletupack.entity.EntityGoldenChicken;
import keletu.keletupack.entity.EntityKeletu;
import keletu.keletupack.render.RenderBaubles;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.Map;

public class ClientProxy extends CommonProxy {
    public void registerItemRenderer( Item item, int meta, String id )
    {
        ModelLoader.setCustomModelResourceLocation( item, meta, new ModelResourceLocation( item.getRegistryName(), id ) );
    }

    public void preInit( FMLPreInitializationEvent event )
    {
        super.preInit( event );
        RenderingRegistry.registerEntityRenderingHandler(EntityGoldenChicken.class, RenderGoldChicken::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityChocow.class, RenderChocolateCow::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityKeletu.class, RenderKeletu::new);
    }


    public void init( FMLInitializationEvent event )
    {
        super.init(event);
        Map<String, RenderPlayer> skinMap = Minecraft.getMinecraft().getRenderManager().getSkinMap();
        RenderPlayer render;
        render = skinMap.get("default");
        render.addLayer(new RenderBaubles(render));

        render = skinMap.get("slim");
        render.addLayer(new RenderBaubles(render));
    }
}
