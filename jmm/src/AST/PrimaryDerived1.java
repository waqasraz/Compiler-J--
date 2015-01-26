


package AST;

public class PrimaryDerived1 extends Primary {

    private Literal1 literal1;

    public PrimaryDerived1 (Literal1 literal1) {
        this.literal1=literal1;
        if(literal1!=null) literal1.setParent(this);
    }

    public Literal1 getLiteral1() {
        return literal1;
    }

    public void setLiteral1(Literal1 literal1) {
        this.literal1=literal1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(literal1!=null) literal1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(literal1!=null) literal1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(literal1!=null) literal1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PrimaryDerived1(\n");

        if(literal1!=null)
            buffer.append(literal1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrimaryDerived1]");
        return buffer.toString();
    }
}
