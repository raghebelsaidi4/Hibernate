# Employee Management System (JPA + Hibernate)

## Overview
This project is a simple Employee Management System using Java Persistence API (JPA) with Hibernate as the ORM framework. It demonstrates CRUD operations on an Employee entity using Hibernate with MySQL as the database.

## Technologies Used
- Java
- JPA (Jakarta Persistence API)
- Hibernate ORM
- MySQL Database
- Maven (for dependency management)

## Project Structure
```
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com.ragheb.entity (Entity class)
│   │   │   ├── com.ragheb.dao (DAO interface)
│   │   │   ├── com.ragheb.dao.impl (DAO implementation)
│   │   │   ├── com.ragheb.constant (Application constants)
│   │   │   ├── com.ragheb.client (Main application/tester)
│   │   ├── resources
│   │   │   ├── META-INF/persistence.xml (Database configuration)
│   ├── test (Unit tests can be added here)
```

## Database Schema
The project interacts with the `employee` table in a MySQL database, which has the following structure:

| Column  | Data Type  |
|---------|-----------|
| emp_no  | Integer (Primary Key) |
| ename   | VARCHAR  |
| sal     | Double  |
| deptno  | Integer  |

## Configuration
### Database Configuration
Modify `persistence.xml` in `src/main/resources/META-INF` with your MySQL credentials:
```xml
<property name="hibernate.connection.url" value="jdbc:mysql://localhost:3306/first_jpa" />
<property name="hibernate.connection.username" value="your_username" />
<property name="hibernate.connection.password" value="your_password" />
```

### Hibernate Settings
- `hibernate.hbm2ddl.auto=update`: Automatically updates the database schema.
- `hibernate.show_sql=true`: Displays generated SQL queries.
- `hibernate.format_sql=true`: Formats SQL output for better readability.

## Running the Application
1. Set up a MySQL database and create the `employee` table if not created automatically.
2. Update the database credentials in `persistence.xml`.
3. Compile and run `Tester.java` in `com.ragheb.client`.
4. Uncomment the required method calls in `Tester.java` to:
    - Fetch an employee by ID
    - Fetch all employees
    - Fetch names and salaries

## Sample Queries Used
```java
public static final String QUERY1 = "FROM EmployeeEntity e WHERE e.empNumber = ?1";
public static final String QUERY2 = "FROM EmployeeEntity e";
public static final String QUERY3 = "SELECT e.empName, e.salary FROM EmployeeEntity e";
```

## Future Enhancements
- Add unit tests
- Implement create, update, and delete operations
- Add a front-end interface (e.g., Spring MVC, React)
- Use Spring Framework for better dependency management



