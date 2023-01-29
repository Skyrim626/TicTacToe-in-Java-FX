module TicTacToe_Final {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.media;
	requires java.desktop;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
}
