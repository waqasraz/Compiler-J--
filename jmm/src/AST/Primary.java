


package AST;

public abstract class Primary implements SyntaxNode {

    private SyntaxNode parent;

    public Functioninvocation getFunctioninvocation() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setFunctioninvocation(Functioninvocation functioninvocation) {
        throw new ClassCastException("tried to call abstract method");
    }

    public Expression getExpression() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setExpression(Expression expression) {
        throw new ClassCastException("tried to call abstract method");
    }

    public String getLiteral2() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setLiteral2(String literal2) {
        throw new ClassCastException("tried to call abstract method");
    }

    public Literal1 getLiteral1() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setLiteral1(Literal1 literal1) {
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
