


package AST;

public class VariableDecl extends Variabledeclaration {

    private String type;
    private Identifier identifier;

    public VariableDecl (String type, Identifier identifier) {
        this.type=type;
        this.identifier=identifier;
        if(identifier!=null) identifier.setParent(this);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type=type;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier=identifier;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(identifier!=null) identifier.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(identifier!=null) identifier.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(identifier!=null) identifier.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VariableDecl(\n");

        buffer.append(" "+tab+type);
        buffer.append("\n");

        if(identifier!=null)
            buffer.append(identifier.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VariableDecl]");
        return buffer.toString();
    }
}
