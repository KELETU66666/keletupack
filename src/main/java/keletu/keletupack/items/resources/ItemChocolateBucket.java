package keletu.keletupack.items.resources;

import keletu.keletupack.init.ModItems;
import keletu.keletupack.keletupack;
import keletu.keletupack.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucketMilk;

public class ItemChocolateBucket extends ItemBucketMilk implements IHasModel {
    public ItemChocolateBucket()
    {
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.MISC);
        this.setUnlocalizedName("chocolate_bucket");
        this.setRegistryName("chocolate_bucket");
        this.setContainerItem(Items.BUCKET);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
            keletupack.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
