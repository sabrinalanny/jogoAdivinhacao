package tree;

/**
 * @author Sabrina
 *
 */
public class Node {

	private String value;
	private Node left;
	private Node right;

	public Node(String value) {
		this.value = value;
	}

	public Node(String value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public boolean isLeaf() {
		return (left == null) && (right == null);
	}

}