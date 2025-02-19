# JPQL (Java Persistence Query Language)

## Frequently Asked Questions

### Q) How many objects can be loaded at a time when calling the `find()` method?
**A)** Only one object.

### Q) How many objects can be removed at a time when calling the `remove()` method?
**A)** Only one object.

### Q) How can I load, update, or delete multiple objects at a time from the database?
**A)** Use JPQL or native SQL queries.

## JPQL vs SQL
- **JPQL queries** are **database-independent**.
- **SQL queries** are **database-dependent**.
- When using JPQL, JPA providers (such as Hibernate) convert JPQL queries into the corresponding SQL queries for the underlying database.
- JPQL syntax is similar to SQL, but instead of table names, it uses entity class references, and instead of column names, it uses entity attributes.

## JPQL vs SQL Examples

| SQL Query | JPQL Query |
|-----------|-----------|
| `SELECT * FROM Emp` | `SELECT e FROM Emp e` |
| `SELECT eName, eAge FROM Emp` | `SELECT e.eName, e.eAge FROM Emp e` |
| `SELECT * FROM Emp WHERE sal > ?` | `SELECT e FROM Emp e WHERE e.salary > ?` |
| `UPDATE Emp SET sal = ? WHERE deptno = ?` | `UPDATE Emp e SET e.salary = ? WHERE e.deptNumber = ?` OR `UPDATE Emp e SET e.salary = :esal WHERE e.deptNumber = :dn` |
| `SELECT e.ename, d.dname FROM emp e JOIN dept d ON e.deptno = d.deptno` | `SELECT e.ename, d.dname FROM Emp e JOIN Dept d ON e.deptNumber = d.deptNumber` |

## How to Execute JPQL Queries
1. **Create a Query object** using `EntityManager.createQuery()`.
2. **Set parameter values** (if applicable) using `setParameter()`.
3. **Execute the query** using `getResultList()` for multiple results or `getSingleResult()` for a single result.

### Example of Executing a JPQL Query
```java
EntityManager em = entityManagerFactory.createEntityManager();
Query query = em.createQuery("SELECT e FROM Employee e WHERE e.salary > :minSalary");
query.setParameter("minSalary", 50000);
List<Employee> employees = query.getResultList();
```



