


package AST;

public class FunctionDecl extends Functiondeclaration {

    private Functionheader functionheader;
    private Block block;

    public FunctionDecl (Functionheader functionheader, Block block) {
        this.functionheader=functionheader;
        if(functionheader!=null) functionheader.setParent(this);
        this.block=block;
        if(block!=null) block.setParent(this);
    }

    public Functionheader getFunctionheader() {
        return functionheader;
    }

    public void setFunctionheader(Functionheader functionheader) {
        this.functionheader=functionheader;
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
        if(functionheader!=null) functionheader.accept(visitor);
        if(block!=null) block.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(functionheader!=null) functionheader.traverseTopDown(visitor);
        if(block!=null) block.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(functionheader!=null) functionheader.traverseBottomUp(visitor);
        if(block!=null) block.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FunctionDecl(\n");

        if(functionheader!=null)
            buffer.append(functionheader.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(block!=null)
            buffer.append(block.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FunctionDecl]");
        return buffer.toString();
    }
}
