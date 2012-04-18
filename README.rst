Spring 3.1 & BackboneJS todo example
====================================

This small example application uses the following stack :

 * XML free Spring MVC 3.1 backend (no web.xml, no applicationContext.xml)
 * Spring Data based MongoDB persistence
 * BackboneJS todo example application

In order to run it :

 * Install Maven and MongoDB
 * Create /data/db directory in order to allow MongoDB to store its data
 * Run mongod daemon
 * Run the following command : "mvn clean install t7:run" (Tomcat 7) or "mvn clean install jetty:run" (Jetty 8)
 * Open your browser and go to http://localhost:8080/todo/


