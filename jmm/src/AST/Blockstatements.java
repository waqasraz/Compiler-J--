


package AST;

public abstract class Blockstatements implements SyntaxNode {

    private SyntaxNode parent;

    public Blockstatements getBlockstatements() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setBlockstatements(Blockstatements blockstatements) {
        throw new ClassCastException("tried to call abstract method");
    }

    public Blockstatement getBlockstatement() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setBlockstatement(Blockstatement blockstatement) {
        throw new ClassCastException("tried to call abstract method");
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public abstract void accept(Visitor visitor);
    public abstract void childrenAccept(Visitor visitor);
    public abstract void traverseTopDown(Visitor visitor);
    public abstract void traverseBottomUp(Visitor visitor);

    public String toString() { return toString(""); }
    public abstract String toString(String tab);
}
