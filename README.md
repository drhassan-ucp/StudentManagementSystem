# Student Management System (v1.0 Starter)

A simple console-based Java application built for in-class practice in the **Agentic Software Engineering** course.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

The compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Setup Instructions

1. Ensure JDK 17+ is installed.
2. Open the project root directory in **VS Code**.
3. Compile the code:
   ```bash
   javac -d bin src/com/bootcamp/model/*.java src/com/bootcamp/service/*.java src/com/bootcamp/util/*.java src/com/bootcamp/Main.java
