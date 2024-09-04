

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class DialogBox extends HBox {
    private Label text;
    private ImageView displayPicture;

    public DialogBox(String s, Image i) {
        text = new Label(s);
        displayPicture = new ImageView(i);

        text.setWrapText(true);
        text.setPadding(new Insets(10));
        displayPicture.setFitWidth(100);
        displayPicture.setFitHeight(100);
        displayPicture.setClip(new Circle(50, 50, 50));
        this.setAlignment(Pos.TOP_RIGHT);


        // adds the nodes to the children list
        this.getChildren().addAll(text, displayPicture);
        this.setPadding(new Insets(10));
    }

    private void flip() {
        this.setAlignment(Pos.TOP_LEFT);
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        FXCollections.reverse(tmp);
        this.getChildren().setAll(tmp);
    }

    public static DialogBox getUserDialog(String s, Image i) {
        DialogBox db = new DialogBox(s, i);
        db.setBackground(new Background(new BackgroundFill(
                Color.PALEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        return db;
    }

    public static DialogBox getBotDialog(String s, Image i) {
        DialogBox dialogBox = new DialogBox(s, i);
        dialogBox.flip();
        return dialogBox;
    }

}
