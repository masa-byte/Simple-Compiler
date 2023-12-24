import java.util.ArrayList;

public class SpecialField extends Field {

	public Integer leftRuleSide;
	public ArrayList<Integer> rightRuleSide;
	public Integer number;

	public SpecialField(String type, Integer number) {
		super(type);
		this.number = number;
		if (type == "r")
			this.createRuleSides();
		else {
			this.leftRuleSide = null;
			this.rightRuleSide = null;
		}
	}

	private void createRuleSides() {
		switch (number) {
			case 1:
				this.leftRuleSide = NonTerminal.WHILELOOP;
				this.rightRuleSide = new ArrayList<Integer>();
				this.rightRuleSide.add(sym.WHILE);
				this.rightRuleSide.add(NonTerminal.EXPRESSION);
				this.rightRuleSide.add(sym.COLON);
				this.rightRuleSide.add(NonTerminal.STATEMENT);
				this.rightRuleSide.add(sym.ELSE);
				this.rightRuleSide.add(NonTerminal.STATEMENT);
				break;
			case 2:
				this.leftRuleSide = NonTerminal.EXPRESSION;
				this.rightRuleSide = new ArrayList<Integer>();
				this.rightRuleSide.add(NonTerminal.EXPRESSION);
				this.rightRuleSide.add(sym.OR);
				this.rightRuleSide.add(NonTerminal.ANDEXPRESSION);
				break;
			case 3:
				this.leftRuleSide = NonTerminal.EXPRESSION;
				this.rightRuleSide = new ArrayList<Integer>();
				this.rightRuleSide.add(NonTerminal.ANDEXPRESSION);
				break;
			case 4:
				this.leftRuleSide = NonTerminal.ANDEXPRESSION;
				this.rightRuleSide = new ArrayList<Integer>();
				this.rightRuleSide.add(NonTerminal.ANDEXPRESSION);
				this.rightRuleSide.add(sym.AND);
				this.rightRuleSide.add(NonTerminal.TERM);
				break;
			case 5:
				this.leftRuleSide = NonTerminal.ANDEXPRESSION;
				this.rightRuleSide = new ArrayList<Integer>();
				this.rightRuleSide.add(NonTerminal.TERM);
				break;
			case 6:
				this.leftRuleSide = NonTerminal.TERM;
				this.rightRuleSide = new ArrayList<Integer>();
				this.rightRuleSide.add(sym.ID);
				break;
			case 7:
				this.leftRuleSide = NonTerminal.TERM;
				this.rightRuleSide = new ArrayList<Integer>();
				this.rightRuleSide.add(sym.CONST);
				break;
			case 8:
				this.leftRuleSide = NonTerminal.STATEMENT;
				this.rightRuleSide = new ArrayList<Integer>();
				this.rightRuleSide.add(NonTerminal.WHILELOOP);
				break;
			case 9:
				this.leftRuleSide = NonTerminal.STATEMENT;
				this.rightRuleSide = new ArrayList<Integer>();
				this.rightRuleSide.add(sym.ID);
				this.rightRuleSide.add(sym.ASSIGN);
				this.rightRuleSide.add(NonTerminal.EXPRESSION);
				this.rightRuleSide.add(sym.SEMICOLON);
				break;
		}
	}

	@Override
	public String toString() {
		String ret = String.format("%d -> ", leftRuleSide);
		for (int alpha : this.rightRuleSide)
			ret += String.format("%d ", alpha);
		return ret;
	}
}
