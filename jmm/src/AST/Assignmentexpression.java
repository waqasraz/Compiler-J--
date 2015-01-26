


package AST;

public abstract class Assignmentexpression implements SyntaxNode {

    private SyntaxNode parent;

    public Assignment getAssignment() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setAssignment(Assignment assignment) {
        throw new ClassCastException("tried to call abstract method");
    }

    public Conditionalorexpression getConditionalorexpression() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setConditionalorexpression(Conditionalorexpression conditionalorexpression) {
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
