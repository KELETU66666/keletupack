package keletu.keletupack.items.resources;

import keletu.keletupack.init.ModItems;
import keletu.keletupack.keletupack;
import keletu.keletupack.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ItemChocolateCream extends ItemFood implements IHasModel {

    public ItemChocolateCream() {
        super(3, 3, false);
        setUnlocalizedName("icecream").setRegistryName("icecream").setCreativeTab(CreativeTabs.MISC);
        ModItems.ITEMS.add(this);
    }


    @Override
    public void registerModels() {
            keletupack.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
