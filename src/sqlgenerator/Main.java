package sqlgenerator;

public class Main {
	
	public static void main(String[] args) {
		// 実行クラス
		SchoolClass class1A = new SchoolClass();
		Exam midtermExam = new Exam(class1A);
		
		System.out.println(SqlText.SEMICOLON);
	}
}
