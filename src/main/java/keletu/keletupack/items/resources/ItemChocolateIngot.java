package keletu.keletupack.items.resources;

import keletu.keletupack.init.ModItems;
import keletu.keletupack.keletupack;
import keletu.keletupack.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemChocolateIngot extends Item implements IHasModel {

    public ItemChocolateIngot() {
        setUnlocalizedName("chocolate_ingot").setRegistryName("chocolate_ingot").setCreativeTab(CreativeTabs.MISC);
        ModItems.ITEMS.add(this);
    }


    @Override
    public void registerModels() {
            keletupack.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
