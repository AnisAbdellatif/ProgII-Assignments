package model;

public class Tree {
    private int value;
    private Tree left;
    private Tree right;

    public Tree(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return value;
    }

    public Tree getLeft() {
        return left;
    }

    public Tree getRight() {
        return right;
    }

    public void setLeft(Tree left) {
        if (left.getValue() > this.value) {
            System.err.println("Left child value is bigger than parent value");
            return;
        }
        this.left = left;
    }

    public void setRight(Tree right) {
        if (right.getValue() < this.value) {
            System.err.println("Right child value is less than parent value");
            return;
        }
        this.right = right;
    }

    public String str() {
        if (left == null && right == null) {
            return String.valueOf(value);
        }
        String in_order = "";
        if (left != null) {
            in_order += left.str() + " ";
        }
        in_order += value;
        if (right != null) {
            in_order += " " + right.str();
        }
        return in_order;
    }

    public void insertValue(int value) {
        if (value == this.getValue()) {
            return;
        } else if (value < this.getValue()) {
            if (this.getLeft() == null) {
                this.setLeft(new Tree(value));
            } else {
                this.getLeft().insertValue(value);
            }
        } else if (value > this.getValue()) {
            if (this.getRight() == null) {
                this.setRight(new Tree(value));
            } else {
                this.getRight().insertValue(value);
            }
        }
    }

    public boolean contains(int value) {
        if (value == this.getValue()) {
            return true;
        } else if (value < this.getValue()) {
            if (this.getLeft() == null) {
                return false;
            } else {
                return this.getLeft().contains(value);
            }
        } else if (value > this.getValue()) {
            if (this.getRight() == null) {
                return false;
            } else {
                return this.getRight().contains(value);
            }
        }
        return false;
    }
}
