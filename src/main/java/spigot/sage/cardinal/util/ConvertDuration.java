package spigot.sage.cardinal.util;

import static spigot.sage.cardinal.util.RemoveStringSuffix.removeSuffix;

public class ConvertDuration {
    static int durationScaleBasis = 1000 * 60;
    static int durationValue;
    static int durationScale;
    static int duration;

    public static int getDuration(String durationArgument) {
        if ( durationArgument.endsWith("min") ) {
            try {
                durationValue = Integer.parseInt(removeSuffix(durationArgument, "min"));
            } catch (Exception exception) {
                durationValue = 0;
            }

            durationScale = durationScaleBasis;
        } else if ( durationArgument.endsWith("h") ) {
            try {
                durationValue = Integer.parseInt(removeSuffix(durationArgument, "h"));
            } catch (Exception exception) {
                durationValue = 0;
            }

            durationScale = durationScaleBasis * 60;
        } else if ( durationArgument.endsWith("d") ) {
            try {
                durationValue = Integer.parseInt(removeSuffix(durationArgument, "d"));
            } catch (Exception exception) {
                durationValue = 0;
            }

            durationScale = durationScaleBasis * 1440;
        }

        duration = durationValue * durationScale;
        return duration;
    }
}
