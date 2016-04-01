package etu.chmi.collision.model;

public class Table {
	
	 // Vars for sides
	 private final Double sideSize;
	 private final Double xTopSide;
	 private final Double yTopSide;
	 private final Double xBottomSide;
	 private final Double yBottomSide;
	 private final Double xLeftSide;
	 private final Double yLeftSide;
	 private final Double xRightSide;
	 private final Double yRightSide;	

	 // Vars for table
	 private final Double width; // without size of side
	 private final Double height; // without size of side
	 private final Double xTop;
	 private final Double yTop;
	 
	 /**
     * Default constructor
     */
	 public Table() {	
		 this(0.0, 0.0, 360.0, 340.0, 20.0);
	}
	 
	 /**
     * Constructor
     */
	 public Table(Double xTopSide, Double yTopSide, Double width, Double height, Double sideSize) {
		 this.width = width;
		 this.height = height;
		 this.sideSize = sideSize;
		 
		 this.xTopSide = xTopSide;
		 this.yTopSide = yTopSide;
		 
		 this.xTop = this.xTopSide+this.sideSize;
		 this.yTop = this.yTopSide+this.sideSize;
		 
		 this.xBottomSide = this.xTopSide;
		 this.yBottomSide = this.yTopSide+this.height+this.sideSize;
		 
		 this.xLeftSide = this.xTopSide;
		 this.yLeftSide = this.yTopSide;
		 
		 this.xRightSide = this.xTopSide+this.width+this.sideSize;
		 this.yRightSide = this.yTopSide; 
	 }
	 
	public Double getSideSize() {
		return sideSize;
	}

	public Double getxTopSide() {
		return xTopSide;
	}

	public Double getyTopSide() {
		return yTopSide;
	}

	public Double getxBottomSide() {
		return xBottomSide;
	}

	public Double getyBottomSide() {
		return yBottomSide;
	}

	public Double getxLeftSide() {
		return xLeftSide;
	}

	public Double getyLeftSide() {
		return yLeftSide;
	}

	public Double getxRightSide() {
		return xRightSide;
	}

	public Double getyRightSide() {
		return yRightSide;
	}
	 public Double getWidth() {
		return width;
	}

	public Double getHeight() {
		return height;
	}

	public Double getxTop() {
		return xTop;
	}

	public Double getyTop() {
		return yTop;
	}

}
