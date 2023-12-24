package AST;

import java.io.*;

public class WhileLoop extends Statement{
    private Statement loopStatement;
    private Statement elseStatement;
    private Expression condition;
    
    public WhileLoop(Expression e, Statement loopS, Statement elseS)
    {
        condition = e;
        loopStatement = loopS;
        elseStatement = elseS;
    }
    
    public void translate( BufferedWriter out )
    throws IOException
    {
        String loopLabel = ASTNode.genLab();
        String elseLabel = ASTNode.genLab();
        String endLabel = ASTNode.genLab();
        out.write( loopLabel + ":" );
        out.newLine();
        condition.translate( out );
        condition.genLoad( "R1", out );
        out.write( "\tJumpIfZero\tR1, " + elseLabel );
        out.newLine();
        loopStatement.translate( out );
        out.write( "\tJump\t" + loopLabel );
        out.newLine();
		out.write( elseLabel + ":" );
		out.newLine();
        elseStatement.translate( out );
        out.write( endLabel + ":" );
        out.newLine();
    }
}