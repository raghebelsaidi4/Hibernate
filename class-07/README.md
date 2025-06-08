# JPA Annotations for Mapping
**@Entity**
Declares a Java class as an entity, meaning it will be mapped to a database table.

**@Table**
Specifies the name of the table in the database that the entity is mapped to. If not specified, the table name defaults to the class name.

**@Id**
Marks a field in the entity class as the primary key for the corresponding table.

**@Column** 
Used to specify the mapping between a field in the entity and a column in the database table. You can customize the column name, length, nullable, etc.


# Can we map a Java class with a table if it has more variables?

Yes. If the Java class has variables that do not correspond to columns in the table, you can use the @Transient annotation. This will exclude those variables from being mapped to the database.

```
@Entity
public class Employee {
@Id
private Long id;

    @Column(name = "first_name")
    private String fristName;

    @Transient
    private String temporaryData;  // This won't be mapped to the database
}
```

# Can we map a Java class with a table having more columns?

Yes. If the table has more columns than the fields in the entity class, the entity will only map the columns that have a corresponding field. The remaining columns will be ignored unless explicitly handled with @Column. If a column in the database is missing a corresponding field in the entity, it will not cause an error as long as it does not have a NOT NULL constraint and a default value.
Configuring Persistence with persistence.xml
Creating the persistence.xml file:
----
The persistence.xml file is required for Hibernate or JPA to configure and manage your persistence unit. It must be placed under the META-INF directory, which should be located under the src/main/resources directory in your project structure.

Example directory structure:

src
└── main
└── resources
└── META-INF
└── persistence.xml
Sample persistence.xml Configuration:

````
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://java.sun.com/xml/ns/persistence"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://java.sun.com/xml/ns/persistence
http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"
version="2.0">

    <persistence-unit name="myJpaUnit">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        <class>com.example.Employee</class> <!-- Include your entity classes here -->

        <properties>
            <property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect" />
            <property name="hibernate.hbm2ddl.auto" value="update" />
            <property name="hibernate.show_sql" value="true" />
            <property name="hibernate.format_sql" value="true" />
        </properties>
    </persistence-unit>
</persistence>

