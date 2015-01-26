


package AST;

public class StatementDerived4 extends Statement {

    public StatementDerived4 () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementDerived4(\n");

        buffer.append(tab);
        buffer.append(") [StatementDerived4]");
        return buffer.toString();
    }
}
