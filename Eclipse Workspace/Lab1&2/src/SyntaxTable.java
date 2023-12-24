
public class SyntaxTable {

	private Field[][] syntaxTable;

	public SyntaxTable() {
		this.createSyntaxTable();
	}

	private void createSyntaxTable() {
		this.syntaxTable = new Field[21][15];

		for (int i = 0; i < 21; i++) {
			for (int j = 0; j < 15; j++) {
				this.syntaxTable[i][j] = new Field("err");
			}
		}

		// I0
		this.syntaxTable[0][0] = new SpecialField("s", 2);
		this.syntaxTable[0][10] = new SpecialField("goTo", 1);

		// I1
		this.syntaxTable[1][9] = new Field("acc");

		// I2
		this.syntaxTable[2][5] = new SpecialField("s", 6);
		this.syntaxTable[2][6] = new SpecialField("s", 7);
		this.syntaxTable[2][11] = new SpecialField("goTo", 3);
		this.syntaxTable[2][13] = new SpecialField("goTo", 4);
		this.syntaxTable[2][14] = new SpecialField("goTo", 5);

		// I3
		this.syntaxTable[3][1] = new SpecialField("s", 8);
		this.syntaxTable[3][3] = new SpecialField("s", 9);

		// I4
		this.syntaxTable[4][1] = new SpecialField("r", 3);
		this.syntaxTable[4][3] = new SpecialField("r", 3);
		this.syntaxTable[4][4] = new SpecialField("s", 10);
		this.syntaxTable[4][8] = new SpecialField("r", 3);

		// I5
		this.syntaxTable[5][1] = new SpecialField("r", 5);
		this.syntaxTable[5][3] = new SpecialField("r", 5);
		this.syntaxTable[5][4] = new SpecialField("r", 5);
		this.syntaxTable[5][8] = new SpecialField("r", 5);

		// I6
		this.syntaxTable[6][1] = new SpecialField("r", 6);
		this.syntaxTable[6][3] = new SpecialField("r", 6);
		this.syntaxTable[6][4] = new SpecialField("r", 6);
		this.syntaxTable[6][8] = new SpecialField("r", 6);

		// I7
		this.syntaxTable[7][1] = new SpecialField("r", 7);
		this.syntaxTable[7][3] = new SpecialField("r", 7);
		this.syntaxTable[7][4] = new SpecialField("r", 7);
		this.syntaxTable[7][8] = new SpecialField("r", 7);

		// I8
		this.syntaxTable[8][0] = new SpecialField("s", 2);
		this.syntaxTable[8][5] = new SpecialField("s", 13);
		this.syntaxTable[8][10] = new SpecialField("goTo", 12);
		this.syntaxTable[8][12] = new SpecialField("goTo", 11);

		// I9
		this.syntaxTable[9][5] = new SpecialField("s", 6);
		this.syntaxTable[9][6] = new SpecialField("s", 7);
		this.syntaxTable[9][13] = new SpecialField("goTo", 14);
		this.syntaxTable[9][14] = new SpecialField("goTo", 5);

		// I10
		this.syntaxTable[10][5] = new SpecialField("s", 6);
		this.syntaxTable[10][6] = new SpecialField("s", 7);
		this.syntaxTable[10][14] = new SpecialField("goTo", 15);

		// I11
		this.syntaxTable[11][2] = new SpecialField("s", 16);

		// I12
		this.syntaxTable[12][2] = new SpecialField("r", 8);
		this.syntaxTable[12][9] = new SpecialField("r", 8);

		// I13
		this.syntaxTable[13][7] = new SpecialField("s", 17);

		// I14
		this.syntaxTable[14][1] = new SpecialField("r", 2);
		this.syntaxTable[14][3] = new SpecialField("r", 2);
		this.syntaxTable[14][4] = new SpecialField("s", 10);
		this.syntaxTable[14][8] = new SpecialField("r", 2);

		// I15
		this.syntaxTable[15][1] = new SpecialField("r", 4);
		this.syntaxTable[15][3] = new SpecialField("r", 4);
		this.syntaxTable[15][4] = new SpecialField("r", 4);
		this.syntaxTable[15][8] = new SpecialField("r", 4);

		// I16
		this.syntaxTable[16][0] = new SpecialField("s", 2);
		this.syntaxTable[16][5] = new SpecialField("s", 13);
		this.syntaxTable[16][10] = new SpecialField("goTo", 12);
		this.syntaxTable[16][12] = new SpecialField("goTo", 18);

		// I17
		this.syntaxTable[17][5] = new SpecialField("s", 6);
		this.syntaxTable[17][6] = new SpecialField("s", 7);
		this.syntaxTable[17][11] = new SpecialField("goTo", 19);
		this.syntaxTable[17][13] = new SpecialField("goTo", 4);
		this.syntaxTable[17][14] = new SpecialField("goTo", 5);

		// I18
		this.syntaxTable[18][2] = new SpecialField("r", 1);
		this.syntaxTable[18][9] = new SpecialField("r", 1);

		// I19
		this.syntaxTable[19][8] = new SpecialField("s", 20);

		// I20
		this.syntaxTable[20][2] = new SpecialField("r", 9);
		this.syntaxTable[20][9] = new SpecialField("r", 9);
	}

	public Field get(int alpha, int beta) {
		return this.syntaxTable[alpha][beta];
	}
}
