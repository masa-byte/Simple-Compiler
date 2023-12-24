package AST;

public class LESS extends BinaryExpression {

    public LESS( Expression left, Expression right )
    {
        super( left, right );
    }
    
    protected String opCode()
    {
        return "Compare_Less";
    }
}