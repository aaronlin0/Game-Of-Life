import java.util.Scanner;

public class Menu {
    private Scanner input = new Scanner(System.in);
    private String titleColor = "#685AFF";
    private String optionColor = "#5AC8FF";
    private String warningColor = "#BA5AFF";
    private String inputColor = "#C9FDFF";
    private int selectConfig;
    private int selectRows;
    private int selectColumns;
    private String selectGridChar;
    private String selectLifeChar;
    private String selectGridColor;
    private String selectLifeColor;
    private String selectCoordColor;

    public Menu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println(Colorize.colorHex("Conway's Game of Life\n", titleColor));
        System.out.println(Colorize.colorHex("(1) Default Config Start", optionColor));
        System.out.println(Colorize.colorHex("(2) Advanced Config Start\n", optionColor));
        System.out.println(Colorize.colorHex("[INT] Enter an option.", optionColor));
        System.out.print(Colorize.colorHex("$ ", inputColor));
        selectConfig = Integer.parseInt(input.nextLine());
        System.out.print("\033[H\033[2J");
        System.out.flush();
        if (selectConfig == 2) {
            advancedSetup();
        }
    }

    public void advancedSetup() {
        System.out.println(Colorize.colorHex("Warning: Recommended to not input any integer >= 100", warningColor));
        System.out.println(Colorize.colorHex("[INT] Enter the amount of rows for the grid.", optionColor));
        System.out.print(Colorize.colorHex("$ ", inputColor));
        selectRows = Integer.parseInt(input.nextLine());
        System.out.println(Colorize.colorHex("Warning: Recommended to not input any integer >= 100", warningColor));
        System.out.println(Colorize.colorHex("[INT] Enter the amount of columns for the grid.", optionColor));
        System.out.print(Colorize.colorHex("$ ", inputColor));
        selectColumns = Integer.parseInt(input.nextLine());
        System.out.println(Colorize.colorHex("Warning: Recommended to input one character only.", warningColor));
        System.out.println(Colorize.colorHex("[STR] Enter the grid character for a blank cell.", optionColor));
        System.out.print(Colorize.colorHex("$ ", inputColor));
        selectGridChar = input.nextLine();
        System.out.println(Colorize.colorHex("Warning: Recommended to input one character only.", warningColor));
        System.out.println(Colorize.colorHex("[STR] Enter the grid character for a live cell.", optionColor));
        System.out.print(Colorize.colorHex("$ ", inputColor));
        selectLifeChar = input.nextLine();
        System.out.println(Colorize.colorHex("[STR] Enter the HEX color code for a blank cell.", optionColor));
        System.out.print(Colorize.colorHex("$ ", inputColor));
        selectGridColor = input.nextLine();
        System.out.println(Colorize.colorHex("[STR] Enter the HEX color code for a live cell.", optionColor));
        System.out.print(Colorize.colorHex("$ ", inputColor));
        selectLifeColor = input.nextLine();
        System.out.println(Colorize.colorHex("[STR] Enter the HEX color code for the coordinates.", optionColor));
        System.out.print(Colorize.colorHex("$ ", inputColor));
        selectCoordColor = input.nextLine();
    }

    public int getConfig() {
        return selectConfig;
    }

    public int getRows() {
        return selectRows;
    }

    public int getColumns() {
        return selectColumns;
    }

    public String getGridChar() {
        return selectGridChar;
    }

    public String getLifeChar() {
        return selectLifeChar;
    }

    public String getGridColor() {
        return selectGridColor;
    }

    public String getLifeColor() {
        return selectLifeColor;
    }

    public String getCoordColor() {
        return selectCoordColor;
    }
}