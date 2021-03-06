package etu.chmi.collision.view;

import etu.chmi.collision.MainApp;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CollisionDisplayController {
	
	/** Canvas object is an image on which we can draw text, 
	 * shapes, and images, using its associated GraphicsContext object.
	 */
	@FXML
    private Canvas canvasTable;
	private GraphicsContext gcTable;
	@FXML
    private Canvas canvasBalls;
	private GraphicsContext gcBalls;

    // Reference to the main application.
    private MainApp mainApp;
    
    /*
     * Vars for movement.
     */
    long startNanoTime;
    private Movement mov;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public CollisionDisplayController() {
    	
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	canvasTable.toBack();
        canvasBalls.toFront();
    	// Gets the contexts 
    	gcTable = canvasTable.getGraphicsContext2D();
    	gcBalls = canvasBalls.getGraphicsContext2D();
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    /**
     * Called when the user clicks on the start button.
     */
    @FXML
    private void handleStart() { 
    	mov = new Movement();
    	startNanoTime = System.nanoTime();
    	mov.start();  	
    }
    
    /*
     * Draws table
	 */
    public void drawTable() {
    	/*
    	 * Draws the sides
    	 */
    	gcTable.setFill(Color.BURLYWOOD);
        gcTable.setStroke(Color.BURLYWOOD);
        // Draws top side
    	gcTable.strokeRect(this.mainApp.getTable().getxTopSide(), 
    			this.mainApp.getTable().getyTopSide(), 
    			this.mainApp.getTable().getWidth()+2*this.mainApp.getTable().getSideSize(), 
    			this.mainApp.getTable().getSideSize());
    	gcTable.fillRect(this.mainApp.getTable().getxTopSide(), 
    			this.mainApp.getTable().getyTopSide(), 
    			this.mainApp.getTable().getWidth()+2*this.mainApp.getTable().getSideSize(), 
    			this.mainApp.getTable().getSideSize()); 
    	// Draws bottom side
    	gcTable.strokeRect(this.mainApp.getTable().getxBottomSide(), 
    			this.mainApp.getTable().getyBottomSide(), 
    			this.mainApp.getTable().getWidth()+2*this.mainApp.getTable().getSideSize(), 
    			this.mainApp.getTable().getSideSize());
    	gcTable.fillRect(this.mainApp.getTable().getxBottomSide(), 
    			this.mainApp.getTable().getyBottomSide(), 
    			this.mainApp.getTable().getWidth()+2*this.mainApp.getTable().getSideSize(), 
    			this.mainApp.getTable().getSideSize());
    	// Draws left side
    	gcTable.strokeRect(this.mainApp.getTable().getxLeftSide(), 
    			this.mainApp.getTable().getyLeftSide(), 
    			this.mainApp.getTable().getSideSize(), 
    			this.mainApp.getTable().getHeight()+2*this.mainApp.getTable().getSideSize());
    	gcTable.fillRect(this.mainApp.getTable().getxLeftSide(), 
    			this.mainApp.getTable().getyLeftSide(), 
    			this.mainApp.getTable().getSideSize(), 
    			this.mainApp.getTable().getHeight()+2*this.mainApp.getTable().getSideSize());
    	// Draws right side
    	gcTable.strokeRect(this.mainApp.getTable().getxRightSide(), 
    			this.mainApp.getTable().getyRightSide(), 
    			this.mainApp.getTable().getSideSize(), 
    			this.mainApp.getTable().getHeight()+2*this.mainApp.getTable().getSideSize());
    	gcTable.fillRect(this.mainApp.getTable().getxRightSide(), 
    			this.mainApp.getTable().getyRightSide(), 
    			this.mainApp.getTable().getSideSize(), 
    			this.mainApp.getTable().getHeight()+2*this.mainApp.getTable().getSideSize());
    	
    	/*
    	 * Draws table
    	 */
    	gcTable.setFill(Color.CADETBLUE);
        gcTable.setStroke(Color.CADETBLUE);
        gcTable.strokeRect(this.mainApp.getTable().getxTop(), this.mainApp.getTable().getyTop(), 
    			this.mainApp.getTable().getWidth(), this.mainApp.getTable().getHeight());
    	gcTable.fillRect(this.mainApp.getTable().getxTop(), this.mainApp.getTable().getyTop(), 
    			this.mainApp.getTable().getWidth(), this.mainApp.getTable().getHeight());
    }

    /*
     * Inner class.
     */ 
    class Movement extends AnimationTimer {
    	
    	/*
         * Draws ball.
    	 */
    	private void drawBall() {
        	gcBalls.setStroke(Color.SALMON);
			gcBalls.setFill(Color.SALMON);
            gcBalls.strokeOval(mainApp.getBallInfo().get(0).getCurX(), 
            		mainApp.getBallInfo().get(0).getCurY(),
            		mainApp.getBallInfo().get(0).getD(), 
            		mainApp.getBallInfo().get(0).getD());
            gcBalls.fillOval(mainApp.getBallInfo().get(0).getCurX(), 
            		mainApp.getBallInfo().get(0).getCurY(),
            		mainApp.getBallInfo().get(0).getD(), 
            		mainApp.getBallInfo().get(0).getD());  
    	}
    	
    	/*
    	 * Calculates track.
    	 */
    	private void calculateTrack(long currentNanoTime) {
    		// Calculates x, y for balls.
        	double t = (currentNanoTime - startNanoTime) / 100000.0;       
        	double x = mainApp.getBallInfo().get(0).getX0() + 
        			   mainApp.getBallInfo().get(0).getV()*t*Math.cos(mainApp.getBallInfo().get(0).getAngle());
        	double y = mainApp.getBallInfo().get(0).getY0() + 
        			   mainApp.getBallInfo().get(0).getV()*t*Math.sin(mainApp.getBallInfo().get(0).getAngle());
        	
        	
        	// Checks collisions with right and left side. 
        	if (((x >= (mainApp.getTable().getxTop()+mainApp.getTable().getWidth()-mainApp.getBallInfo().get(0).getD()))) 
        	       || (x <= mainApp.getTable().getxTop()))
        	{ 
        		// Changes angle, changes x0, y0. Doesn't change curX and curY!!! 
        		mainApp.getBallInfo().get(0).setAngle(Math.PI-mainApp.getBallInfo().get(0).getAngle());
        		mainApp.getBallInfo().get(0).setX0(mainApp.getBallInfo().get(0).getCurX());
        		mainApp.getBallInfo().get(0).setY0(mainApp.getBallInfo().get(0).getCurY());
        		startNanoTime = System.nanoTime();
        	} 
        	else {
	        	// Checks collisions with top and bottom side. 
	        	if 
	        	((y <= mainApp.getTable().getyTop()) 
	        	    || (y >= (mainApp.getTable().getyTop()+mainApp.getTable().getHeight()-mainApp.getBallInfo().get(0).getD())))
	        	{  
	        		// Changes angle, changes x0, y0. Doesn't change curX and curY!!! 
	        		mainApp.getBallInfo().get(0).setAngle(Math.PI*2-mainApp.getBallInfo().get(0).getAngle());
	        		mainApp.getBallInfo().get(0).setX0(mainApp.getBallInfo().get(0).getCurX());
	        		mainApp.getBallInfo().get(0).setY0(mainApp.getBallInfo().get(0).getCurY());
	        		startNanoTime = System.nanoTime();
	        	}
	        	// There is no collision on this step.
	        	else {
	        		// Changes curX and curY.
	        		mainApp.getBallInfo().get(0).setCurX(x);
	        		mainApp.getBallInfo().get(0).setCurY(y);
	        	}
        	}
    	}
    	  	
    	public void handle(long currentNanoTime)
        {
    		// Clears canvas.
        	gcBalls.clearRect(0, 0, canvasBalls.getWidth(), canvasBalls.getHeight());
           
        	calculateTrack(currentNanoTime);
        	
        	drawBall();        	
        }
    }
}
