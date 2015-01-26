


package AST;

public abstract class Statement implements SyntaxNode {

    private SyntaxNode parent;

    public Expression getExpression() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setExpression(Expression expression) {
        throw new ClassCastException("tried to call abstract method");
    }

    public Statement getStatement() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setStatement(Statement statement) {
        throw new ClassCastException("tried to call abstract method");
    }

    public Statement getStatement1() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setStatement1(Statement statement1) {
        throw new ClassCastException("tried to call abstract method");
    }

    public Statementexpression getStatementexpression() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setStatementexpression(Statementexpression statementexpression) {
        throw new ClassCastException("tried to call abstract method");
    }

    public Block getBlock() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setBlock(Block block) {
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
