


package AST;

public class FunctioninvocationDerived1 extends Functioninvocation {

    private Identifier identifier;
    private Argumentlist argumentlist;

    public FunctioninvocationDerived1 (Identifier identifier, Argumentlist argumentlist) {
        this.identifier=identifier;
        if(identifier!=null) identifier.setParent(this);
        this.argumentlist=argumentlist;
        if(argumentlist!=null) argumentlist.setParent(this);
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier=identifier;
    }

    public Argumentlist getArgumentlist() {
        return argumentlist;
    }

    public void setArgumentlist(Argumentlist argumentlist) {
        this.argumentlist=argumentlist;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(identifier!=null) identifier.accept(visitor);
        if(argumentlist!=null) argumentlist.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(identifier!=null) identifier.traverseTopDown(visitor);
        if(argumentlist!=null) argumentlist.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(identifier!=null) identifier.traverseBottomUp(visitor);
        if(argumentlist!=null) argumentlist.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FunctioninvocationDerived1(\n");

        if(identifier!=null)
            buffer.append(identifier.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(argumentlist!=null)
            buffer.append(argumentlist.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FunctioninvocationDerived1]");
        return buffer.toString();
    }
}
