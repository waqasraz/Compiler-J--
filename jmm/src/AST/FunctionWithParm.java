


package AST;

public class FunctionWithParm extends Functiondeclarator {

    private Identifier identifier;
    private Formalparameterlist formalparameterlist;

    public FunctionWithParm (Identifier identifier, Formalparameterlist formalparameterlist) {
        this.identifier=identifier;
        if(identifier!=null) identifier.setParent(this);
        this.formalparameterlist=formalparameterlist;
        if(formalparameterlist!=null) formalparameterlist.setParent(this);
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier=identifier;
    }

    public Formalparameterlist getFormalparameterlist() {
        return formalparameterlist;
    }

    public void setFormalparameterlist(Formalparameterlist formalparameterlist) {
        this.formalparameterlist=formalparameterlist;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(identifier!=null) identifier.accept(visitor);
        if(formalparameterlist!=null) formalparameterlist.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(identifier!=null) identifier.traverseTopDown(visitor);
        if(formalparameterlist!=null) formalparameterlist.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(identifier!=null) identifier.traverseBottomUp(visitor);
        if(formalparameterlist!=null) formalparameterlist.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FunctionWithParm(\n");

        if(identifier!=null)
            buffer.append(identifier.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(formalparameterlist!=null)
            buffer.append(formalparameterlist.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FunctionWithParm]");
        return buffer.toString();
    }
}
