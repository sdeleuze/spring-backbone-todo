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
 * Run the following command : "mvn clean install t7:run"
 * Open your browser and go to http://localhost:8080/todo/

Also tested successfully with Netbeans 7.1 + Tomcat 7.0.22.

With Maven Jetty 8.0.4 plugin, the application starts but can't be accessed. More details on http://stackoverflow.com/questions/8066943/spring-3-1-servlet-3-code-based-configuration-using-the-jetty-maven-plugin

Alternatively, you can use Gradle instead of Maven
 * "gradle tasks" : Lists all tasks in the project
 * "gradle war" : creates a war file under ./build/libs/
 * "gradle tomcatRun" : Uses your files as and where they are and deploys them to Tomcat (uses bmushko's gradle tomcat plugin)
