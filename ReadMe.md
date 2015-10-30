# Introduction #
> TrivialBot is a simple Java based IRC bot that plays trivia games with users in a specific channel.

# Configuration #
> TrivialBot uses two configuration files:
    1. questions.csv
    1. config.txt

## Questions file ##
> Questions should be placed in a file named “questions.csv” and should be placed in the same folder along with the executable Jar file. The file format is quite simple:  `question  <tab>  answer <newline>`

> You can use any spreadsheet editor like Microsoft excel or [LibreOffice](http://www.libreoffice.org/). A sample questions file is included.

> Trivialbot reports the number of questions found at startup, you should notice this. Also Trivialbot will quit if it can’t find any questions or fails to load them.

## Config file ##

> The configuration file is needed for connecting to the IRC channel. The application cannot start without it. The file format is simple: `parameter <space> value`.

> The config file should be placed in the same folder along with the Jar file. A sample config file is included in the released package.


# Running TrivialBot #

> TrivialBot is built on Java. Java must be installed on the server machine.
    1. Extract the zipped downloaded package.
    1. Using cmd/console navigate into TrivialBot’s directory
    1. Type the following command:  `java -jar TrivialBot.jar`
> TrivialBot should be started, and you’ll see some useful information in the cmd/terminal window.

