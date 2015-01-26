
package AST;

public abstract class Additiveexpression implements SyntaxNode {

    private SyntaxNode parent;

    public Additiveexpression getAdditiveexpression() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setAdditiveexpression(Additiveexpression additiveexpression) {
        throw new ClassCastException("tried to call abstract method");
    }

    public String getAddop() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setAddop(String addop) {
        throw new ClassCastException("tried to call abstract method");
    }

    public Multiplicativeexpression getMultiplicativeexpression() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setMultiplicativeexpression(Multiplicativeexpression multiplicativeexpression) {
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
