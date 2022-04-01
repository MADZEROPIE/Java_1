package com.example.demo;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import org.jetbrains.annotations.NotNull;

public class MyTimer {
    int time_left;
    Thread th;
    String message;
    boolean running = false;
    public void setTime_left(@NotNull Double _time_left){
        time_left = _time_left.intValue();
        System.out.println(time_left);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void startTimer(Label l, Slider sl) {
        if (!running) {
            th = new Thread(
                    ()->{
                        try{
                            running = true;
                            while (time_left>0){
                                System.out.println("Time left"+time_left);
                                --time_left;
                                Thread.sleep(500);
                                Platform.runLater(()->sl.setValue(time_left));

                            }
                            if (time_left == 0) {
                                Platform.runLater(()->l.setText(message));
                                running = false;
                            }
                        } catch (InterruptedException ex) {
                            System.out.println("Interrupted");
                            Platform.runLater(()->l.setText("Interrupted"));
                        }
                    }
            );
        }
        th.start();
    }
    public void stop_timer() {
        if (th != null && running) {
            th.interrupt();
        }
        running = false;
    }
}
