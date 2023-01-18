package keletu.keletupack.util.handler;

import fr.wind_blade.isorropia.common.IsorropiaAPI;
import keletu.keletupack.init.ModBlocks;
import keletu.keletupack.init.ModItems;
import keletu.keletupack.items.resources.ResourceKP;
import keletu.keletupack.recipe.Phantominktobaubles;
import keletu.keletupack.util.IHasModel;
import keletu.keletupack.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectEventProxy;
import thaumcraft.api.aspects.AspectRegistryEvent;

import static org.zeith.thaumicadditions.init.KnowledgeTAR.DRACO;

@Mod.EventBusSubscriber

public class RegistryHandler {

    public static final Aspect RENAISSANCE;

    @SubscribeEvent
    public static void onItemRegister( RegistryEvent.Register<Item> event ) {
        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
            event.getRegistry().registerAll(new ResourceKP());
    }
    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
    }

    static {
                RENAISSANCE = new Aspect("renaissance", 0x12ead1, new Aspect[]{DRACO, IsorropiaAPI.PRIDE}, new ResourceLocation("keletupack", "textures/aspects/packaspect.png"), 1);
    }

    @SubscribeEvent
    public static void onModelRegister( ModelRegistryEvent event )
    {
        for ( Item item : ModItems.ITEMS ) {
            if (item instanceof IHasModel) {
                ((IHasModel) item).registerModels();
            }
        }
        for (Block block: ModBlocks.BLOCKS)
        {
            if (block instanceof IHasModel)
            {
                ((IHasModel)block).registerModels();
            }
        }

    }

    @SubscribeEvent
    public static void registerAspects(AspectRegistryEvent event) {
        AspectEventProxy proxy = event.register;
    }

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        IForgeRegistry<IRecipe> registry = event.getRegistry();
        registry.register(new Phantominktobaubles().setRegistryName(Reference.MOD_ID, "phantom_ink"));}
}
