package sqlgenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Exam {
	// 試験名
	final String name;
	// 試験日
	final Date date;
	// 試験の日数
	final int days;
	// 生徒ごとの試験結果
	final List<ExamResult> examResults;

	public Exam(SchoolClass schoolClass) {
		// 試験名
		this.name = "中間考査";
		// 試験日
		this.date = new Date();
		// 試験の日数
		this.days = 3;
		
		// テスト結果の生成
		List<ExamResult> examResults = generateExamResult(schoolClass);
		this.examResults = Collections.unmodifiableList(examResults);
	}
	
	private List<ExamResult> generateExamResult(SchoolClass schoolClass) {
		List<ExamResult> examResult = new ArrayList<ExamResult>();
		for (Student student : schoolClass.students) {
			examResult.add(new ExamResult(student));
		}
		return examResult;
	}
}

class ExamResult {
	
	// 生徒ごとのテスト結果
	final int classNumber;
	final String studentName;
	final boolean attendance;
	final int nationalLanguage;
	final int math;
	final int socialStudies;
	final int science;
	final int english;
	
	public ExamResult(Student student) {
		this.classNumber = student.classNumber;
		this.studentName = student.name;
		
		// ここからしたはランダムにする
		this.attendance = true;
		this.nationalLanguage = 100;
		this.math = 100;
		this.socialStudies = 100;
		this.science = 100;
		this.english = 100;
	}
}
