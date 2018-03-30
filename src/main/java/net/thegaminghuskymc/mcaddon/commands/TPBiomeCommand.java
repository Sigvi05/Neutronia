package net.thegaminghuskymc.mcaddon.commands;

import com.google.common.collect.Lists;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.biome.Biome;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

public class TPBiomeCommand extends CommandBase {

    private final List<String> aliases = Lists.newArrayList(MOD_ID, "f", "fn", "findbio", "findbiome", "find");

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

        if (args.length != 1)
        {
            throw new WrongUsageException("findbiome <name>");
        }
        else
        {
            String s = args[0];

            final SearchResult result = BiomeUtils.searchForBiome(server.getWorld(0), Biome.REGISTRY.getObject(new ResourceLocation(s)), sender.getPosition());
            if (result.found()) {
                sender.sendMessage(new TextComponentString(String.format("We found a biome at X: %d Z: %d with the name %s", result.getX(), result.getZ(), s)));
            } else {
                sender.sendMessage(new TextComponentString(String.format("We did not find any biomes with the name %s", s)));
            }

        }

    }

    @Override
    public String getName() {
        return "findbiome";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "findbiome <name>";
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
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos)
    {
        return args.length == 1 ? getListOfStringsMatchingLastWord(args, "forest", "desert", "red_desert", "black_desert", "deep_ocean", "ocean", "swamp", "mesa") : Collections.emptyList();
    }

}