# Entity States in JPA/Hibernate

In JPA and Hibernate, an entity object can exist in one of the following three states:

### 1. Transient State
- **Description**: When a new object of an entity class is created, it is in the transient state. At this point, the entity is not associated with any persistence context, and it is not stored in the database.
- **Characteristics**:
    - It is a plain Java object (POJO).
    - Changes to the object are not tracked by the persistence context.
    - It will not be saved to the database unless explicitly persisted.

### 2. Persistent State
- **Description**: After an entity object is passed to the `EntityManager.persist()` method, it becomes associated with a persistence context. At this stage, the entity is in the persistent state, and any changes made to it are automatically synchronized with the database.
- **Characteristics**:
    - Managed by the persistence context.
    - Changes to the entity are automatically updated in the database during a transaction commit or a flush operation.
    - Exists in both the application memory and the database.

### 3. Detached State
- **Description**: When an entity is removed from the persistence context (e.g., by closing or clearing the `EntityManager`, or by explicitly detaching the entity), it enters the detached state. At this point, the entity is no longer managed, but it still exists as a plain Java object.
- **Characteristics**:
    - Changes to the entity are not tracked by the persistence context.
    - To reattach the entity and make it persistent again, the `merge()` method can be used.

### Summary Workflow
1. **Transient State**: A new entity object is created.
2. **Persistent State**: The entity is persisted to the database using `EntityManager.persist()`.
3. **Detached State**: The entity is detached from the persistence context by closing, clearing, or explicitly detaching it.

### Example Workflow
```java
// Transient state
EntityClass entity = new EntityClass();
entity.setName("Example");

// Persistent state
EntityManager em = entityManagerFactory.createEntityManager();
em.getTransaction().begin();
em.persist(entity); // Now the entity is in the persistent state
em.getTransaction().commit();

// Detached state
em.close(); // Closing the EntityManager detaches the entity
// The entity is now in the detached state
```

This document helps in understanding the lifecycle of an entity in a JPA/Hibernate environment.

