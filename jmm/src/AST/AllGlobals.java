


package AST;

public class AllGlobals extends St {

    private Globaldeclarations globaldeclarations;

    public AllGlobals (Globaldeclarations globaldeclarations) {
        this.globaldeclarations=globaldeclarations;
        if(globaldeclarations!=null) globaldeclarations.setParent(this);
    }

    public Globaldeclarations getGlobaldeclarations() {
        return globaldeclarations;
    }

    public void setGlobaldeclarations(Globaldeclarations globaldeclarations) {
        this.globaldeclarations=globaldeclarations;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(globaldeclarations!=null) globaldeclarations.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(globaldeclarations!=null) globaldeclarations.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(globaldeclarations!=null) globaldeclarations.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AllGlobals(\n");

        if(globaldeclarations!=null)
            buffer.append(globaldeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AllGlobals]");
        return buffer.toString();
    }
}
