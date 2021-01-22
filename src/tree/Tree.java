package tree;

import java.awt.Component;

import javax.swing.JOptionPane;

/**
 * @author Sabrina
 *
 */
public class Tree {

	protected Node root;

	public Tree() {
		root = null;
	}

	public Node init() {
		final String ROOT = "massa";
		final String LEFT = "Lasanha";
		final String RIGHT = "Bolo de Chocolate";

		Node childLeft = new Node(LEFT, null, null);
		Node childRight = new Node(RIGHT, null, null);

		root = new Node(ROOT, childLeft, childRight);

		return root;
	}

	/* Tenta adivinhar o prato, percorrendo a árvore */
	public void play(Node node) {
		JOptionPane.showMessageDialog(null, "Pense num prato que gosta", "Jogo Teste Sabrina",
				JOptionPane.INFORMATION_MESSAGE);

		while (!node.isLeaf()) {
			if (askQuestion("O prato que você pensou é " + node.getValue() + "?")) {
				node = node.getLeft();
			} else {
				node = node.getRight();
			}
		}

		if (!askQuestion("O prato que você pensou é " + node.getValue() + "?")) {
			addNodes(node);
		} else {
			JOptionPane.showMessageDialog(null, "Acertei de novo!");
		}

	}

	/* Mostra a pergunta */
	public boolean askQuestion(String prompt) {
		String answer = null;
		Component frame = null;
		int i = JOptionPane.showConfirmDialog(frame, prompt, "Confirm", JOptionPane.YES_NO_OPTION);
		if (i == 0) {
			answer = "Y";
		}
		if (i == 1) {
			answer = "N";
		}
		return answer.startsWith("Y");
	}

	public void addNodes(Node node) {
		String chosenFood;

		String guessFood = node.getValue();

		String name = JOptionPane.showInputDialog(null, "Qual prato você pensou?", "Desisto",
				JOptionPane.QUESTION_MESSAGE);
		if (name == null || name.equals("")) {
			System.exit(0);
		}
		chosenFood = name;
		String question = JOptionPane.showInputDialog(null, chosenFood + " é ______ mas " + guessFood + " não.",
				"Complete", JOptionPane.QUESTION_MESSAGE);
		if (question == null || question.equals("")) {
			System.exit(0);
		}

		node.setRight(new Node(question, null, null));
		node.setLeft(new Node(guessFood, null, null));

		node.setValue(question);
		node.setLeft(new Node(chosenFood, null, null));
		node.setRight(new Node(guessFood, null, null));
		// print();
	}

	void print() {
		printTree(root);
	}

	private void printTree(Node root) {
		if (root != null) {
			System.out.println(root.getValue());
			printTree(root.getLeft());
			printTree(root.getRight());
		}
	}

}
