# Hibernate Student Management Application

This project demonstrates a simple Student Management application using Hibernate ORM (Object-Relational Mapping) framework. It covers essential CRUD (Create, Read, Update, Delete) operations on a `Student` entity while adhering to best practices.

---

## Project Structure

### Packages:
1. **`com.ragheb.client`**: Contains the main class (`Tester`) to test the application.
2. **`com.ragheb.dao`**: Contains the `StudentDAO` interface.
3. **`com.ragheb.dao.impl`**: Contains the implementation of `StudentDAO` (`StudentDAOImpl`).
4. **`com.ragheb.entity`**: Contains the `Student` entity class.

### Key Components:
1. **`Student` Entity**:
    - Represents the student data with fields: `id`, `name`, `gender`, `marks`.
    - Implements `Serializable` for object persistence.

2. **`StudentDAO` Interface**:
    - Defines methods for CRUD operations:
        - `saveStudent(Student student)`
        - `loadStudent(int id)`
        - `updateStudent(int id, int marks)`
        - `deleteStudent(int id)`

3. **`StudentDAOImpl` Class**:
    - Implements the `StudentDAO` interface.
    - Uses Hibernate APIs to perform database operations.

4. **`Tester` Class**:
    - Main entry point of the application.
    - Demonstrates usage of CRUD operations.

---

## Steps to Run the Application

### Prerequisites:
- Java Development Kit (JDK) 8+
- Apache Maven
- A relational database (e.g., MySQL, PostgreSQL, etc.)
- Hibernate Configuration (`hibernate.cfg.xml`)

### Configuration:
1. **Database Configuration**:
    - Add your database connection details in the `hibernate.cfg.xml` file:
      ```xml
      <hibernate-configuration>
          <session-factory>
              <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
              <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/your_database</property>
              <property name="hibernate.connection.username">your_username</property>
              <property name="hibernate.connection.password">your_password</property>
              <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
              <property name="hibernate.hbm2ddl.auto">update</property>
          </session-factory>
      </hibernate-configuration>
      ```

2. **Dependencies**:
   Add the required Hibernate and MySQL dependencies in the `pom.xml` file:
   ```xml
   <dependencies>
       <dependency>
           <groupId>org.hibernate</groupId>
           <artifactId>hibernate-core</artifactId>
           <version>5.6.0.Final</version>
       </dependency>
       <dependency>
           <groupId>mysql</groupId>
           <artifactId>mysql-connector-java</artifactId>
           <version>8.0.27</version>
       </dependency>
   </dependencies>
   ```

3. **Database Schema**:
   Hibernate will automatically generate the database schema based on the `Student` entity and the `hibernate.hbm2ddl.auto` property.

---

## Key Features
1. **CRUD Operations**:
    - Create a new student record.
    - Read an existing student by ID.
    - Update the marks of an existing student.
    - Delete a student by ID.

2. **Hibernate Session Management**:
    - Proper session and transaction handling.
    - Ensure sessions and transactions are closed to avoid resource leakage.

3. **Configurable Database Support**:
    - Change the database configuration easily in `hibernate.cfg.xml`.

4. **Entity Mapping**:
    - The `Student` entity is mapped to a database table using Hibernate.

---

## Usage Example
### `Tester` Class Operations:
1. **Save Student**:
   ```java
   student.setId(11);
   student.setName("Ragheb");
   student.setGender("Male");
   student.setMarks(6000);
   dao.saveStudent(student);
   System.out.println("Student saved: " + student);
   ```

2. **Load Student**:
   ```java
   Student loadedStudent = dao.loadStudent(11);
   if (loadedStudent != null) {
       System.out.println("Loaded Student: " + loadedStudent);
   }
   ```

3. **Update Student**:
   ```java
   Student updatedStudent = dao.updateStudent(11, 9000);
   if (updatedStudent != null) {
       System.out.println("Updated Student: " + updatedStudent);
   }
   ```

4. **Delete Student**:
   ```java
   dao.deleteStudent(11);
   System.out.println("Student deleted.");
   ```

---