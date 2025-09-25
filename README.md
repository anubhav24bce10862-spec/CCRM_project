# Java Setup & Platform Fundamentals

This document serves as a guide to the history, architecture, and initial setup of the Java development environment, meeting all platform requirements.

---

## 1. Evolution of Java (Timeline)

Java was created by **James Gosling** and the "Green Team" at Sun Microsystems (now Oracle). Its core promise is **WORA** (Write Once, Run Anywhere).

* **1991:** Project **"Oak"** begins, originally targeting consumer electronics.
* **1995:** The language is renamed **Java** and officially released with **JDK 1.0**, focusing on web applets.
* **1998:** **J2SE 1.2** (Java 2) is released, standardizing the platform into **SE** (Standard), **EE** (Enterprise), and **ME** (Micro) editions.
* **2004:** **J2SE 5.0** (Java 5) introduces major language features: **Generics**, Annotations, Autoboxing/Unboxing, and the enhanced `for` loop.
* **2014:** **Java SE 8** is a revolutionary release, introducing **Lambda Expressions** and the **Stream API** for functional programming.
* **2017:** **Java SE 9** implements the **Java Platform Module System (JPMS or Project Jigsaw)** for modularity.
* **2018 onwards:** Java shifts to a **six-month rapid release cadence**, with new **Long-Term Support (LTS)** versions (like Java 11, 17, 21) released every few years, focusing on performance and modern features (e.g., Project Loom).

---

## 2. Differentiating Java Editions

Java is categorized into different editions to target specific application environments.

| Feature | Java **SE** (Standard Edition) | Java **EE** (Enterprise Edition) / **Jakarta EE** | Java **ME** (Micro Edition) |
| :--- | :--- | :--- | :--- |
| **Purpose** | Core language, desktop, client-side, and general-purpose applications. | Large-scale, distributed, fault-tolerant, and web-based server applications. | Constrained environments, embedded systems, and legacy mobile devices. |
| **Core Libraries** | **Core Java APIs** (`java.lang`, `java.util`, GUI tools like Swing/JavaFX). | **SE APIs + Enterprise APIs** (Servlets, JSPs, EJB, JPA, JAX-RS/REST, WebSockets). | **Subset of SE APIs + Specialized APIs** (e.g., CLDC, MIDP) for resource limits. |
| **Target Env.** | Desktops, command-line tools, local servers (e.g., Spring Boot apps). | Application Servers (e.g., WildFly, GlassFish, WebLogic, Tomcat). | IoT devices, smart cards, older feature phones (mostly historical today). |
| **Key Use Case** | Learning Java, developing desktop utilities, microservices (with frameworks). | E-commerce platforms, Banking systems, large-scale enterprise portals. | Firmware, specialized embedded systems. |

---

## 3. Java Architecture: JDK, JRE, and JVM

These three components form a layered system responsible for developing and running Java programs.

### Java Virtual Machine (JVM)
* **What it is:** The **core** of the Java platform. It's an abstract machine that provides the runtime environment.
* **Role:** Executes the platform-independent **bytecode** (`.class` files) by translating it into native machine code for the specific underlying OS and hardware. It manages memory (**Garbage Collection**) and ensures security.

### Java Runtime Environment (JRE)
* **What it is:** The minimal set of components required to **run** a compiled Java application.
* **Role:** The JRE packages the **JVM** along with the necessary **Java Class Libraries** (the standard API code) and supporting files.
* **Interaction:** The JRE uses the JVM to execute the application's bytecode. *If you only need to run a Java program, you only need the JRE (or just a standalone JVM).*

### Java Development Kit (JDK)
* **What it is:** The complete kit for **developing, compiling, and running** Java applications.
* **Role:** Used by developers to write and build programs. It is the superset of the other two.
* **Components:** **JRE + Development Tools** (like the **`javac`** compiler, **`jdb`** debugger, `javadoc` generator, etc.).
* **Interaction:** A developer uses the **JDK**'s tools to create and compile code. The resulting bytecode is then run by the **JRE/JVM**.

**Conceptual Diagram: JDK $\supset$ JRE $\supset$ JVM**

---

## 4. Install & Configure Java on Windows

The following steps outline the installation and configuration of the **JDK** (which includes the JRE and JVM).

### Step 1: Download and Install the JDK
1.  Download the desired **JDK installer** (e.g., from Oracle or OpenJDK) for Windows.
2.  Run the installer and follow the default prompts. Note the installation path (e.g., `C:\Program Files\Java\jdk-xx`).

### Step 2: Verify Installation
1.  Open the **Command Prompt** or **PowerShell**.
2.  Type the command: `java -version`
3.  The output should display the installed Java version.

**Screenshot Placeholder: Java Verification in Terminal**



### Step 3: Configure `JAVA_HOME` Environment Variable
This variable is essential for many build tools and IDEs to find your Java installation.

1.  Search for and open **"Edit the system environment variables"**.
2.  Click the **"Environment Variables..."** button.
3.  Under **"System variables"**, click **"New..."**.
    * **Variable name:** `JAVA_HOME`
    * **Variable value:** The root directory of your JDK installation (e.g., `C:\Program Files\Java\jdk-17.0.8`).
4.  Optionally, ensure the **`Path`** variable includes `%JAVA_HOME%\bin` to run Java executables from any command line location.


## 5. Using Eclipse IDE

### Step 1: New Java Project Creation
1.  Open Eclipse and select **File $\rightarrow$ New $\rightarrow$ Java Project**.
2.  In the wizard:
    * Enter a **Project name** (e.g., `MyFirstJavaApp`).
    * Ensure the appropriate **JRE** (JDK) is selected.
    * Click **"Finish"**.


### Step 2: Run Configurations
To execute your application, Eclipse manages a "Run Configuration" for you.

1.  Create a class with a `main` method (e.g., in `src/com.mycompany/Main.java`).
2.  To run, simply click the **Run** icon (green play button) on the toolbar. Eclipse automatically creates a default run configuration.
3.  To customize, go to **Run $\rightarrow$ Run Configurations...**.
4.  In the dialog, you can:
    * Select or create a **Java Application** configuration.
    * Verify the **Main class** entry point.
    * Set **Program Arguments** or **VM Arguments**.
    * Click **"Run"** to execute


## Mapping: Syllabus topic → Files
| Topic | Example file/method |
|-------|---------------------|
| Encapsulation | `Student` private fields + getters |
| Inheritance | `Person` → `Student` |
| Polymorphism | `Student.profile()` override |
| Builder | `Course.Builder`, `Student.Builder` |
| Singleton | `AppConfig` |
| Enums | `Semester`, `Grade` |
| Date/Time API | `Student.createdAt`, backups timestamp |
| Streams | `ReportsCLI` GPA distribution |
| Collections | `StudentService` uses List |
| NIO.2 | `ImportExportService.createBackup`, `FileUtil.folderSize` |
| Custom Exceptions | `DuplicateEnrollmentException`, `MaxCreditLimitExceededException` |
| Arrays & Sorting | `ExtraExamples.demonstrate()` |
| Recursion | `ExtraExamples.factorial()` |
| Control flow | `Main`, `ExtraExamples` loops |

## How to run
See `USAGE.md`


