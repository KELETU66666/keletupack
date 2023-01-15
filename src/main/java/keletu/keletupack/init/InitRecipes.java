package keletu.keletupack.init;


import familiarfauna.entities.EntityTurkey;
import fr.wind_blade.isorropia.common.IsorropiaAPI;
import fr.wind_blade.isorropia.common.entities.EntityScholarChicken;
import fr.wind_blade.isorropia.common.items.misc.ItemCat;
import fr.wind_blade.isorropia.common.research.recipes.OrganCurativeInfusionRecipe;
import fr.wind_blade.isorropia.common.research.recipes.SpecieCurativeInfusionRecipe;
import keletu.keletupack.entity.EntityKeletu;
import keletu.keletupack.util.Reference;
import keletu.keletupack.util.handler.RegistryHandler;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.zeith.thaumicadditions.init.BlocksTAR;
import org.zeith.thaumicadditions.init.KnowledgeTAR;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.blocks.BlocksTC;
import thecodex6824.thaumicaugmentation.api.TAItems;
import vazkii.botania.common.block.ModBlocks;

import java.util.UUID;

public class InitRecipes {

    public static void initRecipes() {
        initArcaneRecipes();
    }

private static void initArcaneRecipes() {
    IsorropiaAPI.registerCreatureInfusionRecipe(new ResourceLocation(Reference.MOD_ID, "enderheart"), (new OrganCurativeInfusionRecipe.Builder())
            .withOrganTarget(OrganCurativeInfusionRecipe.Organ.HEART)
            .withAspects((new AspectList()).add(IsorropiaAPI.FLESH, 16).add(Aspect.MOTION, 16).add(Aspect.ELDRITCH, 16))
            .withComponents(Ingredient.fromItem(Items.EGG),
                    Ingredient.fromItem(Items.EGG),
                    Ingredient.fromItem(Items.ENDER_PEARL))
            .withFakeIngredients(Ingredient.fromStacks(ItemCat.createCat(ItemCat.EnumCat.PIG, "Creature")), ItemCat.createCat(ItemCat.EnumCat.ENDERHEART, "Ender Heart"))
            .build());
    IsorropiaAPI.registerCreatureInfusionRecipe(new ResourceLocation(Reference.MOD_ID, "shockskin"), (new OrganCurativeInfusionRecipe.Builder())
            .withOrganTarget(OrganCurativeInfusionRecipe.Organ.SKIN)
            .withAspects((new AspectList()).add(Aspect.ENERGY, 16).add(Aspect.AVERSION, 11).add(Aspect.AIR, 4))
            .withComponents(Ingredient.fromItem(Items.QUARTZ),
                    Ingredient.fromItem(Items.REDSTONE),
                    Ingredient.fromItem(Items.QUARTZ),
                    Ingredient.fromStacks(ThaumcraftApiHelper.makeCrystal(Aspect.AIR)))
            .withFakeIngredients(Ingredient.fromStacks(ItemCat.createCat(ItemCat.EnumCat.PIG, "Creature")), ItemCat.createCat(ItemCat.EnumCat.SHOCK, "Shock Skin"))
            .build());
    IsorropiaAPI.registerCreatureInfusionRecipe(new ResourceLocation(Reference.MOD_ID, "awakened_blood"), (new OrganCurativeInfusionRecipe.Builder())
            .withOrganTarget(OrganCurativeInfusionRecipe.Organ.BLOOD)
            .withAspects((new AspectList()).add(Aspect.LIFE, 32).add(Aspect.MIND, 32))
            .withComponents(Ingredient.fromItem(Items.SPECKLED_MELON),
                    Ingredient.fromItem(Items.SPECKLED_MELON),
                    Ingredient.fromStacks(new ItemStack(Items.GOLDEN_APPLE)),
                    Ingredient.fromItem(Item.getItemFromBlock(BlocksTC.logSilverwood)))
            .withFakeIngredients(Ingredient.fromStacks(new ItemStack[] { ItemCat.createCat(ItemCat.EnumCat.PIG, "Creature") }), ItemCat.createCat(ItemCat.EnumCat.AWAKENED_BLOOD, "Awakened Blood"))
            .build());
    IsorropiaAPI.registerCreatureInfusionRecipe(new ResourceLocation(Reference.MOD_ID, "diamond_skin"), (new OrganCurativeInfusionRecipe.Builder())

            .withOrganTarget(OrganCurativeInfusionRecipe.Organ.SKIN)
            .withModifier("generic.armor", new AttributeModifier(UUID.fromString("6bc2ebe8-2b1c-11eb-adc1-0242ac120002"), "DIAMOND_SKIN", 20.0D, 0))
            .withModifier("generic.armorToughness", new AttributeModifier(UUID.fromString("21afc412-2b1d-11eb-adc1-0242ac120002"), "DIAMOND_SKIN_TOUGHNESS", 8.0D, 0))
            .withAspects((new AspectList()).add(Aspect.BEAST, 8).add(Aspect.PROTECT, 16).add(Aspect.CRYSTAL, 16))
            .withComponents(Ingredient.fromItem(Items.DIAMOND),
                    Ingredient.fromItem(Items.DIAMOND),
                    Ingredient.fromItem(Items.LEATHER))
            .withFakeIngredients(Ingredient.fromStacks(new ItemStack[] { ItemCat.createCat(ItemCat.EnumCat.PIG, "Creature") }), ItemCat.createCat(ItemCat.EnumCat.DIAMOND_SKIN, "Diamond Skin"))
            .build());
    IsorropiaAPI.registerCreatureInfusionRecipe(new ResourceLocation(Reference.MOD_ID, "mooshroom"), (((((SpecieCurativeInfusionRecipe.Builder)(((new SpecieCurativeInfusionRecipe.Builder())

            .withAspects((new AspectList()).add(Aspect.BEAST, 4).add(Aspect.PLANT, 8)))
            .withComponents(Ingredient.fromStacks(new ItemStack(Blocks.BROWN_MUSHROOM)), Ingredient.fromStacks(new ItemStack(Blocks.RED_MUSHROOM)), Ingredient.fromStacks(new ItemStack(Blocks.BROWN_MUSHROOM)), Ingredient.fromStacks(new ItemStack(Blocks.RED_MUSHROOM)))).withInstability(2)).withResult(EntityMooshroom.class)
            .withKnowledgeRequirement("MONSTEREXCHANGE"))
            .withPredicate(entity -> (entity.getClass() == EntityCow.class)))
            .withFakeIngredients(
                    Ingredient.fromStacks(new ItemStack[] { ItemCat.createCat(ItemCat.EnumCat.COW, "cow") }), ItemCat.createCat(ItemCat.EnumCat.COW, "Mooshroom")))
            .build());
    IsorropiaAPI.registerCreatureInfusionRecipe(new ResourceLocation(Reference.MOD_ID, "turkey"), (((((SpecieCurativeInfusionRecipe.Builder)(((new SpecieCurativeInfusionRecipe.Builder())

            .withAspects((new AspectList()).add(IsorropiaAPI.HUNGER, 4).add(Aspect.PLANT, 4)))
            .withComponents(Ingredient.fromStacks(new ItemStack(Items.WHEAT_SEEDS)), Ingredient.fromStacks(new ItemStack(Items.WHEAT_SEEDS)))).withInstability(2)).withResult(EntityTurkey.class)
            .withKnowledgeRequirement("MONSTEREXCHANGE"))
            .withPredicate(entity -> (entity.getClass() == EntityChicken.class)))
            .withFakeIngredients(
                    Ingredient.fromStacks(new ItemStack[] { ItemCat.createCat(ItemCat.EnumCat.CHICKEN, "chicken") }), ItemCat.createCat(ItemCat.EnumCat.CHICKEN, "turkey")))
            .build());
    IsorropiaAPI.registerCreatureInfusionRecipe(new ResourceLocation(Reference.MOD_ID, "chocow"), (((((SpecieCurativeInfusionRecipe.Builder)(((new SpecieCurativeInfusionRecipe.Builder())

            .withAspects((new AspectList()).add(IsorropiaAPI.FLESH, 4).add(Aspect.EXCHANGE, 2)))
            .withComponents(Ingredient.fromStacks(new ItemStack(Items.DYE, 1, 3)), Ingredient.fromStacks(new ItemStack(Items.SUGAR)), Ingredient.fromStacks(new ItemStack(Items.DYE, 1, 3)), Ingredient.fromStacks(new ItemStack(Items.SUGAR)))).withInstability(2)).withResult(EntityTurkey.class)
            .withKnowledgeRequirement("CHOCOCOW"))
            .withPredicate(entity -> (entity.getClass() == EntityChicken.class)))
            .withFakeIngredients(
                    Ingredient.fromStacks(new ItemStack[] { ItemCat.createCat(ItemCat.EnumCat.COW, "cow") }), ItemCat.createCat(ItemCat.EnumCat.COW, "chocolate cow")))
            .build());
    IsorropiaAPI.registerCreatureInfusionRecipe(new ResourceLocation(Reference.MOD_ID, "goldchicken"), (((((SpecieCurativeInfusionRecipe.Builder)(((new SpecieCurativeInfusionRecipe.Builder())

            .withAspects((new AspectList()).add(Aspect.CRAFT, 16).add(Aspect.DESIRE, 8).add(Aspect.METAL, 8)))
            .withComponents(Ingredient.fromStacks(new ItemStack(Items.GOLDEN_APPLE)), Ingredient.fromStacks(new ItemStack(BlocksTC.crucible)), Ingredient.fromStacks(new ItemStack(Items.GOLDEN_APPLE)), Ingredient.fromStacks(new ItemStack(BlocksTC.metalAlchemical)))).withInstability(2)).withResult(EntityTurkey.class)
            .withKnowledgeRequirement("GOLDCHICKEN"))
            .withPredicate(entity -> (entity.getClass() == EntityChicken.class)))
            .withFakeIngredients(
                    Ingredient.fromStacks(new ItemStack[] { ItemCat.createCat(ItemCat.EnumCat.CHICKEN, "chicken") }), ItemCat.createCat(ItemCat.EnumCat.CHICKEN, "goldchicken")))
            .build());
    IsorropiaAPI.registerCreatureInfusionRecipe(new ResourceLocation(Reference.MOD_ID, "keletucraft"), (((((SpecieCurativeInfusionRecipe.Builder)(((new SpecieCurativeInfusionRecipe.Builder())

            .withAspects((new AspectList()).add(RegistryHandler.RENAISSANCE, 233).add(KnowledgeTAR.CAELES, 233).add(IsorropiaAPI.PRIDE, 50)))
            .withComponents(Ingredient.fromStacks(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("ichoriumkit", "ichor_block")))), Ingredient.fromStacks(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("thaumicbases", "blockthauminite")))), Ingredient.fromStacks(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("thaumicperiphery","malignant_heart")))), Ingredient.fromStacks(new ItemStack(BlocksTC.metalAlchemicalAdvanced)), Ingredient.fromStacks(new ItemStack(BlocksTAR.MITHMINITE_BLOCK)), Ingredient.fromStacks(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("isorropia","somatic_brain")))), Ingredient.fromStacks(new ItemStack(TAItems.MATERIAL, 1, 5)), Ingredient.fromStacks(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("ea","upgrade_refining")))), Ingredient.fromStacks(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("thaumicwonders","coalescence_matrix_precursor")))), Ingredient.fromStacks(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("forbiddenmagicre","taint_charcoal")))), Ingredient.fromStacks(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("tg","block_light")))),  Ingredient.fromStacks(new ItemStack(ModBlocks.storage, 1, 1)))).withInstability(2)).withResult(EntityKeletu.class))
            .withPredicate(entity -> (entity.getClass() == EntityScholarChicken.class)))
            .withFakeIngredients(
                    Ingredient.fromStacks(new ItemStack[] { ItemCat.createCat(ItemCat.EnumCat.CHICKEN, "scholar chicken") }), ItemCat.createCat(ItemCat.EnumCat.RABBIT, "keletu")))
            .build());
}
}
