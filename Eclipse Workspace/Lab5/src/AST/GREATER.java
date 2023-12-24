package AST;

public class GREATER extends BinaryExpression {

    public GREATER( Expression left, Expression right )
    {
        super( left, right );
    }
    
    protected String opCode()
    {
        return "Compare_Greater";
    }
}