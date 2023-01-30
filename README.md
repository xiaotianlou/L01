# A1 - Piraten Karpen

  * Author: < xiaotian lou >
  * Email: < loux8@mcmaster.ca >

## Build and Execution

  * To clean your working directory:
    * `mvn clean`
  * To compile the project:
    * `mvn compile`
  * To run the project in development mode:
  * type the mode in string after start program
  * start program with choosed ai mode
    * `mvn -q exec:java -Dexec.args="random combo"`(start with ai slect)
    * `mvn -q exec:java -Dexec.args="combo combo"`(start with ai slect)
  * To package the project as a turn-key artefact:
    * `mvn package`
  * To run the packaged delivery:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar` 
    * `mvn -q exec:java -ae -be"`

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * < print the percentage win of random player >
   * < make log 4j >
   * < have right scoring method >
   * < have ai mode >
   * < have Card >
   * < have seabattle >
   * < have monkey business >

### Backlog 

| MVP? | Id  | Feature  | Status  |  Started  | Delivered |
| :-:  |:-:  |---       | :-:     | :-:       | :-:       |
| x   | F01 | Roll a dice |  D | 01/01/23 |  |01/14/23
| x   | F02 | Roll the number of dice up to eight dices  | D (F01) |01/01/23   |01/17/23
| x   |F03 | end the program with 42 game  | D |01/01/23   |01/17/23
| x   | F04 | end of turn with three and more cranes | D |01/01/23 |01/17/23
| x   | F05 | 2 AI Player using same logical  | D (F02)| 01/01/23| 01/17/23|
| x   | F06 | strategy random dice to keep until end  | D (F02) | 01/01/23|01/17/23
| x   | F07 | Score points: 100 * (diamonds + gold coin) | D (F04) |01/01/23 | 01/17/23
| x   | F08 | end the game with 6000 point for 1 player |D |01/01/23 |01/17/23
| x  |F9  |print percentage of win for each player |D    | 01/01/23      |01/17/23
| x  |F10  |wirie the scoring logcial | D   | 01/01/23      | 01/24/23
| x  |F11  |making ai mode | D    | 01/01/23      |  01/24/23
| x  |F12  | make card bag| D     | 01/01/23       |  01/24/23
| x  |F13  |design for card class | D |  01/01/23     | 01/24/23
| x  |F14  |reload strategy | D   | 01/01/23     |   01/24/28
| x  |F15  |make sea battle | D    | 01/01/23      | 01/24/28
| x  |F16  | make battle mode| D   | 01/01/23      | 01/24/28
| x  |F17  | clean mess| D     |01/01/23     | 01/24/28
| x  |F18  | make money business card| D    | 01/01/28       | 01/29/28      |
| x  |F19  |update PMD | D   | 01/29/28       | 01/29/28    |
| x  |F20  |update skull islan |D     | 01/29/28      |01/29/28    |
| x  |F21  |update Cpl | D   | 01/29/28       | 01/29/28    |
