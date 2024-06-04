#!/bin/bash

PROJECT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"

# Build the project
mvn clean package -DskipTests

# Run unit tests
cd $PROJECT_DIR && mvn test

echo -e

cd $PROJECT_DIR && java -cp "target/classes" org.poker.Main

read -r -p "" -n 1