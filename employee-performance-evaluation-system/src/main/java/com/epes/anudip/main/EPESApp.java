package com.epes.anudip.main;

import java.util.List;
import java.util.Scanner;

import com.epes.anudip.entity.Department;
import com.epes.anudip.entity.Employee;
import com.epes.anudip.entity.KPI;
import com.epes.anudip.service.DepartmentService;
import com.epes.anudip.service.EmployeeService;
import com.epes.anudip.service.KPIService;
import com.epes.anudip.service.PerformanceService;
import com.epes.anudip.service.ReportService;
import com.epes.anudip.util.ConsoleColors;

public class EPESApp {

    public static void main(String[] args) {

        Scanner ip = new Scanner(System.in);

        // Initialize Services
        EmployeeService empServ = new EmployeeService();
        DepartmentService deptServ = new DepartmentService();
        KPIService kpiServ = new KPIService();
        PerformanceService perfServ = new PerformanceService();
        ReportService repServ = new ReportService();

        while (true) {
            System.out.println(ConsoleColors.BOLD_CYAN + "\n====== Employee Performance Evaluation System ======" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BOLD_YELLOW + "1. Add Department" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BOLD_YELLOW + "2. Add Employee" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BOLD_YELLOW + "3. Add KPI" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BOLD_YELLOW + "4. View All KPIs" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BOLD_YELLOW + "5. Add Performance Review" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BOLD_YELLOW + "6. Generate Employee Performance Report" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BOLD_YELLOW + "7. Generate All Employees Report for a year" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BOLD_YELLOW + "8. View All Employees" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BOLD_YELLOW + "9. Update Employee" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BOLD_YELLOW + "10. Delete Employee" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BOLD_RED + "11. Exit" + ConsoleColors.RESET);
            System.out.print(ConsoleColors.BOLD_BLUE + "Enter your choice: " + ConsoleColors.RESET);

            int choice = ip.nextInt();
            ip.nextLine(); // consume new line

            switch (choice) {
                case 1:
                    System.out.print(ConsoleColors.BOLD_BLUE + "Enter Department Name: " + ConsoleColors.RESET);
                    String deptName = ip.nextLine();
                    Department dept = new Department();
                    dept.setName(deptName);
                    deptServ.addDepartment(dept);
                    System.out.println(ConsoleColors.BOLD_GREEN + "✔ Department added successfully!" + ConsoleColors.RESET);
                    break;

                case 2:
                    System.out.print(ConsoleColors.BOLD_BLUE + "Enter Department ID: " + ConsoleColors.RESET);
                    int deptId = ip.nextInt();
                    ip.nextLine();
                    System.out.print(ConsoleColors.BOLD_BLUE + "Enter Employee Name: " + ConsoleColors.RESET);
                    String empName = ip.nextLine();
                    System.out.print(ConsoleColors.BOLD_BLUE + "Enter Employee Designation: " + ConsoleColors.RESET);
                    String empDesig = ip.nextLine();
                    System.out.print(ConsoleColors.BOLD_BLUE + "Enter Employee Email: " + ConsoleColors.RESET);
                    String empEmail = ip.nextLine();
                    Department deptEmp = deptServ.getDepartmentById(deptId);

                    if (deptEmp == null) {
                        System.out.println(ConsoleColors.BOLD_RED + "✘ Invalid Department Id" + ConsoleColors.RESET);
                        break;
                    }

                    Employee emp = new Employee();
                    emp.setName(empName);
                    emp.setDesignation(empDesig);
                    emp.setEmail(empEmail);
                    emp.setDept(deptEmp);
                    empServ.addEmployee(emp);
                    break;

                case 3:
                    System.out.print(ConsoleColors.BOLD_BLUE + "\nEnter KPI Name: " + ConsoleColors.RESET);
                    String kpiName = ip.nextLine();
                    System.out.print(ConsoleColors.BOLD_BLUE + "\nEnter KPI Weightage (1-100): " + ConsoleColors.RESET);
                    int weightage = ip.nextInt();
                    KPI kpi = new KPI();
                    kpi.setName(kpiName);
                    kpi.setWeightage(weightage);
                    kpiServ.addKPI(kpi);
                    System.out.println(ConsoleColors.BOLD_GREEN + "✔ KPI added successfully!" + ConsoleColors.RESET);
                    break;

                case 4:
                    List<KPI> kpis = kpiServ.getAllKPIs();
                    System.out.println(ConsoleColors.BOLD_PURPLE + "\nAll KPIs:" + ConsoleColors.RESET);
                    System.out.printf(ConsoleColors.BOLD_BLUE + "%-10s %-20s %-10s\n" + ConsoleColors.RESET, "KPI ID", "KPI Name", "Weightage");
                    for (KPI k : kpis) {
                        System.out.printf("%-10d %-20s %-10d\n", k.getKpiId(), k.getName(), k.getWeightage());
                    }
                    break;

                case 5:
                    System.out.print(ConsoleColors.BOLD_BLUE + "\nEnter Employee ID to add performance review: " + ConsoleColors.RESET);
                    int reviewEmpId = ip.nextInt();
                    Employee reviewEmp = empServ.getEmployeeById(reviewEmpId);

                    if (reviewEmp != null) {
                        perfServ.addPerformanceReview(reviewEmp);
                    } else {
                        System.out.println(ConsoleColors.BOLD_RED + "✘ Invalid Employee ID." + ConsoleColors.RESET);
                    }
                    break;

                case 6:
                    System.out.print(ConsoleColors.BOLD_BLUE + "Enter Employee ID to generate performance report: " + ConsoleColors.RESET);
                    int reportEmpId = ip.nextInt();
                    repServ.generatePerformanceReport(reportEmpId);
                    break;

                case 7:
                    System.out.print(ConsoleColors.BOLD_BLUE + "Enter Year to view all employee reports: " + ConsoleColors.RESET);
                    int year = ip.nextInt();
                    repServ.generateYearlyReport(year);
                    break;

                case 8:
                    List<Employee> emps = empServ.getAllEmployees();
                    System.out.println(ConsoleColors.BOLD_CYAN + "\n========= All Employees =========" + ConsoleColors.RESET);
                    System.out.printf(ConsoleColors.BOLD_BLUE + "%-8s %-15s %-10s %-15s %-20s %-30s\n" + ConsoleColors.RESET,
                            "EmpId", "EmpName", "DeptId", "DeptName", "Designation", "Email");
                    for (Employee e : emps) {
                        System.out.printf("%-8d %-15s %-10d %-15s %-20s %-30s\n",
                                e.getEmployeeId(),
                                e.getName(),
                                e.getDept().getDepartmentId(),
                                e.getDept().getName(),
                                e.getDesignation(),
                                e.getEmail());
                    }
                    break;

                case 9:
                    System.out.print(ConsoleColors.BOLD_BLUE + "Enter Employee ID to update: " + ConsoleColors.RESET);
                    int updateId = ip.nextInt();
                    ip.nextLine();
                    Employee updateEmp = empServ.getEmployeeById(updateId);
                    if (updateEmp != null) {
                        System.out.print("Enter new name: ");
                        updateEmp.setName(ip.nextLine());
                        System.out.print("Enter new designation: ");
                        updateEmp.setDesignation(ip.nextLine());
                        System.out.print("Enter new email: ");
                        updateEmp.setEmail(ip.nextLine());
                        empServ.updateEmployee(updateEmp);
                        System.out.println(ConsoleColors.BOLD_GREEN + "✔ Employee updated successfully!" + ConsoleColors.RESET);
                    } else {
                        System.out.println(ConsoleColors.BOLD_RED + "✘ Invalid Employee ID." + ConsoleColors.RESET);
                    }
                    break;

                case 10:
                    System.out.print(ConsoleColors.BOLD_BLUE + "Enter Employee ID to delete: " + ConsoleColors.RESET);
                    int deleteId = ip.nextInt();
                    empServ.deleteEmployee(deleteId);
                    System.out.println(ConsoleColors.BOLD_GREEN + "✔ Employee deleted successfully!" + ConsoleColors.RESET);
                    break;

                case 11:
                    System.out.println(ConsoleColors.BOLD_RED + "Exiting the system... Goodbye!" + ConsoleColors.RESET);
                    ip.close();
                    System.exit(0);

                default:
                    System.out.println(ConsoleColors.BOLD_RED + "✘ Invalid choice! Please try again." + ConsoleColors.RESET);
            }
        }
    }
}
