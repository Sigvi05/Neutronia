package net.hdt.neutronia.base.util;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;

import java.util.List;
import java.util.Objects;

public class Utilities {

    public static String stringToRainbow(String parString, boolean parReturnToBlack) {
        int stringLength = parString.length();
        if (stringLength < 1) {
            return "";
        }
        String outputString = "";
        TextFormatting[] colorChar = {
                TextFormatting.RED,
                TextFormatting.GOLD,
                TextFormatting.YELLOW,
                TextFormatting.GREEN,
                TextFormatting.AQUA,
                TextFormatting.BLUE,
                TextFormatting.LIGHT_PURPLE,
                TextFormatting.DARK_PURPLE
        };
        for (int i = 0; i < stringLength; i++) {
            outputString = outputString + colorChar[i % 8] + parString.substring(i, i + 1);
        }
        if (parReturnToBlack) {
            return outputString + TextFormatting.BLACK;
        }
        return outputString + TextFormatting.WHITE;
    }

    public static String stringToRainbow(String parString) {
        return stringToRainbow(parString, false);
    }

    public static String stringToGolden(String parString, int parShineLocation, boolean parReturnToBlack) {
        int stringLength = parString.length();
        if (stringLength < 1) {
            return "";
        }
        String outputString = "";
        for (int i = 0; i < stringLength; i++) {
            if ((i + parShineLocation + Minecraft.getSystemTime() / 20) % 88 == 0) {
                outputString = outputString + TextFormatting.WHITE + parString.substring(i, i + 1);
            } else if ((i + parShineLocation + Minecraft.getSystemTime() / 20) % 88 == 1) {
                outputString = outputString + TextFormatting.YELLOW + parString.substring(i, i + 1);
            } else if ((i + parShineLocation + Minecraft.getSystemTime() / 20) % 88 == 87) {
                outputString = outputString + TextFormatting.YELLOW + parString.substring(i, i + 1);
            } else {
                outputString = outputString + TextFormatting.GOLD + parString.substring(i, i + 1);
            }
        }
        if (parReturnToBlack) {
            return outputString + TextFormatting.BLACK;
        }
        return outputString + TextFormatting.WHITE;
    }

    public static String stringToGolden(String parString, int parShineLocation) {
        return stringToGolden(parString, parShineLocation, false);
    }

    public static String toPigLatin(String s) {
        StringBuilder latin = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            while (i < s.length() && !isLetter(s.charAt(i))) {
                latin.append(s.charAt(i));
                i++;
            }
            if (i >= s.length())
                break;
            int begin = i;
            while (i < s.length() && isLetter(s.charAt(i))) {
                i++;
            }
            int end = i;
            latin.append(pigWord(s.substring(begin, end)));
        }
        return latin.toString();
    }

    private static boolean isLetter(char c) {
        return ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
    }

    private static String pigWord(String word) {
        int split = firstVowel(word);
        return word.substring(split) + "-" + word.substring(0, split) + "ay";
    }

    private static int firstVowel(String word) {
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'a' || word.charAt(i) == 'e' ||
                    word.charAt(i) == 'i' || word.charAt(i) == 'o' ||
                    word.charAt(i) == 'u') {
                return i;
            }
        }
        return 0;
    }

    /*
     * World utilities
     */

    public static double getHeightValue(World parWorld, double parX, double parZ) {
        int intX = MathHelper.floor(parX);
        int intZ = MathHelper.floor(parZ);

        int chunkX = intX >> 4;
        int chunkZ = intZ >> 4;
        double height = parWorld.getChunk(chunkX, chunkZ)
                .getHeightValue(intX & 15, intZ & 15);

        return height;
    }

    public static RayTraceResult getMouseOverExtended(float dist) {
        Minecraft mc = FMLClientHandler.instance().getClient();
        Entity theRenderViewEntity = mc.getRenderViewEntity();
        AxisAlignedBB theViewBoundingBox = new AxisAlignedBB(
                Objects.requireNonNull(theRenderViewEntity).posX - 0.5D,
                theRenderViewEntity.posY - 0.0D,
                theRenderViewEntity.posZ - 0.5D,
                theRenderViewEntity.posX + 0.5D,
                theRenderViewEntity.posY + 1.5D,
                theRenderViewEntity.posZ + 0.5D);
        RayTraceResult returnMOP = null;
        if (mc.world != null) {
            double var2 = dist;
            returnMOP = theRenderViewEntity.rayTrace(var2, 0);
            double calcdist = var2;
            Vec3d pos = theRenderViewEntity.getPositionEyes(0);
            var2 = calcdist;
            if (returnMOP != null) {
                calcdist = returnMOP.hitVec.distanceTo(pos);
            }

            Vec3d lookvec = theRenderViewEntity.getLook(0);
            Vec3d var8 = pos.add(lookvec.x * var2, lookvec.y * var2, lookvec.z * var2);
            Entity pointedEntity = null;
            float var9 = 1.0F;
            List<Entity> list = mc.world.getEntitiesWithinAABBExcludingEntity(theRenderViewEntity,
                    theViewBoundingBox.grow(lookvec.x * var2, lookvec.y * var2, lookvec.z * var2).expand(var9, var9, var9));
            double d = calcdist;

            for (Entity entity : list) {
                if (entity.canBeCollidedWith()) {
                    float bordersize = entity.getCollisionBorderSize();
                    AxisAlignedBB aabb = new AxisAlignedBB(entity.posX - entity.width / 2, entity.posY, entity.posZ - entity.width / 2,
                            entity.posX + entity.width / 2, entity.posY + entity.height, entity.posZ + entity.width / 2);
                    aabb.expand(bordersize, bordersize, bordersize);
                    RayTraceResult mop0 = aabb.calculateIntercept(pos, var8);

                    if (aabb.contains(pos)) {
                        if (0.0D < d || d == 0.0D) {
                            pointedEntity = entity;
                            d = 0.0D;
                        }
                    } else if (mop0 != null) {
                        double d1 = pos.distanceTo(mop0.hitVec);

                        if (d1 < d || d == 0.0D) {
                            pointedEntity = entity;
                            d = d1;
                        }
                    }
                }
            }

            if (pointedEntity != null && (d < calcdist || returnMOP == null)) {
                returnMOP = new RayTraceResult(pointedEntity);
            }

        }
        return returnMOP;
    }
}