Run Hazelcast IMDG 3.9.3 in local

Note:

Spring-data-hazelcast 1.1.1 (the last release version) depends on Spring-data-keyvalue 1.2.4.RELEASE which is a very old version.
Spring-data-keyvalue is at 2.0.6.RELEASE which is shipped with Spring Boot 2.0.1.

So Spring Boot 2.0.1 apps do not work with spring-data-hazelcast 1.1.1.

So had to use an older verson of Spring Boot (1.5.12)