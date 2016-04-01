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
    // For movement.
    long startNanoTime;
    private Movement mov;
    boolean wasRef;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public CollisionDisplayController() {
    	mov = new Movement();
    	wasRef = false;
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
    	startNanoTime = System.nanoTime();
    	wasRef = false;
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

    
    
    
    
    class Movement extends AnimationTimer {
    	  	
    	public void handle(long currentNanoTime)
        {
    		
    		
    		
            // Clears canvas.
        	gcBalls.clearRect(0, 0, canvasBalls.getWidth(), canvasBalls.getHeight());
           
        	double t = (currentNanoTime - startNanoTime) / 10000000.0; 
        	
        	mainApp.getBallInfo().get(0).setCurX(
        			mainApp.getBallInfo().get(0).getX0() + 
        			mainApp.getBallInfo().get(0).getV()*t*Math.cos(mainApp.getBallInfo().get(0).getAngle()));
        	mainApp.getBallInfo().get(0).setCurY(
        			mainApp.getBallInfo().get(0).getY0() + 
        			mainApp.getBallInfo().get(0).getV()*t*Math.sin(mainApp.getBallInfo().get(0).getAngle()));
        	
        	System.out.println("x = "+mainApp.getBallInfo().get(0).getCurX());
        	System.out.println("y = "+mainApp.getBallInfo().get(0).getCurY());
        	System.out.println("angle = "+mainApp.getBallInfo().get(0).getAngle());
        	System.out.println("cos = "+Math.cos(mainApp.getBallInfo().get(0).getAngle()));
        	System.out.println("sin = "+Math.sin(mainApp.getBallInfo().get(0).getAngle()));
        	System.out.println("t = "+t);
        	
        	/*if ((mainApp.getBallInfo().get(0).getCurY().compareTo(80.0) <= 0.0) && (!wasRef)) {
        		System.out.println("fghjkl");
        		
        		mainApp.getBallInfo().get(0).setAngle(Math.PI-mainApp.getBallInfo().get(0).getAngle());
        		mainApp.getBallInfo().get(0).setX0(mainApp.getBallInfo().get(0).getCurX());
        		mainApp.getBallInfo().get(0).setY0(mainApp.getBallInfo().get(0).getCurY());
        		startNanoTime = System.nanoTime();
        		wasRef = true;
        	} 
        	else {
        		
        	}*/
        		// Draws the ball
	        	gcBalls.setStroke(Color.SALMON);
				gcBalls.setFill(Color.SALMON);
	            gcBalls.strokeOval(mainApp.getBallInfo().get(0).getCurX(), 
	            		mainApp.getBallInfo().get(0).getCurY(),
	            		mainApp.getBallInfo().get(0).getRad(), 
	            		mainApp.getBallInfo().get(0).getRad());
	            gcBalls.fillOval(mainApp.getBallInfo().get(0).getCurX(), 
	            		mainApp.getBallInfo().get(0).getCurY(),
	            		mainApp.getBallInfo().get(0).getRad(), 
	            		mainApp.getBallInfo().get(0).getRad());            
        }
    }
}
