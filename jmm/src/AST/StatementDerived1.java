


package AST;

public class StatementDerived1 extends Statement {

    private Block block;

    public StatementDerived1 (Block block) {
        this.block=block;
        if(block!=null) block.setParent(this);
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block=block;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(block!=null) block.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(block!=null) block.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(block!=null) block.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementDerived1(\n");

        if(block!=null)
            buffer.append(block.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementDerived1]");
        return buffer.toString();
    }
}
