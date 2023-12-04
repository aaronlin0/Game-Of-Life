import java.util.Scanner;

public class Life {
    private Scanner input = new Scanner(System.in);
    private String optionColor = "#5AC8FF";
    private String warningColor = "#BA5AFF";
    private String inputColor = "#C9FDFF";
    private String lifeCoords;
    private int[] lifeCoordsArray;

    public Life() {
        lifeCoords = "";
        lifeCoordsArray = new int[] {};
    }

    public boolean hasDuplicateSubstring(String lifeCoord, String newCoord) {
        int len = lifeCoord.length();
        for (int i = 0; i <= len - newCoord.length(); i++) {
            String substring = lifeCoord.substring(i, i + newCoord.length());
            if (substring.equals(newCoord)) {
                return true;
            }
        }
        return false;
    }

    public int inputLifeRow() {
        int lifeRow;
        System.out.println(Colorize.colorHex("Warning: Enter 0 to exit.", warningColor));
        System.out.println(Colorize.colorHex("[INT] Enter life row.", optionColor));
        System.out.print(Colorize.colorHex("$ ", inputColor));
        lifeRow = Integer.parseInt(input.nextLine());
        return lifeRow;
    }

    public int inputLifeColumn() {
        int lifeColumn;
        System.out.println(Colorize.colorHex("[INT] Enter life column.", optionColor));
        System.out.print(Colorize.colorHex("$ ", inputColor));
        lifeColumn = Integer.parseInt(input.nextLine());
        return lifeColumn;
    }

    public int[] lifeCoordinatesAppend(int row, int column) {
        int lifeRow;
        int lifeColumn;
        String newCoord;
        lifeRow = inputLifeRow();
        if (lifeRow == 0) {
            lifeCoordsArray = convertCoordsToArray();
            return new int[] { -1 };
        }
        if (lifeRow > row || lifeRow < 0) {
            return new int[] { 1 };
        }
        lifeColumn = inputLifeColumn();
        if (lifeColumn == 0) {
            lifeCoordsArray = convertCoordsToArray();
            return new int[] { -1 };
        }
        if (lifeColumn > column || lifeColumn < 0) {
            return new int[] { 1 };
        }
        newCoord = lifeRow + "," + lifeColumn + ";";
        if (hasDuplicateSubstring(lifeCoords, newCoord)) {
            lifeCoords = lifeCoords.replace(newCoord, "");
            return new int[] { lifeRow, lifeColumn };
        } else {
            lifeCoords += newCoord;
        }
        return new int[] { 0 };
    }

    public String getCoordinate(int index, boolean getRow) {
        String[] coordinatePairs = lifeCoords.split(";");
        String[] pair = coordinatePairs[index].split(",");
        if (getRow) {
            return pair[0];
        } else {
            return pair[1];
        }
    }

    public int[] convertCoordsToArray() {
        String[] coordinatePairs = lifeCoords.split(";");
        int[] array = new int[coordinatePairs.length * 2];

        int index = 0;
        for (String coordinatePair : coordinatePairs) {
            String[] number = coordinatePair.split(",");
            array[index++] = Integer.parseInt(number[0]);
            array[index++] = Integer.parseInt(number[1]);
        }
        return array;
    }

    public int countNeighbors(int lifeRow, int lifeColumn, String[][] grid) {
        int neighbors = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int row = lifeRow + i;
                int column = lifeColumn + j;
                if (row >= 0 && row < grid.length && column >= 0 && column < grid[0].length) {
                    if (grid[row][column] == "O") {
                        neighbors++;
                    }
                }
            }
        }
        return neighbors;
    }

    public String getLifeCoords() {
        return lifeCoords;
    }

    public int[] getLifeCoordsArray() {
        return lifeCoordsArray;
    }
}