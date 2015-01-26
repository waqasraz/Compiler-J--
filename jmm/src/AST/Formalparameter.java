


package AST;

public abstract class Formalparameter implements SyntaxNode {

    private SyntaxNode parent;

    public String getType() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setType(String type) {
        throw new ClassCastException("tried to call abstract method");
    }

    public Identifier getIdentifier() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setIdentifier(Identifier identifier) {
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
