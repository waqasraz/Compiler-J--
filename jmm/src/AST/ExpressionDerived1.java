


package AST;

public class ExpressionDerived1 extends Expression {

    private Assignmentexpression assignmentexpression;

    public ExpressionDerived1 (Assignmentexpression assignmentexpression) {
        this.assignmentexpression=assignmentexpression;
        if(assignmentexpression!=null) assignmentexpression.setParent(this);
    }

    public Assignmentexpression getAssignmentexpression() {
        return assignmentexpression;
    }

    public void setAssignmentexpression(Assignmentexpression assignmentexpression) {
        this.assignmentexpression=assignmentexpression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(assignmentexpression!=null) assignmentexpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(assignmentexpression!=null) assignmentexpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(assignmentexpression!=null) assignmentexpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExpressionDerived1(\n");

        if(assignmentexpression!=null)
            buffer.append(assignmentexpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExpressionDerived1]");
        return buffer.toString();
    }
}
