


package AST;

public class GlobalFunctionDecl extends Globaldeclaration {

    private Functiondeclaration functiondeclaration;

    public GlobalFunctionDecl (Functiondeclaration functiondeclaration) {
        this.functiondeclaration=functiondeclaration;
        if(functiondeclaration!=null) functiondeclaration.setParent(this);
    }

    public Functiondeclaration getFunctiondeclaration() {
        return functiondeclaration;
    }

    public void setFunctiondeclaration(Functiondeclaration functiondeclaration) {
        this.functiondeclaration=functiondeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(functiondeclaration!=null) functiondeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(functiondeclaration!=null) functiondeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(functiondeclaration!=null) functiondeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalFunctionDecl(\n");

        if(functiondeclaration!=null)
            buffer.append(functiondeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalFunctionDecl]");
        return buffer.toString();
    }
}
