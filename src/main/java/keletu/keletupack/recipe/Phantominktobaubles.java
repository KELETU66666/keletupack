package keletu.keletupack.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.zeith.thaumicadditions.init.ItemsTAR;
import thaumicperiphery.crafting.PhantomInkRecipe;

public class Phantominktobaubles extends PhantomInkRecipe {

    protected boolean isInkable(ItemStack stack) {
        Item item = stack.getItem();

        boolean inkable = false;

        if (item == ItemsTAR.TRAVELLER_BELT || item == ItemsTAR.STRIDING_BELT || item == ItemsTAR.METEOR_BELT || item == ItemsTAR.FRAGNANT_PENDANT) inkable = true;

        if (item == ForgeRegistries.ITEMS.getValue(new ResourceLocation("ichoriumkit", "focus_pouch"))) inkable = true;

        if (item == ForgeRegistries.ITEMS.getValue(new ResourceLocation("planarartifice", "belt_of_suspension")) || item == ForgeRegistries.ITEMS.getValue(new ResourceLocation("planarartifice", "mirrored_amulet"))) inkable = true;

        if (item == ForgeRegistries.ITEMS.getValue(new ResourceLocation("tg", "belt_light")) || item == ForgeRegistries.ITEMS.getValue(new ResourceLocation("tg", "belt_shade"))) inkable = true;


        return inkable;
    }

}