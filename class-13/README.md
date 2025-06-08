# **Hibernate/JPA NamedQuery**

Named queries in Hibernate/JPA are predefined queries that can be referenced by name, improving performance, reusability, and maintainability. Here's what you need to know:

---

## **1. What is a NamedQuery?**
A **NamedQuery** is a static, precompiled JPQL or native SQL query defined at the entity level (using annotations or XML) and referenced by a unique name.

### **Example (Annotation-based)**
```java
@Entity
@NamedQuery(
    name = "Employee.findBySalary",
    query = "SELECT e FROM Employee e WHERE e.salary > :minSalary"
)
public class Employee {
    @Id
    private Long id;
    private String name;
    private double salary;
    // ...
}
```

### **Usage in Code**
```java
TypedQuery<Employee> query = entityManager.createNamedQuery(
    "Employee.findBySalary", Employee.class);
query.setParameter("minSalary", 50000);
List<Employee> employees = query.getResultList();
```

---

## **2. NamedQuery vs Dynamic Query**
| Feature          | **NamedQuery** | **Dynamic Query** |
|----------------|--------------|----------------|
| **Compilation** | Precompiled (better performance) | Compiled at runtime |
| **Reusability** |  Can be reused across the app |  Defined per use |
| **Performance** | Faster (parsed once) | Slower (parsed every time) |
| **Maintenance** | Centralized in entity | Scattered in code |
| **Validation** | Checked at startup | May fail at runtime |

---

## **3. Advantages of NamedQuery**
 **Performance Optimization** (precompiled, cached)  
 **Type Safety** (avoids runtime errors)  
 **Better Maintainability** (centralized queries)  
 **Security** (reduces SQL injection risk)

---

## **4. NamedNativeQuery (for SQL)**
Used when you need **native SQL** instead of JPQL:
```java
@Entity
@NamedNativeQuery(
    name = "Employee.findTopEarners",
    query = "SELECT * FROM employees WHERE salary > :minSalary ORDER BY salary DESC",
    resultClass = Employee.class
)
public class Employee { ... }
```

**Usage:**
```java
Query query = entityManager.createNamedQuery("Employee.findTopEarners");
query.setParameter("minSalary", 100000);
List<Employee> topEarners = query.getResultList();
```

---

## **5. Hibernate 6+ Updates**
- **`@NamedQuery`** still widely used, but **Hibernate 6+** also supports:
    - **`@NamedQueries`** (for multiple queries)
    - **`@NamedEntityGraph`** (for optimized fetching)
    - **`@HibernateQuery`** (for advanced HQL features)

---

## **6. Common Interview Questions**
1. **Why use NamedQuery instead of dynamic queries?**  
   → Better performance, reusability, and compile-time validation.

2. **Can NamedQuery be modified at runtime?**  
   → No, they are static (but you can use **`CriteriaQuery`** for dynamic cases).

3. **How does Hibernate cache NamedQuery?**  
   → Parsed and cached at startup (reduces overhead).

4. **Can NamedQuery be used with pagination?**  
   → Yes, via `setFirstResult()` and `setMaxResults()`.

5. **What’s the difference between `@NamedQuery` and `@NamedNativeQuery`?**  
   → `@NamedQuery` uses JPQL, while `@NamedNativeQuery` uses raw SQL.
