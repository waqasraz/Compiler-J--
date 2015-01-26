


package AST;

public abstract class Blockstatement implements SyntaxNode {

    private SyntaxNode parent;

    public Statement getStatement() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setStatement(Statement statement) {
        throw new ClassCastException("tried to call abstract method");
    }

    public Variabledeclaration getVariabledeclaration() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setVariabledeclaration(Variabledeclaration variabledeclaration) {
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
