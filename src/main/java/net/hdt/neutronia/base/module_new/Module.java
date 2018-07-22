package net.hdt.neutronia.base.module_new;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class Module implements Comparable<Module> {

	private static Gson GSON = new GsonBuilder().registerTypeAdapter(ItemStack.class, new JsonDeserializer<ItemStack>() {

		@Override
		public ItemStack deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			Item item = null;
			int count = 1; // Would it even be used here ?
			int metadata = 0;
			
			if(json instanceof JsonObject) {
				JsonObject jsonObj = (JsonObject) json;
				
				// Try to get item
				try {
					item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(jsonObj.get("id").getAsString()));
				} catch(Exception e) { }
				
				// Try to get count (uncomment if could be useful)
				try {
					count = jsonObj.get("count").getAsInt();
				} catch(Exception e) { }
				
				// Try to get metadata
				try {
					metadata = jsonObj.get("metadata").getAsInt();
				} catch(Exception e) { }
			}
			
			return item == null ? null : new ItemStack(item, count, metadata);
		}
		
	}).registerTypeAdapter(ResourceLocation.class, new JsonDeserializer<ResourceLocation>() {

		@Override
		public ResourceLocation deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			try {
				return new ResourceLocation(json.getAsString());
			} catch(Exception e) {
				return null;
			}
		}
				
	}).create();
	
    private String name, description;
    private ItemStack icon_stack;
    private ArrayList<Feature> features;
    private boolean enabledByDefault, enabled;

    public String getName() {
        if(name != null) {
            return name;
        } else {
            return makeName();
        }
    }

    private String makeName() {
        return getClass().getSimpleName().replaceAll("Neutronia", "").toLowerCase();
    }

    public ItemStack getIconStack() {
        if(icon_stack != null)
            return icon_stack;
        else
            return new ItemStack(Blocks.BARRIER);
    }

    @Override
    public int compareTo(Module module) {
        return name.compareTo(module.name);
    }

}
