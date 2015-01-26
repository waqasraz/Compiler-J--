


package AST;

public class GlobalVariableDecl extends Globaldeclaration {

    private Variabledeclaration variabledeclaration;

    public GlobalVariableDecl (Variabledeclaration variabledeclaration) {
        this.variabledeclaration=variabledeclaration;
        if(variabledeclaration!=null) variabledeclaration.setParent(this);
    }

    public Variabledeclaration getVariabledeclaration() {
        return variabledeclaration;
    }

    public void setVariabledeclaration(Variabledeclaration variabledeclaration) {
        this.variabledeclaration=variabledeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(variabledeclaration!=null) variabledeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(variabledeclaration!=null) variabledeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(variabledeclaration!=null) variabledeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalVariableDecl(\n");

        if(variabledeclaration!=null)
            buffer.append(variabledeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalVariableDecl]");
        return buffer.toString();
    }
}
