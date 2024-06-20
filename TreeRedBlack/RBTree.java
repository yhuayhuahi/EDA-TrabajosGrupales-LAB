public class RBTree {

    private Node root;
    private final Node TNULL;

    public RBTree() {
        TNULL = new Node(0, null);
        TNULL.setColor("BLACK");
        root = TNULL;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void insert(int key) {
        Node node = new Node(key, null);
        node.setLeft(TNULL);
        node.setRight(TNULL);
        node.setColor("RED");

        Node parent = null;
        Node current = root;

        while (current != TNULL) {
            parent = current;
            if (node.getData() < current.getData()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        node.setFather(parent);
        if (parent == null) {
            root = node;
        } else if (node.getData() < parent.getData()) {
            parent.setLeft(node);
        } else {
            parent.setRight(node);
        }

        if (node.getFather() == null) {
            node.setColor("BLACK");
            return;
        }

        if (node.getFather().getFather() == null) {
            return;
        }

        fixInsert(node);
    }

    private void fixInsert(Node k) {
        Node uncle;
        while (k.getFather().getColor().equals("RED")) {
            if (k.getFather() == k.getFather().getFather().getRight()) {
                uncle = k.getFather().getFather().getLeft();
                if (uncle.getColor().equals("RED")) {
                    uncle.setColor("BLACK");
                    k.getFather().setColor("BLACK");
                    k.getFather().getFather().setColor("RED");
                    k = k.getFather().getFather();
                } else {
                    if (k == k.getFather().getLeft()) {
                        k = k.getFather();
                        rightRotate(k);
                    }
                    k.getFather().setColor("BLACK");
                    k.getFather().getFather().setColor("RED");
                    leftRotate(k.getFather().getFather());
                }
            } else {
                uncle = k.getFather().getFather().getRight();
                if (uncle.getColor().equals("RED")) {
                    uncle.setColor("BLACK");
                    k.getFather().setColor("BLACK");
                    k.getFather().getFather().setColor("RED");
                    k = k.getFather().getFather();
                } else {
                    if (k == k.getFather().getRight()) {
                        k = k.getFather();
                        leftRotate(k);
                    }
                    k.getFather().setColor("BLACK");
                    k.getFather().getFather().setColor("RED");
                    rightRotate(k.getFather().getFather());
                }
            }
            if (k == root) {
                break;
            }
        }
        root.setColor("BLACK");
    }

    private void leftRotate(Node x) {
        Node y = x.getRight();
        x.setRight(y.getLeft());
        if (y.getLeft() != TNULL) {
            y.getLeft().setFather(x);
        }
        y.setFather(x.getFather());
        if (x.getFather() == null) {
            root = y;
        } else if (x == x.getFather().getLeft()) {
            x.getFather().setLeft(y);
        } else {
            x.getFather().setRight(y);
        }
        y.setLeft(x);
        x.setFather(y);
    }

    private void rightRotate(Node x) {
        Node y = x.getLeft();
        x.setLeft(y.getRight());
        if (y.getRight() != TNULL) {
            y.getRight().setFather(x);
        }
        y.setFather(x.getFather());
        if (x.getFather() == null) {
            root = y;
        } else if (x == x.getFather().getRight()) {
            x.getFather().setRight(y);
        } else {
            x.getFather().setLeft(y);
        }
        y.setRight(x);
        x.setFather(y);
    }
}
