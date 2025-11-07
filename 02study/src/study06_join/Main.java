package study06_join;

public class Main {

	public static void main(String[] args) {

		Member st1 = new Member("홍길동", 16);
		Member st2 = new StudentMember("이순신", 18, "수원초");
		Member t1 = new TeacherMember("호날두", 25, "체육");

		StudentMember st3 = (StudentMember) st2;

		st1.showInfo();
		st3.study();
	}

}
