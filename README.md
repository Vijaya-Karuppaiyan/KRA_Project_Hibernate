# Employee Performance Evaluation System (EPES).
  A Java-Hibernate based system to evaluate employee performance using KPIs and generate reports.
     - Vijaya K, Senior Faculty, Deep Tech, Anudip Foundation.
## Project Scope
  1. Evaluate employee performance using measurable KPIs
  2. Allow managers to record scores for each KPI twice a year
  3. Automatically calculate weighted scores
  4. Generate half-yearly performance reports with comments
  5. Maintain department, employee, KPI, and review data in a structured database
## Technology Stack
  - Frontend: Console-based Java UI
  - Backend: Core Java
  - ORM: Hibernate (JPA)
  - Database: MySQL
  - Tools: Eclipse, Maven 
  - Others: ANSI Colors for console output formatting
## Key Features / Modules
  - Department Management
  - Employee Management (Add, Update, Delete and view all employees)
  - KPI Management (Add, List)
  - Performance Review Entry (H1 & H2)
  - Report Generation per Employee and per Year
  - Console UI with ANSI coloring for clarity
## ER Diagram
  - Refer to uploaded diagram image.
  - Entities: Employee, Department, KPI, PerformanceReview, Report
  - Relationships:
  - Employee → Department (Many-to-One)
  - PerformanceReview → Employee, KPI (Many-to-One)
  - Report → Employee (Many-to-One)
    ![image](https://github.com/user-attachments/assets/08528933-9ada-4bf8-8840-3b5b5904c5da)
## Project Architecture
  - **Layered Architecture:**
  - Presentation Layer: Main class (EPESApp.java)
  - Service Layer: Business logic (PerformanceService, ReportService, etc.)
  - DAO Layer: Hibernate-based DB interaction (DAO classes)
  - Entity Layer: JPA Entities (Employee, Department, KPI, etc.)
    ![image](https://github.com/user-attachments/assets/9482f8ca-9f83-4ae0-bd90-a7189fb5568a)
## Sample Workflow
  1. Manager adds Department and Employees.
  2. Defines KPIs.
  3. Reviews employee KPIs every half year.
  4. System generates scores and performance reports.
  5. Manager views reports per employee or entire year.
## Sample Screenshots:
   Menu in the project:
     ![image](https://github.com/user-attachments/assets/214a0097-fc97-4b06-979a-a07789d46f6c)
   Viewed all KPIs:
     ![image](https://github.com/user-attachments/assets/7e47ec29-0434-46b4-a5e6-47ec90c32cfd)
   Viewed all Employees:
     ![image](https://github.com/user-attachments/assets/e0886808-3b19-4f44-8b06-4c8c5c1104e6)
   Employee performance report for the given EmployeeID:
     ![image](https://github.com/user-attachments/assets/d03c0673-bb62-47d5-a3f9-dc11a479ec73)
  All Employees performance report for the given year:
    Enter your choice: 7
    Enter year : 2025
===== Performance Reports for Year: 2025 ===== 
Employee ID: 1 
Half-Year: H1
Final Score: 87.0
Performance Rating:  Excellent 
-------------------------------------
Employee ID: 1 
Half-Year: H2
Final Score: 100.0 
Performance Rating:  Excellent 
------------------------------------- 
Employee ID: 2
Half-Year: H1
Final Score: 65.0 
Performance Rating: Satisfactory 
-------------------------------------
Employee ID: 2
Half-Year: H2
Final Score: 85.2 
Performance Rating:  Excellent 
------------------------------------- 
Employee ID: 4 
Half-Year: H1
Final Score: 89.0
Performance Rating: Excellent 
--------------------------------------
Employee ID: 3 
Half-Year: H1
Final Score: 67.0 
Performance Rating: Satisfactory 
---------------------------------------
Employee ID: 5 
Half-Year: H1
Final Score: 88.0 
Performance Rating:  Excellent
-------------------------------------

## Future Enhancements
 - Web-based frontend using Spring Boot +  React
 - Manager login and authentication
 - Export reports to PDF
 - Graphical dashboards
 - Notification/email integration
## Conclusion
  - The EPES system helps track and evaluate employee productivity using structured KPIs.
  - Built with clean modular architecture using Java and Hibernate.
  - Can be scaled and extended to enterprise-level web-based HR tools.
## Thankyou.
















