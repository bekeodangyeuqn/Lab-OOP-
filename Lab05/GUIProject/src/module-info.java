/**
 * 
 */
/**
 * @author admin
 *
 */
module GUIProject {
	requires java.desktop;
	requires javafx.base;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.controls;
	
	exports hust.soict.hedspi.javafx;
	opens hust.soict.hedspi.javafx to javafx.graphics, javafx.fxml;
}