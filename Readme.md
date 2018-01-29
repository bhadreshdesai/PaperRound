# Paper Round

A sample town planning and paper delivery program using AngularJS and Spring Boot.
Project uses junit and cucumber for running unit tests.
Project uses jacoco for code coverage.


## Getting Started

These instructions will get the project up and running on your local machine


### Prerequisites

Java 8+
Maven (optional, you can use maven wrapper)

Note: If you done have have maven installed on your machine replace all mvn command below with mvnw


### Running the tests

Run following command on command prompt

```
mvn verify
```

Jacoco report - ./target/site/jacoco/index.html

Cucumber report - ./target/cucumber-html-reports/overview-features.html


### Running the application

```
mvnw spring-boot:run
```

Navigate to [http://localhost:8080](http://localhost:8080) in a browser

Application main page will be displayed.

You can upload a street specification file.

Alternatively you can enter space separated street specification in the field provided and click Submit button.

Results will be displayed below the Submit button.

You can change the value of the Delivery Approach and see the updated results for the selected Delivery Approach.

