


package AST;

public class FormalparameterlistDerived1 extends Formalparameterlist {

    private Formalparameter formalparameter;

    public FormalparameterlistDerived1 (Formalparameter formalparameter) {
        this.formalparameter=formalparameter;
        if(formalparameter!=null) formalparameter.setParent(this);
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
        if(formalparameter!=null) formalparameter.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(formalparameter!=null) formalparameter.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(formalparameter!=null) formalparameter.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormalparameterlistDerived1(\n");

        if(formalparameter!=null)
            buffer.append(formalparameter.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormalparameterlistDerived1]");
        return buffer.toString();
    }
}
