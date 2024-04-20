import model.Tree;

public class Main {
    public static void main(String[] args) {
        Tree tree = null;
        tree = new Tree(5);

        System.out.print(tree.str());
        System.out.println(" " + tree.str().equals(new String("5")));

        tree = new Tree(5);

        Tree left = new Tree(2);
        left.setLeft(new Tree(-4));
        left.setRight(new Tree(3));
        tree.setLeft(left);

        tree.setRight(new Tree(18));

        System.out.print(tree.str());
        System.out.println(" " + tree.str().equals(new String("-4 2 3 5 18")));

        System.out.print(tree.getLeft().str());
        System.out.println(" " + tree.getLeft().str().equals(new String("-4 2 3")));
        
        System.out.print(tree.getRight().str());
        System.out.println(" " + tree.getRight().str().equals(new String("18")));

        tree.insertValue(1);
        System.out.print(tree.str());
        System.out.println(" " + tree.str().equals(new String("-4 1 2 3 5 18")));

        System.out.println(tree.contains(1));
        System.out.println(tree.contains(0));

    }
}
