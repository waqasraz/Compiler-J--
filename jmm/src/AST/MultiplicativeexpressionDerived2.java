


package AST;

public class MultiplicativeexpressionDerived2 extends Multiplicativeexpression {

    private Multiplicativeexpression multiplicativeexpression;
    private String mulop;
    private Unaryexpression unaryexpression;

    public MultiplicativeexpressionDerived2 (Multiplicativeexpression multiplicativeexpression, String mulop, Unaryexpression unaryexpression) {
        this.multiplicativeexpression=multiplicativeexpression;
        if(multiplicativeexpression!=null) multiplicativeexpression.setParent(this);
        this.mulop=mulop;
        this.unaryexpression=unaryexpression;
        if(unaryexpression!=null) unaryexpression.setParent(this);
    }

    public Multiplicativeexpression getMultiplicativeexpression() {
        return multiplicativeexpression;
    }

    public void setMultiplicativeexpression(Multiplicativeexpression multiplicativeexpression) {
        this.multiplicativeexpression=multiplicativeexpression;
    }

    public String getMulop() {
        return mulop;
    }

    public void setMulop(String mulop) {
        this.mulop=mulop;
    }

    public Unaryexpression getUnaryexpression() {
        return unaryexpression;
    }

    public void setUnaryexpression(Unaryexpression unaryexpression) {
        this.unaryexpression=unaryexpression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(multiplicativeexpression!=null) multiplicativeexpression.accept(visitor);
        if(unaryexpression!=null) unaryexpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(multiplicativeexpression!=null) multiplicativeexpression.traverseTopDown(visitor);
        if(unaryexpression!=null) unaryexpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(multiplicativeexpression!=null) multiplicativeexpression.traverseBottomUp(visitor);
        if(unaryexpression!=null) unaryexpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultiplicativeexpressionDerived2(\n");

        if(multiplicativeexpression!=null)
            buffer.append(multiplicativeexpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+mulop);
        buffer.append("\n");

        if(unaryexpression!=null)
            buffer.append(unaryexpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultiplicativeexpressionDerived2]");
        return buffer.toString();
    }
}
