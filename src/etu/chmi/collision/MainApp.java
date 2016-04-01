package etu.chmi.collision;

import java.io.IOException;
import java.util.LinkedList;

import etu.chmi.collision.model.Ball;
import etu.chmi.collision.model.Table;
import etu.chmi.collision.view.CollisionDisplayController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private AnchorPane rootLayout;
    
    private Table table; 
    /**
     * The data as an observable list of Balls.
     */
    private LinkedList<Ball> ballInfo;
        
    /**
     * Constructor
     */
    public MainApp() {
    	this.table = new Table();
    	this.ballInfo = new LinkedList<Ball>();
    	this.ballInfo.add(new Ball(150.0, 150.0, 50.0, 0.8,-Math.PI/6));
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Collisions");

        initRootLayout();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/CollisionDisplay.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            // Give the controller access to the main app.
            CollisionDisplayController controller = loader.getController();
            controller.setMainApp(this);
            controller.drawTable();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public Table getTable() {
        return this.table;
    }
    /**
     * Returns the data as an observable list of Balls. 
     * @return
     */
    public LinkedList<Ball> getBallInfo() {
        return ballInfo;
    }
}