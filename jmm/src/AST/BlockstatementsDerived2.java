


package AST;

public class BlockstatementsDerived2 extends Blockstatements {

    private Blockstatements blockstatements;
    private Blockstatement blockstatement;

    public BlockstatementsDerived2 (Blockstatements blockstatements, Blockstatement blockstatement) {
        this.blockstatements=blockstatements;
        if(blockstatements!=null) blockstatements.setParent(this);
        this.blockstatement=blockstatement;
        if(blockstatement!=null) blockstatement.setParent(this);
    }

    public Blockstatements getBlockstatements() {
        return blockstatements;
    }

    public void setBlockstatements(Blockstatements blockstatements) {
        this.blockstatements=blockstatements;
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
        if(blockstatements!=null) blockstatements.accept(visitor);
        if(blockstatement!=null) blockstatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(blockstatements!=null) blockstatements.traverseTopDown(visitor);
        if(blockstatement!=null) blockstatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(blockstatements!=null) blockstatements.traverseBottomUp(visitor);
        if(blockstatement!=null) blockstatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("BlockstatementsDerived2(\n");

        if(blockstatements!=null)
            buffer.append(blockstatements.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(blockstatement!=null)
            buffer.append(blockstatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BlockstatementsDerived2]");
        return buffer.toString();
    }
}
