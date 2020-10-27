# Getting Started

### Description
Simple Spring project which implements multiple data sources (currently from postgres). Tested on 
data when each table are in different database and there is no connection between them.

### Important notes
Each configuration are set for different data source (in package config).
 - it is important to keep repositories (or another classes which works with dataSource) separated 
 - you must define packages in builder (one class from package is enough)
 - all configuration is set in application profile (application-local.yml)
 - second datasource needs to have separate configuration as it is not native in yml (you can even omit standard
 spring.datasource and replace it with your "path", e.g. spring.first-datasource or just first-datasource - 
 then keep in mind to change path for settings in configuration class) 
 - defining schema in entities is not required
 - when using direct entityManager in your classes, use @Qualifier("dbStudentEntityManagerFactory")

```
@Autowired
@Qualifier("dbStudentEntityManagerFactory")
private EntityManager em;
```