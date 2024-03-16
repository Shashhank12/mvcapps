package CALab;

import javax.swing.*;

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
    }

    public void update() {
        // call update method of each CellView
    	for (int i = 0; i < cellViews.length; i++) {
    		for (int j = 0; j < cellViews.length; j++) {
        		cellViews[i][j].update();
        	}
    	}
    }

}