


package AST;

public class StatementexpressionDerived1 extends Statementexpression {

    private Assignment assignment;

    public StatementexpressionDerived1 (Assignment assignment) {
        this.assignment=assignment;
        if(assignment!=null) assignment.setParent(this);
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment=assignment;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(assignment!=null) assignment.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(assignment!=null) assignment.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(assignment!=null) assignment.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementexpressionDerived1(\n");

        if(assignment!=null)
            buffer.append(assignment.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementexpressionDerived1]");
        return buffer.toString();
    }
}
