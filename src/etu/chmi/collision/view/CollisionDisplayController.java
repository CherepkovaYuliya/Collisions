package etu.chmi.collision.view;

import etu.chmi.collision.MainApp;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

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
    	gc.strokeOval(100, 100, 100, 100);
    }

}
