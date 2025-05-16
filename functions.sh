#!/bin/bash

# Default environment if the provided one is invalid
DEFAULT_ENVIRONMENT="localChrome"

# Function to run a specific runner with a given environment
run_test() {
  local runner=$1
  local env=$2

  # Validate the environment
  case "$env" in
    localChrome|remoteChrome|localEdge|remoteEdge|localFirefox|remoteFirefox)
      ;;
    *)
      echo "Warning: Environment '$env' is not valid. Using default environment '$DEFAULT_ENVIRONMENT'."
      env=$DEFAULT_ENVIRONMENT
      ;;
  esac

  echo "Running $runner with environment $env..."
  gradle test --tests "us.opencart.runners.$runner" -Denvironment="$env"
}

run_all_tests() {
  local env=$1
  # Validate the environment
  case "$env" in
    localChrome|remoteChrome|localEdge|remoteEdge|localFirefox|remoteFirefox)
      ;;
    *)
      echo "Warning: Environment '$env' is not valid. Using default environment '$DEFAULT_ENVIRONMENT'."
      env=$DEFAULT_ENVIRONMENT
      ;;
  esac

  echo "Running $runner with environment $env..."
  gradle test --tests "us.opencart.runners.*Runner" -Denvironment="$env"
}
