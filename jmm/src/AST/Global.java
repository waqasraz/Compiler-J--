


package AST;

public class Global extends Globaldeclarations {

    private Globaldeclaration globaldeclaration;

    public Global (Globaldeclaration globaldeclaration) {
        this.globaldeclaration=globaldeclaration;
        if(globaldeclaration!=null) globaldeclaration.setParent(this);
    }

    public Globaldeclaration getGlobaldeclaration() {
        return globaldeclaration;
    }

    public void setGlobaldeclaration(Globaldeclaration globaldeclaration) {
        this.globaldeclaration=globaldeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(globaldeclaration!=null) globaldeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(globaldeclaration!=null) globaldeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(globaldeclaration!=null) globaldeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Global(\n");

        if(globaldeclaration!=null)
            buffer.append(globaldeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Global]");
        return buffer.toString();
    }
}
