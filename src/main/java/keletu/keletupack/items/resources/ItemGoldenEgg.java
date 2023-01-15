package keletu.keletupack.items.resources;

import keletu.keletupack.init.ModItems;
import keletu.keletupack.items.ItemBase;
import keletu.keletupack.keletupack;
import keletu.keletupack.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemGoldenEgg extends Item implements IHasModel {

    public ItemGoldenEgg() {
        setUnlocalizedName("gold_egg").setRegistryName("gold_egg").setCreativeTab(CreativeTabs.MISC);
        ModItems.ITEMS.add(this);
    }


    @Override
    public void registerModels() {
            keletupack.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
