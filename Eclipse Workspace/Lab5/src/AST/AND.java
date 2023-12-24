package AST;

public class AND extends BinaryExpression {
    
    public AND( Expression left, Expression right )
    {
        super( left, right );
    }
    
    protected String opCode()
    {
        return "And";
    }
}