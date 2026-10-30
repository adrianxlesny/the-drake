package com.adrianxlesny.thedrake;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TheDrakeApp extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(TheDrakeApp.class.getResource("TheDrakeView.fxml"));
		stage.setScene(new Scene(fxmlLoader.load()));
		stage.setTitle("The Drake");
		stage.show();
	}
}