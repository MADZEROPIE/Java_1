package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Slider my_slider;
    @FXML
    private TextArea textArea;

    private MyTimer my_timer;


    @FXML
    protected void onHelloButtonClick() {
        my_timer = new MyTimer();
        my_timer.setTime_left(my_slider.getValue());
        welcomeText.setText("");
        my_timer.setMessage(textArea.getText());
        my_timer.startTimer(welcomeText, my_slider);
    }

    @FXML
    protected void onButtonClick() {
        my_timer.stop_timer();
    }

}