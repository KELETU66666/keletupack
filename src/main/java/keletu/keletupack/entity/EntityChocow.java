package keletu.keletupack.entity;

import keletu.keletupack.init.ModItems;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;

public class EntityChocow extends EntityCow {
    public EntityChocow(World world) {
        super(world);
    }

    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        ItemStack itemstack = player.getHeldItem(hand);

        if (itemstack.getItem() == Items.BUCKET && !player.capabilities.isCreativeMode && !this.isChild())
        {
            player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
            itemstack.shrink(1);

            if (itemstack.isEmpty())
            {
                player.setHeldItem(hand, new ItemStack(ModItems.Chocolate));
            }
            else if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.Chocolate)))
            {
                player.dropItem(new ItemStack(ModItems.Chocolate), false);
            }

            return true;
        }
        else
        {
            return super.processInteract(player, hand);
        }
    }

}
