#!/bin/bash

# Load the run_test function
source ./functions.sh
chmod +x gradle

# Clean previous test results
echo "Cleaning previous test results..."
gradle clean

# Execute test runners
run_all_tests "remoteChrome"

# Generate Serenity report
echo "Generating Serenity report..."
gradle aggregate

echo "Process completed. Check the report at target/site/serenity/index.html"
