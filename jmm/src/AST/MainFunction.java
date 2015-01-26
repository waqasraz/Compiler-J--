


package AST;

public class MainFunction extends Mainfunctiondeclaration {

    private Mainfunctiondeclarator mainfunctiondeclarator;
    private Block block;

    public MainFunction (Mainfunctiondeclarator mainfunctiondeclarator, Block block) {
        this.mainfunctiondeclarator=mainfunctiondeclarator;
        if(mainfunctiondeclarator!=null) mainfunctiondeclarator.setParent(this);
        this.block=block;
        if(block!=null) block.setParent(this);
    }

    public Mainfunctiondeclarator getMainfunctiondeclarator() {
        return mainfunctiondeclarator;
    }

    public void setMainfunctiondeclarator(Mainfunctiondeclarator mainfunctiondeclarator) {
        this.mainfunctiondeclarator=mainfunctiondeclarator;
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
        if(mainfunctiondeclarator!=null) mainfunctiondeclarator.accept(visitor);
        if(block!=null) block.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(mainfunctiondeclarator!=null) mainfunctiondeclarator.traverseTopDown(visitor);
        if(block!=null) block.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(mainfunctiondeclarator!=null) mainfunctiondeclarator.traverseBottomUp(visitor);
        if(block!=null) block.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MainFunction(\n");

        if(mainfunctiondeclarator!=null)
            buffer.append(mainfunctiondeclarator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(block!=null)
            buffer.append(block.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MainFunction]");
        return buffer.toString();
    }
}
