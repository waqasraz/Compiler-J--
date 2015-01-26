


package AST;

public class ConditionalorexpressionDerived2 extends Conditionalorexpression {

    private Conditionalorexpression conditionalorexpression;
    private Conditionalandexpression conditionalandexpression;

    public ConditionalorexpressionDerived2 (Conditionalorexpression conditionalorexpression, Conditionalandexpression conditionalandexpression) {
        this.conditionalorexpression=conditionalorexpression;
        if(conditionalorexpression!=null) conditionalorexpression.setParent(this);
        this.conditionalandexpression=conditionalandexpression;
        if(conditionalandexpression!=null) conditionalandexpression.setParent(this);
    }

    public Conditionalorexpression getConditionalorexpression() {
        return conditionalorexpression;
    }

    public void setConditionalorexpression(Conditionalorexpression conditionalorexpression) {
        this.conditionalorexpression=conditionalorexpression;
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
        if(conditionalorexpression!=null) conditionalorexpression.accept(visitor);
        if(conditionalandexpression!=null) conditionalandexpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(conditionalorexpression!=null) conditionalorexpression.traverseTopDown(visitor);
        if(conditionalandexpression!=null) conditionalandexpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(conditionalorexpression!=null) conditionalorexpression.traverseBottomUp(visitor);
        if(conditionalandexpression!=null) conditionalandexpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionalorexpressionDerived2(\n");

        if(conditionalorexpression!=null)
            buffer.append(conditionalorexpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(conditionalandexpression!=null)
            buffer.append(conditionalandexpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionalorexpressionDerived2]");
        return buffer.toString();
    }
}
