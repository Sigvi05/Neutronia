package net.hdt.neutronia.util.idk;

import net.hdt.neutronia.Main;

public class InvalidConfigException extends Exception {

    public InvalidConfigException(String cause) {
        super(cause);
    }

    public void printException() {
        Main.LOGGER.error(this.getMessage());
        for (int i = 0; i < this.getStackTrace().length; i++) {
            StackTraceElement element = this.getStackTrace()[i];
            Main.LOGGER.error(element.toString());

            if (i >= 10) {
                Main.LOGGER.error((this.getStackTrace().length - 10) + " more...");
                break;
            }
        }

        Main.LOGGER.info("");
    }

}