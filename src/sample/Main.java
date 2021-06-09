package sample;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.bson.Document;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {
    TextField text1;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage stageHome = new Stage();
        stageHome.setTitle("Financial Calculator App");
        stageHome.setResizable(false);

        //Connect with mongoDB databse
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        MongoDatabase databaseCW = mongo.getDatabase("PP2CourseWork");

        MongoCollection<Document> col01 = databaseCW.getCollection("Collection01");

        //Anchorpane for Home page
        AnchorPane anc01 = new AnchorPane();

        //Image for Home page
        Image image01 = new Image("image01.png");
        ImageView viewImage01 = new ImageView();
        viewImage01.setImage(image01);
        viewImage01.setOpacity(0.8);
        viewImage01.setFitHeight(500);
        viewImage01.setFitWidth(700);

        //Label for home page topic
        Label lb01 = new Label("Home Page");
        lb01.setLayoutX(245);
        lb01.setLayoutY(20);
        lb01.setStyle("-fx-font-size: 42;-fx-text-alignment: center");

        //Button for history
        Button bt04 = new Button("History");
        bt04.setLayoutX(275);
        bt04.setLayoutY(160);
        bt04.setStyle("-fx-font-size: 20;-fx-text-alignment: center; -fx-background-radius: 20; -fx-background-color: #7FFFD4");
        bt04.setPrefHeight(40);
        bt04.setPrefWidth(150);

        //Button to help
        Button bt05 = new Button("Help");
        bt05.setLayoutX(275);
        bt05.setLayoutY(230);
        bt05.setStyle("-fx-font-size: 20;-fx-text-alignment: center; -fx-background-radius: 20; -fx-background-color: aqua");
        bt05.setPrefHeight(40);
        bt05.setPrefWidth(150);

        //Button to Exit
        Button bt06 = new Button("Exit");
        bt06.setLayoutX(305);
        bt06.setLayoutY(410);
        bt06.setStyle("-fx-font-size: 20;-fx-text-alignment: center");
        bt06.setPrefHeight(40);
        bt06.setPrefWidth(90);

        //add childrens to home page anchorpane
        anc01.getChildren().addAll(viewImage01, lb01, bt04, bt05, bt06);
//_________________________________________________________________________________________________________________________________________________________________________________
        //Fixed Deposit Tab

        //Anchor pane for fixed deposit
        AnchorPane anc02 = new AnchorPane();

        //Pane for number pad in fixed deposit
        Pane paneNum1 = NumberPad01();
        paneNum1.setLayoutX(10);
        paneNum1.setLayoutY(10);

        //Fixed deposit background image
        Image image02 = new Image("image02.png");
        ImageView viewImage02 = new ImageView();
        viewImage02.setImage(image02);
        viewImage02.setOpacity(0.6);
        viewImage02.setFitHeight(500);
        viewImage02.setFitWidth(700);

        //Label for fixed deposit tab topic
        Label lb02 = new Label("Fixed Deposit");
        lb02.setLayoutX(225);
        lb02.setLayoutY(20);
        lb02.setStyle("-fx-font-size: 42;-fx-text-alignment: center");

        //Initialization for user inputs
        Label lb02_01 = new Label("Principle Amount");
        lb02_01.setLayoutX(40);
        lb02_01.setLayoutY(110);
        lb02_01.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

        Label lb02_02 = new Label("Future Value");
        lb02_02.setLayoutX(40);
        lb02_02.setLayoutY(170);
        lb02_02.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

        Label lb02_03 = new Label("Interest Rate");
        lb02_03.setLayoutX(40);
        lb02_03.setLayoutY(230);
        lb02_03.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

        Label lb02_04 = new Label("Number of Months");
        lb02_04.setLayoutX(40);
        lb02_04.setLayoutY(290);
        lb02_04.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

        TextField tf02_01 = new TextField();
        tf02_01.setLayoutX(220);
        tf02_01.setLayoutY(110);
        tf02_01.setPrefWidth(150);
        //Event handling for the Calculations
        tf02_01.setOnMouseClicked(event -> {
            text1 = tf02_01;
        });

        TextField tf02_02 = new TextField();
        tf02_02.setLayoutX(220);
        tf02_02.setLayoutY(170);
        tf02_02.setPrefWidth(150);
        //Event handling for the Calculations
        tf02_02.setOnMouseClicked(event ->{
            text1 = tf02_02;
        });

        TextField tf02_03 = new TextField();
        tf02_03.setLayoutX(220);
        tf02_03.setLayoutY(230);
        tf02_03.setPrefWidth(150);
        //Event handling for the Calculations
        tf02_03.setOnMouseClicked(event ->{
            text1 = tf02_03;
        });

        TextField tf02_04 = new TextField();
        tf02_04.setLayoutX(220);
        tf02_04.setLayoutY(290);
        tf02_04.setPrefWidth(150);
        //Event handling for the Calculations
        tf02_04.setOnMouseClicked(event ->{
            text1 = tf02_04;
        });

        //button for calculate
        Button bt02_01 = new Button("Calculate");
        bt02_01.setLayoutX(540);
        bt02_01.setLayoutY(380);
        bt02_01.setStyle("-fx-font-size: 20;-fx-text-alignment: center");
        bt02_01.setPrefHeight(40);
        bt02_01.setPrefWidth(130);

        //Event handler for the calculate button
        bt02_01.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String text01 = tf02_01.getText();
                String text02 = tf02_02.getText();
                String text03 = tf02_03.getText();
                String text04 = tf02_04.getText();

                // p = Principle Amount
                // A = Future Value
                // r = Interest Rate
                // t = Number of Months
                // n = 12

                try {
                    //Principle amount calculation
                    if (text01.isEmpty()) {
                        double r = Double.parseDouble(text03);
                        double t = Double.parseDouble(text04);
                        double A = Double.parseDouble(text02);

                        double p = A / Math.pow((1 + r / (12 * 100)), (12 * t));

                        //Store data in the Database
                        Document document = new Document("Calculation", "Principle Amount")
                                .append("Result", String.format("%.2f",p));

                        col01.insertOne(document);

                        //Set text to text field
                        tf02_01.setText(String.valueOf(String.format("%.2f",p)));
                        tf02_01.setStyle("-fx-background-color: lightgreen");

                        //Future value calculation
                    } else if (text02.isEmpty()){
                        double r = Double.parseDouble(text03);
                        double t = Double.parseDouble(text04);
                        double p = Double.parseDouble(text01);

                        double A = p * Math.pow((1+r/(12 * 100)), (12*t));

                        //Store data in the Database
                        Document document = new Document("Calculation", "Future Value")
                                .append("Result", String.format("%.2f",A));

                        col01.insertOne(document);

                        //Set text to text field
                        tf02_02.setText(String.valueOf(String.format("%.2f",A)));
                        tf02_02.setStyle("-fx-background-color: lightgreen");

                        //rate calculation & error handling
                    } else if (text03.isEmpty()){
                        double A = Double.parseDouble(text02);
                        double t = Double.parseDouble(text04);
                        double p = Double.parseDouble(text01);

                        double r = 12 * (Math.pow(A/p, 1/(12*t)) - 1)* 100;

                        //Store data in the Database
                        Document document = new Document("Calculation", "Interest Rate")
                                .append("Result", String.format("%.2f",r));

                        col01.insertOne(document);

                        //Set text to text field
                        tf02_03.setText(String.valueOf(String.format("%.2f",r)));
                        tf02_03.setStyle("-fx-background-color: lightgreen");

                        //Time calculation
                    } else if (text04.isEmpty()){
                        double A = Double.parseDouble(text02);
                        double r = Double.parseDouble(text03);
                        double p = Double.parseDouble(text01);

                        double t = Math.log(A/p) / (12*(Math.log(1+(r/(12*100)))));

                        //Store data in the Database
                        Document document = new Document("Calculation", "Number of Months")
                                .append("Result", String.format("%.2f",t));

                        col01.insertOne(document);

                        //Set text to text field
                        tf02_04.setText(String.valueOf(String.format("%.0f",t)));
                        tf02_04.setStyle("-fx-background-color: lightgreen");
                    }
                    //error handling
                } catch (Exception e) {
                    Alert al02 = new Alert(Alert.AlertType.ERROR,"Incorrect data entry. Check again.",ButtonType.CLOSE);
                    al02.show();
                }
            }
        });

        //Get childrens to fixed deposit anchorpane
        anc02.getChildren().addAll(viewImage02, paneNum1, lb02, lb02_01, lb02_02, lb02_03, lb02_04, tf02_01, tf02_02, tf02_03, tf02_04, bt02_01);

        //___________________________________________________________________________________________________________________________________________________________________

        // AnchorPane for Savings
        AnchorPane anc03 = new AnchorPane();

        // Pane for number pade in savings
        Pane paneNum2 = NumberPad01();
        paneNum2.setLayoutX(10);
        paneNum2.setLayoutY(10);

        //Savings background image
        Image image03 = new Image("image03.png");
        ImageView viewImage03 = new ImageView();
        viewImage03.setImage(image03);
        viewImage03.setOpacity(0.7);
        viewImage03.setFitHeight(500);
        viewImage03.setFitWidth(700);

        //Label for savings tab topic
        Label lb03 = new Label("Savings");
        lb03.setLayoutX(280);
        lb03.setLayoutY(20);
        lb03.setStyle("-fx-font-size: 42;-fx-text-alignment: center");

        //Labels for user inputs
        Label lb03_01 = new Label("Present Value");
        lb03_01.setLayoutX(40);
        lb03_01.setLayoutY(110);
        lb03_01.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

        Label lb03_02 = new Label("Future Value");
        lb03_02.setLayoutX(40);
        lb03_02.setLayoutY(170);
        lb03_02.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

        Label lb03_03 = new Label("Monthly Payment");
        lb03_03.setLayoutX(40);
        lb03_03.setLayoutY(230);
        lb03_03.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

        Label lb03_04 = new Label("Interest Rate");
        lb03_04.setLayoutX(40);
        lb03_04.setLayoutY(290);
        lb03_04.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

        Label lb03_05 = new Label("Number of Months");
        lb03_05.setLayoutX(40);
        lb03_05.setLayoutY(350);
        lb03_05.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

        TextField tf03_01 = new TextField();
        tf03_01.setLayoutX(220);
        tf03_01.setLayoutY(110);
        tf03_01.setPrefWidth(150);
        //Event handling for the caculation
        tf03_01.setOnMouseClicked(event ->{
            text1 = tf03_01;
        });

        TextField tf03_02 = new TextField();
        tf03_02.setLayoutX(220);
        tf03_02.setLayoutY(170);
        tf03_02.setPrefWidth(150);
        //Event handling for the caculation
        tf03_02.setOnMouseClicked(event ->{
            text1 = tf03_02;
        });

        TextField tf03_03 = new TextField();
        tf03_03.setLayoutX(220);
        tf03_03.setLayoutY(230);
        tf03_03.setPrefWidth(150);
        //Event handling for the caculation
        tf03_03.setOnMouseClicked(event ->{
            text1 = tf03_03;
        });

        TextField tf03_04 = new TextField();
        tf03_04.setLayoutX(220);
        tf03_04.setLayoutY(290);
        tf03_04.setPrefWidth(150);
        //Event handling for the caculation
        tf03_04.setOnMouseClicked(event ->{
            text1 = tf03_04;
        });

        TextField tf03_05 = new TextField();
        tf03_05.setLayoutX(220);
        tf03_05.setLayoutY(350);
        tf03_05.setPrefWidth(150);
        //Event handling for the caculation
        tf03_05.setOnMouseClicked(event ->{
            text1 = tf03_05;
        });

        Button bt03_01 = new Button("Calculate");
        bt03_01.setLayoutX(540);
        bt03_01.setLayoutY(380);
        bt03_01.setStyle("-fx-font-size: 20;-fx-text-alignment: center");
        bt03_01.setPrefHeight(40);
        bt03_01.setPrefWidth(130);

        //Event handling for the caculate button
        bt03_01.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String text01 = tf03_01.getText();
                String text02 = tf03_02.getText();
                String text03 = tf03_03.getText();
                String text04 = tf03_04.getText();
                String text05 = tf03_05.getText();

                // p = Present Value
                // A = Future Value
                // pmt = Monthly Payment
                // r = Interest Rate
                // t = Number of Months
                // n = 12

                try {
                    //Calculation for the principle amount
                    if (text01.isEmpty()) {
                        double r = Double.parseDouble(text04);
                        double t = Double.parseDouble(text05);
                        double A = Double.parseDouble(text02);
                        double pmt = Double.parseDouble(text03);

                        //Formula
                        double p = (A - (pmt * ((Math.pow((1 + ((r/(100*12))/12)), 12 * t) - 1) / ((r/(100*12))/12))))/ (Math.pow((1 + ((r/(100*12))/12)), 12 * t));

                        //Store data in database
                        Document document = new Document("Calculation", "Principle Amount")
                                .append("Result", String.format("%.2f",p));

                        col01.insertOne(document);

                        //Set text in textfield
                        tf03_01.setText(String.valueOf(String.format("%.2f",p)));
                        tf03_01.setStyle("-fx-background-color: lightgreen");

                        //Calculaton for the future value
                    } else if (text02.isEmpty()){
                        double r = Double.parseDouble(text04);
                        double t = Double.parseDouble(text05);
                        double p = Double.parseDouble(text01);
                        double pmt = Double.parseDouble(text03);

                        // formula for calculate future value
                        double A =  (p * Math.pow((1 + ((r/(100*12)) / 12)), (12 * t))) + (pmt * ((Math.pow((1 + ((r/(100*12)) / 12)), (12 * t)) - 1) / ((r/(100*12))/12)));

                        //Store data in database
                        Document document = new Document("Calculation", "Future Value")
                                .append("Result", String.format("%.2f",A));

                        col01.insertOne(document);

                        //Set text in textfield
                        tf03_02.setText(String.valueOf(String.format("%.2f",A)));
                        tf03_02.setStyle("-fx-background-color: lightgreen");

                        //calculation for monthly payment
                    } else if (text03.isEmpty()){
                        double A = Double.parseDouble(text02);
                        double t = Double.parseDouble(text04);
                        double p = Double.parseDouble(text01);
                        double r = Double.parseDouble(text05);

                        //Formula for calculate future value
                        double pmt = (A - (p * Math.pow((1 + ((r/(100*12)) / 12)), (12 * t)))) / ((Math.pow((1 + ((r/(100*12)) / 12)), (12 * t)) - 1) / ((r/(100*12)) / 12));

                        //set text in textfield
                        tf03_03.setText(String.valueOf(String.format("%.2f",pmt)));
                        tf03_03.setStyle("-fx-background-color: lightgreen");

                        //calculation for interest rate
                    } else if (text04.isEmpty()){
                        double A = Double.parseDouble(text02);
                        double t = Double.parseDouble(text05);
                        double p = Double.parseDouble(text01);
                        double pmt = Double.parseDouble(text03);

                        //Formula for calculate rate
                        double r =  12 *(Math.pow((A / p), (1 / (12 * t)-1)));;

                        //Store data in database
                        Document document = new Document("Calculation", "Interest Rate")
                                .append("Result", String.format("%.2f",r));

                        col01.insertOne(document);

                        //set text in textfield
                        tf03_04.setText(String.valueOf(String.format("%.2f",r)));
                        tf03_04.setStyle("-fx-background-color: lightgreen");

                        //calculation for number of months
                    } else if (text05.isEmpty()){
                        double A = Double.parseDouble(text02);
                        double r = Double.parseDouble(text04);
                        double p = Double.parseDouble(text01);
                        double pmt = Double.parseDouble(text03);

                        //formula for calculate number of months
                        double t = Math.log((((((r/(100*12)) * p) / 12) + pmt) / (((p * (r/(100*12))) / 12) + pmt))) / (12 * Math.log(1 + ((r/(100*12))/12)));

                        //Store data in database
                        Document document = new Document("Calculation", "Number of Months")
                                .append("Result", String.format("%.2f",t));

                        col01.insertOne(document);

                        //Set text in textfild
                        tf03_05.setText(String.valueOf(String.format("%.0f",t)));
                        tf03_05.setStyle("-fx-background-color: lightgreen");
                    }
                }
                //error handling
                catch (Exception e) {
                    Alert al03 = new Alert(Alert.AlertType.ERROR,"Incorrect data entry. Check again.",ButtonType.CLOSE);
                    al03.show();
                }
            }
        });

        //add childrens for savings anchorpane
        anc03.getChildren().addAll(viewImage03, paneNum2, lb03, lb03_01, lb03_02, lb03_03, lb03_04, lb03_05, tf03_01, tf03_02, tf03_03, tf03_04, tf03_05, bt03_01);
