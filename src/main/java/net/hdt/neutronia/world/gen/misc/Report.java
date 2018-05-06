package net.hdt.neutronia.world.gen.misc;

import net.hdt.neutronia.util.Reference;

/* Console message reporter [key = value] */
public class Report {

    String result = "[" + Reference.NAME + " v" + Reference.VERSION + "]";

    public Report add(String key, String value) {
        result += "[" + key + " = " + value + "]";
        return this;
    }

    public void print() {
        System.out.println(result);
    }

}