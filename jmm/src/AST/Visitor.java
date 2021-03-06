


package AST;

public interface Visitor { 

    public void visit(Conditionalorexpression conditionalorexpression);
    public void visit(Additiveexpression additiveexpression);
    public void visit(Functioninvocation functioninvocation);
    public void visit(Relationalexpression relationalexpression);
    public void visit(Mainfunctiondeclarator mainfunctiondeclarator);
    public void visit(Variabledeclaration variabledeclaration);
    public void visit(Mainfunctiondeclaration mainfunctiondeclaration);
    public void visit(Globaldeclarations globaldeclarations);
    public void visit(Block block);
    public void visit(Equalityexpression equalityexpression);
    public void visit(St st);
    public void visit(Assignment assignment);
    public void visit(Primary primary);
    public void visit(Globaldeclaration globaldeclaration);
    public void visit(Functiondeclaration functiondeclaration);
    public void visit(Formalparameter formalparameter);
    public void visit(Expression expression);
    public void visit(Statement statement);
    public void visit(Unaryexpression unaryexpression);
    public void visit(Argumentlist argumentlist);
    public void visit(Statementexpression statementexpression);
    public void visit(Assignmentexpression assignmentexpression);
    public void visit(Blockstatements blockstatements);
    public void visit(Literal1 literal1);
    public void visit(Functionheader functionheader);
    public void visit(Postfixexpression postfixexpression);
    public void visit(Functiondeclarator functiondeclarator);
    public void visit(Conditionalandexpression conditionalandexpression);
    public void visit(Formalparameterlist formalparameterlist);
    public void visit(Multiplicativeexpression multiplicativeexpression);
    public void visit(Blockstatement blockstatement);
    public void visit(ExpressionDerived1 expressionDerived1);
    public void visit(AssignmentDerived1 assignmentDerived1);
    public void visit(AssignmentexpressionDerived2 assignmentexpressionDerived2);
    public void visit(AssignmentexpressionDerived1 assignmentexpressionDerived1);
    public void visit(ConditionalorexpressionDerived2 conditionalorexpressionDerived2);
    public void visit(ConditionalorexpressionDerived1 conditionalorexpressionDerived1);
    public void visit(ConditionalandexpressionDerived2 conditionalandexpressionDerived2);
    public void visit(ConditionalandexpressionDerived1 conditionalandexpressionDerived1);
    public void visit(EqualityexpressionDerived3 equalityexpressionDerived3);
    public void visit(EqualityexpressionDerived2 equalityexpressionDerived2);
    public void visit(EqualityexpressionDerived1 equalityexpressionDerived1);
    public void visit(RelationalexpressionDerived2 relationalexpressionDerived2);
    public void visit(RelationalexpressionDerived1 relationalexpressionDerived1);
    public void visit(AdditiveexpressionDerived2 additiveexpressionDerived2);
    public void visit(AdditiveexpressionDerived1 additiveexpressionDerived1);
    public void visit(MultiplicativeexpressionDerived2 multiplicativeexpressionDerived2);
    public void visit(MultiplicativeexpressionDerived1 multiplicativeexpressionDerived1);
    public void visit(UnaryexpressionDerived3 unaryexpressionDerived3);
    public void visit(UnaryexpressionDerived2 unaryexpressionDerived2);
    public void visit(UnaryexpressionDerived1 unaryexpressionDerived1);
    public void visit(PostfixexpressionDerived2 postfixexpressionDerived2);
    public void visit(PostfixexpressionDerived1 postfixexpressionDerived1);
    public void visit(FunctioninvocationDerived2 functioninvocationDerived2);
    public void visit(FunctioninvocationDerived1 functioninvocationDerived1);
    public void visit(ArgumentlistDerived2 argumentlistDerived2);
    public void visit(ArgumentlistDerived1 argumentlistDerived1);
    public void visit(PrimaryDerived4 primaryDerived4);
    public void visit(PrimaryDerived3 primaryDerived3);
    public void visit(PrimaryDerived2 primaryDerived2);
    public void visit(PrimaryDerived1 primaryDerived1);
    public void visit(StatementexpressionDerived2 statementexpressionDerived2);
    public void visit(StatementexpressionDerived1 statementexpressionDerived1);
    public void visit(StatementDerived9 statementDerived9);
    public void visit(StatementDerived8 statementDerived8);
    public void visit(StatementDerived7 statementDerived7);
    public void visit(StatementDerived6 statementDerived6);
    public void visit(StatementDerived5 statementDerived5);
    public void visit(StatementDerived4 statementDerived4);
    public void visit(StatementDerived3 statementDerived3);
    public void visit(StatementDerived2 statementDerived2);
    public void visit(StatementDerived1 statementDerived1);
    public void visit(BlockstatementDerived2 blockstatementDerived2);
    public void visit(BlockstatementDerived1 blockstatementDerived1);
    public void visit(BlockstatementsDerived2 blockstatementsDerived2);
    public void visit(BlockstatementsDerived1 blockstatementsDerived1);
    public void visit(BlockDerived2 blockDerived2);
    public void visit(BlockDerived1 blockDerived1);
    public void visit(MainfunctiondeclaratorDerived2 mainfunctiondeclaratorDerived2);
    public void visit(MainfunctiondeclaratorDerived1 mainfunctiondeclaratorDerived1);
    public void visit(MainFunction mainFunction);
    public void visit(FormalparameterDerived1 formalparameterDerived1);
    public void visit(FormalparameterlistDerived2 formalparameterlistDerived2);
    public void visit(FormalparameterlistDerived1 formalparameterlistDerived1);
    public void visit(FunctionWithNoParm functionWithNoParm);
    public void visit(FunctionWithParm functionWithParm);
    public void visit(FunctionheaderDerived2 functionheaderDerived2);
    public void visit(FunctionheaderDerived1 functionheaderDerived1);
    public void visit(FunctionDecl functionDecl);
    public void visit(Identifier identifier);
    public void visit(VariableDecl variableDecl);
    public void visit(GlobalMainFunctionDecl globalMainFunctionDecl);
    public void visit(GlobalFunctionDecl globalFunctionDecl);
    public void visit(GlobalVariableDecl globalVariableDecl);
    public void visit(GlobaldeclarationsDerived1 globaldeclarationsDerived1);
    public void visit(Global global);
    public void visit(StringVal stringVal);
    public void visit(Constant constant);
    public void visit(AllGlobals allGlobals);
    public void visit(StDerived1 stDerived1);

}
