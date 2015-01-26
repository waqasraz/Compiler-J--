


package AST;

public class AdditiveexpressionDerived2 extends Additiveexpression {

    private Additiveexpression additiveexpression;
    private String addop;
    private Multiplicativeexpression multiplicativeexpression;

    public AdditiveexpressionDerived2 (Additiveexpression additiveexpression, String addop, Multiplicativeexpression multiplicativeexpression) {
        this.additiveexpression=additiveexpression;
        if(additiveexpression!=null) additiveexpression.setParent(this);
        this.addop=addop;
        this.multiplicativeexpression=multiplicativeexpression;
        if(multiplicativeexpression!=null) multiplicativeexpression.setParent(this);
    }

    public Additiveexpression getAdditiveexpression() {
        return additiveexpression;
    }

    public void setAdditiveexpression(Additiveexpression additiveexpression) {
        this.additiveexpression=additiveexpression;
    }

    public String getAddop() {
        return addop;
    }

    public void setAddop(String addop) {
        this.addop=addop;
    }

    public Multiplicativeexpression getMultiplicativeexpression() {
        return multiplicativeexpression;
    }

    public void setMultiplicativeexpression(Multiplicativeexpression multiplicativeexpression) {
        this.multiplicativeexpression=multiplicativeexpression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(additiveexpression!=null) additiveexpression.accept(visitor);
        if(multiplicativeexpression!=null) multiplicativeexpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(additiveexpression!=null) additiveexpression.traverseTopDown(visitor);
        if(multiplicativeexpression!=null) multiplicativeexpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(additiveexpression!=null) additiveexpression.traverseBottomUp(visitor);
        if(multiplicativeexpression!=null) multiplicativeexpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AdditiveexpressionDerived2(\n");

        if(additiveexpression!=null)
            buffer.append(additiveexpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+addop);
        buffer.append("\n");

        if(multiplicativeexpression!=null)
            buffer.append(multiplicativeexpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AdditiveexpressionDerived2]");
        return buffer.toString();
    }
}
