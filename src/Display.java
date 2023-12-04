import java.text.DecimalFormat;

public class Display {
    private DecimalFormat df = new DecimalFormat("00");
    private Life life = new Life();
    private int rows;
    private int columns;
    private String gridChar;
    private String lifeChar;
    private String gridColor;
    private String lifeColor;
    private String coordColor;
    private String[][] grid;

    public Display() {
        this.rows = 20;
        this.columns = 20;
        this.gridChar = ".";
        this.lifeChar = "O";
        this.gridColor = "#2883FF";
        this.lifeColor = "#A52AFF";
        this.coordColor = "#C9FDFF";
        this.grid = new String[rows][columns];
    }

    public Display(int rows, int columns, String gridChar, String lifeChar, String gridColor, String lifeColor,
                   String coordColor) {
        this.rows = rows;
        this.columns = columns;
        this.gridChar = gridChar;
        this.lifeChar = lifeChar;
        this.gridColor = gridColor;
        this.lifeColor = lifeColor;
        this.coordColor = coordColor;
        grid = new String[rows][columns];
    }

    public String coordTop() {
        String topCoordinates = "   ";
        for (int columnNum = 1; columnNum < columns + 1; columnNum++) {
            topCoordinates += df.format(columnNum) + " ";
        }
        return Colorize.colorHex(topCoordinates, coordColor);
    }

    public void gridInitialFill() {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                grid[row][column] = Colorize.colorHex(gridChar, gridColor);
            }
        }
    }

    public void gridPrintWithCoord() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println(coordTop() + "  ");
        for (int row = 0; row < grid.length; row++) {
            System.out.print(Colorize.colorHex(df.format(row + 1) + " ", coordColor));
            for (int column = 0; column < grid[row].length; column++) {
                System.out.print(grid[row][column] + "  ");
            }
            System.out.println();
        }
    }

    public void gridPrint() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                System.out.print(grid[row][column] + "  ");
            }
            System.out.println();
        }
    }

    public void evolve() {
        int[] lifeCoords = life.getLifeCoordsArray();
        String[][] newGrid = new String[rows][columns];
        for (int l = 0; l < rows; l++) {
            for (int m = 0; m < columns; m++) {
                if (newGrid[l][m] == null) {
                    newGrid[l][m] = Colorize.colorHex(gridChar, gridColor);
                }
            }
        }
        for (int i = 0; i < lifeCoords.length / 2; i++) {
            int row = lifeCoords[i * 2];
            int column = lifeCoords[i * 2 + 1];
            int neighbors = life.countNeighbors(row, column, grid);
            for (int j = -1; j < 2; j++) {
                for (int k = -1; k < 2; k++) {
                    int newRow = row + j;
                    int newColumn = column + k;
                    if (newRow < 0 || newColumn < 0 || newRow >= rows || newColumn >= columns) {
                        continue;
                    }
                    if (grid[newRow][newColumn].equals(lifeChar)) {
                        if (neighbors < 2 || neighbors > 3) {
                            newGrid[newRow][newColumn] = Colorize.colorHex(gridChar, gridColor);
                        } else {
                            newGrid[newRow][newColumn] = Colorize.colorHex(lifeChar, lifeColor);
                        }
                    } else {
                        if (neighbors == 3) {
                            newGrid[newRow][newColumn] = Colorize.colorHex(lifeChar, lifeColor);
                        }
                    }
                }
            }

        }

        for (int m = 0; m < rows; m++) {
            System.arraycopy(newGrid[m], 0, grid[m], 0, columns);
        }
    }

    public void gridUpdate(int row, int column, String option) {
        if (option.equals("add")) {
            grid[row][column] = Colorize.colorHex(lifeChar, lifeColor);
        } else if (option.equals("del")) {
            grid[row][column] = Colorize.colorHex(gridChar, gridColor);
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public String[][] getGrid() {
        return grid;
    }
}
