package tree;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.add(10, 0);
        tree.add(11, 0);
        tree.add(7, 0);
        tree.add(6, 0);
        tree.add(8, 0);
        tree.add(12, 0);

        tree.delete(6);
        tree.printLeft();//Симетричний обход

        tree.printRight();//Обратный обход

        tree.print();//Прямой обход
    }

}
