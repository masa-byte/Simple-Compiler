package AST;

public class OR extends BinaryExpression {
    
    public OR( Expression left, Expression right )
    {
        super( left, right );
    }
    
    protected String opCode()
    {
    	return "Or";
    }
}