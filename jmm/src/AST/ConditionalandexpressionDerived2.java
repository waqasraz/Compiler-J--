


package AST;

public class ConditionalandexpressionDerived2 extends Conditionalandexpression {

    private Conditionalandexpression conditionalandexpression;
    private Equalityexpression equalityexpression;

    public ConditionalandexpressionDerived2 (Conditionalandexpression conditionalandexpression, Equalityexpression equalityexpression) {
        this.conditionalandexpression=conditionalandexpression;
        if(conditionalandexpression!=null) conditionalandexpression.setParent(this);
        this.equalityexpression=equalityexpression;
        if(equalityexpression!=null) equalityexpression.setParent(this);
    }

    public Conditionalandexpression getConditionalandexpression() {
        return conditionalandexpression;
    }

    public void setConditionalandexpression(Conditionalandexpression conditionalandexpression) {
        this.conditionalandexpression=conditionalandexpression;
    }

    public Equalityexpression getEqualityexpression() {
        return equalityexpression;
    }

    public void setEqualityexpression(Equalityexpression equalityexpression) {
        this.equalityexpression=equalityexpression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(conditionalandexpression!=null) conditionalandexpression.accept(visitor);
        if(equalityexpression!=null) equalityexpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(conditionalandexpression!=null) conditionalandexpression.traverseTopDown(visitor);
        if(equalityexpression!=null) equalityexpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(conditionalandexpression!=null) conditionalandexpression.traverseBottomUp(visitor);
        if(equalityexpression!=null) equalityexpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionalandexpressionDerived2(\n");

        if(conditionalandexpression!=null)
            buffer.append(conditionalandexpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(equalityexpression!=null)
            buffer.append(equalityexpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionalandexpressionDerived2]");
        return buffer.toString();
    }
}
