package net.hdt.neutronia.dying_system_rewamp;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

public enum TextFormatting {
    LIGHT_YELLOW("LIGHT_YELLOW", 'y', 0),
    BEIGE("BEIGE", 'b', 1),
    PEACH("PEACH", 'p', 2),
    TAN("TAN", 't', 3),
    LUMINOUS("LUMINOUS", 'l', 4);

    /**
     * Maps a name (e.g., 'underline') to its corresponding enum value (e.g., UNDERLINE).
     */
    private static final Map<String, TextFormatting> NAME_MAPPING = Maps.<String, TextFormatting>newHashMap();
    /**
     * Matches formatting codes that indicate that the client should treat the following text as bold, recolored,
     * obfuscated, etc.
     */
    private static final Pattern FORMATTING_CODE_PATTERN = Pattern.compile("(?i)\u00a7[0-9A-FK-OR]");

    static {
        for (TextFormatting textformatting : values()) {
            NAME_MAPPING.put(lowercaseAlpha(textformatting.name), textformatting);
        }
    }

    /**
     * The name of this color/formatting
     */
    private final String name;
    /**
     * The formatting code that produces this format.
     */
    private final char formattingCode;
    private final boolean fancyStyling;
    /**
     * The control string (section sign + formatting code) that can be inserted into client-side text to display
     * subsequent text in this format.
     */
    private final String controlString;
    /**
     * The numerical index that represents this color
     */
    private final int colorIndex;

    private TextFormatting(String formattingName, char formattingCodeIn, int colorIndex) {
        this(formattingName, formattingCodeIn, false, colorIndex);
    }

    private TextFormatting(String formattingName, char formattingCodeIn, boolean fancyStylingIn) {
        this(formattingName, formattingCodeIn, fancyStylingIn, -1);
    }

    private TextFormatting(String formattingName, char formattingCodeIn, boolean fancyStylingIn, int colorIndex) {
        this.name = formattingName;
        this.formattingCode = formattingCodeIn;
        this.fancyStyling = fancyStylingIn;
        this.colorIndex = colorIndex;
        this.controlString = "\u00a7" + formattingCodeIn;
    }

    private static String lowercaseAlpha(String p_175745_0_) {
        return p_175745_0_.toLowerCase(Locale.ROOT).replaceAll("[^a-z]", "");
    }

    /**
     * Returns a copy of the given string, with formatting codes stripped away.
     */
    @Nullable
    public static String getTextWithoutFormattingCodes(@Nullable String text) {
        return text == null ? null : FORMATTING_CODE_PATTERN.matcher(text).replaceAll("");
    }

    /**
     * Gets a value by its friendly name; null if the given name does not map to a defined value.
     */
    @Nullable
    public static TextFormatting getValueByName(@Nullable String friendlyName) {
        return friendlyName == null ? null : (TextFormatting) NAME_MAPPING.get(lowercaseAlpha(friendlyName));
    }

    /**
     * Get a TextFormatting from it's color index
     */
    @Nullable
    public static TextFormatting fromColorIndex(int index) {
        for (TextFormatting textformatting : values()) {
            if (textformatting.getColorIndex() == index) {
                return textformatting;
            }
        }

        return null;
    }

    /**
     * Gets all the valid values.
     */
    public static Collection<String> getValidValues(boolean p_96296_0_, boolean p_96296_1_) {
        List<String> list = Lists.newArrayList();

        for (TextFormatting textformatting : values()) {
            if ((!textformatting.isColor() || p_96296_0_) && (!textformatting.isFancyStyling() || p_96296_1_)) {
                list.add(textformatting.getFriendlyName());
            }
        }

        return list;
    }

    /**
     * Returns the numerical color index that represents this formatting
     */
    public int getColorIndex() {
        return this.colorIndex;
    }

    /**
     * False if this is just changing the color or resetting; true otherwise.
     */
    public boolean isFancyStyling() {
        return this.fancyStyling;
    }

    /**
     * Checks if this is a color code.
     */
    public boolean isColor() {
        return !this.fancyStyling;
    }

    /**
     * Gets the friendly name of this value.
     */
    public String getFriendlyName() {
        return this.name().toLowerCase(Locale.ROOT);
    }

    public String toString() {
        return this.controlString;
    }

}