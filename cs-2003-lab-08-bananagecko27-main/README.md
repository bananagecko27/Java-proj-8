[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-718a45dd9cf7e7f842a935f5ebbe5719a5e09af4491e668f4dbf3b35d5cca122.svg)](https://classroom.github.com/online_ide?assignment_repo_id=12431483&assignment_repo_type=AssignmentRepo)
# CS-2003-Lab-8

## Overview
The eighth lab is intended to introduce you to how queues can be used to process tasks. You’ve been provided with six files: Main.java, BasicQueue.java, QueueInterface.java, lab08.txt, Task.java, and TaskQueue.java. **Main.java** is the driver file to add tasks to and process tasks from the task queue. **BasicQueue.java** is a reference-based implementation of the queue interface. **QueueInterface.java** is the description of the queue interface. **lab08.txt** is an input file that includes a series of tasks to be added to the task queue. **Task.java** is a struct class that represents a single task. **TaskQueue.java** is the implementation of the task queue to process tasks.

Use **TUGrader.java** to ensure that all unit tests in the provided test file(s) pass.

## Assignment
The main function of Main.java reads in a sequence of tasks from lab08.txt. Each Task is added to a holding queue, which is an instance of BasicQueue. Once all tasks have been read in, a TaskQueue is instantiated. Each task in the holding queue is added to the task queue when the task has arrived as determined by the arrival time specified in lab08.txt. Tasks that have been enqueued to the task queue are simultaneously processed until all tasks have been completed. The number of tasks and average wait time of each task is then reported.

Implement the remainder of TaskQueue.java where comments indicate that the code still needs to be completed. Once the code has been completed, please document in a report the start time, end time, and wait time of each task. The start time of each task is the time tick at which the time was added to the task queue. The end time of each task is the time tick at which the time was removed from the task queue. The wait time of each task is the difference between the task’s arrival time and the task’s start time. You should also report the average wait time across tasks.

## Submission
The assignment is due by the end-of-day Friday of the following week. **Your report should be submitted to Harvey.**

*To submit your work, please review the **Commits** section below.*

## Grading Rubric
- [ ] (30pts) Can enqueue new tasks to the task queue
- [ ] (50pts) Can process tasks in the task queue
- [ ] (20pts) Complete report

## Compiling and Testing Code
Your IDE should provide tools to compile your code. If you're unfamiliar with that process, you can research it online or ask. Most developers compile their code from command line using a shell script, such as a **Makefile** or build script (**build.sh**). I've provided build scripts for you in both *Powershell* and *Bash*. Refer to the following directions on how to use these scripts based on the terminal that you're using. If you're on Windows, please use Windows Subsystem for Linux (WSL), Git Bash, or Powershell, not Command Prompt.

### Windows Users (Powershell)
- To compile your code: `./build.ps1`
- To compile and run your code: `./build.ps1 run` (forwards clargs to program)
- To compile and test your code: `./build.ps1 test` (forwards clargs to TUGrader)
- To format your code: `./build.ps1 fmt`
- To sync your code: `./build.ps1 sync`
- To submit your code: `./build.ps1 submit`
- To remove class files: `./build.ps1 clean`

### Windows Users (WSL, Git Bash), Mac and Linux Users
- To compile your code: `./build.sh`
- To compile and run your code: `./build.sh run` (forwards clargs to program)
- To compile and test your code: `./build.sh test` (forwards clargs to TUGrader)
- To format your code: `./build.sh fmt`
- To sync your code: `./build.sh sync`
- To submit your code: `./build.sh submit`
- To remove class files: `./build.sh clean`

These scripts use the following commands. Note that Windows users need to replace the colon with a semicolon in the Java classpath.
- To compile a Java file: `javac -d target -cp lib/*:src <filepath>.java`
- To execute a Java file: `java -cp lib/*:target <package-path>.<filename>`
- To format a Java file: `java -jar lib/google-java-format.jar --replace --skip-javadoc-formatting <filepath>.java`
- To remove class files: `rm -r target/*`

## Code Style
All code should follow the [Google Java style guidelines](https://google.github.io/styleguide/javaguide.html). If you find anything in the code that does not follow the style guidelines, feel free to fix it, but you are not required to do so. Only your handwritten code will be evaluated for its style. You do not need to follow the style guidelines to the letter but egregious deviations from the style guidelines will be penalized. A submission that passes all test cases but does not use an appropriate style will not receive an A for the assignment.

For those using an IDE, such as Eclipse or VS Code, the IDE should provide a formatting tool. I've included the XML specification of the Google Java Style Guidelines at `.vscode/java-google-style.xml`. You can configure your IDE to use the provided XML as its formatting rules to format your code to the Google Java Style Guidelines, which are the industry standard.

If you're working from command-line, [google-java-format](https://github.com/google/google-java-format) is an open-source formatting tool that you can use to format your files. You can use the following commands to format your code depending on your terminal.
- `./build.ps1 fmt`
- `./build.sh fmt`

## Commits
Commits should be made incrementally. Many commits are always better than few, and commits can always be squashed together later if there are too many. You should try to make a commit every time you've made tangible progress in the development of your code.

Every commit should have a commit message. The standard format for commit messages is to start with a verb in present-tense followed by a concise message (typically less than 50 characters) that summarizes the change that the commit is introducing to the repo. For example, "Updates README", "Implements Array", "Passes testGet".

Popular IDEs, such as Eclipse and VS Code, provide integrated Git tools. If you're on Windows, you can install Git Bash or Windows Subsystem for Linux (WSL). If you're on Mac or Linux, you already have git installed.

If you've just installed git, it will need to be configured. The easy way to configure git is from a terminal. Use the following commands.
- `git config --global user.name "<github-username-goes-here>"`
- `git config --global user.email "<github-email-goes-here>"`
- `git config --global pull.rebase true` (optional)
- `git config --global fetch.prune true` (optional)
- `git config --global diff.colorMoved zebra` (optional)

To sync changes made from another device, use the following command.
- `git fetch origin main`
- `git pull origin main`

To push commits from command line, use the following commands.
- `git add -A`
- `git commit -m "<your message goes here>"`
- `git push origin main`

You can also sync all changes and submit with the following commands depending on your terminal.
- `./build.ps1 submit`
- `./build.sh submit`
