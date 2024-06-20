public class Node {
    
    private int data;
    private String color;
    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
        this.color = "RED";
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
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

    public void changeColor() {
        if (this.color.equals("RED")) {
            this.color = "BLACK";
        } else {
            this.color = "RED";
        }
    }

}
