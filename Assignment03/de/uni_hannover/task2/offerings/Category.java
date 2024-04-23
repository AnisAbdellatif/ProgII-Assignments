package de.uni_hannover.task2.offerings;

public enum Category {
    FURNITURE, ELECTRONICS, OTHER;

    public String str() {
        switch(this) {
            case FURNITURE:
                return "Furniture";
            case ELECTRONICS:
                return "Electronics";
            case OTHER:
                return "Other";
            default:
                return "";
        }
    }
}