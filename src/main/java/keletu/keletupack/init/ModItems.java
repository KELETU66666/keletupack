package keletu.keletupack.init;

import keletu.keletupack.items.resources.ItemChocolateBucket;
import keletu.keletupack.items.resources.ItemChocolateCream;
import keletu.keletupack.items.resources.ItemChocolateIngot;
import keletu.keletupack.items.resources.ItemGoldenEgg;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<Item>();
    public static final Item Gold_Egg = new ItemGoldenEgg();
    public static final Item Chocolate = new ItemChocolateBucket();
    public static final Item Chocolate_Cream = new ItemChocolateCream();
    public static final Item Chocolate_Ingot = new ItemChocolateIngot();
}