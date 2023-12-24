
import java.util.Hashtable;
public class KWTable {

	private Hashtable<String, Integer> mTable;
	public KWTable()
	{
		mTable = new Hashtable<>();
		mTable.put("program", sym.PROGRAM);
		mTable.put("integer", sym.INTEGER);
		mTable.put("char", sym.CHAR);
		mTable.put("real", sym.REAL);
		mTable.put("boolean", sym.BOOLEAN);
		mTable.put("begin", sym.BEGIN);
		mTable.put("end", sym.END);
		mTable.put("else", sym.ELSE);
		mTable.put("while", sym.WHILE);
	}
	
	public int find(String keyword)
	{
		Object symbol = mTable.get(keyword);
		if (symbol != null)
			return ((Integer)symbol).intValue();
		
		System.out.println("ID");
		return sym.ID;
	}
}
