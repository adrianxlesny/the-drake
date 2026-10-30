module com.adrianxlesny.thedrake {
	requires javafx.controls;
	requires javafx.fxml;

	opens com.adrianxlesny.thedrake to javafx.fxml;
	exports com.adrianxlesny.thedrake;
}