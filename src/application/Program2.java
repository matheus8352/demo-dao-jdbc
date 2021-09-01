package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== TEST 1: seller findById ====");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n==== TEST 2: seller findAll ====");
		List<Department> list = departmentDao.findAll();
		list.forEach(System.out::println);
		
		/*System.out.println("\n==== TEST 3: seller insert ====");
		department = new Department(null, "Non alcoholic drinks");
		departmentDao.insert(department);
		System.out.println("Inserted! New ID = " + department.getId());*/
		
		System.out.println("\n==== TEST 4: seller update ====");
		System.out.println("Enter id for update test: ");
		int id = scanner.nextInt();
		department = departmentDao.findById(id);
		if(department != null) {
			department.setName("Alcoholic drinks");
			departmentDao.update(department);
			System.out.println("Update completed");
		}
		
		System.out.println("\n==== TEST 5: seller delete ====");
		System.out.println("Enter id for delete test: ");
		id = scanner.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		scanner.close();
	}
}
