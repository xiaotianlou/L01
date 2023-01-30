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
  * 
  * start program with choosed ai mode
    * `mvn -q exec:java -Dexec.args="random combo"`(start with ai slect)
    * `mvn -q exec:java -Dexec.args="combo combo"`(start with ai slect)
  * To package the project as a turn-key artefact:
    * `mvn package`
  * To run the packaged delivery:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar` 

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * < print the percentage win of random player >

### Backlog 

| MVP? | Id  | Feature  | Status  |  Started  | Delivered |
| :-:  |:-:  |---       | :-:     | :-:       | :-:       |
| x   | F01 | Roll a dice |  D | 01/01/23 |  |
| x   | F02 | Roll the number of dice up to eight dices  | D (F01) |   |
| x   |F03 | end the program with 42 game  | D |   |
| x   | F04 | end of turn with three and more cranes | D | |
| x   | F05 | 2 AI Player using same logical  | D (F02) | |
| x   | F06 | strategy random dice to keep until end  | D (F02) | |
| x   | F07 | Score points: 100 * (diamonds + gold coin) | D (F04) | | 
| x   | F08 | end the game with 6000 point for 1 player |D | |
| x  |F9  |print percentage of win for each player |D    | :-:       | :-:       |
| x  |F10  |wirie the scoring logcial | D   | :-:       | :-:       |
| x  |F11  |making ai mode | D    | :-:       | :-:       |
| x  |F12  | make card bag| D     | :-:       | :-:       |
| x  |F13  |design for card class | D   | :-:       | :-:       |
| x  |F14  |reload strategy | D   | :-:       | :-:       |
| x  |F15  |make sea battle | D    | :-:       | :-:       |
| x  |F16  | make battle mode| D   | :-:       | :-:       |
| x  |F17  | clean mess| D     | :-:       | :-:       |
| x  |F18  | make money business card| D    | :-:       | :-:       |
| x  |F19  | | :-:     | :-:       | :-:       |
| x  |F20  | | :-:     | :-:       | :-:       |

