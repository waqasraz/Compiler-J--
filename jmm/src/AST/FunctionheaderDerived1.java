


package AST;

public class FunctionheaderDerived1 extends Functionheader {

    private String type;
    private Functiondeclarator functiondeclarator;

    public FunctionheaderDerived1 (String type, Functiondeclarator functiondeclarator) {
        this.type=type;
        this.functiondeclarator=functiondeclarator;
        if(functiondeclarator!=null) functiondeclarator.setParent(this);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type=type;
    }

    public Functiondeclarator getFunctiondeclarator() {
        return functiondeclarator;
    }

    public void setFunctiondeclarator(Functiondeclarator functiondeclarator) {
        this.functiondeclarator=functiondeclarator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(functiondeclarator!=null) functiondeclarator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(functiondeclarator!=null) functiondeclarator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(functiondeclarator!=null) functiondeclarator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FunctionheaderDerived1(\n");

        buffer.append(" "+tab+type);
        buffer.append("\n");

        if(functiondeclarator!=null)
            buffer.append(functiondeclarator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FunctionheaderDerived1]");
        return buffer.toString();
    }
}
