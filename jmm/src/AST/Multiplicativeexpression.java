


package AST;

public abstract class Multiplicativeexpression implements SyntaxNode {

    private SyntaxNode parent;

    public Multiplicativeexpression getMultiplicativeexpression() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setMultiplicativeexpression(Multiplicativeexpression multiplicativeexpression) {
        throw new ClassCastException("tried to call abstract method");
    }

    public String getMulop() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setMulop(String mulop) {
        throw new ClassCastException("tried to call abstract method");
    }

    public Unaryexpression getUnaryexpression() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setUnaryexpression(Unaryexpression unaryexpression) {
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
