package sqlgenerator;

public enum SqlText {
	INSERT("INSERT"),
	INTO("INTO"),
	LEFT_PARENTHESIS("("),
	RIGHT_PARENTHESIS(")"),
	SEMICOLON(";");
	
	String text;

	SqlText(String text) {
		this.text = text;
	}

	public String toString() {
		return this.text;
	}
}