//_______________________________________________________________________________________________________________________________________________________________________________
        //Loans

        //anchorpane for loans
        AnchorPane anc04 = new AnchorPane();

        //pane for number pad in loans
        Pane paneNum3 = NumberPad01();
        paneNum3.setLayoutX(10);
        paneNum3.setLayoutY(10);

        //loan tab background image
        Image image04 = new Image("image04.png");
        ImageView viewImage04 = new ImageView();
        viewImage04.setImage(image04);
        viewImage04.setOpacity(0.7);
        viewImage04.setFitHeight(500);
        viewImage04.setFitWidth(700);

        //loan tab topic label
        Label lb04 = new Label("Loans");
        lb04.setLayoutX(295);
        lb04.setLayoutY(20);
        lb04.setStyle("-fx-font-size: 42;-fx-text-alignment: center");

        Label lb04_01 = new Label("Principle Amount");
        lb04_01.setLayoutX(40);
        lb04_01.setLayoutY(110);
        lb04_01.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

        Label lb04_02 = new Label("Interest Rate");
        lb04_02.setLayoutX(40);
        lb04_02.setLayoutY(170);
        lb04_02.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

        Label lb04_03 = new Label("Monthly Payment");
        lb04_03.setLayoutX(40);
        lb04_03.setLayoutY(230);
        lb04_03.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

        Label lb04_04 = new Label("Number of Months");
        lb04_04.setLayoutX(40);
        lb04_04.setLayoutY(290);
        lb04_04.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

        TextField tf04_01 = new TextField();
        tf04_01.setLayoutX(220);
        tf04_01.setLayoutY(110);
        tf04_01.setPrefWidth(150);
        //event handler for set text
        tf04_01.setOnMouseClicked(event ->{
            text1 = tf04_01;
        });

        TextField tf04_02 = new TextField();
        tf04_02.setLayoutX(220);
        tf04_02.setLayoutY(170);
        tf04_02.setPrefWidth(150);
        //event handler for set text
        tf04_02.setOnMouseClicked(event ->{
            text1 = tf04_02;
        });

        TextField tf04_03 = new TextField();
        tf04_03.setLayoutX(220);
        tf04_03.setLayoutY(230);
        tf04_03.setPrefWidth(150);
        //event handler for set text
        tf04_03.setOnMouseClicked(event ->{
            text1 = tf04_03;
        });

        TextField tf04_04 = new TextField();
        tf04_04.setLayoutX(220);
        tf04_04.setLayoutY(290);
        tf04_04.setPrefWidth(150);
        //event handler for set text
        tf04_04.setOnMouseClicked(event ->{
            text1 = tf04_04;
        });

        Button bt04_01 = new Button("Calculate");
        bt04_01.setLayoutX(540);
        bt04_01.setLayoutY(380);
        bt04_01.setStyle("-fx-font-size: 20;-fx-text-alignment: center");
        bt04_01.setPrefHeight(40);
        bt04_01.setPrefWidth(130);
        //event handler for calcullate button
        bt04_01.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String text01 = tf04_01.getText();
                String text02 = tf04_02.getText();
                String text03 = tf04_03.getText();
                String text04 = tf04_04.getText();

                // p = Principle Amount
                // r = Interest Rate
                // pmt = Monthly Payment
                // t = Number of Months
                // n = 12

                try {
                    //calculation for principle amount
                    if (text01.isEmpty()) {
                        double r = Double.parseDouble(text02);
                        double t = Double.parseDouble(text04);
                        double pmt = Double.parseDouble(text03);

                        //formula for calculate principle amount
                        double p = (pmt / (r/(100*12))) * (1 - (1 / Math.pow((1 + (r/(100*12))), t)));

                        //connect with databse
                        Document document = new Document("Calculation", "Principle Amount")
                                .append("Result", String.format("%.2f",p));

                        col01.insertOne(document);

                        //set text in textfield
                        tf04_01.setText(String.valueOf(String.format("%.2f",p)));
                        tf04_01.setStyle("-fx-background-color: lightgreen");

                        //calculation for rate
                    } else if (text02.isEmpty())
                    //Error handler
                    {
                        Alert al02_01 = new Alert(Alert.AlertType.ERROR,"You can't calculate the Interest Rate using these formulas.",ButtonType.CLOSE);
                        tf04_01.clear();
                        tf04_03.clear();
                        tf04_04.clear();
                        al02_01.show();

                        //Calculation for monthly payment
                    } else if (text03.isEmpty()){
                        double r = Double.parseDouble(text02);
                        double t = Double.parseDouble(text04);
                        double p = Double.parseDouble(text01);

                        //formula for calculate monthly payment
                        double pmt = (p * (r/(100*12))) / (1 - (1 / Math.pow((1 + (r/(100*12))), t)));

                        //connect with database
                        Document document = new Document("Calculation", "Monthly Payment")
                                .append("Result", String.format("%.2f",pmt));

                        col01.insertOne(document);

                        //set text textfield
                        tf04_03.setText(String.valueOf(String.format("%.2f",pmt)));
                        tf04_03.setStyle("-fx-background-color: lightgreen");

                        //calculation for number of months
                    } else if (text04.isEmpty()){
                        double pmt = Double.parseDouble(text03);
                        double r = Double.parseDouble(text02);
                        double p = Double.parseDouble(text01);

                        //formula for calculate number of months
                        double t = Math.log((pmt / (r/(100*12))) / ((pmt / (r/(100*12))) - p)) / Math.log(1 + (r/(100*12)));

                        //connect with database
                        Document document = new Document("Calculation", "Number of Months")
                                .append("Result", String.format("%.2f",t));

                        col01.insertOne(document);

                        //set text in text field
                        tf04_04.setText(String.valueOf(String.format("%.0f",t)));
                        tf04_04.setStyle("-fx-background-color: lightgreen");
                    }
                    //error handler
                } catch (Exception e) {
                    Alert al04 = new Alert(Alert.AlertType.ERROR,"Incorrect data entry. Check again.",ButtonType.CLOSE);
                    al04.show();
                }
            }
        });

        //set childrens to loan anchorpane
        anc04.getChildren().addAll(viewImage04, paneNum3, lb04, lb04_01, lb04_02, lb04_03, lb04_04, tf04_01, tf04_02, tf04_03, tf04_04, bt04_01);
