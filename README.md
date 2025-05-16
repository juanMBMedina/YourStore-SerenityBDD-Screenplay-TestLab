# Automated Testing Plan with Serenity - Screenplay

This repository contains the implementation of an automated testing plan developed using Serenity Screenplay. The project was created as part of the automation course offered by Academia QA and adapted for use with the Your Store demo application.

## Project Overview

The main objective of this project is to demonstrate a robust and maintainable test automation framework using Java, Gradle, Cucumber, and the Screenplay design pattern.

The repository includes:
- Test cases automated with Selenium WebDriver.
- Screenplay structure for reusable and maintainable components.
- Test execution through Cucumber and JUnit.
- Cucumber integration for reports.

## File Structure
```
📦 YourStore-SerenityBdd-Screenplay-TestLab
📦 src
├── 📂 main
│   ├── 📂 java
│   │   ├── 📂 co.com.theinternet         # (opcional) funcionalidades distintas o demos
│   │   └── 📂 us.opencart
│   │       ├── 📂 exceptions             # Excepciones personalizadas usadas en pruebas
│   │       ├── 📂 models                 # Modelos de datos (POJOs)
│   │       ├── 📂 questions              # Clases de tipo Question del patrón Screenplay
│   │       ├── 📂 tasks                  # Clases Task (acciones que realiza el actor)
│   │       ├── 📂 ui                     # Targets (elementos de la UI)
│   │       └── 📂 utils                  # Utilidades y helpers
│   └── 📂 resources
│       └── 📄 (vacío o config adicional)
│
├── 📂 test
│   ├── 📂 java
│   │   ├── 📂 co.com.theinternet         # (opcional) pruebas de ese dominio
│   │   └── 📂 us.opencart
│   │       ├── 📂 hooks                  # Clases para configurar Before/After (Cucumber)
│   │       ├── 📂 runners                # Clases Runner para ejecutar los features
│   │       └── 📂 stepdefinitions        # Glue code: Step Definitions de Cucumber
│   └── 📂 resources
│       ├── 📂 features
│       │   ├── 📂 theinternet            # Features de otro dominio (demo)
│       │   └── 📂 us.opencart
│       │       └── 📄 login.feature     # Feature file principal (ejemplo: login)
│       ├── 📂 testdata                  # Archivos de datos de prueba (CSV, JSON, etc.)
│       └── 📄 serenity.conf             # Configuración de entornos (Serenity/Thucydides)
│
├── 📂 target                            # Directorio de salida (build, reports, etc.)
│
├── 📄 build.gradle                      # Configuración de Gradle
└── 📄 serenity.properties               # Configuración principal de Serenity

```

## Prerequisites

Ensure you have the following installed:
- Java 17+
- Gradle 8.13
- Chrome, Edge and Firefox browser
- IntelliJ IDEA (recommended for development)

## Getting Started

Clone this repository:
```bash
git clone git@github.com:juanMBMedina/YourStore-SerenityBdd-Screenplay-TestLab.git
cd YourStore-SerenityBdd-Screenplay-TestLab
```

To install dependencies and run tests:
```bash
mvn clean test
```

To run tests with a specific browser (e.g., Edge) and remote mode, remote mode have the parameter headless by default:
```bash
gradle clean test --tests "us.opencart.runners.LoginRunner" -Denvironment=localChrome && gradle aggregate
gradle clean test --tests "us.opencart.runners.LoginRunner" -Denvironment=remoteChrome && gradle aggregate
```

Or set the environment variable before running:
```bash
export ENVIRONMENT=remoteChrome
export SUITE=LoginRunner
gradle clean test --tests "us.opencart.runners.SUITE" -Denvironment=remoteChrome && gradle aggregate
```
Run sonar-scanner in Local Environment:
```bash
sonar-scanner.bat -D"sonar.login=%SONAR_TOKEN%" -D"project.settings=sonar-scanner.properties" -D"sonar.projectBaseDir=."
```

## Running in IntelliJ

To run with custom VM options in IntelliJ:
1. Select your runner
2. Go to `Run > Edit Configurations`.
3. Add VM options: `-Denvironment=remoteChrome` `-Denvironment=localChrome`.
4. Run your test.

## Reports

After execution, Cucumber generates detailed HTML reports. Find them in:
```
/target/site/serenity/index.html
```

## Contributing

Feel free to fork the project, open issues, or submit pull requests to enhance the framework.

## License

This project is licensed under the GNU General Public License v3.0.

## Contact

For questions or feedback, please contact:

- **Name:** Juan Miguel Blanco Medina
- **Email:** juanmblancom@gmail.com
- **GitHub:** [https://github.com/juanMBMedina](https://github.com/juanMBMedina)
