import java.io.Reader;
import java.util.Stack;

public class SyntaxAnalyzer {
    private Stack<Integer> stack;
    private MPLexer lexicAnalizator;
    private SyntaxTable syntaxTable;

    public SyntaxAnalyzer(Reader in) {
        this.lexicAnalizator = new MPLexer(in);
        this.syntaxTable = new SyntaxTable();
        this.stack = new Stack<Integer>();
        this.stack.push(0);
    }

    public int LR() {
        int accepted = 0, error = 0, k, top_state;
        Yytoken next = this.nextlex();
        Field field;

        do {
            field = getField(top(), next);

            switch (field.type) {
                case "acc":
                    accepted = 1;
                    break;
                case "err":
                    error = 1;
                    break;
                case "s":
                    this.stack.push(next.m_index);
                    this.stack.push(((SpecialField)field).number);
                    next = this.nextlex();
                    break;
                case "r":
                    k = ((SpecialField)field).number;
                    pop(2 * ((SpecialField)field).rightRuleSide.size());

                    top_state = top();
                    push(((SpecialField)field).leftRuleSide);
                    push(goTo(top_state, ((SpecialField)field).leftRuleSide));
                    break;
            }
        } while (accepted == 0 && error == 0);

        return accepted;
    }



    private Yytoken nextlex() {
        try {
            return this.lexicAnalizator.next_token();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Field getField(int alpha, Yytoken next) {
        Field returnField = null;
        try {
            System.out.println("State: " + top());
            System.out.println("Next: " + next.m_index + " [" + next.m_text + "]");
            returnField = this.syntaxTable.get(alpha, next.m_index);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnField;
    }

    private int top() {
        try {
            return this.stack.peek();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    private void pop(int amount) {
        try {
            for (int i = 0; i < amount; i++)
                this.stack.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void push(int token) {
        this.stack.push(token);
    }
    
    private int goTo(int alpha, Integer reduction) {
        int ret = -1;
        try {
            Field field = this.syntaxTable.get(alpha, reduction);
            ret = ((SpecialField)field).number;
            System.out.println("Goto(" + alpha + ", " + reduction + ") = " + ret);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
