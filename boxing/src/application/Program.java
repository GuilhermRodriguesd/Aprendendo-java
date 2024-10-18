package application;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entites.Employee;

public class Program {

	public static void main(String[] args) {
		
		 Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>(); 
		
		System.out.println("Quantos funcionarios serao registrados?  ");
		int N = sc.nextInt();
		
		for (int i=0; i<N; i++) {
			
			System.out.println();
			System.out.println("Funcionario #" +(i + 1) + ":") ;
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			while (hasId(list, id)) {
				System.out.println("Esse ID já existe!");
			}
			
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salario: ");
			Double salary = sc.nextDouble();
			
			
			Employee emp = new Employee(id, name, salary);
			
			list .add(emp);
			
		}
		
		System.out.print("Entre com o id do funcionario que vai ter o salario incrementado: ");
		int idsalary = sc.nextInt();
		Integer pos = position(list, idsalary);
		if (pos == null) { 
		System.out.println("Esse ID não existe! ");
		}
		else {
			System.out.print("Qual a porcentagem?: ");
			double percent = sc.nextDouble();
			list.get(pos).increaseSalary(percent);
		}
		
		System.out.println();
		System.out.println("Lista dos funcionarios: ");
		for (Employee emp : list) {
			System.out.println(emp);
		}
		
		sc.close();
	}
		
	
		private static boolean hasId(List<Employee> list, Integer id) {
		 Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}


		public static Integer position(List<Employee> list, int id) {
			for (int i = 0; i < list.size(); i ++) {
				if (list.get(i).getId() ==id) {
					return i;
				}
			}
			return null;
		}
	
}
