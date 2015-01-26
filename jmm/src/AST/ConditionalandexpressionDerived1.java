


package AST;

public class ConditionalandexpressionDerived1 extends Conditionalandexpression {

    private Equalityexpression equalityexpression;

    public ConditionalandexpressionDerived1 (Equalityexpression equalityexpression) {
        this.equalityexpression=equalityexpression;
        if(equalityexpression!=null) equalityexpression.setParent(this);
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
        if(equalityexpression!=null) equalityexpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(equalityexpression!=null) equalityexpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(equalityexpression!=null) equalityexpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionalandexpressionDerived1(\n");

        if(equalityexpression!=null)
            buffer.append(equalityexpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionalandexpressionDerived1]");
        return buffer.toString();
    }
}
