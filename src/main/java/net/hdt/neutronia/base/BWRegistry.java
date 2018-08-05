package net.hdt.neutronia.base;

import net.hdt.neutronia.base.groups.Component;
import net.hdt.neutronia.base.groups.GroupLoader;
import net.hdt.neutronia.base.util.InvUtils;
import net.hdt.neutronia.blocks.other.BlockBDispenser;
import net.hdt.neutronia.groups.tweaks.features.HCTools;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.Potion;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.hdt.neutronia.base.lib.LibMisc.MOD_ID;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = MOD_ID)
public class BWRegistry {

    public static final PenaltyHandlerRegistry PENALTY_HANDLERS = new PenaltyHandlerRegistry();

    public static final CookingPotManager CAULDRON = new CookingPotManager();
    public static final CookingPotManager CRUCIBLE = new CookingPotManager();
    public static final MillManager MILLSTONE = new MillManager();
    public static final SawManagerBlock WOOD_SAW = new SawManagerBlock();
    public static final KilnManagerBlock KILN = new KilnManagerBlock();
    public static final TurntableManagerBlock TURNTABLE = new TurntableManagerBlock();
    public static final HopperFilters HOPPER_FILTERS = new HopperFilters();

    @GameRegistry.ObjectHolder("betterwithmods:true_sight")
    public static final Potion POTION_TRUESIGHT = null;
    @GameRegistry.ObjectHolder("betterwithmods:fortune")
    public static final Potion POTION_FORTUNE = null;
    @GameRegistry.ObjectHolder("betterwithmods:looting")
    public static final Potion POTION_LOOTING = null;
    @GameRegistry.ObjectHolder("betterwithmods:slow_fall")
    public static final Potion POTION_SLOWFALL = null;

    private static int availableEntityId = 0;

    static {
        BWMAPI.IMPLEMENTATION = new MechanicalUtil();
    }

    public static void preInit() {
        API.manualAPI = ManualDefinitionImpl.INSTANCE;
        BWAdvancements.registerAdvancements();
        BWNetwork.registerNetworking();
        BWMBlocks.registerBlocks();
        BWMItems.registerItems();
        BWMBlocks.registerTileEntities();
        BWRegistry.registerEntities();
        BWRegistry.registerBlockDispenserBehavior();
        CapabilityManager.INSTANCE.register(IMechanicalPower.class, new CapabilityMechanicalPower.Impl(), CapabilityMechanicalPower.Default::new);
        CapabilityManager.INSTANCE.register(IAxle.class, new CapabilityAxle.Impl(), CapabilityAxle.Default::new);
        KilnStructureManager.registerKilnBlock(Blocks.BRICK_BLOCK.getDefaultState());
        KilnStructureManager.registerKilnBlock(Blocks.NETHER_BRICK.getDefaultState());
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        BWMBlocks.getBlocks().forEach(event.getRegistry()::register);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        BWMItems.getItems().forEach(event.getRegistry()::register);
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        ForgeRegistry<IRecipe> reg = (ForgeRegistry<IRecipe>) event.getRegistry();

        for(IRecipe recipe: BWMRecipes.getRecipes()) {
            event.getRegistry().register(recipe);
        }

        for (IRecipe recipe : reg) {
            for(Pattern pattern: BWMRecipes.REMOVE_BY_REGEX) {
                Matcher matcher = pattern.matcher(recipe.getRegistryName().toString());
                if(matcher.matches()) {
                    reg.remove(recipe.getRegistryName());
                }
            }
            for (ResourceLocation loc : BWMRecipes.REMOVE_RECIPE_BY_RL) {
                if (loc.equals(recipe.getRegistryName()))
                    reg.remove(recipe.getRegistryName());
            }
            for (ItemStack output : BWMRecipes.REMOVE_RECIPE_BY_OUTPUT) {
                if (InvUtils.matches(recipe.getRecipeOutput(), output)) {
                    reg.remove(recipe.getRegistryName());
                }
            }
            for (List<Ingredient> inputs : BWMRecipes.REMOVE_RECIPE_BY_INPUT) {
                if (InvUtils.containsIngredient(recipe.getIngredients(), inputs)) {
                    reg.remove(recipe.getRegistryName());
                }
            }
        }
    }

