package spigot.sage.cardinal.util;

import org.apache.commons.lang.StringUtils;

public class RemoveStringSuffix {
    public static String removeSuffix(final String inputString, final String suffix) {
        return StringUtils.removeEnd(inputString, suffix);
    }
}
