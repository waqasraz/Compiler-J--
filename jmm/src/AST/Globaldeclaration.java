


package AST;

public abstract class Globaldeclaration implements SyntaxNode {

    private SyntaxNode parent;

    public Mainfunctiondeclaration getMainfunctiondeclaration() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setMainfunctiondeclaration(Mainfunctiondeclaration mainfunctiondeclaration) {
        throw new ClassCastException("tried to call abstract method");
    }

    public Functiondeclaration getFunctiondeclaration() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setFunctiondeclaration(Functiondeclaration functiondeclaration) {
        throw new ClassCastException("tried to call abstract method");
    }

    public Variabledeclaration getVariabledeclaration() {
        throw new ClassCastException("tried to call abstract method");
    }

    public void setVariabledeclaration(Variabledeclaration variabledeclaration) {
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
