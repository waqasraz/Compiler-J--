


package AST;

public class FormalparameterlistDerived2 extends Formalparameterlist {

    private Formalparameterlist formalparameterlist;
    private Formalparameter formalparameter;

    public FormalparameterlistDerived2 (Formalparameterlist formalparameterlist, Formalparameter formalparameter) {
        this.formalparameterlist=formalparameterlist;
        if(formalparameterlist!=null) formalparameterlist.setParent(this);
        this.formalparameter=formalparameter;
        if(formalparameter!=null) formalparameter.setParent(this);
    }

    public Formalparameterlist getFormalparameterlist() {
        return formalparameterlist;
    }

    public void setFormalparameterlist(Formalparameterlist formalparameterlist) {
        this.formalparameterlist=formalparameterlist;
    }

    public Formalparameter getFormalparameter() {
        return formalparameter;
    }

    public void setFormalparameter(Formalparameter formalparameter) {
        this.formalparameter=formalparameter;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(formalparameterlist!=null) formalparameterlist.accept(visitor);
        if(formalparameter!=null) formalparameter.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(formalparameterlist!=null) formalparameterlist.traverseTopDown(visitor);
        if(formalparameter!=null) formalparameter.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(formalparameterlist!=null) formalparameterlist.traverseBottomUp(visitor);
        if(formalparameter!=null) formalparameter.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormalparameterlistDerived2(\n");

        if(formalparameterlist!=null)
            buffer.append(formalparameterlist.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(formalparameter!=null)
            buffer.append(formalparameter.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormalparameterlistDerived2]");
        return buffer.toString();
    }
}
