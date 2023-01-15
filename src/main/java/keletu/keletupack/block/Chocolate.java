package keletu.keletupack.block;

import keletu.keletupack.init.ModBlocks;
import keletu.keletupack.init.ModItems;
import keletu.keletupack.keletupack;
import keletu.keletupack.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import thaumcraft.api.ThaumcraftMaterials;

public class Chocolate extends Block implements IHasModel {

    public Chocolate(){
        super(ThaumcraftMaterials.MATERIAL_TAINT);
        setHardness(2.0F);
        setResistance(10.0F);
        setCreativeTab(CreativeTabs.MISC);
        this.setHarvestLevel("pickaxe", 0);
        setUnlocalizedName("chocolate_block");
        setRegistryName("chocolate_block");

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        keletupack.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
