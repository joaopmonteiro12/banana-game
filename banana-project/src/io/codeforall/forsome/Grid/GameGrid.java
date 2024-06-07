package io.codeforall.forsome.Grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GameGrid implements Grid {

    public static final int PADDING = 10;
    public static final int CELL_SIZE = 20;
    private int cols;
    private int rows;
    private Rectangle field;
    //private Cell[][] cells;

    public GameGrid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.field = new Rectangle(PADDING, PADDING, cols * CELL_SIZE, rows * this.CELL_SIZE);
        //this.cells = new Cell[rows][cols];
    }

    @Override
    public void init() {
        field.draw();
        int transY = 0;

        /*for (int i = 0; i < rows; i++) {
            int transX = 0;
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell(transX, transY, j, i);
                transX += CELL_SIZE;
            }
            transY += CELL_SIZE;
        }*/
    }

    @Override
    public int getCols() {
        return this.cols;
    }

    @Override
    public int getRows() {
        return this.rows;
    }

    public int getWidth() {
        return field.getWidth();
    }

    public int getHeight() {
        return field.getHeight();
    }

    public int getX() {
        return this.field.getX();
    }

    public int getY() {
        return this.field.getY();
    }

    public int getCellSize() {
        return CELL_SIZE;
    }

    @Override
    public GridPosition makeGridPosition(int col, int row) {
        GridPosition gridPosition = new GameGridPosition(col, row, this);
        return gridPosition;
    }

    public int rowToY(int row) {
        return (row * CELL_SIZE) + PADDING;
    }

    public int columnToX(int column) {
        return (column * CELL_SIZE) + PADDING;
    }

    /*public class Cell {
        private int col;
        private int row;

        private int width;
        private int height;
        private Rectangle cell;


        private boolean isPainted;

        public Cell(int transX, int transY, int col, int row) {
            this.col = col;
            this.row = row;
            this.height = CELL_SIZE;
            this.width = CELL_SIZE;
            this.cell = new Rectangle(PADDING, PADDING, width, height);
            cell.translate(transX, transY);
            this.isPainted = false;
            cellDraw();
        }

        public void cellDraw() {
            this.cell.draw();
        }

        public boolean isPainted() {
            return isPainted;
        }

        public void setPainted(boolean painted) {
            isPainted = painted;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }
    }*/
}