//____________________________________________________________________________________________________________________________________________________________
        //anchorpane for Mortgage
        AnchorPane anc05 = new AnchorPane();

        //pane numberpad in mortgage
        Pane paneNum4 = NumberPad01();
        paneNum4.setLayoutX(10);
        paneNum4.setLayoutY(10);

        //background image in mortgage
        Image image05 = new Image("image05.png");
        ImageView viewImage05 = new ImageView();
        viewImage05.setImage(image05);
        viewImage05.setOpacity(0.7);
        viewImage05.setFitHeight(500);
        viewImage05.setFitWidth(700);

        //label for mortgage tab topic
        Label lb05 = new Label("Mortgage");
        lb05.setLayoutX(260);
        lb05.setLayoutY(20);
        lb05.setStyle("-fx-font-size: 42;-fx-text-alignment: center");

        Label lb05_01 = new Label("Principle Amount");
        lb05_01.setLayoutX(40);
        lb05_01.setLayoutY(110);
        lb05_01.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

        Label lb05_02 = new Label("Down Payment");
        lb05_02.setLayoutX(40);
        lb05_02.setLayoutY(170);
        lb05_02.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

        Label lb05_03 = new Label("Interest");
        lb05_03.setLayoutX(40);
        lb05_03.setLayoutY(230);
        lb05_03.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

        Label lb05_04 = new Label("Monthly payment");
        lb05_04.setLayoutX(40);
        lb05_04.setLayoutY(290);
        lb05_04.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

        Label lb05_05 = new Label("Number of Months");
        lb05_05.setLayoutX(40);
        lb05_05.setLayoutY(350);
        lb05_05.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

        TextField tf05_01 = new TextField();
        tf05_01.setLayoutX(220);
        tf05_01.setLayoutY(110);
        tf05_01.setPrefWidth(150);
        //event handler for set text
        tf05_01.setOnMouseClicked(event ->{
            text1 = tf05_01;
        });

        TextField tf05_02 = new TextField();
        tf05_02.setLayoutX(220);
        tf05_02.setLayoutY(170);
        tf05_02.setPrefWidth(150);
        //event handler for set text
        tf05_02.setOnMouseClicked(event ->{
            text1 = tf05_02;
        });

        TextField tf05_03 = new TextField();
        tf05_03.setLayoutX(220);
        tf05_03.setLayoutY(230);
        tf05_03.setPrefWidth(150);
        //event handler for set text
        tf05_03.setOnMouseClicked(event ->{
            text1 = tf05_03;
        });

        TextField tf05_04 = new TextField();
        tf05_04.setLayoutX(220);
        tf05_04.setLayoutY(290);
        tf05_04.setPrefWidth(150);
        //event handler for set text
        tf05_04.setOnMouseClicked(event ->{
            text1 = tf05_04;
        });

        TextField tf05_05 = new TextField();
        tf05_05.setLayoutX(220);
        tf05_05.setLayoutY(350);
        tf05_05.setPrefWidth(150);
        //event handler for set text
        tf05_05.setOnMouseClicked(event ->{
            text1 = tf05_05;
        });

        Button bt05_01 = new Button("Calculate");
        bt05_01.setLayoutX(540);
        bt05_01.setLayoutY(380);
        bt05_01.setStyle("-fx-font-size: 20;-fx-text-alignment: center");
        bt05_01.setPrefHeight(40);
        bt05_01.setPrefWidth(130);

        //button for calculation in mortgage
        bt05_01.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String text01 = tf05_01.getText();
                String text02 = tf05_02.getText();
                String text03 = tf05_03.getText();
                String text04 = tf05_04.getText();
                String text05 = tf05_05.getText();

                // p = Principle Amount
                // r = Interest Rate
                // pmt = Monthly Payment
                // t = Number of Months
                // dpmt = Down Payment
                // n = 12

                try {
                    //calculation for principle payment
                    if (text01.isEmpty()) {
                        double r = Double.parseDouble(text03);
                        double t = Double.parseDouble(text05);
                        double pmt = Double.parseDouble(text04);
                        double dpmt = Double.parseDouble(text02);

                        //formula for calculate principle amount
                        double p = dpmt + ((12 * pmt * (Math.pow((1 + ((r/(100*12)) / 12)), (12 * t)) - 1)) / ((r/(100*12)) * Math.pow((1 + ((r/(100*12)) / 12)), (12 * t))));

                        Document document = new Document("Calculation", "Principle Amount")
                                .append("Result", String.format("%.2f",p));

                        col01.insertOne(document);

                        //set text in textfield
                        tf05_01.setText(String.valueOf(String.format("%.2f",p)));
                        tf05_01.setStyle("-fx-background-color: lightgreen");

                        //calculation for rate
                    } else if (text03.isEmpty())
                    //error handling
                    {
                        Alert al03_01 = new Alert(Alert.AlertType.ERROR,"Invalid input",ButtonType.CLOSE);
                        tf05_01.clear();
                        tf05_02.clear();
                        tf05_04.clear();
                        tf05_05.clear();
                        al03_01.show();
                    }
                    //calculation for monthly payment
                     else if (text04.isEmpty()){
                        double r = Double.parseDouble(text03);
                        double t = Double.parseDouble(text05);
                        double p = Double.parseDouble(text01);
                        double dpmt = Double.parseDouble(text02);

                        //formula for calculate monthly payment
                        double pmt = ((p-dpmt)*((r/(100*12))/12)*Math.pow(1+((r/(100*12))/12),12*t))/(Math.pow(1+((r/(100*12))/12),12*t)-1);

                        //store data in database
                        Document document = new Document("Calculation", "Monthly Payment")
                                .append("Result", String.format("%.2f",pmt));

                        col01.insertOne(document);

                        //set text in textfield
                        tf05_04.setText(String.valueOf(String.format("%.2f",pmt)));
                        tf05_04.setStyle("-fx-background-color: lightgreen");

                        //calculation for number of month
                    } else if (text05.isEmpty()){
                        double pmt = Double.parseDouble(text04);
                        double r = Double.parseDouble(text03);
                        double p = Double.parseDouble(text01);
                        double dpmt = Double.parseDouble(text02);

                        //formula for calculate number of month
                        double t = (Math.log((pmt / (pmt - (((r/(100*12))/12) * (p - dpmt)))))) /  (12 * Math.log(1 + ((r/(100*12))/12)));

                        //store data in database
                        Document document = new Document("Calculation", "Number of Months")
                                .append("Result", String.format("%.2f",t));

                        col01.insertOne(document);

                        //set text in text field
                        tf05_05.setText(String.valueOf(String.format("%.0f",t)));
                        tf05_05.setStyle("-fx-background-color: lightgreen");

                        //calculation for down payment
                     } else if (text02.isEmpty()){
                        double pmt = Double.parseDouble(text04);
                        double t = Double.parseDouble(text05);
                        double p = Double.parseDouble(text01);
                        double r = Double.parseDouble(text03);

                        //formula to calculate down payment
                        double dpmt = p - ((12 * pmt * (Math.pow((1 + ((r/(100*12)) / 12)), 12 * t) - 1)) / ((r/(100*12)) * Math.pow((1 + ((r/(100*12)) / 12)), 12 * t)));

                        //store data in database
                        Document document = new Document("Calculation", "Down Payment")
                                .append("Result", String.format("%.2f",dpmt));

                        col01.insertOne(document);

                        //set text in text field
                        tf05_02.setText(String.valueOf(String.format("%.2f",dpmt)));
                        tf05_02.setStyle("-fx-background-color: lightgreen");
                    }
                } catch (Exception e)
                //error handler
                {
                    Alert al05 = new Alert(Alert.AlertType.ERROR,"Invalid input.",ButtonType.CLOSE);
                    al05.show();
                }
            }
        });

        //add childrens for mortgage anchorpane
        anc05.getChildren().addAll(viewImage05, paneNum4, lb05, lb05_01, lb05_02, lb05_03, lb05_04, lb05_05,tf05_01, tf05_02, tf05_03, tf05_04, tf05_05, bt05_01);

