


package AST;

public class ArgumentlistDerived2 extends Argumentlist {

    private Argumentlist argumentlist;
    private Expression expression;

    public ArgumentlistDerived2 (Argumentlist argumentlist, Expression expression) {
        this.argumentlist=argumentlist;
        if(argumentlist!=null) argumentlist.setParent(this);
        this.expression=expression;
        if(expression!=null) expression.setParent(this);
    }

    public Argumentlist getArgumentlist() {
        return argumentlist;
    }

    public void setArgumentlist(Argumentlist argumentlist) {
        this.argumentlist=argumentlist;
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
        if(argumentlist!=null) argumentlist.accept(visitor);
        if(expression!=null) expression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(argumentlist!=null) argumentlist.traverseTopDown(visitor);
        if(expression!=null) expression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(argumentlist!=null) argumentlist.traverseBottomUp(visitor);
        if(expression!=null) expression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ArgumentlistDerived2(\n");

        if(argumentlist!=null)
            buffer.append(argumentlist.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(expression!=null)
            buffer.append(expression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ArgumentlistDerived2]");
        return buffer.toString();
    }
}
