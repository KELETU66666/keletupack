package keletu.keletupack.util.handler;

import keletu.keletupack.event.AntiCheatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;

public class EventHandler {
    public static void registerEvents() {
        if (Loader.isModLoaded("projecte")) {
            MinecraftForge.EVENT_BUS.register(new AntiCheatEvent());
        }
    }
}
