


package AST;

public class GlobaldeclarationsDerived1 extends Globaldeclarations {

    private Globaldeclarations globaldeclarations;
    private Globaldeclaration globaldeclaration;

    public GlobaldeclarationsDerived1 (Globaldeclarations globaldeclarations, Globaldeclaration globaldeclaration) {
        this.globaldeclarations=globaldeclarations;
        if(globaldeclarations!=null) globaldeclarations.setParent(this);
        this.globaldeclaration=globaldeclaration;
        if(globaldeclaration!=null) globaldeclaration.setParent(this);
    }

    public Globaldeclarations getGlobaldeclarations() {
        return globaldeclarations;
    }

    public void setGlobaldeclarations(Globaldeclarations globaldeclarations) {
        this.globaldeclarations=globaldeclarations;
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
        if(globaldeclarations!=null) globaldeclarations.accept(visitor);
        if(globaldeclaration!=null) globaldeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(globaldeclarations!=null) globaldeclarations.traverseTopDown(visitor);
        if(globaldeclaration!=null) globaldeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(globaldeclarations!=null) globaldeclarations.traverseBottomUp(visitor);
        if(globaldeclaration!=null) globaldeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobaldeclarationsDerived1(\n");

        if(globaldeclarations!=null)
            buffer.append(globaldeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(globaldeclaration!=null)
            buffer.append(globaldeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobaldeclarationsDerived1]");
        return buffer.toString();
    }
}
