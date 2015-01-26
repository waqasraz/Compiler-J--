


package AST;

public class UnaryexpressionDerived2 extends Unaryexpression {

    private Unaryexpression unaryexpression;

    public UnaryexpressionDerived2 (Unaryexpression unaryexpression) {
        this.unaryexpression=unaryexpression;
        if(unaryexpression!=null) unaryexpression.setParent(this);
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
        if(unaryexpression!=null) unaryexpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(unaryexpression!=null) unaryexpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(unaryexpression!=null) unaryexpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("UnaryexpressionDerived2(\n");

        if(unaryexpression!=null)
            buffer.append(unaryexpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [UnaryexpressionDerived2]");
        return buffer.toString();
    }
}
