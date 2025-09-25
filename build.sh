#!/bin/bash
set -e
echo "Compiling Java sources..."
javac -d out $(find src -name "*.java")
echo "Done. Run: java -cp out edu.ccrm.cli.Main"
