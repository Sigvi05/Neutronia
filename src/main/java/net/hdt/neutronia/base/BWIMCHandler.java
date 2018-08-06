package net.hdt.neutronia.base;

import com.google.common.collect.ImmutableList;
import net.hdt.neutronia.base.util.ReflectionLib;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCMessage;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.function.Consumer;

public class BWIMCHandler {

    private static final HashMap<String, Consumer<Object>> IMC_HANDLER = new HashMap<>();

    static {

    }

    public static void registerIMC(String key, Consumer<Object> function) {
        IMC_HANDLER.put(key, function);
    }

    public static void processIMC(ImmutableList<IMCMessage> message) {
        Logger log = Neutronia.LOGGER;
        for (IMCMessage m : message) {
            try {
                String k = m.key;
                log.debug("[NTIMCHandler] %s from %s", k, m.getSender());
                if (IMC_HANDLER.containsKey(k)) {
                    IMC_HANDLER.get(k).accept(ObfuscationReflectionHelper.getPrivateValue(IMCMessage.class, m, ReflectionLib.IMC_MESSAGE_VALUE));
                }
            } catch (Throwable t) {
                bigWarning(log, Level.ERROR, "Bad IMC message (%s)\nfrom %s", m.key, m.getSender());
                log.catching(t);
            }
        }
    }

    public static void bigWarning(Logger log, Level level, String format, Object... data) {
        String o = String.format(format, data);
        String err = "************************";
        err += err;
        log.log(level, err);
        log.log(level, err);
        for (String str : o.split("\n", 0))
            log.log(level, str);
        log.log(level, err);
        log.log(level, err);
    }
}
