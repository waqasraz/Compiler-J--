


package AST;

public class UnaryexpressionDerived3 extends Unaryexpression {

    private Postfixexpression postfixexpression;

    public UnaryexpressionDerived3 (Postfixexpression postfixexpression) {
        this.postfixexpression=postfixexpression;
        if(postfixexpression!=null) postfixexpression.setParent(this);
    }

    public Postfixexpression getPostfixexpression() {
        return postfixexpression;
    }

    public void setPostfixexpression(Postfixexpression postfixexpression) {
        this.postfixexpression=postfixexpression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(postfixexpression!=null) postfixexpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(postfixexpression!=null) postfixexpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(postfixexpression!=null) postfixexpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("UnaryexpressionDerived3(\n");

        if(postfixexpression!=null)
            buffer.append(postfixexpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [UnaryexpressionDerived3]");
        return buffer.toString();
    }
}
