package sample;



import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Random;

public class ControllerPlayScreen {


    public ImageView karte;
    public Button btnImg;

    public ImageView newCard; // Aufliegende Karte
    public ImageView newCard1; // 1-5 eigene Karten
    public ImageView newCard2;
    public ImageView newCard3;
    public ImageView newCard4;
    public ImageView newCard5;

    public Image image;
    public Image image2;
    public Image image3;
    public Image image4;
    public Image image5;
    public Image image6;

    public Button btnStart1;
    public Pane mainPane;

    private int a,b,c,d;
    private boolean startButtonActive=true;

    public void initialize(){

        //karten namen 1-32, random zahl von 1-32 generieren und dann mit to string karte anzeigen i+.jpg
        int newCardsCounter=0;

        try {
            Random rndm = new Random();

            btnStart1.setOnMouseEntered(actionEvent -> {
                btnStart1.setStyle("-fx-background-color: #20b5d9; -fx-background-insets: 1; -fx-border-color: #ffffff; -fx-border-radius: 5;");
            });

            btnStart1.setOnMouseExited(actionEvent -> {
                btnStart1.setStyle("-fx-background-color: #41d9c4; -fx-background-insets: 1; -fx-border-color: #ffffff; -fx-border-radius: 5;");
            });

            btnStart1.setOnMouseClicked(actionEvent -> {
                int x = 1 + rndm.nextInt(32);
                image = new Image("karten/"+x+".png");
                newCard.setImage(image);

                mainPane.getChildren().remove(btnStart1);
                startButtonActive=false;

                if(startButtonActive==false) {

                    x = 1 + rndm.nextInt(32);
                    int y = x;
                    image = new Image("karten/" + x + ".png");
                    image2 = new Image("karten/" + y + ".png");
                    newCard1.setImage(image);

                    newCard1.setOnMouseClicked(actionEvent1 -> {
                        newCard.setImage(image2);
                        newCard1.setImage(null);

                    });

                    x = 1 + rndm.nextInt(32);
                    a = x;
                    image = new Image("karten/" + x + ".png");
                    image3 = new Image("karten/" + a + ".png");
                    newCard2.setImage(image);

                    newCard2.setOnMouseClicked(actionEvent1 -> {
                        newCard.setImage(image3);
                        newCard2.setImage(null);

                    });


                    x = 1 + rndm.nextInt(32);
                    b = x;
                    image = new Image("karten/" + x + ".png");
                    image4 = new Image("karten/" + b + ".png");
                    newCard3.setImage(image);

                    newCard3.setOnMouseClicked(actionEvent1 -> {
                        newCard.setImage(image4);
                        newCard3.setImage(null);

                    });

                    x = 1 + rndm.nextInt(32);
                    c = x;
                    image = new Image("karten/" + x + ".png");
                    image5 = new Image("karten/" + c + ".png");
                    newCard4.setImage(image);

                    newCard4.setOnMouseClicked(actionEvent1 -> {
                        newCard.setImage(image5);
                        newCard4.setImage(null);

                    });

                    x = 1 + rndm.nextInt(32);
                    d = x;
                    image = new Image("karten/" + x + ".png");
                    image6 = new Image("karten/" + d + ".png");
                    newCard5.setImage(image);

                    newCard5.setOnMouseClicked(actionEvent1 -> {
                        newCard.setImage(image6);
                        newCard5.setImage(null);

                    });
                }

                karte.setOnMouseClicked(actionEvent1 -> {
                    int x1 = 1 + rndm.nextInt(32);
                    image = new Image("karten/"+x1+".png");

                    if(newCard1.getImage()==null){
                        newCard1.setImage(image);
                    }else if(newCard2.getImage()==null){
                        newCard2.setImage(image);
                    }else if(newCard3.getImage()==null){
                        newCard3.setImage(image);
                    }else if(newCard4.getImage()==null){
                        newCard4.setImage(image);
                    }else if(newCard5.getImage()==null){
                        newCard5.setImage(image);
                    }
                });
            });




        }catch (Exception e){
            e.printStackTrace();
        }


    }

    //newCard = new ImageView(("pfad"));



}