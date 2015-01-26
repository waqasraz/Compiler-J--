
public class Yytoken {

	private String _type;
	private String _text;
	private int _line;
	private int _sym;
	
	public Yytoken(String type, String text, int line, int sym)
	{
		_type = type;
		_text = text;
		_line = line;
		_sym  = sym;
	}
	
	public String toString()
	{
		return "Type ("+_type+"): "+_text+" (line: "+_line+") (Symbol: "+_sym+")"; 
	}
}
