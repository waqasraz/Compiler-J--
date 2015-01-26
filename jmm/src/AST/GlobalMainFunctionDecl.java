


package AST;

public class GlobalMainFunctionDecl extends Globaldeclaration {

    private Mainfunctiondeclaration mainfunctiondeclaration;

    public GlobalMainFunctionDecl (Mainfunctiondeclaration mainfunctiondeclaration) {
        this.mainfunctiondeclaration=mainfunctiondeclaration;
        if(mainfunctiondeclaration!=null) mainfunctiondeclaration.setParent(this);
    }

    public Mainfunctiondeclaration getMainfunctiondeclaration() {
        return mainfunctiondeclaration;
    }

    public void setMainfunctiondeclaration(Mainfunctiondeclaration mainfunctiondeclaration) {
        this.mainfunctiondeclaration=mainfunctiondeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(mainfunctiondeclaration!=null) mainfunctiondeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(mainfunctiondeclaration!=null) mainfunctiondeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(mainfunctiondeclaration!=null) mainfunctiondeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalMainFunctionDecl(\n");

        if(mainfunctiondeclaration!=null)
            buffer.append(mainfunctiondeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalMainFunctionDecl]");
        return buffer.toString();
    }
}
