


package AST;

public class AssignmentDerived1 extends Assignment {

    private Identifier identifier;
    private Assignmentexpression assignmentexpression;

    public AssignmentDerived1 (Identifier identifier, Assignmentexpression assignmentexpression) {
        this.identifier=identifier;
        if(identifier!=null) identifier.setParent(this);
        this.assignmentexpression=assignmentexpression;
        if(assignmentexpression!=null) assignmentexpression.setParent(this);
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier=identifier;
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
        if(identifier!=null) identifier.accept(visitor);
        if(assignmentexpression!=null) assignmentexpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(identifier!=null) identifier.traverseTopDown(visitor);
        if(assignmentexpression!=null) assignmentexpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(identifier!=null) identifier.traverseBottomUp(visitor);
        if(assignmentexpression!=null) assignmentexpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AssignmentDerived1(\n");

        if(identifier!=null)
            buffer.append(identifier.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(assignmentexpression!=null)
            buffer.append(assignmentexpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AssignmentDerived1]");
        return buffer.toString();
    }
}
