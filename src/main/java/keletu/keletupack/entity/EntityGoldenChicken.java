package keletu.keletupack.entity;

import fr.wind_blade.isorropia.common.items.ItemsIS;
import keletu.keletupack.init.ModItems;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityGoldenChicken extends EntityChicken {
    public EntityGoldenChicken(World world) {
        super(world);
        this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
    }

    public void onLivingUpdate() {
        int notTime = this.timeUntilNextEgg;
        this.timeUntilNextEgg = Integer.MAX_VALUE;
        super.onLivingUpdate();
        this.timeUntilNextEgg = notTime;
        if (this.world.isRemote || isChild() || isChickenJockey())
            return;
        if (--this.timeUntilNextEgg <= 0) {
            playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand
                    .nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            dropItem(ModItems.Gold_Egg, 1);
            this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        }
    }

    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setInteger("egg", this.timeUntilNextEgg);
    }

    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.timeUntilNextEgg = (compound.getInteger("egg") != 0) ? compound.getInteger("egg") : this.timeUntilNextEgg;
       }
}
