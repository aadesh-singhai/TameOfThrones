# Geektrust coding challenge
[![Generic badge](https://img.shields.io/badge/build-passing-any.svg)](https://shields.io/)
[![Generic badge](https://img.shields.io/badge/version-v0.0.1-blue.svg)](https://shields.io/)
[![Generic badge](https://img.shields.io/badge/built%20wth-gradle-red.svg)](https://shields.io/)
## Problem Context - <a href="https://www.geektrust.in/coding-problem/backend/tame-of-thrones">Tame of Thrones</a>.
Coding challenge is to have a King send secret message to each kingdom and win them over.
Once he wins 3 more kingdoms, he is the ruler! The secret message needs to contain the letters of the animal in their emblem.
For example, secret message to the Land kingdom (emblem: Panda) needs to have the letter 'p','n','d' at-least once and 'a' atleast twice. If he sends "ahdvvnxxxautup" to the Land kingdom, he will win them over.
King Shan wants to make sure his secret message is not found by his enemies easily. So he decides to use the oldest of the
ciphers 'Seasar cipher’.
## Input/Output
* I/P - Text File with format - KINGDOM_NAME MESSAGE
* O/P - Console RULER_KINGDOM_NAME ALLIES
### SAMPLE INPUT/OUTPUT
    AIR ROZO                    SPACE AIR LAND ICE
    LAND FAIJWJSOOFAMAU
    ICE STHSTSTVSASOS 
    ------------------------------------------------
    AIR OWLAOWLBOWLC            NONE
    LAND OFBBMUFDICCSO
    ICE VTBTBHTBBBOBAB
    WATER SUMMER IS COMING

## System Requirments
1. Java 1.8 or above
2. Gradle v5.1.1 or above
## Steps to build
1. Clone the repository ```$ git clone https://github.com/aadesh-singhai/TameOfThrones.git```
2. Go to the root directory and install dependencies```$ .\gradlew build```
3. Go to the root directory and run the program```$ java -jar <pathToJar/geektrust.jar <path-to-input-file>```
