


package AST;

public abstract class Formalparameterlist implements SyntaxNode {

    private SyntaxNode parent;

    public Formalparameterlist getFormalparameterlist() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setFormalparameterlist(Formalparameterlist formalparameterlist) {
        throw new ClassCastException("tried to call abstract method");
    }

    public Formalparameter getFormalparameter() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setFormalparameter(Formalparameter formalparameter) {
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