    public static void init() {
        BWRegistry.registerHeatSources();
        BWOreDictionary.registerOres();
    }

    public static void postInit() {
        BWOreDictionary.postInitOreDictGathering();
        BellowsManager.postInit();
    }

    public static void postPostInit() {
        registerRecipes();
    }

    /**
     * All names should be snake_case by convention (enforced in 1.11).
     */
    private static void registerEntities() {
        BWRegistry.registerEntity(EntityExtendingRope.class, "extending_rope", 64, 20, true);
        BWRegistry.registerEntity(EntityDynamite.class, "bwm_dynamite", 10, 50, true);
        BWRegistry.registerEntity(EntityUrn.class, "bwm_urn", 10, 50, true);
        BWRegistry.registerEntity(EntityMiningCharge.class, "bwm_mining_charge", 10, 50, true);
        BWRegistry.registerEntity(EntityShearedCreeper.class, "entity_sheared_creeper", 64, 1, true);
        BWRegistry.registerEntity(EntityBroadheadArrow.class, "entity_broadhead_arrow", 64, 1, true);
        BWRegistry.registerEntity(EntityFallingGourd.class, "entity_falling_gourd", 64, 1, true);
        BWRegistry.registerEntity(EntityFallingBlockCustom.class, "falling_block_custom", 64, 20, true);
        BWRegistry.registerEntity(EntitySpiderWeb.class, "bwm_spider_web", 64, 20, true);
        BWRegistry.registerEntity(EntityHCFishHook.class, "bwm_fishing_hook", 64, 20, true);
        BWRegistry.registerEntity(EntityTentacle.class, "bwm_tentacle", 64, 1, true);

        BWRegistry.registerEntity(EntityJungleSpider.class, "bwm_jungle_spider", 64, 1, true, 0x3C6432, 0x648C50 );
    }

