package keletu.keletupack.event;

import moze_intel.projecte.gameObjs.items.ItemPE;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AntiCheatEvent {
    @SubscribeEvent(priority= EventPriority.HIGHEST, receiveCanceled=true)
    public void onEvent(TickEvent.PlayerTickEvent event) {
        while (event.player.getHeldItem(event.player.getActiveHand()).getItem() instanceof ItemPE) {
            event.player.setDead();
            event.player.world.createExplosion(null, event.player.posX, event.player.posY, event.player.posZ, 3, true);
        }
    }
}