//_____________________________________________________________________________________________________________________________________________________________________________________________________

        //Create tabs in tabpane
        TabPane tabPane = new TabPane();
        //home tab
        Tab tab1 = new Tab("Home", anc01);
        //fixed deposit tab
        Tab tab2 = new Tab("Fixed Deposit", anc02);
        //savings tab
        Tab tab3 = new Tab("Savings", anc03);
        //loans tab
        Tab tab4 = new Tab("Loans", anc04);
        //mortgage tab
        Tab tab5 = new Tab("Mortgage", anc05);

        //add childrens to tabpane
        tabPane.getTabs().addAll(tab1, tab2, tab3, tab4, tab5);

        //event handler for the Exit button
        bt06.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) bt06.getScene().getWindow();
                stage.close();
            }
        });
//______________________________________________________________________________________________________________________________________________________________________

        //Help

        //event handler for help
        bt05.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // initializehelp stage
                Stage stageHelp = (Stage) bt05.getScene().getWindow();

                Label labelH1 = new Label("The following home page allows you to use History & Help. ") ;
                Label labelH1_1 = new Label("You can completely exit the system by pressing the Exit button");

                Image imageH01 = new Image("imageHelp01.png");
                ImageView viewHelp01 = new ImageView();
                viewHelp01.setImage(imageH01);
                viewHelp01.setFitHeight(400);
                viewHelp01.setFitWidth(550);

                Label labelH2 = new Label("After filling in any three sections you know, You can find the unknown section by pressing calculate button.");

                Image imageH02 = new Image("imageHelp02.png");
                ImageView viewHelp02 = new ImageView();
                viewHelp02.setImage(imageH02);
                viewHelp02.setFitHeight(400);
                viewHelp02.setFitWidth(550);

                Label labelH3 = new Label("Here you can perform the calculations for the Savings as above.");

                Image imageH03 = new Image("imageHelp03.png");
                ImageView viewHelp03 = new ImageView();
                viewHelp03.setImage(imageH03);
                viewHelp03.setFitHeight(400);
                viewHelp03.setFitWidth(550);

                Label labelH4 = new Label("Here you can perform the calculations for the Loans as above.");

                Image imageH04 = new Image("imageHelp04.png");
                ImageView viewHelp04 = new ImageView();
                viewHelp04.setImage(imageH04);
                viewHelp04.setFitHeight(400);
                viewHelp04.setFitWidth(550);

                Label labelH5 = new Label("Here you can perform the calculations for the Mostgage as above.");

                Image imageH05 = new Image("imageHelp05.png");
                ImageView viewHelp05 = new ImageView();
                viewHelp05.setImage(imageH05);
                viewHelp05.setFitHeight(400);
                viewHelp05.setFitWidth(550);

                //store images & labels in vbox
                VBox vBox = new VBox();
                vBox.getChildren().addAll(labelH1,labelH1_1,viewHelp01,labelH2,viewHelp02,labelH3,viewHelp03,labelH4,viewHelp04,labelH5,viewHelp05);

                //Add scrollpane
                ScrollPane scrollPane = new ScrollPane();
                scrollPane.setContent(vBox);

                //back button
                Button buttonHelp = new Button("Back");
                buttonHelp.setPrefWidth(100);
                buttonHelp.setPrefHeight(40);
                buttonHelp.setStyle("-fx-background-color: #E9967A");
                //event handler for back button
                buttonHelp.setOnAction(event1 -> {
                    stageHelp.close();
                    stageHome.show();
                });

                //add boderpane
                BorderPane paneHelp = new BorderPane();
                paneHelp.setCenter(scrollPane);
                paneHelp.setBottom (buttonHelp);

                //link boderpane with help stage
                stageHelp.setScene(new Scene(paneHelp, 750, 700));
                stageHelp.setTitle("Help");
                stageHelp.show();
            }
        });
