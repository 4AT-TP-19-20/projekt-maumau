package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.text.Text;

public class ControllerEndScreen {
    public static Text winText;
    public Button closeBTN;


    public void initialize(){

//        ControllerEndScreen.winText.setText(ControllerPlayScreen.sp1.name+" hat gewonnen!");

        closeBTN.setOnMouseClicked(actionEvent1 -> {
            Main.PRIMARYSTAGE.close();
        });


    }

}
