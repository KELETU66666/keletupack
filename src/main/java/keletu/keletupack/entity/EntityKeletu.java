package keletu.keletupack.entity;

import com.verdantartifice.thaumicwonders.common.blocks.BlocksTW;
import com.verdantartifice.thaumicwonders.common.items.ItemsTW;
import keletu.keletupack.init.ModItems;
import keletu.keletupack.util.Reference;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import thaumcraft.api.blocks.BlocksTC;

public class EntityKeletu extends EntityRabbit {

    public static final ResourceLocation LOOT_KELETU = new ResourceLocation("keletupack", "entities/creative");

    public EntityKeletu(World world) {
        super(world);
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_WITHER_DEATH;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return LOOT_KELETU;
    }
}
