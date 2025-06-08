# **@GeneratedValue**

The `@GeneratedValue` annotation is used to specify how primary key values should be automatically generated for entities. Here's everything you need to know:

## **1. Basic Usage**
```java
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // ...
}
```

## **2. Generation Strategies**

### **2.1 `GenerationType.IDENTITY`**
- Uses database identity column (auto-increment in MySQL, serial in PostgreSQL)
- **Pros**: Simple, database handles sequencing
- **Cons**: Batch inserts not efficient

```java
@GeneratedValue(strategy = GenerationType.IDENTITY)
```

### **2.2 `GenerationType.SEQUENCE`**
- Uses database sequence object
- **Pros**: Better performance, supports pre-allocation
- **Cons**: Database-specific

```java
@GeneratedValue(strategy = GenerationType.SEQUENCE)
```

With custom sequence:
```java
@GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "product_seq")
@SequenceGenerator(
    name = "product_seq",
    sequenceName = "PRODUCT_SEQUENCE",
    allocationSize = 100)
```

### **2.3 `GenerationType.TABLE`**
- Uses a dedicated table to simulate sequences
- **Pros**: Portable across databases
- **Cons**: Worst performance, table locks

```java
@GeneratedValue(strategy = GenerationType.TABLE)
```

With custom table:
```java
@TableGenerator(
    name = "product_gen",
    table = "ID_GENERATOR",
    pkColumnName = "GEN_NAME",
    valueColumnName = "GEN_VALUE",
    pkColumnValue = "PRODUCT_ID",
    allocationSize = 100)
@GeneratedValue(
    strategy = GenerationType.TABLE,
    generator = "product_gen")
```

### **2.4 `GenerationType.AUTO` (Default)**
- Lets JPA provider choose the strategy
- **Pros**: Portable
- **Cons**: Behavior varies by provider

```java
@GeneratedValue // defaults to AUTO
```

## **3. Hibernate-Specific Strategies**

### **3.1 UUID Generation**
```java
@Id
@GeneratedValue(generator = "UUID")
@GenericGenerator(
    name = "UUID",
    strategy = "org.hibernate.id.UUIDGenerator")
private String id;
```

### **3.2 Custom Generators**
```java
public class CustomIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) {
        return "PROD-" + UUID.randomUUID().toString();
    }
}

@Entity
public class Product {
    @Id
    @GeneratedValue(generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "com.example.CustomIdGenerator")
    private String id;
}
```

## **4. Best Practices (2025)**

1. **For new projects**: Prefer `SEQUENCE` with allocationSize (performance)
2. **For MySQL/PostgreSQL**: `IDENTITY` is simple and effective
3. **For distributed systems**: Consider UUID strategies
4. **Always specify allocationSize** for sequence/table strategies (50-100 is good)
5. **Avoid TABLE generator** unless absolutely necessary

