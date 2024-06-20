public class Node {
    
    private Node father;
    private int data;
    private String color;
    private Node left;
    private Node right;

    public Node(int data, Node father) {
        this.father = father;
        this.data = data;
        this.color = "RED";
        this.left = null;
        this.right = null;
    }

    public Node getFather() {
        return father;
    }
    public void setFather(Node father) {
        this.father = father;
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

    //Aun dudo si debe ir aqui
    public void changeColor() {
        if (this.color.equals("RED")) {
            this.color = "BLACK";
        } else {
            this.color = "RED";
        }
    }

}
