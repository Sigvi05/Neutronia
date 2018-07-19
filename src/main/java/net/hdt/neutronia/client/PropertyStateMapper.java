package net.hdt.neutronia.client;

import com.google.common.collect.Maps;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.LinkedHashMap;

/**
 * Maps a single property to multiple blockstate files in order to make the mapping easier to handle
 */
public class PropertyStateMapper extends StateMapperBase {

	private final PropertyEnum<?> prop;
	private final IProperty<?>[] ignore;

	private ResourceLocation name;

	public PropertyStateMapper(ResourceLocation name, PropertyEnum<?> prop, IProperty<?>... ignore) {
		this.name = name;
		this.prop = prop;
		this.ignore = ignore;
	}

	public PropertyStateMapper(PropertyEnum<?> prop, IProperty<?>... ignore) {
		this(null, prop, ignore);
	}

	@Nonnull
	@Override
	protected ModelResourceLocation getModelResourceLocation(@Nonnull IBlockState state) {
		ResourceLocation baseLoc = name;
		if(baseLoc == null) {
			baseLoc = state.getBlock().getRegistryName();
		}
		LinkedHashMap<IProperty<?>, Comparable<?>> map = Maps.newLinkedHashMap(state.getProperties());
		map.remove(prop);
		for(IProperty<?> ignored : ignore) {
			map.remove(ignored);
		}
		ResourceLocation res = new ResourceLocation(baseLoc.getNamespace(), baseLoc.getPath() + "/" + state.getValue(prop).getName());

		return new ModelResourceLocation(res, this.getPropertyString(map));
	}

}