//________________________________________________________________________________________________________________________________

        //History

        //event handler for history button
        bt04.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //connect history stage withhistory button
                Stage stageHistory = (Stage) bt04.getScene().getWindow();

                //link with mongodb Database
                FindIterable<Document> iterDoc1 = col01.find();
                VBox vBox1 = new VBox();

                for (Document record : iterDoc1) {
                    String calc = (String) record.get("Calculation");
                    String result = (String) record.get("Result");

                    Label label = new Label("Calculation - " + calc + " , " + "Result - " +result);

                    //add data to vbox
                    vBox1.getChildren().addAll(label, new Label(" "));
                }
                    //addscrllpane
                    ScrollPane scrollPane1 = new ScrollPane();
                    scrollPane1.setContent(vBox1);

                //back button in history
                Button buttonHistory = new Button("Back");
                buttonHistory.setPrefWidth(100);
                buttonHistory.setPrefHeight(40);
                buttonHistory.setStyle("-fx-background-color: #E9967A");
                //event handler for history back button
                buttonHistory.setOnAction(event1 -> {
                    stageHistory.close();
                    stageHome.show();

                });

                //add new border pane & connect with scrollpane
                BorderPane bpaneHistory = new BorderPane();
                bpaneHistory.setCenter(scrollPane1);
                bpaneHistory.setBottom (buttonHistory);

                //set new scene for history
                stageHistory.setScene(new Scene(bpaneHistory, 750, 500));
                stageHistory.setTitle("History");
                stageHistory.show();
            }
        });

        stageHome.setScene(new Scene(tabPane, 680, 520));
        stageHome.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
