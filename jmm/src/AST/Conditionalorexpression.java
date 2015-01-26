


package AST;

public abstract class Conditionalorexpression implements SyntaxNode {

    private SyntaxNode parent;

    public Conditionalorexpression getConditionalorexpression() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setConditionalorexpression(Conditionalorexpression conditionalorexpression) {
        throw new ClassCastException("tried to call abstract method");
    }

    public Conditionalandexpression getConditionalandexpression() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setConditionalandexpression(Conditionalandexpression conditionalandexpression) {
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
