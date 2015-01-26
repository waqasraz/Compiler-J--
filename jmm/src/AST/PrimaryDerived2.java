


package AST;

public class PrimaryDerived2 extends Primary {

    private String literal2;

    public PrimaryDerived2 (String literal2) {
        this.literal2=literal2;
    }

    public String getLiteral2() {
        return literal2;
    }

    public void setLiteral2(String literal2) {
        this.literal2=literal2;
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
        buffer.append("PrimaryDerived2(\n");

        buffer.append(" "+tab+literal2);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrimaryDerived2]");
        return buffer.toString();
    }
}
