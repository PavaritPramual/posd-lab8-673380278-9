# posd-lab8-673380278-9

This repository contains the deliverables for Lab 8 of the POSD (Principles of Software Development) course.

## Description

- Lab document: `lab8_document_673380278-9.pdf` (written report and instructions).
- Source code: web and Java source files (HTML, Java, CSS) used for the lab exercises.

## Repository structure (high-level)

- lab8_document_673380278-9.pdf  - Lab report / instructions (PDF)
- (other folders/files)           - HTML, Java and CSS source files for the lab

> Note: The repository includes a mix of HTML, Java and CSS. Inspect folders like `src/`, `webapp/` or other top-level directories to find the source code.

## Prerequisites

- Java 8+ (or the Java version used in the project)
- A build tool (Maven or Gradle) if the project uses one
- A web browser to open HTML files
- Optional: an IDE (IntelliJ IDEA, Eclipse, VS Code) for development

## Build & Run (general guidance)

Because projects can be organized differently, follow one of these common flows depending on what the repository contains:

1. If the project is a Maven project
   - Build: `mvn clean package`
   - Run (if it produces a runnable JAR): `java -jar target/<artifact>.jar`

2. If the project is a Gradle project
   - Build: `./gradlew build` (or `gradle build`)
   - Run: follow the run instructions included in the project (or run the produced artifact)

3. If the project is a web application (static HTML/CSS)
   - Open the HTML files in a browser, or serve them with a simple static server:
     - `python -m http.server 8000` (Python 3)
     - Then open `http://localhost:8000/` in your browser

4. If the project targets a servlet container (Tomcat)
   - Build a WAR and deploy to the Tomcat `webapps/` folder, or run using your IDE's Tomcat integration.

If you tell me which build system or entry point the repository uses (for example: Maven, Gradle, or a runnable JAR, or a specific main class), I can add exact build & run instructions.

## View the lab report

Open `lab8_document_673380278-9.pdf` in a PDF viewer to read the lab instructions, report, and results.

## Notes

- This README is intentionally generic because the repository contains multiple file types (HTML, Java, CSS) and the precise build/run steps depend on how the project is structured. If you want, I can:
  - Inspect the repository and add precise build/run instructions
  - Add badges (build, license) or a CONTRIBUTING guide
  - Create a GitHub Actions workflow to build the project

## Author / Contact

Repository owner: PavaritPramual

