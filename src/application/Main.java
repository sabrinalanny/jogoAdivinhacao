package application;

import javafx.application.Application;
import javafx.stage.Stage;
import tree.Node;
import tree.Tree;

/**
 * @author Sabrina
 *
 */
public class Main extends Application {

	Tree guessTree;

	@Override
	public void start(Stage primaryStage) {
		try {
			guessTree = new Tree();
			Node root = guessTree.init();

			while (true) {
				guessTree.play(root);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
