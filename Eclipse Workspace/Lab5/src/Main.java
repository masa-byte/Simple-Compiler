import java.io.*;

import AST.*;

public class Main {
    public static void main( String[] args ) {
        try {
            String filename = "testinput.txt";
            String fullPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + filename;
		    FileReader file = new FileReader( fullPath );
            MPLexer scanner = new MPLexer( file );
            MPParser parser = new MPParser( scanner );
            
            ASTNode ast = (ASTNode) parser.parse().value;
            String outputFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "output.txt";
            BufferedWriter writer = new BufferedWriter( new FileWriter( outputFilePath ) );
            ast.translate( writer );
            writer.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}