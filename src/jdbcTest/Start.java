package jdbcTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		System.out.println("student data entry");
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			System.out.println("press 1 to ADD student");
			System.out.println("press 2 to Delete student");
			System.out.println("press 3 to Display student");
			System.out.println("press 4 exit app");
			int choice=Integer.parseInt(br.readLine());
			
			if(choice==1)
			{
				//add student
				System.out.println("Enter user name:");
				String name=br.readLine();
				System.out.println("Enter user phno:");
				String phone=br.readLine();
				
				//create student object
				Student st=new Student(name,phone);
				boolean answer=StudentDao.insertStudentToDB(st);
				if(answer)
				{
					System.out.println("Student is added successfully...");
				}else {
					System.out.println("something went wrong");
				}
				System.out.println(st);
			}else if(choice==2)
			{
				//delete student
				System.out.println("Enter student id to delete:");
				int userId=Integer.parseInt(br.readLine());
				boolean f=StudentDao.deleteStudent(userId);
				if(f) {
					System.out.println("Deleted");
				}else {
					System.out.println("something went wrong");
				}
			}else if(choice==3)
			{
				//display student
				StudentDao.showAllStudent();
			}else if(choice==4)
			{
				//exit
				break;
			}else {

			}
			
		}
		System.out.println("Thank you using my application....");
		System.out.println("bye");

	}

}
