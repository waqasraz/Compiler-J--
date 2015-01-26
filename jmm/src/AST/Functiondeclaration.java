


package AST;

public abstract class Functiondeclaration implements SyntaxNode {

    private SyntaxNode parent;

    public Functionheader getFunctionheader() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setFunctionheader(Functionheader functionheader) {
        throw new ClassCastException("tried to call abstract method");
    }

    public Block getBlock() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setBlock(Block block) {
        throw new ClassCastException("tried to call abstract method");
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public abstract void accept(Visitor visitor);
    public abstract void childrenAccept(Visitor visitor);
    public abstract void traverseTopDown(Visitor visitor);
    public abstract void traverseBottomUp(Visitor visitor);

    public String toString() { return toString(""); }
    public abstract String toString(String tab);
}
