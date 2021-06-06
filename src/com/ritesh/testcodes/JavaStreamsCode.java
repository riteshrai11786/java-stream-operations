package com.ritesh.testcodes;

import com.ritesh.testcodes.model.Employee;
import com.ritesh.testcodes.repository.EmployeeRepository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreamsCode {

    private static Employee[] arrayOfEmployees = {
            new Employee(1, "John", "Bezos", 100000.0),
            new Employee(2, "Bill", "Smart", 200000.0),
            new Employee(3, "Mark", "Teller", 300000.0)
    };

    private static List<Employee> employeeList = Arrays.asList(arrayOfEmployees);
    private static EmployeeRepository employeeRepository = new EmployeeRepository(employeeList);

    public static void main(String [] args) {



        // Convert the array of employees to ArrayList. Old school way :)
        System.out.println(employeeList.toString());

        // Approach 1 is to Stream.of
        Stream.of(arrayOfEmployees[0], arrayOfEmployees[1], arrayOfEmployees[2])
                .forEach( emp -> System.out.print(emp.toString() + ", "));

        System.out.println();
        // Using the Stream builder
        Stream.Builder<Employee> empStreamBuilder = Stream.builder();

        // Insert the elements to the stream
        empStreamBuilder.accept(arrayOfEmployees[0]);
        empStreamBuilder.accept(arrayOfEmployees[1]);
        empStreamBuilder.accept(arrayOfEmployees[2]);

        // print values from employees stream
        Stream<Employee> empStream = empStreamBuilder.build();
        empStream.forEach(emp -> System.out.print(emp.toString() + ", "));
        System.out.println();
        // Let's do it by functions now
        printEmplyeeIds(employeeList);
        // Let's sort below int array
        int[] someRandomArray = {11,34,1,99,22,10,6};
        sortAnIntArray(someRandomArray);
        // Now, let's sort the employee objects based on firstname, then last name then salary
        sortByMultipleFields(arrayOfEmployees);
        System.out.println();
        // find if the ids is present
        Integer[] empIds = {1,2,3};
        findAndMapEmpIds(empIds);
        // Let's do some int[] and Integer operaions
        dealWithIntArraysAndLists();
        //filter stream of employees based on multiple conditions
        filterEmployees();
        // Now let's find first
        firstEmployee();
        // Convert list to array
        printEmployeeArray();
        // Let's try flatMap now
        flatMapOperation();
        //intermediate operation
        increaseSalaryOfEveryEmployee();

    }

    private static void increaseSalaryOfEveryEmployee() {
        List<Employee> listOfSalIncEmps = Arrays.stream(arrayOfEmployees)
                .peek(emp -> emp.salaryIncrement(10.0))
                .peek(emp -> emp.setSalary(emp.getSalary() + 10))
                .peek(System.out::print)
                .collect(Collectors.toList());
        System.out.println("Original list : ");
        System.out.print(arrayOfEmployees);
        System.out.println("List after peek operations list : ");
        listOfSalIncEmps.forEach(System.out::print);
    }

    private static void flatMapOperation() {
        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("John", "Bezos"),
                Arrays.asList("Bill", "Smart"),
                Arrays.asList("Mark", "Teller"));
        List<String> namesFlatStream = namesNested.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println();
        System.out.print(namesFlatStream);
    }

    private static void printEmployeeArray() {
        Employee[] employees = employeeList.stream().toArray(Employee[]::new);
        System.out.println();
        Arrays.stream(employees).forEach(System.out::print);
        // Let's do this with int now
        int[] tempArray = {2, 1, 3, 4};
        List<Integer> listOfInt = new ArrayList<>();
        System.out.println();
        listOfInt = Arrays.stream(tempArray).boxed().collect(Collectors.toList());
        listOfInt.stream().forEach(System.out::print);
        Integer[] ints = listOfInt.stream().toArray(Integer[]::new);
        System.out.println();
        Arrays.stream(ints).forEach(System.out::print);
    }

    private static void firstEmployee() {
        Integer[] empIds = { 1, 2, 3, 4 };

        Employee employee = Arrays.stream(empIds)
                .map(employeeRepository::findById)
                .filter(e -> e !=null)
                .filter(e -> e.getSalary() > 100000)
                .findFirst()
                .orElse(null);
        System.out.println();
        System.out.print(employee.toString());
    }

    private static void filterEmployees() {
        Integer[] empIds = {1,2,3,4};

        List<Employee> employees = Stream.of(empIds)
                .map(employeeRepository::findById)
                .filter(e -> e!= null)
                .filter(e -> e.getSalary() >= 200000)
                .collect(Collectors.toList());
                //Above is cean way of writing code
                /*Arrays.stream(empIds).map(employeeRepository::findById)
                .filter(e -> {
                    if (e!=null && e.getSalary()>=200000)
                        return true;
                    return false;
                }).collect(Collectors.toList());*/

        System.out.println();
        System.out.print(employees);
    }

    private static void dealWithIntArraysAndLists() {
        //Convert int[] to Integer List
        int[] someIntArray = {21,14,61,77,0,6, 33, 2};
        System.out.println("Without sorting : ");
        Arrays.stream(someIntArray).forEach(idx -> System.out.print(idx + ", "));
        System.out.println();
        System.out.println("After Sorting : ");
        IntStream.of(someIntArray).sorted().forEach(idx -> System.out.print(idx + ", "));
        System.out.println();
        // first way to convert
        List<Integer> someIntegerList = Arrays.stream(someIntArray).boxed().collect(Collectors.toList());
        someIntegerList.stream().forEach(idx -> System.out.print(idx + ", "));
        System.out.println();
        someIntegerList.sort(Comparator.naturalOrder());
        someIntegerList.stream().forEach(idx -> System.out.print(idx + ", "));
        System.out.println();
        // Another way to convert to the List
        List<Integer> anotherIntegerList = IntStream.of(someIntArray).boxed().collect(Collectors.toList());
        anotherIntegerList.stream().forEach(idx -> System.out.print(idx + ", "));
        System.out.println();
    }

    private static void findAndMapEmpIds(Integer[] empIds) {
        List<Employee> employees = Stream.of(empIds)
                .map(employeeRepository::findById)
                .collect(Collectors.toList())
                ;
        System.out.println(employees.toString());
    }

    private static void sortByMultipleFields(Employee[] someRandomArray) {
        List<Employee> empList = Arrays.asList(someRandomArray)
                .stream()
                .sorted(Comparator.comparing(Employee::getFirstName)
                .thenComparing(Employee::getLastName)
                .thenComparing(Employee::getSalary))
                .collect(Collectors.toList());
        empList.stream().forEach(System.out::print);
    }

    private static void sortAnIntArray(int[] someRandomArray) {
        // sort and print
        Arrays.stream(someRandomArray).sorted().forEach(i -> System.out.print(i + ", "));
    }

    private static void printEmplyeeIds(List<Employee> employeeList) {
        // Create the int array from the object list
        int[] empIds =  /*(Integer[]) employeeList.stream()
                .map(emp -> emp.getEmployeeId())
                .toArray();*/
                employeeList.stream()
                        .mapToInt(Employee::getEmployeeId)
                        .toArray();
        // print from stream array
        Arrays.stream(empIds).forEach(System.out::print);
        System.out.println();
        // Convert int array to ArrayList of integer
        List<Integer> empIdList = Arrays.stream(empIds).boxed().collect(Collectors.toList());
        empIdList.stream().forEach(System.out::print);
        System.out.println();

    }
}