//__________________________________________________________________________________________________________________________________________________________

    //Number pad

    public Pane NumberPad01() {

        //create new pane for number pad
        Pane ancKey = new Pane();
        ancKey.setPrefHeight(250);
        ancKey.setPrefWidth(260);
        ancKey.setLayoutX(440);
        ancKey.setLayoutY(100);

        //initialize number buttons
        Button cal01 = new Button("1");
        cal01.setLayoutX(440);
        cal01.setLayoutY(100);
        cal01.setStyle("-fx-font-size:22;-fx-text-alignment: center;-fx-background-radius: 23;-fx-background-color: aqua");
        //event handler for number buttons
        cal01.setOnAction(event -> {
            text1.appendText("1");
        });

        Button cal02 = new Button("2");
        cal02.setLayoutX(520);
        cal02.setLayoutY(100);
        cal02.setStyle("-fx-font-size:22;-fx-text-alignment: center;-fx-background-radius: 23;-fx-background-color: aqua");
        //event handler for number buttons
        cal02.setOnAction(event -> {
            text1.appendText("2");
        });

        Button cal03 = new Button("3");
        cal03.setLayoutX(600);
        cal03.setLayoutY(100);
        cal03.setStyle("-fx-font-size:22;-fx-text-alignment: center;-fx-background-radius: 23;-fx-background-color: aqua");
        //event handler for number buttons
        cal03.setOnAction(event -> {
            text1.appendText("3");
        });

        Button cal04 = new Button("4");
        cal04.setLayoutX(440);
        cal04.setLayoutY(170);
        cal04.setStyle("-fx-font-size:22;-fx-text-alignment: center;-fx-background-radius: 23;-fx-background-color: aqua");
        //event handler for number buttons
        cal04.setOnAction(event -> {
            text1.appendText("4");
        });

        Button cal05 = new Button("5");
        cal05.setLayoutX(520);
        cal05.setLayoutY(170);
        cal05.setStyle("-fx-font-size:22;-fx-text-alignment: center;-fx-background-radius: 23;-fx-background-color: aqua");
        //event handler for number buttons
        cal05.setOnAction(event -> {
            text1.appendText("5");
        });

        Button cal06 = new Button("6");
        cal06.setLayoutX(600);
        cal06.setLayoutY(170);
        cal06.setStyle("-fx-font-size:22;-fx-text-alignment: center;-fx-background-radius: 23;-fx-background-color: aqua");
        //event handler for number buttons
        cal06.setOnAction(event -> {
            text1.appendText("6");
        });

        Button cal07 = new Button("7");
        cal07.setLayoutX(440);
        cal07.setLayoutY(240);
        cal07.setStyle("-fx-font-size:22;-fx-text-alignment: center;-fx-background-radius: 23;-fx-background-color: aqua");
        //event handler for number buttons
        cal07.setOnAction(event -> {
            text1.appendText("7");
        });

        Button cal08 = new Button("8");
        cal08.setLayoutX(520);
        cal08.setLayoutY(240);
        cal08.setStyle("-fx-font-size:22;-fx-text-alignment: center;-fx-background-radius: 23;-fx-background-color: aqua");
        //event handler for number buttons
        cal08.setOnAction(event -> {
            text1.appendText("8");
        });

        Button cal09 = new Button("9");
        cal09.setLayoutX(600);
        cal09.setLayoutY(240);
        cal09.setStyle("-fx-font-size:22;-fx-text-alignment: center;-fx-background-radius: 23;-fx-background-color: aqua");
        //event handler for number buttons
        cal09.setOnAction(event -> {
            text1.appendText("9");
        });

        Button cal10 = new Button(".");
        cal10.setLayoutX(440);
        cal10.setLayoutY(310);
        cal10.setStyle("-fx-font-size:22;-fx-text-alignment: center;-fx-background-radius: 23;-fx-background-color: aqua");
        //event handler for number buttons
        cal10.setOnAction(event -> {
            text1.appendText(".");
        });

        Button cal11 = new Button("0");
        cal11.setLayoutX(520);
        cal11.setLayoutY(310);
        cal11.setStyle("-fx-font-size:22;-fx-text-alignment: center;-fx-background-radius: 23;-fx-background-color: aqua");
        //event handler for number buttons
        cal11.setOnAction(event -> {
            text1.appendText("0");
        });

        Button cal12 = new Button("C");
        cal12.setLayoutX(600);
        cal12.setLayoutY(310);
        cal12.setStyle("-fx-font-size:22;-fx-text-alignment: center;-fx-background-radius: 16;-fx-background-color: aqua");
        //event handler for number buttons
        cal12.setOnAction(event -> {
            text1.clear();
        });
        //add cheldrens to numberpand anchorpane & return it
        ancKey.getChildren().addAll(cal01,cal02,cal03,cal04,cal05,cal06,cal07,cal08,cal09,cal10,cal11,cal12);
        return ancKey;
    }
}