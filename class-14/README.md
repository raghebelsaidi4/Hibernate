# **Hibernate/JPA Criteria API Interview Questions (2025)**

The Criteria API in Hibernate/JPA provides a **type-safe, programmatic way** to build dynamic queries. Unlike JPQL or HQL (which use strings), the Criteria API uses Java objects, reducing runtime errors and improving maintainability.

---

## **1. What is the Criteria API?**
A **Java-based, type-safe** alternative to writing JPQL/HQL queries. It allows dynamic query construction at runtime.

### **Example: Basic Criteria Query**
```java
CriteriaBuilder cb = entityManager.getCriteriaBuilder();
CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
Root<Employee> root = cq.from(Employee.class);

// WHERE salary > 50000
cq.select(root).where(cb.gt(root.get("salary"), 50000));

TypedQuery<Employee> query = entityManager.createQuery(cq);
List<Employee> employees = query.getResultList();
```

---

## **2. Criteria API vs JPQL/HQL**
| Feature          | **Criteria API** | **JPQL/HQL** |
|----------------|---------------|-------------|
| **Type Safety** | Compile-time checks |  String-based (runtime errors) |
| **Dynamic Queries** |  Best for dynamic conditions |  Better for static queries |
| **Readability** |  Verbose |  More concise |
| **Performance** | Same (converts to SQL) | Same |
| **Maintenance** |  Refactoring-friendly |  Harder to refactor |

---

## **3. Key Components of Criteria API**
1. **`CriteriaBuilder`** – Creates predicates, expressions, and queries.
2. **`CriteriaQuery<T>`** – Defines the query structure (SELECT, WHERE, etc.).
3. **`Root<T>`** – Represents the root entity (like `FROM Employee`).
4. **`Predicate`** – Used in `WHERE` clauses (e.g., `salary > 50000`).
5. **`Join`** – For handling associations (e.g., `employee.department`).

### **Example with Joins**
```java
CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
Root<Employee> emp = cq.from(Employee.class);
Join<Employee, Department> dept = emp.join("department"); // Implicit INNER JOIN

cq.select(emp)
  .where(cb.equal(dept.get("name"), "Engineering"));
```

---

## **4. Dynamic Query Example**
Criteria API shines when queries are built **dynamically** (e.g., search filters).

```java
public List<Employee> findEmployees(String name, Double minSalary, String deptName) {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
    Root<Employee> emp = cq.from(Employee.class);

    List<Predicate> predicates = new ArrayList<>();

    if (name != null) {
        predicates.add(cb.like(emp.get("name"), "%" + name + "%"));
    }
    if (minSalary != null) {
        predicates.add(cb.ge(emp.get("salary"), minSalary));
    }
    if (deptName != null) {
        predicates.add(cb.equal(emp.get("department").get("name"), deptName));
    }

    cq.where(predicates.toArray(new Predicate[0]));
    return entityManager.createQuery(cq).getResultList();
}
```

---

## **5. Hibernate 6+ Updates**
- **`JpaCriteriaQuery`** (standard JPA) vs **`HibernateCriteriaBuilder`** (Hibernate extensions).
- **Better support for:**
    - **Embeddable types**
    - **Tuple queries** (multi-select)
    - **Entity graphs** (fetch optimizations)

### **Example: Tuple Queries**
```java
CriteriaQuery<Tuple> cq = cb.createTupleQuery();
Root<Employee> emp = cq.from(Employee.class);
cq.multiselect(emp.get("name").alias("empName"), emp.get("salary").alias("salary"));

List<Tuple> results = entityManager.createQuery(cq).getResultList();
for (Tuple tuple : results) {
    String name = tuple.get("empName", String.class);
    Double salary = tuple.get("salary", Double.class);
}
```

---

## **7. Criteria API vs QueryDSL (Bonus)**
- **Criteria API** → Official JPA, but verbose.
- **QueryDSL** → More concise, fluent API (popular in Spring Data JPA).

### **QueryDSL Example**
```java
QEmployee emp = QEmployee.employee;
JPAQuery<Employee> query = new JPAQuery<>(entityManager);
List<Employee> employees = query.select(emp)
                              .from(emp)
                              .where(emp.salary.gt(50000))
                              .fetch();
```
