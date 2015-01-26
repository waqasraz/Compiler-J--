


package AST;

public class RelationalexpressionDerived2 extends Relationalexpression {

    private Relationalexpression relationalexpression;
    private String relationalop;
    private Additiveexpression additiveexpression;

    public RelationalexpressionDerived2 (Relationalexpression relationalexpression, String relationalop, Additiveexpression additiveexpression) {
        this.relationalexpression=relationalexpression;
        if(relationalexpression!=null) relationalexpression.setParent(this);
        this.relationalop=relationalop;
        this.additiveexpression=additiveexpression;
        if(additiveexpression!=null) additiveexpression.setParent(this);
    }

    public Relationalexpression getRelationalexpression() {
        return relationalexpression;
    }

    public void setRelationalexpression(Relationalexpression relationalexpression) {
        this.relationalexpression=relationalexpression;
    }

    public String getRelationalop() {
        return relationalop;
    }

    public void setRelationalop(String relationalop) {
        this.relationalop=relationalop;
    }

    public Additiveexpression getAdditiveexpression() {
        return additiveexpression;
    }

    public void setAdditiveexpression(Additiveexpression additiveexpression) {
        this.additiveexpression=additiveexpression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(relationalexpression!=null) relationalexpression.accept(visitor);
        if(additiveexpression!=null) additiveexpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(relationalexpression!=null) relationalexpression.traverseTopDown(visitor);
        if(additiveexpression!=null) additiveexpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(relationalexpression!=null) relationalexpression.traverseBottomUp(visitor);
        if(additiveexpression!=null) additiveexpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RelationalexpressionDerived2(\n");

        if(relationalexpression!=null)
            buffer.append(relationalexpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+relationalop);
        buffer.append("\n");

        if(additiveexpression!=null)
            buffer.append(additiveexpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RelationalexpressionDerived2]");
        return buffer.toString();
    }
}
