# Data Persistence:
Data persistence involves storing data permanently.

# Components of Data Persistence:
1. Data: What to persist?
2. Medium: How to persist?
3. Storage: Where to persist?

# Data
1. Raw data
2. Java objects

# Medium
1. Java I/O streams
2. Serialization/De-serialization
3. JDBC (Java Database Connectivity)

# Storage
1. File
2. Database

![Image](https://github.com/user-attachments/assets/d11c7907-9838-4c02-a664-322f32ba9239)

# Serialization:
Serialization is the process of converting a Java object into a stream of bytes, which can then be stored in a file or transmitted over a network.

# De-serialization:
De-serialization is the process of converting a stream of bytes back into a Java object.

# Drawbacks of Using Files:
1. Data Redundancy
2. Data Inconsistency
3. Data Security
4. Storage limitations
5. Lack of Transaction Support
6. No Support for Constraints

![Image](https://github.com/user-attachments/assets/a8e14307-3f22-4c6a-8584-eb02d55bc189)

JDBC technology enables CRUD operations on database data:
- C: Create (insert)
- R: Read (select)
- U: Update (modify)
- D: Delete (remove)

Example: To store an Employee object in a database using JDBC API:
1. Read data from the Employee object using getter methods.
2. Create a PreparedStatement object in JDBC.
3. Set the data in the PreparedStatement and execute it.
  


  
  
  
