package keletu.keletupack.proxy;

import keletu.keletupack.util.handler.EventHandler;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void registerItemRenderer( Item item, int meta, String id )
    {
    }


    public void preInit( FMLPreInitializationEvent event )
    {
        EventHandler.registerEvents();
    }

    public void registerDisplayInformationInit() {}

}
