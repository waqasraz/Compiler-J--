


package AST;

public class StatementDerived8 extends Statement {

    private Expression expression;
    private Statement statement;
    private Statement statement1;

    public StatementDerived8 (Expression expression, Statement statement, Statement statement1) {
        this.expression=expression;
        if(expression!=null) expression.setParent(this);
        this.statement=statement;
        if(statement!=null) statement.setParent(this);
        this.statement1=statement1;
        if(statement1!=null) statement1.setParent(this);
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression=expression;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement=statement;
    }

    public Statement getStatement1() {
        return statement1;
    }

    public void setStatement1(Statement statement1) {
        this.statement1=statement1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(expression!=null) expression.accept(visitor);
        if(statement!=null) statement.accept(visitor);
        if(statement1!=null) statement1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(expression!=null) expression.traverseTopDown(visitor);
        if(statement!=null) statement.traverseTopDown(visitor);
        if(statement1!=null) statement1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(expression!=null) expression.traverseBottomUp(visitor);
        if(statement!=null) statement.traverseBottomUp(visitor);
        if(statement1!=null) statement1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementDerived8(\n");

        if(expression!=null)
            buffer.append(expression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(statement!=null)
            buffer.append(statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(statement1!=null)
            buffer.append(statement1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementDerived8]");
        return buffer.toString();
    }
}
