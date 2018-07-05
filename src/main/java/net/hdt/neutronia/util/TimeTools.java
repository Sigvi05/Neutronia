package net.hdt.neutronia.util;

/**
 * Created on 7/5/18.
 */
public class TimeTools {

    public static int ticksToSeconds(int ticks)
    {
        return ticks/20;
    }

    public static int ticksToMinutes(int ticks)
    {
        return ticksToSeconds(ticks)/60;
    }

    public static int ticksToHours(int ticks)
    {
        return ticksToMinutes(ticks)/60;
    }

    public static int secondsToTicks(int seconds)
    {
        return seconds*20;
    }

    public static int minutesToTicks(int minutes)
    {
        return secondsToTicks(minutes*60);
    }

    public static int hoursToTicks(int hours)
    {
        return minutesToTicks(hours*60);
    }
}
