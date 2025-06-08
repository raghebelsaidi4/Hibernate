# **Hibernate Caching**

Caching is one of Hibernate's most powerful features for optimizing performance. Here's a comprehensive look at Hibernate caching in modern applications:

## **1. Cache Levels in Hibernate**

### **1.1 First-Level Cache (Session Cache)**
- **Scope**: Single Session
- **Enabled**: Always on
- **Lifecycle**: Cleared when session closes
- **Behavior**:
    - Stores loaded entities during session
    - Prevents duplicate queries for same data

```java
Session session = sessionFactory.openSession();
Product p1 = session.get(Product.class, 101); // Hits DB
Product p2 = session.get(Product.class, 101); // Returns cached
session.close(); // Cache cleared
```

### **1.2 Second-Level Cache**
- **Scope**: SessionFactory (application-wide)
- **Enabled**: Requires explicit configuration
- **Providers**: Ehcache, Infinispan, Hazelcast, Caffeine
- **Best for**: Read-heavy, rarely changed data

```xml
<!-- persistence.xml -->
<property name="hibernate.cache.use_second_level_cache" value="true"/>
<property name="hibernate.cache.region.factory_class" 
          value="org.hibernate.cache.ehcache.EhCacheRegionFactory"/>
```

```java
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Product { ... }
```

### **1.3 Query Cache**
- **Scope**: Caches query results
- **Requires**: Second-level cache enabled
- **Best for**: Frequent parameterized queries

```java
Query query = session.createQuery("FROM Product p WHERE p.category = :category")
    .setCacheable(true)
    .setParameter("category", "Electronics");
```

## **2. Cache Concurrency Strategies**

| Strategy | Description | Use Case |
|----------|-------------|----------|
| **READ_ONLY** | Immutable data | Reference data |
| **NONSTRICT_READ_WRITE** | Minimal locks | Occasionally updated |
| **READ_WRITE** | Soft locks | Frequently read, sometimes updated |
| **TRANSACTIONAL** | JTA transactions | High consistency needs |

## **3. Modern Cache Providers (2025)**

### **3.1 Caffeine (Recommended for new projects)**
```xml
<property name="hibernate.cache.region.factory_class"
          value="org.hibernate.cache.jcache.JCacheRegionFactory"/>
<property name="hibernate.javax.cache.provider"
          value="com.github.benmanes.caffeine.jcache.spi.CaffeineCachingProvider"/>
```

### **3.2 Redis (Distributed caching)**
```xml
<property name="hibernate.cache.region.factory_class"
          value="org.hibernate.cache.redis.hibernate5.RedisRegionFactory"/>
```

## **4. Cache Configuration Best Practices**

```java
// Entity configuration
@Entity
@Cacheable
@org.hibernate.annotations.Cache(
    usage = CacheConcurrencyStrategy.READ_WRITE,
    region = "product_cache",
    include = "non-lazy"
)
public class Product {
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany
    private Set<Review> reviews;
}
```

**Key Settings:**
```properties
# Enable statistics
hibernate.generate_statistics=true
hibernate.cache.use_structured_entries=true

# TTL settings
hibernate.cache.redis.expiryInSeconds=3600
```

## **5. Cache Invalidation Patterns**

### **5.1 Manual Eviction**
```java
sessionFactory.getCache().evictEntity(Product.class, productId);
sessionFactory.getCache().evictEntityRegion(Product.class);
sessionFactory.getCache().evictAllRegions();
```

### **5.2 Automatic Time-to-Live**
```java
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "hourly_products")
@TimeToLive(seconds = 3600)
```

## **6. Hibernate 6+ Cache Improvements**

1. **Better integration** with Jakarta EE caching (JCache)
2. **Reactive caching** support
3. **Automatic cache tuning** based on usage patterns
4. **Improved Redis integration** with JSON serialization

## **7. Common Performance Pitfalls**

1. **Over-caching**: Caching frequently updated data
2. **Under-caching**: Not caching hot data
3. **Wrong strategy**: Using READ_ONLY for mutable data
4. **Cache bloat**: Not setting proper TTLs
5. **N+1 with caching**: Forgetting to cache associations

## **8. Monitoring Cache Efficiency**

```java
Statistics stats = sessionFactory.getStatistics();
System.out.println("Second Level Hit Count: " 
    + stats.getSecondLevelCacheHitCount());
System.out.println("Query Cache Hit Ratio: "
    + stats.getQueryCacheHitCount() / (double) stats.getQueryExecutionCount());
```

