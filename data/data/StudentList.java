package data;

import java.util.ArrayList;

public class StudentList implements IStudentList{
	private ArrayList<Student> studentList = new ArrayList<Student>();
	
	private StudentList(){};
    private static StudentList c = new StudentList();
	public static StudentList getStudentList() {
		return c;
	}
	

	@Override
	public void addItem(String name, long id, int score1, int score2) {
		// TODO 自动生成的方法存根
		Student student = new Student(id, name, score1, score2);
		studentList.add(student);
	}

	@Override
	public void deleteItem(int i) {
		// TODO 自动生成的方法存根
		studentList.remove(i);
	}

	@Override
	public void showName(int i) {
		// TODO 自动生成的方法存根
		if (i < studentList.size()) {
			System.out.println("名字："+studentList.get(i).getStudentName());
		}
	}

	@Override
	public void showId(int i) {
		// TODO 自动生成的方法存根
		if (i < studentList.size()) {
			System.out.println("学号："+studentList.get(i).getStudentId());
		}
		
	}

	@Override
	public void showScore1(int i) {
		// TODO 自动生成的方法存根
		if (i < studentList.size()) {
			System.out.println("课程1："+studentList.get(i).getScore1());
		}
		
	}

	@Override
	public void showScore2(int i) {
		// TODO 自动生成的方法存根
		if (i < studentList.size()) {
			System.out.println("课程2："+studentList.get(i).getScore2());
		}
		
	}

	@Override
	public void showTotalScore(int i) {
		// TODO 自动生成的方法存根
		if (i < studentList.size()) {
			System.out.println("总成绩："+studentList.get(i).getTotalScore());
		}
	}

	
	@Override
	public void editName(int i, String newName) {
		// TODO 自动生成的方法存根
		if (i < studentList.size()) {
			studentList.get(i).setStudentName(newName);
		}
	}

	@Override
	public void editId(int i, long newId) {
		// TODO 自动生成的方法存根
		if (i < studentList.size()) {
			studentList.get(i).setStudentId(newId);
		}
	}

	@Override
	public void editScore1(int i, int newScore1) {
		// TODO 自动生成的方法存根
		if (i < studentList.size()) {
			studentList.get(i).setScore1(newScore1);
			studentList.get(i).setTotalScore(studentList.get(i).getScore2()+newScore1);
		}
	}

	@Override
	public void editScore2(int i, int newScore2) {
		// TODO 自动生成的方法存根
		if (i < studentList.size()) {
			studentList.get(i).setScore2(newScore2);
			studentList.get(i).setTotalScore(studentList.get(i).getScore1()+newScore2);
		}
	}

	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return studentList.size();
	}

	@Override
	public String getName(int i) {
		// TODO 自动生成的方法存根
		if (i < studentList.size()) {
			return studentList.get(i).getStudentName();
		} else {
			return "系统错误";
		}
		
	}

	@Override
	public long getId(int i) {
		// TODO 自动生成的方法存根
		if (i < studentList.size()) {
			return studentList.get(i).getStudentId();
		} else {
			return 0;
		}
	}

	@Override
	public int getScore1(int i) {
		// TODO 自动生成的方法存根
		if (i < studentList.size()) {
			return studentList.get(i).getScore1();
		} else {
			return -1;
		}
	}

	@Override
	public int getScore2(int i) {
		// TODO 自动生成的方法存根
		if (i < studentList.size()) {
			return studentList.get(i).getScore2();
		} else {
			return -1;
		}
	}

	@Override
	public int getTotalScore(int i) {
		// TODO 自动生成的方法存根
		if (i < studentList.size()) {
			return studentList.get(i).getTotalScore();
		} else {
			return -1;
		}
	}

	
	
	}
