


package AST;

public abstract class Equalityexpression implements SyntaxNode {

    private SyntaxNode parent;

    public Equalityexpression getEqualityexpression() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setEqualityexpression(Equalityexpression equalityexpression) {
        throw new ClassCastException("tried to call abstract method");
    }

    public Relationalexpression getRelationalexpression() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setRelationalexpression(Relationalexpression relationalexpression) {
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
