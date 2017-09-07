package application;
    
import java.io.File;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	
	Player player;
	FileChooser fileChooser;
	
    @Override
    public void start(final Stage PRIMARY_STAGE) {
    	
    	MenuItem open = new MenuItem("Open");
    	Menu file = new Menu("File");
    	MenuBar menu = new MenuBar();
    	
    	file.getItems().add(open);
    	menu.getMenus().add(file);
    	
    	fileChooser = new FileChooser();
    	
    	open.setOnAction(new EventHandler <ActionEvent>() {
    		public void handle(ActionEvent e) {
    			player.player.pause();
    			File file = fileChooser.showOpenDialog(PRIMARY_STAGE);
    			Scene scene = new Scene(player, 710, 535, Color.BLACK);
    			PRIMARY_STAGE.setScene(scene);
    			if(file != null) {
    				try {
    				player = new Player(file.toURI().toURL().toExternalForm());
    				} catch (MalformedURLException el) {
    					el.printStackTrace();
    				}
    			}
    		}
    	});
    	
        player = new Player("file:///C:/gotg.mp4");
        player.setTop(menu);
        Scene scene = new Scene(player, 720, 535, Color.BLACK);
        PRIMARY_STAGE.setScene(scene);
        PRIMARY_STAGE.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
