package tree;

public class BinaryTree {
    private static class Node {
        int key;
        Object value;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }

        public Node(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Node(int key, Object value, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

    private Node root;

    public void add(int key, Object value) {
        // первый элемент?
        if (root == null) {
            root = new Node(key, value);
        } else { // это не первый элемент и нужно найти место вставки
            Node found = findNode(root, key);
            if (found == null) return;
            if (key > found.key) {
                found.right = new Node(key, value);
            } else if (key < found.key) {
                found.left = new Node(key, value);
            } else {
                found.value = value;
            }
        }
    }

    private Node findNode(Node cur, int key) {
        if (key > cur.key) { // добавляем в право
            if (cur.right == null) {
                return cur;
            } else {
                return findNode(cur.right, key);
            }
        } else if (key < cur.key) {
            if (cur.left == null) {
                return cur;
            } else {
                return findNode(cur.left, key);
            }
        } else {
            return cur;
        }
    }

    private Node find(Node cur, int key) {
        if (cur == null) return null;
        if (key > cur.key) { // добавляем в право
            return find(cur.right, key);
        } else if (key < cur.key) {
            return find(cur.left, key);
        } else {
            return cur;
        }
    }

    public Object find(int key) {
        Node found = find(root, key);
        return found != null ? found.value : null;
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private Node delete(Node current, int key) {
        if (current == null) {
            return null;
        }
        else if (key == current.key) {
            if (current.left == null && current.right == null) {
                return null;
            }
            else if (current.right == null) {
                return current.left;
            }
            else if (current.left == null) {
                return current.right;
            }
            else{
                int smallestValue = findSmallestValue(current.right);
                current.key = smallestValue;
                current.right = delete(current.right, smallestValue);
                return current;
            }
        }
        else if (key < current.key) {
            current.left = delete(current.left, key);
            return current;
        }
        else {
            current.right = delete(current.right, key);
            return current;
        }
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.key : findSmallestValue(root.left);
    }

    public void printLeft() { //Симетричний обход
        printLeft(root);
    }

    private void printLeft(Node cur) { //Симетричний обход
        if(cur != null){
            if(cur.left != null){
                printLeft(cur.left);
            }

            System.out.println(cur.key);

            if(cur.right != null){
                printLeft(cur.right);
            }
        }else{
            System.out.println("Null");
        }
    }

    public void printRight() { //Обратный обход
        printRight(root);
    }

    private void printRight(Node cur) { //Обратный обход
        if(cur != null){
            if(cur.left != null){
                printRight(cur.left);
            }

            if(cur.right != null){
                printRight(cur.right);
            }

            System.out.println(cur.key);
        }else{
            System.out.println("Null");
        }
    }

    public void print() { // Прямой обход
        print(root);
    }

    private void print(Node cur) { // Прямой обход
        if(cur != null){
            System.out.println(cur.key);
            if(cur.left != null){
                print(cur.left);
            }

            if(cur.right != null){
                print(cur.right);
            }
        }else {
            System.out.println("Null");
        }
    }
}
