


package AST;

public abstract class Mainfunctiondeclarator implements SyntaxNode {

    private SyntaxNode parent;

    public Identifier getIdentifier() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setIdentifier(Identifier identifier) {
        throw new ClassCastException("tried to call abstract method");
    }

    public Formalparameterlist getFormalparameterlist() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setFormalparameterlist(Formalparameterlist formalparameterlist) {
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
