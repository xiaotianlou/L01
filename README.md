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
| x   | F01 | Roll a dice |  S | 01/01/23 |  |
| x   | F02 | Roll the number of dice up to eight dices  |  B (F01) |   |
| x   |F03 | end the program with 42 game  |  P  |   |
| x   | F04 | end of turn with three and more cranes | P | |
| x   | F05 | 2 AI Player using same logical  | B (F02) | |
| x   | F06 | strategy random dice to keep until end  | B (F02) | |
| x   | F07 | Score points: 100 * (diamonds + gold coin) | B (F04) | | 
| x   | F08 | end the game with 6000 point for 1 player | | |
| x  |F9  |print percentage of win for each player | :-:     | :-:       | :-:       |
| x  |F10  |wirie the scoring logcial | :-:     | :-:       | :-:       |
| x  |F11  |making ai mode | :-:     | :-:       | :-:       |
| x  |F12  | make card bag| :-:     | :-:       | :-:       |
| x  |F13  |design for card class | :-:     | :-:       | :-:       |
| x  |F14  |reload strategy | :-:     | :-:       | :-:       |
| x  |F15  |make sea battle | :-:     | :-:       | :-:       |
| x  |F16  | make battle mode| :-:     | :-:       | :-:       |
| x  |F17  | clean mess| :-:     | :-:       | :-:       |
| x  |F18  | make money business card| :-:     | :-:       | :-:       |
| x  |F19  | | :-:     | :-:       | :-:       |
| x  |F20  | | :-:     | :-:       | :-:       |

