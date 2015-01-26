

package AST;

public class AdditiveexpressionDerived1 extends Additiveexpression {

    private Multiplicativeexpression multiplicativeexpression;

    public AdditiveexpressionDerived1 (Multiplicativeexpression multiplicativeexpression) {
        this.multiplicativeexpression=multiplicativeexpression;
        if(multiplicativeexpression!=null) multiplicativeexpression.setParent(this);
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
        if(multiplicativeexpression!=null) multiplicativeexpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(multiplicativeexpression!=null) multiplicativeexpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(multiplicativeexpression!=null) multiplicativeexpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AdditiveexpressionDerived1(\n");

        if(multiplicativeexpression!=null)
            buffer.append(multiplicativeexpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AdditiveexpressionDerived1]");
        return buffer.toString();
    }
}
