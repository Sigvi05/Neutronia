package net.hdt.neutronia.commands;

import com.google.common.collect.Lists;
import net.hdt.neutronia.util.Reference;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public class CommandFindBiome extends CommandBase {

    private final List<String> aliases = Lists.newArrayList(Reference.MOD_ID, "f", "fn", "findbio", "findbiome", "find");

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

        if (args.length < 2) {
            throw new WrongUsageException("findbiome <dimension> <name>");
        } else {
            String dimensionID = args[0];
            String biomeName = args[1];
            final SearchResult result = BiomeUtils.searchForBiome(server.getWorld(dimensionID.length()), Biome.REGISTRY.getObject(new ResourceLocation(biomeName)), sender.getPosition());
            if (result.found()) {
                sender.sendMessage(TextComponentUtils.processComponent(sender, new TextComponentString(String.format("We found a biome at X: %d Z: %d with the name %s", result.getX(), result.getZ(), biomeName)), (EntityPlayer) sender));
            } else {
                sender.sendMessage(new TextComponentString(String.format("We did not find any biomes with the name %s", biomeName)));
            }
        }

    }

    @Override
    public String getName() {
        return "findbiome";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "findbiome <dimension> <name>";
    }

    @Override
    public List<String> getAliases() {
        return aliases;
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    /**
     * Get a list of options for when the user presses the TAB key
     */
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        return args.length == 2 ? getListOfStringsMatchingLastWord(args, ForgeRegistries.BIOMES.getEntries().iterator().next().getValue().getBiomeName()) : Collections.emptyList();
    }

}