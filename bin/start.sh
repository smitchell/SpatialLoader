#!/bin/sh
cd ../
mvn clean install dependency:copy-dependencies
java -cp "./database.properties:target/dependency/*:target/SpatialLoader.jar" org.springframework.batch.core.launch.support.CommandLineJobRunner load-postgis-config.xml loadGpsPointsJob