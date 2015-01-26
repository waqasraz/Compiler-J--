


package AST;

public class BlockDerived1 extends Block {

    private Blockstatements blockstatements;

    public BlockDerived1 (Blockstatements blockstatements) {
        this.blockstatements=blockstatements;
        if(blockstatements!=null) blockstatements.setParent(this);
    }

    public Blockstatements getBlockstatements() {
        return blockstatements;
    }

    public void setBlockstatements(Blockstatements blockstatements) {
        this.blockstatements=blockstatements;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(blockstatements!=null) blockstatements.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(blockstatements!=null) blockstatements.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(blockstatements!=null) blockstatements.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("BlockDerived1(\n");

        if(blockstatements!=null)
            buffer.append(blockstatements.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BlockDerived1]");
        return buffer.toString();
    }
}
