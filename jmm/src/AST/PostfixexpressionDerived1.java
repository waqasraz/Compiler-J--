


package AST;

public class PostfixexpressionDerived1 extends Postfixexpression {

    private Primary primary;

    public PostfixexpressionDerived1 (Primary primary) {
        this.primary=primary;
        if(primary!=null) primary.setParent(this);
    }

    public Primary getPrimary() {
        return primary;
    }

    public void setPrimary(Primary primary) {
        this.primary=primary;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(primary!=null) primary.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(primary!=null) primary.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(primary!=null) primary.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PostfixexpressionDerived1(\n");

        if(primary!=null)
            buffer.append(primary.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PostfixexpressionDerived1]");
        return buffer.toString();
    }
}
