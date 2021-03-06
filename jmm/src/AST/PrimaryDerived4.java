


package AST;

public class PrimaryDerived4 extends Primary {

    private Functioninvocation functioninvocation;

    public PrimaryDerived4 (Functioninvocation functioninvocation) {
        this.functioninvocation=functioninvocation;
        if(functioninvocation!=null) functioninvocation.setParent(this);
    }

    public Functioninvocation getFunctioninvocation() {
        return functioninvocation;
    }

    public void setFunctioninvocation(Functioninvocation functioninvocation) {
        this.functioninvocation=functioninvocation;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(functioninvocation!=null) functioninvocation.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(functioninvocation!=null) functioninvocation.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(functioninvocation!=null) functioninvocation.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PrimaryDerived4(\n");

        if(functioninvocation!=null)
            buffer.append(functioninvocation.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrimaryDerived4]");
        return buffer.toString();
    }
}
