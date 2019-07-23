
Java 8 needed to run this code.

Dropwizard is an open source Java framework for developing REST APIs.


Libraries using from Dropwizard:

1. * [Jetty](http://www.eclipse.org/jetty/) for serving an HTTP server inside this project'.
2. * [Jersey](http://jersey.java.net/) for developing RESTful Web Services in Java'.
3. * [Jackson](https://github.com/FasterXML/jackson) for objects to/from JSON conversion'.

Using Hibernate features for the database.

# Running The Application

To test the application run the following commands.

* To package the example run.

        mvn package

* To setup the h2 database run.

		java -jar target/OnlineStoreFront-1.0.5.jar db migrate example.yml

* To run the server run.

		java -jar target/OnlineStoreFront-1.0.5.jar server example.yml



