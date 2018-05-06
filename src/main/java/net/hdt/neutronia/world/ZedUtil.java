// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ZedUtil.java

package net.hdt.neutronia.world;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

import javax.vecmath.Vector3d;
import java.io.*;

public final class ZedUtil {

    public ZedUtil() {
    }

    public static Vector3d AddVect(Vector3d v1, Vector3d v2) {
        Vector3d v = new Vector3d(v1);
        v.add(v2);
        return v;
    }

    public static Vector3d BlockPosVector3d(BlockPos bp) {
        return new Vector3d(bp.getX(), bp.getY(), bp.getZ());
    }

    public static Vec3d AddVect(Vec3d v1, Vec3d v2) {
        Vec3d v = new Vec3d(v1.x, v1.y, v1.z);
        return v.add(v2);
    }

    public static Vector3d Vec3dVector3d(Vec3d v1) {
        return new Vector3d(v1.x, v1.y, v1.z);
    }

    public static Vec3d Vector3dVec3d(Vector3d v1) {
        return new Vec3d(v1.x, v1.y, v1.z);
    }

    public static Vector3d SubVect(Vector3d v1, Vector3d v2) {
        Vector3d v = new Vector3d(v1);
        v.sub(v2);
        return v;
    }

    public static Vec3d SubVect(Vec3d v1, Vec3d v2) {
        Vec3d v = new Vec3d(v1.x, v1.y, v1.z);
        return v.subtract(v2);
    }

    public static Vector3d MultVect(Vector3d v1, float mult) {
        Vector3d v = new Vector3d(v1);
        v.scale(mult);
        return v;
    }

    public static Vec3d MultVect(Vec3d v1, float mult) {
        Vec3d v = new Vec3d(v1.x, v1.y, v1.z);
        return v.scale(mult);
    }

    public static BlockPos newBlPos(Vector3d v1) {
        BlockPos nbp = new BlockPos(v1.x, v1.y, v1.z);
        return nbp;
    }

    public static BlockPos newBlPos(Vec3d v1) {
        BlockPos nbp = new BlockPos(v1.x, v1.y, v1.z);
        return nbp;
    }

    public static float VectorDist(Vector3d v1, Vector3d v2) {
        return (float) SubVect(v2, v1).length();
    }

    public static float VectorDistSqr(Vector3d v1, Vector3d v2) {
        return (float) SubVect(v2, v1).lengthSquared();
    }

    public static BlockArray loadFromFile(String path) {
        BlockArray BA;
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            BA = (BlockArray) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Serialized data is loaded");
            BA.LoadFromSave();
            return BA;
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("BlockArrayClass not found");
            c.printStackTrace();
        }
        return null;
    }

    public static boolean saveToFile(String path, String filename, BlockArray BA) {
        BA.PrepareSave();
        try {
            File directory = new File(path);
            if (!directory.exists())
                directory.mkdirs();
            FileOutputStream fileOut = new FileOutputStream((new StringBuilder()).append(path).append("\\").append(filename).toString());
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(BA);
            out.close();
            fileOut.close();
            return true;
        } catch (IOException i) {
            i.printStackTrace();
        }
        return false;
    }

    public static BlockArray loadFromJson(String path) {
        BlockArray BA;
        try {
            FileReader fileIn = new FileReader(path);
            JsonReader jr = new JsonReader(fileIn);
            BA = (new Gson()).fromJson(jr, BlockArray.class);
            jr.close();
            fileIn.close();
            BA.LoadFromSave();
            return BA;
        } catch (IOException i) {
            i.printStackTrace();
        } catch (JsonIOException c) {
            System.out.println("BlockArrayClass not found");
            c.printStackTrace();
        }
        return null;
    }

    public static boolean saveToJson(String path, String filename, BlockArray BA) {
        BA.PrepareSave();
        try {
            Gson gson = (new GsonBuilder()).setPrettyPrinting().create();
            String json = gson.toJson(BA);
            File directory = new File(path);
            if (!directory.exists())
                directory.mkdirs();
            FileWriter fileOut = new FileWriter((new StringBuilder()).append(path).append("\\").append(filename).toString());
            fileOut.write(json, 0, json.length());
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
        return false;
    }
}
