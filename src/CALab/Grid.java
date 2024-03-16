package CALab;

import java.awt.*;
import java.util.*;
import java.io.*;
import mvc.*;

public abstract class Grid extends Model {
    static private int time = 0;
    protected int dim = 20;
    protected Cell[][] cells;

    public int getDim() { return dim; }
    public int getTime() { return time; }
    public Cell getCell(int row, int col) { return cells[row][col]; }
    public abstract Cell makeCell(boolean uniform);


    public Grid(int dim) {
        this.dim = dim;
        cells = new Cell[dim][dim];
        populate();
    }
    public Grid() { this(20); }

    protected void populate() {
        // 1. use makeCell to fill in cells
        // 2. use getNeighbors to set the neighbors field of each cell
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col] = makeCell(true);
            }
        }

        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col].neighbors = getNeighbors(cells[row][col], 1);
            }
        }
    }

    // called when Populate button is clicked
    public void repopulate(boolean randomly) {
    	// randomly set status of each cell
        if (randomly) {
            for (int row = 0; row < dim; row++) {
                for (int col = 0; col < dim; col++) {
                    cells[row][col].reset(true);
                }
            }
        // set the status of each cell to 0 (dead)
        } else {
            for (int row = 0; row < dim; row++) {
                for (int col = 0; col < dim; col++) {
                    cells[row][col].reset(false);
                }
            }
        }
        // notify subscribers
        notifySubscribers();
    }


    public Set<Cell> getNeighbors(Cell asker, int radius) {
        /*
        return the set of all cells that can be reached from the asker in radius steps.
        If radius = 1 this is just the 8 cells touching the asker.
        Tricky part: cells in row/col 0 or dim - 1.
        The asker is not a neighbor of itself.
        */
        Set<Cell> neighbors = new HashSet<Cell>();
        int row = asker.row;
        int col = asker.col;
        for (int r = row - radius; r <= row + radius; r++) {
            for (int c = col - radius; c <= col + radius; c++) {
                if (r >= 0 && r < dim && c >= 0 && c < dim) {
                    if (r != row || c != col) {
                        neighbors.add(cells[r][c]);
                    }
                }
            }
        }
        return neighbors;
    }


    // cell phases:

    public void observe() {
        // call each cell's observe method and notify subscribers
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col].observe();
                cells[row][col].notifySubscribers();
            }
        }
    }

    public void interact() {
        // call each cell's interact method
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col].interact();
            }
        }
    }

    public void update() {
        // call each cell's update method and notify subscribers
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col].update();
                cells[row][col].notifySubscribers();
            }
        }
    }

    public void updateLoop(int cycles) {
        observe();
        for(int cycle = 0; cycle < cycles; cycle++) {
            interact();
            update();
            observe();
            time++;
            System.out.println("time = " + time);
        }
    }
}

