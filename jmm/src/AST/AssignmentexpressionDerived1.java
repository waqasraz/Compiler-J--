


package AST;

public class AssignmentexpressionDerived1 extends Assignmentexpression {

    private Conditionalorexpression conditionalorexpression;

    public AssignmentexpressionDerived1 (Conditionalorexpression conditionalorexpression) {
        this.conditionalorexpression=conditionalorexpression;
        if(conditionalorexpression!=null) conditionalorexpression.setParent(this);
    }

    public Conditionalorexpression getConditionalorexpression() {
        return conditionalorexpression;
    }

    public void setConditionalorexpression(Conditionalorexpression conditionalorexpression) {
        this.conditionalorexpression=conditionalorexpression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(conditionalorexpression!=null) conditionalorexpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(conditionalorexpression!=null) conditionalorexpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(conditionalorexpression!=null) conditionalorexpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AssignmentexpressionDerived1(\n");

        if(conditionalorexpression!=null)
            buffer.append(conditionalorexpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AssignmentexpressionDerived1]");
        return buffer.toString();
    }
}
