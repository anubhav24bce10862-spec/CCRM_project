# Usage

## Prerequisites
- Java JDK 17+ recommended (project uses modern Java features).
- No external libraries required.

## Build & Run (Unix-like)
1. Compile:
   javac -d out $(find src -name "*.java")

2. Run:
   java -cp out edu.ccrm.cli.Main

## Build Jar
javac -d out $(find src -name "*.java")
jar --create --file ccrm.jar -C out/ .
java -jar ccrm.jar

## Notes
- Program runs in console / terminal only.
- Place sample CSV files in `data/test-data/`.
