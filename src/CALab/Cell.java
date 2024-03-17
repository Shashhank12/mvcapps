package CALab;

import java.util.*;
import java.awt.Color;
import java.io.*;

import mvc.Publisher;

public abstract class Cell extends Publisher implements Serializable {

    protected int row = 0, col = 0;
    protected Set<Cell> neighbors = new HashSet<Cell>();
    protected Grid myGrid = null;
    protected Cell partner = null;


    // choose a random neighbor as a partner
    public void choosePartner() {
        if (partner == null && neighbors != null) {
        	/*
			Set partner to null
			Convert neighbors set to a local array
			Starting at a random position in the array search for a neighbor without a partner
			Make the first such neighbor (if any) the partner and set its partner field to this
			*/
        	
        	
        	partner = null;
        	Cell[] cellArr = (Cell[]) neighbors.toArray();
        	Random rand = new Random();
        	int randInt = rand.nextInt(neighbors.size());
        	int checked = 0;
        	while (checked != neighbors.size()) {
        		if (randInt > neighbors.size()) {
        			randInt = 0;
        		} else {
        			if (cellArr[randInt].partner != null) {
        				this.partner = cellArr[randInt];
        				cellArr[randInt].partner = this;
        			}
                	randInt++;
        		}
        		checked++;
        	}
        }

    }

    public void unpartner() {
        if (partner != null) {
            if (partner.partner != null) {
                partner.partner = null;
            }
            partner = null;
        }
    }

    // get color
    public abstract Color getColor();
    // get ambience
    public abstract int getAmbience();
    // observer neighbors' states
    public abstract void observe();
    // interact with a random neighbor
    public abstract void interact();
    // update my state
    public abstract void update();
    // set status to status + 1 mod whatever
    public abstract void nextState();
    // set status to a random or initial value
    public abstract void reset(boolean randomly);

}


