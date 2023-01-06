sudoku-solver
=============

GUI application to solve Sudoku puzzles.

Each cell is checked for all possible values (and solved if there is only one possible value), then a recursive
backtracking algorithm is used to solve the remaining cells.

### Build & Run Jar

You may use your IDE to build executable JAR. Consult documentation of your IDE. Or simply use Maven: in project
directory, run the following command. Result JAR will be saved inside `target/` folder

```shell
mvn clean package
```