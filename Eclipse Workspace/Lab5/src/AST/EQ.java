package AST;

public class EQ extends BinaryExpression {

    public EQ( Expression left, Expression right )
    {
        super( left, right );
    }
    
    protected String opCode()
    {
        return "Compare_Equal";
    }
}