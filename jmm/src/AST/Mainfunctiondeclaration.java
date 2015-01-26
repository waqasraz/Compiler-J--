


package AST;

public abstract class Mainfunctiondeclaration implements SyntaxNode {

    private SyntaxNode parent;

    public Mainfunctiondeclarator getMainfunctiondeclarator() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setMainfunctiondeclarator(Mainfunctiondeclarator mainfunctiondeclarator) {
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
