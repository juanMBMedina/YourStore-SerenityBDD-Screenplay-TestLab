#!/bin/bash

# Load the run_test function
source ./functions.sh
chmod +x ./gradlew

# Clean previous test results
echo "Cleaning previous test results..."
./gradlew clean

# Execute test runners
run_all_tests "remoteChrome"

# Generate Serenity report
echo "Generating Serenity report..."
./gradlew aggregate

echo "Process completed. Check the report at target/site/serenity/index.html"
