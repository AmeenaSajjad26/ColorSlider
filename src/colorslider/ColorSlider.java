//Ameena Sajjad

package colorslider;

import javafx.application.Application;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Slider;
import javafx.scene.text.FontWeight;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ColorSlider extends Application 
{
    @Override
    public void start(Stage primaryStage) 
    {
        int width = 210;
        int length = 15;
        int maximum = 255;
        
       Slider sl = new Slider(0,maximum,0);
       sl.setShowTickLabels(true);
       sl.setShowTickMarks(false);
       sl.setMajorTickUnit(maximum);
       
       Slider slG = new Slider(0,maximum,0);
       slG.setShowTickLabels(true);
       slG.setShowTickMarks(false);
       slG.setMajorTickUnit(maximum);
       
       Slider slB = new Slider(0,maximum,0);
       slB.setShowTickLabels(true);
       slB.setShowTickMarks(false);
       slB.setMajorTickUnit(maximum);
       
       Rectangle rectangle = new Rectangle(175,175);
       rectangle.setStroke(Color.BLACK);
       rectangle.setFill(Color.GRAY);
       rectangle.setStrokeWidth(3);

        Rectangle r = new Rectangle(width,length,Color.RED); 
        r.setStroke(Color.BLACK);
        r.setStrokeWidth(3);
        
       Label red = new Label ("RED",r); 
       red.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
       red.setContentDisplay(ContentDisplay.RIGHT);
       
       Rectangle g = new Rectangle (width,length,Color.GREEN);
       g.setStroke(Color.BLACK);
       g.setStrokeWidth(3);
       
       Label green = new Label ("GREEN",g);
       green.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
       green.setContentDisplay(ContentDisplay.RIGHT);
       
       Rectangle b = new Rectangle (width,length,Color.BLUE);
       b.setStroke(Color.BLACK);
       b.setStrokeWidth(3);
       
       Label blue = new Label ("BLUE",b);
       blue.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
       blue.setContentDisplay(ContentDisplay.RIGHT);
       
        sl.valueProperty().addListener(ov ->
           {
               Color c = Color.rgb(
                       (int) sl.getValue(),
                       (int) slG.getValue(),
                       (int) slB.getValue()); 
               rectangle.setFill(c);    
           });
        
        slG.valueProperty().addListener(ov ->
           {
               Color c = Color.rgb(
                       (int) sl.getValue(),
                       (int) slG.getValue(),
                       (int) slB.getValue());
               rectangle.setFill(c);    
           });
        
        slB.valueProperty().addListener(ov ->
           {
               Color c = Color.rgb((int) sl.getValue(),(int) slG.getValue(),(int) slB.getValue());
               rectangle.setFill(c);    
           });
          
       VBox vBox = new VBox();
       
       vBox.setPadding(new Insets(75, 25, 25, 5));
       
       vBox.setAlignment(Pos.TOP_RIGHT);
       
       vBox.getChildren().add(red);
       VBox.setMargin(sl, new Insets(20, 0, 20, 65));
       vBox.getChildren().add(sl);
       
       vBox.getChildren().add(green);
       VBox.setMargin(slG, new Insets(20, 0, 20, 65));
       vBox.getChildren().add(slG);
       
       vBox.getChildren().add(blue);
       VBox.setMargin(slB, new Insets(20, 0, 20, 65));
       vBox.getChildren().add(slB);
       
        BorderPane pane = new BorderPane();
        pane.setLeft(vBox);
        pane.setCenter(rectangle);
        
        Scene scene = new Scene(pane, 600, 400);
        primaryStage.setTitle("Color Slider");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}