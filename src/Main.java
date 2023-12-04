public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Display display = new Display();
        Life life = new Life();
        int config = menu.getConfig();
        int[] editGrid;

        if (config == 1) {
            display = new Display();
        } else if (config == 2) {
            display = new Display(menu.getRows(), menu.getColumns(), menu.getGridChar(), menu.getLifeChar(),
                    menu.getGridColor(), menu.getLifeColor(), menu.getCoordColor());
        }
        display.gridInitialFill();

        while (true) {
            display.gridPrintWithCoord();
            editGrid = life.lifeCoordinatesAppend(display.getRows(), display.getColumns());
            if (editGrid[0] == -1) {
                break;
            }
            if (editGrid[0] == 0) {
                int lastRow = Integer.parseInt(life.getCoordinate(life.getLifeCoords().split(";").length - 1, true));
                int lastColumn = Integer
                        .parseInt(life.getCoordinate(life.getLifeCoords().split(";").length - 1, false));
                display.gridUpdate(lastRow - 1, lastColumn - 1, "add");
            }
            if (editGrid.length == 2) {
                display.gridUpdate(editGrid[0] - 1, editGrid[1] - 1, "del");
            }
        }

        while (true) {
            display.gridPrint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            display.evolve();
        }
    }
}
