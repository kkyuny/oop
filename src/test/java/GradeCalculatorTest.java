import org.example.grade.domain.Course;
import org.example.grade.domain.Courses;
import org.example.grade.domain.GradeCalculator;
import org.example.grade.domain.GradeResult;
import org.example.grade.ui.ConsoleOutputUI;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GradeCalculatorTest {
    // 학점계산기, 코스
    // 평균학점 계산 요청 ---> '학점계산기'는 계산에 필요한 정보를 코스 도메인(일급 컬렉션)에 요청
    //                ---> 코스는 (학점수×교과목 평점)의 합계와 수강신청 총학점 수를 학점계산기에 다시 전달
    //                ---> 학점 계산기는 계산만 수행해서 최초 요청온 곳에 최종 값을 전달한다.
    @Test
    void calculateGradeTest() {
        // given
        List<Course> courses = List.of(new Course("OOP", Course.MAJOR_CREDIT, "A+"),
                new Course("자료구조", Course.MAJOR_CREDIT, "A+"),
                new Course("중국어회화", Course.GENERAL_CREDIT, "C"));

        // when
        GradeCalculator gradeCalculator = new GradeCalculator(new Courses(courses));
        GradeResult gradeResult = gradeCalculator.calculateGrade();

        // then
        ConsoleOutputUI.printGrade(gradeResult);
    }
}
