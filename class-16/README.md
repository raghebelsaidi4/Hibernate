# **JPA Relationships**

JPA relationships define how entities are associated with each other. Understanding them is crucial for database design and efficient data retrieval. Here's a comprehensive guide:

## **1. Basic Relationship Types**

### **1.1 @OneToOne**
- One entity instance is associated with exactly one instance of another entity.
- Example: User ↔ UserProfile (one user has one profile)

```java
@Entity
public class User {
    @Id private Long id;
    
    @OneToOne
    @JoinColumn(name = "profile_id")
    private UserProfile profile;
}

@Entity
public class UserProfile {
    @Id private Long id;
    
    @OneToOne(mappedBy = "profile")
    private User user;
}
```

### **1.2 @OneToMany / @ManyToOne**
- One entity relates to multiple instances of another entity.
- Example: Department ↔ Employee (one department has many employees)

```java
@Entity
public class Department {
    @Id private Long id;
    
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}

@Entity
public class Employee {
    @Id private Long id;
    
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;
}
```

### **1.3 @ManyToMany**
- Multiple instances of one entity relate to multiple instances of another.
- Example: Student ↔ Course (many students enroll in many courses)

```java
@Entity
public class Student {
    @Id private Long id;
    
    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;
}

@Entity
public class Course {
    @Id private Long id;
    
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;
}
```

---

## **2. Relationship Fetch Types**
### **2.1 EAGER Loading**
- Related entities are loaded immediately.
- Can cause performance issues (N+1 queries).

```java
@OneToMany(fetch = FetchType.EAGER)
private List<Employee> employees;
```

### **2.2 LAZY Loading (Recommended)**
- Related entities are loaded only when accessed.
- Better performance, but can cause `LazyInitializationException` if accessed outside a session.

```java
@ManyToOne(fetch = FetchType.LAZY)
private Department department;
```

---

## **3. Cascade Types**
Defines how operations (PERSIST, MERGE, REMOVE, etc.) propagate to related entities.

```java
@OneToMany(cascade = CascadeType.ALL) // Saves/deletes children automatically
private List<OrderItem> items;
```

| Cascade Type | Description |
|-------------|-------------|
| **PERSIST** | Saves child when parent is saved |
| **MERGE** | Updates child when parent is updated |
| **REMOVE** | Deletes child when parent is deleted |
| **ALL** | All operations cascade |
| **REFRESH** | Refreshes child when parent is refreshed |

---

## **4. Bidirectional vs Unidirectional**
### **4.1 Bidirectional (Recommended)**
- Both entities reference each other.
- Requires `mappedBy` to define the owning side.

```java
// Owning side (Employee)
@ManyToOne
private Department department;

// Inverse side (Department)
@OneToMany(mappedBy = "department")
private List<Employee> employees;
```

### **4.2 Unidirectional**
- Only one entity references the other.
- Simpler but can’t navigate from both sides.

```java
// Only in Employee
@ManyToOne
private Department department;
```

---

## **5. Common Interview Questions (2025)**
### **Q1. What’s the difference between `@JoinColumn` and `mappedBy`?**
- **`@JoinColumn`** → Defines the foreign key column (owning side).
- **`mappedBy`** → Indicates the inverse side (doesn’t manage the relationship).

### **Q2. How do you avoid N+1 queries in `@OneToMany`?**
- Use `JOIN FETCH` in JPQL:
  ```java
  @Query("SELECT d FROM Department d JOIN FETCH d.employees")
  List<Department> findAllWithEmployees();
  ```
- Or `@EntityGraph` in Spring Data JPA.

### **Q3. What happens if you don’t specify `mappedBy` in `@OneToMany`?**
- JPA creates a **join table**, which is often unnecessary.

### **Q4. How do you handle `LazyInitializationException`?**
- Open a session (e.g., `@Transactional` in Spring).
- Use `JOIN FETCH` or `@EntityGraph` to load data eagerly when needed.

### **Q5. When should you use `@ManyToMany`?**
- When both entities can have multiple associations (e.g., Students ↔ Courses).
- **Best practice**: Use a **junction entity** (`@OneToMany` + `@ManyToOne`) for extra fields.

---

## **6. Hibernate 6+ Updates**
- **Better lazy loading** (no proxy issues).
- **`@ForeignKey`** for explicit constraint naming.
- **`@OrderColumn`** improvements for indexed collections.

---

## **Final Thoughts**
- **Use `LAZY` fetching by default** (optimize performance).
- **Prefer bidirectional** for full navigation.
- **Avoid `CascadeType.ALL`** unless truly needed.

