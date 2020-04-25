/*
 *       Filename:  BollaRebotant0.java
 *
 *    Description:  
 *
 *        Created:  25 d’abr. 2020
 *       Revision:  none
 *
 *        @Author:  xavier - xavier.sastre@cide.es
 *       @Version:  1.0
 *
 * =====================================================================================
 */
package cide.dam.pr20192020.javaFX;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BollaRebotant0 extends Application {

    public static Circle cercle;
    public static Pane canvas;

    @Override
    public void start(final Stage primaryStage) {

        canvas = new Pane();
        final Scene escena = new Scene(canvas, 400, 400);

        primaryStage.setTitle("Bolla Rebotant");
        primaryStage.setScene(escena);
        primaryStage.show();

        cercle = new Circle(15, Color.BLUE);
        cercle.relocate(100, 100);

        canvas.getChildren().addAll(cercle);

        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {

            double deltaX = 3;
            double deltaY = 3;

            @Override
            public void handle(final ActionEvent t) {
                cercle.setLayoutX(cercle.getLayoutX() + deltaX);
                cercle.setLayoutY(cercle.getLayoutY() + deltaY);

                final Bounds limits = canvas.getBoundsInLocal();
                final boolean alLimitDret = cercle.getLayoutX() >= (limits.getMaxX() - cercle.getRadius()-deltaX);
                final boolean alLimitEsquerra = cercle.getLayoutX() <= (limits.getMinX() + cercle.getRadius()-deltaX);
                final boolean alLimitInferior = cercle.getLayoutY() >= (limits.getMaxY() - cercle.getRadius()-deltaY);
                final boolean alLimitSuperior = cercle.getLayoutY() <= (limits.getMinY() + cercle.getRadius()-deltaY);

                if (alLimitDret || alLimitEsquerra) {
                	// Delta aleatori
                	// Multiplicam pel signe de deltaX per mantenir la trajectoria
                	deltaX = Math.signum(deltaX)*(int)(Math.random()*10+1);
                    deltaX *= -1;
                 }
                if (alLimitInferior || alLimitSuperior) {
                	// Delta aleatori
                	// Multiplicam pel signe de deltaX per mantenir la trajectoria
                	deltaY = Math.signum(deltaY)*(Math.random()*10+1);
                    deltaY *= -1;
                }
            }
        }));

        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
    }

    public static void main(final String[] args) {
        launch(args);
    }
}