/**
 * 
 */
/**
 * @author admin
 *
 */

module AimsProject {
	requires java.desktop;
	requires javafx.swing;
	requires javafx.fxml;
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires javafx.base;
	exports hust.soict.hedspi.aims.screen;
	exports hust.soict.hedspi.aims.media;
	exports hust.soict.hedspi.aims;
	opens hust.soict.hedspi.aims.screen to javafx.fxml;
	opens hust.soict.hedspi.aims.media to javafx.base;
	opens hust.soict.hedspi.aims to javafx.graphics;
}