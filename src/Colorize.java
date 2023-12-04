public class Colorize {

    /**1
     * Generates a colored message using the specified color code.
     *
     * @param message   the message to be colored
     * @param colorCode the color code to be applied to the message
     * @return the colored message
     */
    public static String color(String message, String colorCode) {
        return colorCode + message + RESETALL;
    }

    /**
     * Generates a colored message using the specified RGB values.
     *
     * @param message the message to be colored
     * @param rgb     an array containing the RGB values
     * @return the colored message
     */
    public static String colorRgb(String message, int[] rgb) {
        return "\033[38;2;" + rgb[0] + ";" + rgb[1] + ";" + rgb[2] + "m" + message + RESETALL;
    }

    /**
     * Generates a colored message using the specified hex color code.
     *
     * @param message the message to be colored
     * @param hex     the hex color code to convert to RGB
     * @return the colored message
     */
    public static String colorHex(String message, String hex) {
        int[] rgb = hexToRgb(hex);
        return "\033[38;2;" + rgb[0] + ";" + rgb[1] + ";" + rgb[2] + "m" + message + RESETALL;
    }

    /**
     * Generates a message with a colored background using the specified RGB values.
     *
     * @param message the message to be displayed with the colored background
     * @param rgb     an array containing the RGB values
     * @return the colored string with the background in RGB format
     */
    public static String colorBgRgb(String message, int[] rgb) {
        return "\033[48;2;" + rgb[0] + ";" + rgb[1] + ";" + rgb[2] + "m" + message + RESETALL;
    }

    /**
     * Generates a message with a colored background using the specified hex color
     * code.
     *
     * @param message the message to be displayed with the colored background
     * @param hex     the hex color code to convert to RGB
     * @return the colored background string
     */
    public static String colorBgHex(String message, String hex) {
        int[] rgb = hexToRgb(hex);
        return "\033[48;2;" + rgb[0] + ";" + rgb[1] + ";" + rgb[2] + "m" + message + RESETALL;
    }

    /**
     * Generates a colored message with a colored background using RGB values or hex
     * color codes.
     *
     * @param message   the message to be combined with colors
     * @param foreColor the foreground color to be applied to the message
     * @param backColor the background color to be applied to the message
     * @return the combined message with foreground and background colors
     */
    public static String colorCombined(String message, Object foreColor, Object backColor) {
        int[] foreRgb = isColorCode(foreColor) ? (int[]) foreColor : hexToRgb((String) foreColor);
        int[] backRgb = isColorCode(backColor) ? (int[]) backColor : hexToRgb((String) backColor);
        return "\033[38;2;" + foreRgb[0] + ";" + foreRgb[1] + ";" + foreRgb[2] + "m\033[48;2;"
                + backRgb[0] + ";" + backRgb[1] + ";" + backRgb[2] + "m" + message + RESETALL;
    }

    /**
     * Converts a hexadecimal color code to its RGB equivalent.
     *
     * @param hex the hexadecimal color code to convert
     * @return an array of three integers representing the RGB values
     */
    public static int[] hexToRgb(String hex) {
        hex = hex.replaceFirst("#", "");
        int[] rgb = new int[3];
        rgb[0] = Integer.parseInt(hex.substring(0, 2), 16);
        rgb[1] = Integer.parseInt(hex.substring(2, 4), 16);
        rgb[2] = Integer.parseInt(hex.substring(4, 6), 16);
        return rgb;
    }

    /**
     * Checks if the given object is a color code.
     *
     * @param color the object to be checked
     * @return true if the object is a color code, false otherwise
     */
    public static boolean isColorCode(Object color) {
        return color instanceof int[];
    }

    public static final String RESETALL = "\033[0m";
    public static final String BLACK = "\033[30m";
    public static final String LGRAY = "\033[37m";
    public static final String DGRAY = "\033[90m";
    public static final String WHITE = "\033[97m";
    public static final String RED = "\033[31m";
    public static final String GREEN = "\033[32m";
    public static final String YELLOW = "\033[33m";
    public static final String BLUE = "\033[34m";
    public static final String MAGENTA = "\033[35m";
    public static final String CYAN = "\033[36m";
    public static final String LRED = "\033[91m";
    public static final String LGREEN = "\033[92m";
    public static final String LYELLOW = "\033[93m";
    public static final String LBLUE = "\033[94m";
    public static final String LMAGENTA = "\033[95m";
    public static final String LCYAN = "\033[96m";
}