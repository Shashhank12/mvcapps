package CALab;

import mvc.*;
import java.awt.*;

public class GridView extends View {

    private CellView[][] cellViews;

    public GridView(Model model) {
    	super(model);
        /*
        Cell cell = new CellView(((Grid)model).getCell(row, col)
        cellViews[row][col] = cell
        set cell.row and cell.col here
        */
        int dim = ((Grid)model).getDim();
        cellViews = new CellView[dim][dim];
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                Cell cell = ((Grid)model).getCell(row, col);
                cellViews[row][col] = new CellView(cell);
                cell.row = row;
                cell.col = col;
            }
        }
        this.setLayout(new GridLayout(dim, dim));
        for (int row = 0; row < dim; row++) {
        	for (int col = 0; col < dim ; col++) {
        		this.add(cellViews[row][col]);
        	}
        }
    }

    public void update() {
        // call update method of each CellView
    	for (int i = 0; i < cellViews.length; i++) {
    		for (int j = 0; j < cellViews[0].length; j++) {
        		cellViews[i][j].update();
        	}
    	}
    }

    public void setModel(Model newModel) {
        super.setModel(newModel);
        Grid grid = (Grid)model;
        for (int i = 0; i < Grid.dim; i++) {
            for (int j = 0; j < Grid.dim; j++) {
                cellViews[i][j].setCell(grid.getCell(i, j));
            }
        }
        update();
    }
}