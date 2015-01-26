


package AST;

public class BlockstatementsDerived1 extends Blockstatements {

    private Blockstatement blockstatement;

    public BlockstatementsDerived1 (Blockstatement blockstatement) {
        this.blockstatement=blockstatement;
        if(blockstatement!=null) blockstatement.setParent(this);
    }

    public Blockstatement getBlockstatement() {
        return blockstatement;
    }

    public void setBlockstatement(Blockstatement blockstatement) {
        this.blockstatement=blockstatement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(blockstatement!=null) blockstatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(blockstatement!=null) blockstatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(blockstatement!=null) blockstatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("BlockstatementsDerived1(\n");

        if(blockstatement!=null)
            buffer.append(blockstatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BlockstatementsDerived1]");
        return buffer.toString();
    }
}
