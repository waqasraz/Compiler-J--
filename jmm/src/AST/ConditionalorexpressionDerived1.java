


package AST;

public class ConditionalorexpressionDerived1 extends Conditionalorexpression {

    private Conditionalandexpression conditionalandexpression;

    public ConditionalorexpressionDerived1 (Conditionalandexpression conditionalandexpression) {
        this.conditionalandexpression=conditionalandexpression;
        if(conditionalandexpression!=null) conditionalandexpression.setParent(this);
    }

    public Conditionalandexpression getConditionalandexpression() {
        return conditionalandexpression;
    }

    public void setConditionalandexpression(Conditionalandexpression conditionalandexpression) {
        this.conditionalandexpression=conditionalandexpression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(conditionalandexpression!=null) conditionalandexpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(conditionalandexpression!=null) conditionalandexpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(conditionalandexpression!=null) conditionalandexpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionalorexpressionDerived1(\n");

        if(conditionalandexpression!=null)
            buffer.append(conditionalandexpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionalorexpressionDerived1]");
        return buffer.toString();
    }
}
