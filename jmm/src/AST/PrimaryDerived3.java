


package AST;

public class PrimaryDerived3 extends Primary {

    private Expression expression;

    public PrimaryDerived3 (Expression expression) {
        this.expression=expression;
        if(expression!=null) expression.setParent(this);
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression=expression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(expression!=null) expression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(expression!=null) expression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(expression!=null) expression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PrimaryDerived3(\n");

        if(expression!=null)
            buffer.append(expression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrimaryDerived3]");
        return buffer.toString();
    }
}
