#!/bin/bash

# Load the run_test function
source ./functions.sh

# Clean previous test results
echo "Cleaning previous test results..."
./gradlew clean

# Execute test runners
run_test "LoginRunner" "remoteChrome"
#run_test "RegisterRunner" "remoteEdge"
#run_test "AddToCartRunner" "remoteFirefox"

# Generate Serenity report
echo "Generating Serenity report..."
./gradlew aggregate

echo "Process completed. Check the report at target/site/serenity/index.html"
