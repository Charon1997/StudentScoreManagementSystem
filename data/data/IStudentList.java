package data;

public interface IStudentList {
	 void addItem(String name,long id,int score1,int score2);
	 void deleteItem(int i);
	 
	 void showName(int i);
	 void showId(int i);
	 void showScore1(int i);
	 void showScore2(int i);
	 void showTotalScore(int i);
	 
	 void editName(int i,String newName);
	 void editId(int i,long newId);
	 void editScore1(int i,int newScore1);
	 void editScore2(int i,int newScore2);
	 
	 int getCount();
	 
	 String getName(int i);
	 long getId(int i);
	 int getScore1(int i);
	 int getScore2(int i);
	 int getTotalScore(int i);
}
