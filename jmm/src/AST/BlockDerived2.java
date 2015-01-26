


package AST;

public class BlockDerived2 extends Block {

    public BlockDerived2 () {
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
        buffer.append("BlockDerived2(\n");

        buffer.append(tab);
        buffer.append(") [BlockDerived2]");
        return buffer.toString();
    }
}
