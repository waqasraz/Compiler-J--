


package AST;

public class EqualityexpressionDerived1 extends Equalityexpression {

    private Relationalexpression relationalexpression;

    public EqualityexpressionDerived1 (Relationalexpression relationalexpression) {
        this.relationalexpression=relationalexpression;
        if(relationalexpression!=null) relationalexpression.setParent(this);
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
        if(relationalexpression!=null) relationalexpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(relationalexpression!=null) relationalexpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(relationalexpression!=null) relationalexpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EqualityexpressionDerived1(\n");

        if(relationalexpression!=null)
            buffer.append(relationalexpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [EqualityexpressionDerived1]");
        return buffer.toString();
    }
}
