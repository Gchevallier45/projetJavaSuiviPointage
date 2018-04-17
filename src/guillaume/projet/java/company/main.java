package guillaume.projet.java.company;

import java.time.LocalTime;

import guillaume.projet.java.time.Check;
import guillaume.projet.java.time.Time;
import guillaume.projet.java.time.WorkingDay;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MainWindow main = new MainWindow();
		stubFunction();	
	}
	
	public static void stubFunction() {
		try {
			Company testCompany = new Company("coucou");
			Department d = new Department("info");
			Check check = new Check();
			check.check();
			check.check();
			//System.out.println(check.getOutCheck().getRoundedTime());
			Employee e = new Employee("jean","bon","0123456789",42,"jeanbon@beurre.fr",new WorkingDay(LocalTime.of(8,15),LocalTime.of(18,15)));
			Employee er = new Employee("jean","ninja","0123458789",42,"jeanninja@beurre.fr",new WorkingDay(LocalTime.of(8,15),LocalTime.of(18,15)));
			Employee ere = new Employee("jean","bon","0123456789",42,"jeanbon@beurre.fr",new WorkingDay(LocalTime.of(8,15),LocalTime.of(18,15)));
			testCompany.addDepartment(d);
			testCompany.addEmployee(e,d);
			testCompany.addEmployee(er,d);
			//testCompany.addEmployee(ere);
			//System.out.println(e.getId());
			//System.out.println(er.getId());
			//System.out.println(e.getLastName());
			System.out.println(testCompany);
			testCompany.removeEmployee(e);
			System.out.println(testCompany);
			testCompany.addEmployee(e,d);
			System.out.println(testCompany);
			testCompany.removeDepartment(d);
			System.out.println(testCompany);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}

}
