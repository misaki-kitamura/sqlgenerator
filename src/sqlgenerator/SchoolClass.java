package sqlgenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

public class SchoolClass {
	// 在籍生徒のリスト
	final List<Student> students;
	
	public SchoolClass() {
		// csvファイルを読み込み
		List<EnumMap<StudentsList, String>> csvData = CsvReader.getCsvMapList(Tables.STUDENTS_LIST.toString());
		// csvデータを元にStudentオブジェクトを生成
		List<Student> students = new ArrayList<Student>();
		for (int i = 0; i < students.size(); i++) {
			students.add(new Student(csvData.get(i)));
		}
		this.students = Collections.unmodifiableList(students);
	}
}

class Student {
	final int classNumber;
	final String name;
	final String furigana;
	final String gender;
	final String club;
	
	public Student(EnumMap<StudentsList, String> student) {
		classNumber = Integer.valueOf(student.get(StudentsList.CLASS_NUMBER));
		name = student.get(StudentsList.NAME);
		furigana = student.get(StudentsList.FURIGANA);
		gender = student.get(StudentsList.GENDER);
		club = student.get(StudentsList.CLUB);
	}
}
