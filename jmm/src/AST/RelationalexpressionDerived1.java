


package AST;

public class RelationalexpressionDerived1 extends Relationalexpression {

    private Additiveexpression additiveexpression;

    public RelationalexpressionDerived1 (Additiveexpression additiveexpression) {
        this.additiveexpression=additiveexpression;
        if(additiveexpression!=null) additiveexpression.setParent(this);
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
        if(additiveexpression!=null) additiveexpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(additiveexpression!=null) additiveexpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(additiveexpression!=null) additiveexpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RelationalexpressionDerived1(\n");

        if(additiveexpression!=null)
            buffer.append(additiveexpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RelationalexpressionDerived1]");
        return buffer.toString();
    }
}
