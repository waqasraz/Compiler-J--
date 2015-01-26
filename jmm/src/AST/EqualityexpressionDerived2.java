


package AST;

public class EqualityexpressionDerived2 extends Equalityexpression {

    private Equalityexpression equalityexpression;
    private Relationalexpression relationalexpression;

    public EqualityexpressionDerived2 (Equalityexpression equalityexpression, Relationalexpression relationalexpression) {
        this.equalityexpression=equalityexpression;
        if(equalityexpression!=null) equalityexpression.setParent(this);
        this.relationalexpression=relationalexpression;
        if(relationalexpression!=null) relationalexpression.setParent(this);
    }

    public Equalityexpression getEqualityexpression() {
        return equalityexpression;
    }

    public void setEqualityexpression(Equalityexpression equalityexpression) {
        this.equalityexpression=equalityexpression;
    }

    public Relationalexpression getRelationalexpression() {
        return relationalexpression;
    }

    public void setRelationalexpression(Relationalexpression relationalexpression) {
        this.relationalexpression=relationalexpression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(equalityexpression!=null) equalityexpression.accept(visitor);
        if(relationalexpression!=null) relationalexpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(equalityexpression!=null) equalityexpression.traverseTopDown(visitor);
        if(relationalexpression!=null) relationalexpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(equalityexpression!=null) equalityexpression.traverseBottomUp(visitor);
        if(relationalexpression!=null) relationalexpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EqualityexpressionDerived2(\n");

        if(equalityexpression!=null)
            buffer.append(equalityexpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(relationalexpression!=null)
            buffer.append(relationalexpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [EqualityexpressionDerived2]");
        return buffer.toString();
    }
}
