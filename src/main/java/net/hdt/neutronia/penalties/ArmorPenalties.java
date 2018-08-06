package net.hdt.neutronia.penalties;

import net.hdt.neutronia.base.util.player.PlayerHelper;
import net.minecraft.entity.player.EntityPlayer;
import org.apache.commons.lang3.Range;

public class ArmorPenalties extends PenaltyHandler<Integer, BasicPenalty<Integer>> {

    private static final String category = "neutronia.armor.penalties";

    public ArmorPenalties() {
        addDefault(new BasicPenalty<>(true, true, true, true, true, false, 1f, 0f, "light", "neutronia.armor_penalty.light", category, Range.between(0, 10)));
        addDefault(new BasicPenalty<>(true, true, true, true, true, false, 0.9f, 0f, "medium", "neutroonia.armor_penalty.medium", category, Range.between(13, 23)));
        addDefault(new BasicPenalty<>(true, false, true, true, true, false, 0.8f, 0f, "heavy", "neutronia.armor_penalty.heavy", category, Range.between(24, 30)));
    }


    @Override
    public BasicPenalty<Integer> getPenalty(EntityPlayer player) {
        return getPenalty(PlayerHelper.getWornArmorWeight(player));
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }
}
