


package AST;

public class FunctionheaderDerived2 extends Functionheader {

    private String typevoid;
    private Functiondeclarator functiondeclarator;

    public FunctionheaderDerived2 (String typevoid, Functiondeclarator functiondeclarator) {
        this.typevoid=typevoid;
        this.functiondeclarator=functiondeclarator;
        if(functiondeclarator!=null) functiondeclarator.setParent(this);
    }

    public String getTypevoid() {
        return typevoid;
    }

    public void setTypevoid(String typevoid) {
        this.typevoid=typevoid;
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
        buffer.append("FunctionheaderDerived2(\n");

        buffer.append(" "+tab+typevoid);
        buffer.append("\n");

        if(functiondeclarator!=null)
            buffer.append(functiondeclarator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FunctionheaderDerived2]");
        return buffer.toString();
    }
}
