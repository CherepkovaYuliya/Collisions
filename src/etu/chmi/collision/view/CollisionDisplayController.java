package etu.chmi.collision.view;

import etu.chmi.collision.MainApp;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CollisionDisplayController {
	
	/** Canvas object is an image on which we can draw text, 
	 * shapes, and images, using its associated GraphicsContext object.
	 */
	@FXML
    private Canvas canvas;
	private GraphicsContext gc;

    // Reference to the main application.
    private MainApp mainApp;

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
    	// Gets the context 
    	gc = canvas.getGraphicsContext2D();
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
    	drawTable();
		
    	
    	 /*final long startNanoTime = System.nanoTime();
    	
    	new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                // Clears canvas.
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                // Draws rect.
            	gc.strokeRect(10, 10, 80, 10);
            	
            	// Calculate x, y of circle.
            	double t = (currentNanoTime - startNanoTime) / 100000000.0; 
            	double x = 180;
                double y = 180 - t;
                
                // If it's top border, go down
            	if (y <= 20) 
            		gc.strokeOval(x, y+2*t, 50, 50);
            	else
            		gc.strokeOval(x, y, 50, 50);
            }
        }.start();*/
    	
    }
    
    /*
     * Draws table
	 */
    private void drawTable() {
    	/*
    	 * Draws the sides
    	 */
    	gc.setFill(Color.BURLYWOOD);
        gc.setStroke(Color.BURLYWOOD);
        // Draws top side
    	gc.strokeRect(this.mainApp.getTable().getxTopSide(), 
    			this.mainApp.getTable().getyTopSide(), 
    			this.mainApp.getTable().getWidth()+2*this.mainApp.getTable().getSideSize(), 
    			this.mainApp.getTable().getSideSize());
    	gc.fillRect(this.mainApp.getTable().getxTopSide(), 
    			this.mainApp.getTable().getyTopSide(), 
    			this.mainApp.getTable().getWidth()+2*this.mainApp.getTable().getSideSize(), 
    			this.mainApp.getTable().getSideSize()); 
    	// Draws bottom side
    	gc.strokeRect(this.mainApp.getTable().getxBottomSide(), 
    			this.mainApp.getTable().getyBottomSide(), 
    			this.mainApp.getTable().getWidth()+2*this.mainApp.getTable().getSideSize(), 
    			this.mainApp.getTable().getSideSize());
    	gc.fillRect(this.mainApp.getTable().getxBottomSide(), 
    			this.mainApp.getTable().getyBottomSide(), 
    			this.mainApp.getTable().getWidth()+2*this.mainApp.getTable().getSideSize(), 
    			this.mainApp.getTable().getSideSize());
    	// Draws left side
    	gc.strokeRect(this.mainApp.getTable().getxLeftSide(), 
    			this.mainApp.getTable().getyLeftSide(), 
    			this.mainApp.getTable().getSideSize(), 
    			this.mainApp.getTable().getHeight()+2*this.mainApp.getTable().getSideSize());
    	gc.fillRect(this.mainApp.getTable().getxLeftSide(), 
    			this.mainApp.getTable().getyLeftSide(), 
    			this.mainApp.getTable().getSideSize(), 
    			this.mainApp.getTable().getHeight()+2*this.mainApp.getTable().getSideSize());
    	// Draws right side
    	gc.strokeRect(this.mainApp.getTable().getxRightSide(), 
    			this.mainApp.getTable().getyRightSide(), 
    			this.mainApp.getTable().getSideSize(), 
    			this.mainApp.getTable().getHeight()+2*this.mainApp.getTable().getSideSize());
    	gc.fillRect(this.mainApp.getTable().getxRightSide(), 
    			this.mainApp.getTable().getyRightSide(), 
    			this.mainApp.getTable().getSideSize(), 
    			this.mainApp.getTable().getHeight()+2*this.mainApp.getTable().getSideSize());
    	
    	/*
    	 * Draws table
    	 */
    	gc.setFill(Color.CADETBLUE);
        gc.setStroke(Color.CADETBLUE);
        gc.strokeRect(this.mainApp.getTable().getxTop(), this.mainApp.getTable().getyTop(), 
    			this.mainApp.getTable().getWidth(), this.mainApp.getTable().getHeight());
    	gc.fillRect(this.mainApp.getTable().getxTop(), this.mainApp.getTable().getyTop(), 
    			this.mainApp.getTable().getWidth(), this.mainApp.getTable().getHeight());
    }

}
