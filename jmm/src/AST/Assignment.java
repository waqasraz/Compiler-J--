


package AST;

public abstract class Assignment implements SyntaxNode {

    private SyntaxNode parent;

    public Identifier getIdentifier() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setIdentifier(Identifier identifier) {
        throw new ClassCastException("tried to call abstract method");
    }

    public Assignmentexpression getAssignmentexpression() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setAssignmentexpression(Assignmentexpression assignmentexpression) {
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
