# Features of Hibernate

Hibernate is a powerful Object-Relational Mapping (ORM) tool that provides several advanced features to simplify database operations and improve application performance. Below are the key features:

## 1. Hibernate Query Language (HQL)
Hibernate provides **HQL (Hibernate Query Language)**, an object-oriented query language.  

### Benefits of HQL:
- HQL allows writing queries in a database-independent manner.
- It uses **class names** and **field/variable names** instead of database table names and column names.
- Reduces the complexity of switching databases since HQL queries are database-agnostic.

**Example Comparison**:

| Operation                   | SQL Query                          | HQL Query                           |
|-----------------------------|-------------------------------------|-------------------------------------|
| Select all rows             | `SELECT * FROM emp;`               | `SELECT e FROM emp e;`             |
| Select specific columns     | `SELECT empName, empAge FROM emp;` | `SELECT e.empName, e.empAge FROM emp e;` |

---

## 2. Caching  
![Caching Diagram](https://github.com/user-attachments/assets/049bbc28-bc37-4ceb-a71f-8baa51a8e19f)

Caching significantly improves the performance of an application by **loading objects from cache memory** instead of querying the database repeatedly.

### Levels of Caching in Hibernate:
1. **Level 1 Cache**:
   - Built into Hibernate.
   - Enabled by default for every session.
   - Specific to the Hibernate `Session` object.

2. **Level 2 Cache**:
   - Optional and must be explicitly enabled.
   - Shared across multiple sessions in the same application.
   - Uses third-party cache providers like **Ehcache**, **OSCache**, or **Infinispan**.

---

## 3. Lazy Loading  
![Lazy Loading Diagram](https://github.com/user-attachments/assets/0a2d4f41-fb88-4927-9fee-f4335797a54e)

Hibernate employs **lazy loading** to reduce the number of database calls and improve performance.  

### How Lazy Loading Works:
- When the application requests an object, Hibernate creates a **proxy object** and returns it without actually loading the data from the database.
- The real data is fetched from the database **only when the application accesses the proxy object**.

### Benefits of Lazy Loading:
- Minimizes unnecessary database access.
- Reduces the number of round trips between the application and the database.

---

## 4. Connection Pooling  
![Connection Pooling Diagram](https://github.com/user-attachments/assets/6790b376-10fb-4fcc-b4c7-7708f96a9b1e)

Hibernate includes a **built-in connection pooling mechanism** to optimize database connections.

### How Connection Pooling Works:
1. When the application starts, Hibernate creates a pool of database connections.
2. These connections are reused, reducing the overhead of creating and destroying connections for each request.
3. The connection pool is destroyed automatically when the application shuts down.

### Benefits of Connection Pooling:
- Enhances application performance by reducing connection overhead.
- Efficiently manages the lifecycle of database connections.

---

## 5. Criteria API  
Hibernate provides a **Criteria API** to build dynamic and efficient queries programmatically.  
### Benefits:
- Allows creating tuned queries for better performance.
- Ensures applications fetch data quickly, enhancing overall efficiency.

**Example**:
```java
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
Root<Employee> root = query.from(Employee.class);
query.select(root).where(builder.equal(root.get("department"), "HR"));
List<Employee> result = session.createQuery(query).getResultList();
```

---

## 6. Locking  
Hibernate provides locking mechanisms to ensure data consistency when multiple transactions work on the same data concurrently.  
### Types of Locking:
1. **Optimistic Locking**: Assumes minimal conflicts and uses a version/timestamp for validation before committing changes.  
2. **Pessimistic Locking**: Prevents conflicts by locking the data during a transaction, ensuring no other transaction modifies it simultaneously.

---

## 7. Associations  
Hibernate supports object relationships/associations and manages them seamlessly. These include:
1. **One-to-One**
2. **Many-to-One**
3. **One-to-Many**
4. **Many-to-Many**

---

# Files Required for the First Hibernate Application

To build your first Hibernate application, you need the following files:

### 1. POJO Class  
A **POJO (Plain Old Java Object)** is a simple Java class without any dependency on specific APIs (except `java.io.Serializable` if needed).  
### Example:
```java
public class Employee implements Serializable {
    private int id;
    private String name;

    // Default Constructor
    public Employee() {}

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
```

### 2. Mapping File  
Defines how the POJO class is mapped to the database table (e.g., via XML or annotations).

### 3. Configuration File  
Specifies database connection properties and Hibernate settings (e.g., `hibernate.cfg.xml`).

### 4. Client Program  
Contains the main method to test the application by performing CRUD operations using Hibernate.

---

# Java Bean  

A **Java Bean** is a special type of class that follows specific conventions.  

### Rules for Java Beans:
1. The class **must be public**.
2. The class **must contain a default/parameter-less constructor**.
3. All private members **must have getter and setter methods**.
4. The class **can implement the `Serializable` interface** (optional).  

### Note:
- Every **Java Bean class** is a **POJO class**.  
- However, not every **POJO class** is a **Java Bean class**.  

### Example of a Java Bean:
```java
public class EmployeeBean implements Serializable {
    private int id;
    private String name;

    // Default Constructor
    public EmployeeBean() {}

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
```

---

# Summary

Hibernate provides a wide range of features to simplify and optimize database interactions:
- **HQL** for database-independent queries.
- **Caching** for better performance.
- **Lazy Loading** to minimize database calls.
- **Connection Pooling** for efficient connection management.
- **Criteria API** for dynamic and optimized queries.
- **Locking** mechanisms for data consistency.
- Support for **Associations** to manage relationships.
