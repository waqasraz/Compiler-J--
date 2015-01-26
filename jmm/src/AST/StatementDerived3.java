


package AST;

public class StatementDerived3 extends Statement {

    private Statementexpression statementexpression;

    public StatementDerived3 (Statementexpression statementexpression) {
        this.statementexpression=statementexpression;
        if(statementexpression!=null) statementexpression.setParent(this);
    }

    public Statementexpression getStatementexpression() {
        return statementexpression;
    }

    public void setStatementexpression(Statementexpression statementexpression) {
        this.statementexpression=statementexpression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(statementexpression!=null) statementexpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(statementexpression!=null) statementexpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(statementexpression!=null) statementexpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementDerived3(\n");

        if(statementexpression!=null)
            buffer.append(statementexpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementDerived3]");
        return buffer.toString();
    }
}
