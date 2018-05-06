// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BlockArray.java

package net.hdt.neutronia.world;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import javax.vecmath.Vector3d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BlockArray
        implements Serializable {
    private static final long serialVersionUID = 0xcc0860L;
    public transient List blocks;
    public List blocksSnaps;
    public transient BlockPos CenterOffset;
    public Vector3d CntOff;
    public boolean allowSlopes;
    public boolean isSlope;
    public Vector3d ObjSize;
    public boolean allowHex;
    public boolean allowRect;
    public boolean isFloorObject;
    public boolean isWallObject;
    public boolean isCeilingObject;
    public boolean cantTouchWall;
    public Vector3d FloorDist;
    public Vector3d CeilingDist;
    public transient World wrld;

    public BlockArray() {
        CenterOffset = new BlockPos(0, 0, 0);
        CntOff = new Vector3d(0.0D, 0.0D, 0.0D);
        allowSlopes = true;
        isSlope = false;
        ObjSize = new Vector3d(0.0D, 0.0D, 0.0D);
        allowHex = true;
        allowRect = true;
        isFloorObject = true;
        isWallObject = false;
        isCeilingObject = false;
        cantTouchWall = false;
        FloorDist = new Vector3d(-1D, -1D, -1D);
        CeilingDist = new Vector3d(-1D, -1D, -1D);
        wrld = null;
        blocks = new ArrayList();
        blocks.add(new ArrayList());
        ((List) blocks.get(0)).add(new ArrayList());
        blocksSnaps = new ArrayList();
        blocksSnaps.add(new ArrayList());
        ((List) blocksSnaps.get(0)).add(new ArrayList());
    }

    public BlockArray(BlockArray BA) {
        CenterOffset = new BlockPos(0, 0, 0);
        CntOff = new Vector3d(0.0D, 0.0D, 0.0D);
        allowSlopes = true;
        isSlope = false;
        ObjSize = new Vector3d(0.0D, 0.0D, 0.0D);
        allowHex = true;
        allowRect = true;
        isFloorObject = true;
        isWallObject = false;
        isCeilingObject = false;
        cantTouchWall = false;
        FloorDist = new Vector3d(-1D, -1D, -1D);
        CeilingDist = new Vector3d(-1D, -1D, -1D);
        wrld = null;
        blocks = new ArrayList();
        blocks.add(new ArrayList());
        ((List) blocks.get(0)).add(new ArrayList());
        blocksSnaps = new ArrayList();
        blocksSnaps.add(new ArrayList());
        ((List) blocksSnaps.get(0)).add(new ArrayList());
        CenterOffset = new BlockPos(BA.CenterOffset);
        CntOff = new Vector3d(BA.CntOff);
        allowSlopes = BA.allowSlopes;
        isSlope = BA.isSlope;
        ObjSize = new Vector3d(BA.ObjSize);
        allowHex = BA.allowHex;
        allowRect = BA.allowRect;
        isFloorObject = BA.isFloorObject;
        isWallObject = BA.isWallObject;
        isCeilingObject = BA.isCeilingObject;
        cantTouchWall = BA.cantTouchWall;
        FloorDist = new Vector3d(BA.FloorDist);
        CeilingDist = new Vector3d(BA.CeilingDist);
        wrld = BA.wrld;
    }

    public void init() {
        blocks = new ArrayList();
        blocks.add(new ArrayList());
        ((List) blocks.get(0)).add(new ArrayList());
        CenterOffset = new BlockPos(0, 0, 0);
    }

    public IBlockState getBlock(int x, int y, int z) {
        List lstY = blocks;
        if (lstY.size() >= y + 1) {
            List lstX = (List) lstY.get(y);
            if (lstX.size() >= x + 1) {
                List lstZ = (List) lstX.get(x);
                if (lstZ.size() >= z + 1)
                    return (IBlockState) lstZ.get(z);
            }
        }
        return null;
    }

    public void setBlock(int x, int y, int z, IBlockState block) {
        List lstY;
        for (lstY = blocks; lstY.size() < y + 1; lstY.add(new ArrayList())) ;
        List lstX;
        for (lstX = (List) lstY.get(y); lstX.size() < x + 1; lstX.add(new ArrayList())) ;
        List lstZ;
        for (lstZ = (List) lstX.get(x); lstZ.size() < z + 1; lstZ.add(null)) ;
        lstZ.set(z, block);
    }

    public void clear() {
        List lstY = blocks;
        for (int i = 0; i < lstY.size(); i++) {
            List lstX = (List) lstY.get(i);
            for (int j = 0; j < lstX.size(); j++) {
                List lstZ = (List) lstX.get(j);
                lstZ.clear();
            }

            lstX.clear();
        }

        lstY.clear();
    }

    public Vector3d GetBounds() {
        int maxX = 0;
        int maxY = 0;
        int maxZ = 0;
        List lstY = blocks;
        maxY = lstY.size();
        for (int i = 0; i < lstY.size(); i++) {
            List lstX = (List) lstY.get(i);
            if (lstX.size() > maxX)
                maxX = lstX.size();
            for (int j = 0; j < lstX.size(); j++) {
                List lstZ = (List) lstX.get(j);
                if (lstZ.size() > maxZ)
                    maxZ = lstZ.size();
            }

        }

        return new Vector3d(maxX, maxY, maxZ);
    }

    public BlockArray Rotate(int deg) {
        Vector3d Bounds = GetBounds();
        BlockArray newBar = new BlockArray(this);
        switch (deg) {
            case 90: // 'Z'
                newBar.CenterOffset = new BlockPos(Bounds.z - (double) CenterOffset.getZ() - 1.0D, CenterOffset.getY(), CenterOffset.getX());
                break;

            case 180:
                newBar.CenterOffset = new BlockPos(Bounds.x - (double) CenterOffset.getX() - 1.0D, CenterOffset.getY(), Bounds.z - (double) CenterOffset.getZ() - 1.0D);
                break;

            case 270:
                newBar.CenterOffset = new BlockPos(CenterOffset.getZ(), CenterOffset.getY(), Bounds.x - (double) CenterOffset.getX() - 1.0D);
                break;
        }
        newBar.CntOff = new Vector3d(newBar.CenterOffset.getX(), newBar.CenterOffset.getY(), newBar.CenterOffset.getZ());
        List lstY = blocks;
        for (int i = 0; i < lstY.size(); i++) {
            List lstX = (List) lstY.get(i);
            for (int j = 0; j < lstX.size(); j++) {
                List lstZ = (List) lstX.get(j);
                for (int k = 0; k < lstZ.size(); k++) {
                    IBlockState IBS = (IBlockState) lstZ.get(k);
                    if (IBS != null) {
                        PropertyEnum FACING = null;
                        try {
                            EnumFacing ef = null;
                            Collection col = IBS.getPropertyKeys();
                            Iterator it = col.iterator();
                            do {
                                if (!it.hasNext())
                                    break;
                                IProperty prop = (IProperty) it.next();
                                if (prop.toString().contains("PropertyDirection")) {
                                    FACING = (PropertyEnum) prop;
                                    ef = (EnumFacing) IBS.getValue(FACING);
                                    if (ef.getAxis() != net.minecraft.util.EnumFacing.Axis.Y) {
                                        int rot = 0;
                                        while (rot < deg / 90) {
                                            ef = ef.rotateY();
                                            IBS = IBS.withProperty(FACING, ef);
                                            rot++;
                                        }
                                    }
                                }
                            } while (true);
                        } catch (IllegalArgumentException illegalargumentexception) {
                        }
                    }
                    switch (deg) {
                        case 90: // 'Z'
                            newBar.setBlock((int) Bounds.z - (k + 1), i, j, IBS);
                            break;

                        case 180:
                            newBar.setBlock((int) Bounds.x - (j + 1), i, (int) Bounds.z - (k + 1), IBS);
                            break;

                        case 270:
                            newBar.setBlock(k, i, (int) Bounds.x - (j + 1), IBS);
                            break;

                        default:
                            newBar.setBlock(j, i, k, IBS);
                            break;
                    }
                }

            }

        }

        return newBar;
    }

    public BlockArray Mirror() {
        Vector3d Bounds = GetBounds();
        BlockArray newBar = new BlockArray(this);
        newBar.CntOff = new Vector3d(newBar.CenterOffset.getX(), newBar.CenterOffset.getY(), newBar.CenterOffset.getZ());
        List lstY = blocks;
        for (int i = 0; i < lstY.size(); i++) {
            List lstX = (List) lstY.get(i);
            for (int j = 0; j < lstX.size(); j++) {
                List lstZ = (List) lstX.get(j);
                for (int k = 0; k < lstZ.size(); k++) {
                    IBlockState IBS = (IBlockState) lstZ.get(k);
                    if (IBS == null)
                        continue;
                    PropertyEnum FACING = null;
                    try {
                        EnumFacing ef = null;
                        Collection col = IBS.getPropertyKeys();
                        Iterator it = col.iterator();
                        do {
                            if (!it.hasNext())
                                break;
                            IProperty prop = (IProperty) it.next();
                            if (prop.toString().contains("PropertyDirection")) {
                                FACING = (PropertyEnum) prop;
                                ef = (EnumFacing) IBS.getValue(FACING);
                                if (ef.getAxis() == net.minecraft.util.EnumFacing.Axis.X) {
                                    int rot = 0;
                                    while (rot < 2) {
                                        ef = ef.rotateY();
                                        IBS = IBS.withProperty(FACING, ef);
                                        rot++;
                                    }
                                }
                            }
                        } while (true);
                    } catch (IllegalArgumentException illegalargumentexception) {
                    }
                    newBar.setBlock((int) Bounds.x - (j + 1), i, k, IBS);
                }

            }

        }

        return newBar;
    }

    public void PrepareSave() {
        CntOff = new Vector3d(CenterOffset.getX(), CenterOffset.getY(), CenterOffset.getZ());
        clearSnaps();
        if (wrld != null) {
            List lstY = blocks;
            for (int i = 0; i < lstY.size(); i++) {
                List lstX = (List) lstY.get(i);
                for (int j = 0; j < lstX.size(); j++) {
                    List lstZ = (List) lstX.get(j);
                    for (int k = 0; k < lstZ.size(); k++)
                        if (lstZ.get(k) != null) {
                            ZedBlockSnapshot bs = new ZedBlockSnapshot((IBlockState) lstZ.get(k));
                            setBlockSnap(j, i, k, bs);
                        } else {
                            setBlockSnap(j, i, k, null);
                        }

                }

            }

        }
    }

    public void LoadFromSave() {
        if (blocks == null)
            init();
        clear();
        CenterOffset = ZedUtil.newBlPos(CntOff);
        List lstY = blocksSnaps;
        for (int i = 0; i < lstY.size(); i++) {
            List lstX = (List) lstY.get(i);
            for (int j = 0; j < lstX.size(); j++) {
                List lstZ = (List) lstX.get(j);
                for (int k = 0; k < lstZ.size(); k++)
                    if (lstZ.get(k) != null) {
                        IBlockState bs = ((ZedBlockSnapshot) lstZ.get(k)).getReplacedBlock();
                        setBlock(j, i, k, bs);
                    } else {
                        setBlockSnap(j, i, k, null);
                    }

            }

        }

    }

    public void setBlockSnap(int x, int y, int z, ZedBlockSnapshot block) {
        List lstY;
        for (lstY = blocksSnaps; lstY.size() < y + 1; lstY.add(new ArrayList())) ;
        List lstX;
        for (lstX = (List) lstY.get(y); lstX.size() < x + 1; lstX.add(new ArrayList())) ;
        List lstZ;
        for (lstZ = (List) lstX.get(x); lstZ.size() < z + 1; lstZ.add(null)) ;
        lstZ.set(z, block);
    }

    public void clearSnaps() {
        List lstY = blocksSnaps;
        for (int i = 0; i < lstY.size(); i++) {
            List lstX = (List) lstY.get(i);
            for (int j = 0; j < lstX.size(); j++) {
                List lstZ = (List) lstX.get(j);
                lstZ.clear();
            }

            lstX.clear();
        }

        lstY.clear();
    }

    public class ZedBlockSnapshot
            implements Serializable {

        final BlockArray this$0;
        private transient IBlockState replacedBlock;
        private transient ResourceLocation registryName;
        private String domain;
        private String path;
        private int meta;

        public ZedBlockSnapshot(IBlockState state) {
            super();
            this.this$0 = BlockArray.this;
            registryName = state.getBlock().getRegistryName();
            domain = registryName.getResourceDomain();
            path = registryName.getResourcePath();
            meta = state.getBlock().getMetaFromState(state);
        }

        public IBlockState getReplacedBlock() {
            if (replacedBlock == null)
                replacedBlock = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(domain, path)).getStateFromMeta(meta);
            return replacedBlock;
        }
    }
}
