package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.Date;

public class Main extends Application {
    private ImageView getIcon(String resourcePath) {
        InputStream input = this.getClass().getResourceAsStream(resourcePath);
        Image image = new Image(input);
        return new ImageView(image);
    }

    @Override
    public void start(Stage stage) throws Exception{
        MenuItem styleChristmas = new MenuItem("Christmas");
        MenuItem styleDaily = new MenuItem("Daily");

        ImageView imageViewLang = this.getIcon("/sample/icons/transfer.png");
        // Create a MenuButton with Text & Icon & 3 Items
        MenuButton menuButton = new MenuButton("Styles", imageViewLang, styleChristmas, styleDaily);


        FlowPane root = new FlowPane();
        root.setPadding(new Insets(10));
        root.setVgap(5);
        root.setHgap(5);

        final Button button = new Button("Play");
        final TextField textField = new TextField();
        final Label label = new Label("Some thing here!");


        root.getChildren().addAll(menuButton, button, textField, label);

        final Scene scene = new Scene(root, 500, 500); // сцена - главное окно.

        stage.setTitle("Test CSS style");
        stage.setScene(scene);
        stage.show();

        styleChristmas.setOnAction(new EventHandler<ActionEvent>() {
            //            @Override
            public void handle(ActionEvent event) {
                scene.getStylesheets().clear();
                scene.getStylesheets().add((getClass().getResource("/sample/Christams.css")).toExternalForm());
                System.out.println("ClickChristmas");
                label.setText("Marry Christmas!!!");
            }
        });

        styleDaily.setOnAction(new EventHandler<ActionEvent>() {
            //            @Override
            public void handle(ActionEvent event) {
                scene.getStylesheets().clear();
                scene.getStylesheets().add((getClass().getResource("/sample/Daily.css")).toExternalForm());
                System.out.println("ClickDaily");
                label.setText("Today !!!" + new Date());
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
