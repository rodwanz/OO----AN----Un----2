package application7;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities7.Employee2;

public class ProgramaEmployee2 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee2> list = new ArrayList<>();
		
		//PART 1 - READING DATA: - LENDO DADOS
		
		System.out.print("How many employee will be registered? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println();
			System.out.println("Employee #" + i + ": ");
			
			System.out.print("Id: ");
			int id = sc.nextInt();
			while (hasId(list, id)) {
				System.out.print("Id already taken. Try again: ");
				id = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			list.add(new Employee2(id, name, salary));
		}
		
		//PART 2 - UPDATES SALARY OF GIVEN EMPLOYEE: - ATUALIZANDO O SALÁRIO DO FUNCIONÁRIO
		
		System.out.println();
		System.out.print("Enter the employee id that will have salary incrase : ");
		int id = sc.nextInt();
		Employee2 emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("This id does not exist!");
		}else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}
		
		//PART 3 - LISTING EMPLOYEES: - LISTAGEM DE FUNCIONÁRIOS
		
		System.out.println();
		System.out.println("List of employees:");
		for (Employee2 obj : list) {
			System.out.println(obj);
		}
		
		sc.close();
	}
	
	public static boolean hasId(List<Employee2> list, int id) {
		Employee2 emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
		
	}

}