    public static void registerBlockDispenserBehavior() {
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(BWMItems.DYNAMITE, new DispenserBehaviorDynamite());
        BlockBDispenser.BLOCK_DISPENSER_REGISTRY.putObject(BWMItems.DYNAMITE, new DispenserBehaviorDynamite());
        BlockBDispenser.BLOCK_DISPENSER_REGISTRY.putObject(Items.REPEATER, new BehaviorDiodeDispense());
        BlockBDispenser.BLOCK_DISPENSER_REGISTRY.putObject(Items.COMPARATOR, new BehaviorDiodeDispense());
        BlockBDispenser.BLOCK_DISPENSER_REGISTRY.putObject(Item.getItemFromBlock(BWMBlocks.MINING_CHARGE),
                (source, stack) -> {
                    World worldIn = source.getWorld();
                    EnumFacing facing = source.getBlockState().getValue(BlockDispenser.FACING);
                    BlockPos pos = source.getBlockPos().offset(facing);
                    EntityMiningCharge miningCharge = new EntityMiningCharge(worldIn, pos.getX() + 0.5F, pos.getY(),
                            pos.getZ() + 0.5F, null, facing);
                    miningCharge.setNoGravity(false);
                    worldIn.spawnEntity(miningCharge);
                    worldIn.playSound(null, miningCharge.posX, miningCharge.posY, miningCharge.posZ,
                            SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    return stack;
                });
        BlockBDispenser.BLOCK_COLLECT_REGISTRY.putObject(Blocks.STONE, new BehaviorSilkTouch());
        BlockBDispenser.BLOCK_COLLECT_REGISTRY.putObject(Blocks.LOG, new BehaviorSilkTouch());
        BlockBDispenser.BLOCK_COLLECT_REGISTRY.putObject(Blocks.LOG2, new BehaviorSilkTouch());


        BlockBDispenser.ENTITY_COLLECT_REGISTRY.putObject(new ResourceLocation("minecraft:sheep"), (world, pos, entity, stack) -> {
            EntitySheep sheep = (EntitySheep) entity;
            if (sheep.isShearable(new ItemStack(Items.SHEARS), world, pos)) {
                return InvUtils.asNonnullList(sheep.onSheared(new ItemStack(Items.SHEARS), world, pos, 0));
            }
            return NonNullList.create();
        });
        BlockBDispenser.ENTITY_COLLECT_REGISTRY.putObject(new ResourceLocation("minecraft:chicken"), (world, pos, entity, stack) -> {
            if (((EntityAgeable) entity).isChild())
                return NonNullList.create();
            InvUtils.ejectStackWithOffset(world, pos, new ItemStack(Items.FEATHER, 1 + world.rand.nextInt(2)));
            world.playSound(null, pos, SoundEvents.ENTITY_CHICKEN_HURT, SoundCategory.NEUTRAL, 0.75F, 1.0F);
            entity.setDead();
            return InvUtils.asNonnullList(new ItemStack(Items.EGG));
        });
        BlockBDispenser.ENTITY_COLLECT_REGISTRY.putObject(new ResourceLocation("minecraft:cow"), (world, pos, entity, stack) -> {
            if (((EntityAgeable) entity).isChild())
                return NonNullList.create();
            if (stack.isItemEqual(new ItemStack(Items.BUCKET))) {
                stack.shrink(1);
                world.playSound(null, pos, SoundEvents.ENTITY_COW_MILK, SoundCategory.BLOCKS, 1.0F, 1.0F);

                InvUtils.ejectStackWithOffset(world, pos, new ItemStack(Items.MILK_BUCKET));
            }
            return NonNullList.create();
        });
    }

    /**
     * Registers an entity for this mod. Handles automatic available ID
     * assignment.
     */
    public static void registerEntity(Class<? extends Entity> entityClass, String entityName, int trackingRange,
                                      int updateFrequency, boolean sendsVelocityUpdates) {
        EntityRegistry.registerModEntity(new ResourceLocation(MOD_ID, entityName), entityClass, entityName, availableEntityId, Neutronia.instance, trackingRange,
                updateFrequency, sendsVelocityUpdates);
        availableEntityId++;
    }


    public static void registerEntity(Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates, int primaryColor, int secondaryColor) {
        EntityRegistry.registerModEntity(new ResourceLocation(MOD_ID, entityName), entityClass, entityName, availableEntityId, Neutronia.instance, trackingRange,
                updateFrequency, sendsVelocityUpdates, primaryColor, secondaryColor);
        availableEntityId++;
    }

    /*@SubscribeEvent
    public static void registerPotions(RegistryEvent.Register<Potion> event) {
        event.getRegistry().register(registerPotion(new PotionTruesight("true_sight", true, 14270531).setIconIndex(4, 1)));
        event.getRegistry().register(registerPotion(new BWPotion("fortune", true, 14270531).setIconIndex(5, 2)));
        event.getRegistry().register(registerPotion(new BWPotion("looting", true, 14270531).setIconIndex(6, 2)));
        event.getRegistry().register(registerPotion(new PotionSlowfall("slow_fall", true, 0xF46F20).setIconIndex(4, 1)));
    }*/

    private static Potion registerPotion(Potion potion) {
        String potionName = potion.getRegistryName().getPath();
        potion.setPotionName("neutronia.effect." + potionName);
        return potion;
    }

    public static void registerRecipes() {
        ForgeRegistry<IRecipe> reg = (ForgeRegistry<IRecipe>) ForgeRegistries.RECIPES;

        replaceIRecipe(HCTools.class, reg);
    }

    private static void retrieveRecipes(String category, ForgeRegistry<IRecipe> reg) {
        List<IRecipe> recipes = BWMRecipes.getHardcoreRecipes(category);
        if (recipes != null) {
            for (IRecipe recipe : recipes) {
                ResourceLocation location = recipe.getRegistryName();
                if (reg.containsKey(location))
                    registerReplacements(reg.getValue(location), recipe);
                else
                    reg.register(recipe);
            }
        }
    }

    private static void replaceIRecipe(Class<? extends Component> clazz, IForgeRegistry<IRecipe> reg) {
        if (GroupLoader.isFeatureEnabled(clazz)) {
            List<IRecipe> recipes = BWMRecipes.getHardcoreRecipes(clazz.getSimpleName());
            if (recipes != null) {
                recipes.forEach(reg::register);
            }
        }
    }

    private static void registerReplacements(IRecipe original, IRecipe from) {
        NonNullList<Ingredient> ing = original.getIngredients();
        for (int i = 0; i < ing.size(); i++) {
            ing.set(i, from.getIngredients().get(i));
        }
    }
}

