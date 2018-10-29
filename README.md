# RPG Game - The Coffee Journey

                  ., '''''''''''''''''' ,.
               .'   .oooooo$$$$$ooooooo.   '.
              ::  ,$$$$$$$$$$$$$$$$$$$$$$,  ',
              |;  '$$$$$$$$$$$$$$$$$$$$$$'    ''''''''''.
              |;     ''''''$$$$$'''''''       ,:''''':, |
              |;   '|                   |'    ||      | |
              |;   '|                   |'    ||      | |
              |;   '|                   |'    ||      | |
              |;   '|                   |'    ||      | |
              |;   '|                   |'    ':.....:' |
              |;   '|                   |'     ,,,,,,,,,'
              |;   '|                   |'    ;
              |;.   |                   |   .'
               '||,,,                   ,,,;'
                  ''';;;;,,,,,,,,,,,;;;;'''
                         '''''''''''


## Table of Contents

- [Introduction](#introduction)
- [Technical Info](#technical-info)
- [Requirements](#requirements)
- [Usage](#usage)
- [Test Coverage](#test-coverage)
- [Developer Considerations](#developer-considerations)

## Introduction

At this game, you are a Software Developer that is trying to do what we do every day: Drink Coffee!
You can choose your Programming Language, but you have to think with your brain, not with your heart S2!

Here is the dynamics:

You are now at your desk with Slack window opened and with a lot of notifications blinking!

Each slack message could have a good or bad surprise, that guides you in our path to **Coffee Nirvana**, when you everything become shiny and clear (this is the end of the game).

But... I don't think only good thinks are going to happen! You will need to correct a lot of bugs and solve a lot of problems too.

If your caffeine level reach **ZERO**, then you are `DEAD`

I wish you good luck!

## Technical Info

The software was developed using the following tools/platforms:
- [Linux Mint 19](https://www.linuxmint.com/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [Java 8](https://www.java.com/pt_BR/)
- [Maven](https://maven.apache.org/)
- [JUnit 4](https://junit.org/junit4/)
- [AssertJ](http://joel-costigliola.github.io/assertj/)
- [Mockito](https://site.mockito.org/)
- [PowerMock](https://github.com/powermock/powermock)
- [Jacoco](https://www.eclemma.org/jacoco/trunk/doc/maven.html)

## Requirements

In order to run the game, you need to have installed at your environment:
1. [Java 8](https://www.java.com/pt_BR/)
2. [Maven](https://maven.apache.org/)


## Usage

First, you have to generate the `jar` with `mvn`:

```sh
$ mvn clean install
```

You are ready to run with the command:

```sh
$ java -jar target/rpg-game-1.0-SNAPSHOT.jar 
```
Follow the instructions on screen and **enjoy your coffee**

## Test Coverage
1. `Exceptions` were not tested.
2. `Main` class was nos tested
3. `InputUtils` and `FileUtils` were removed from Jacoco Coverage because of an [incompatibility](https://github.com/powermock/powermock/wiki/Code-coverage-with-JaCoCo) between Jacoco and PowerMock

## Developer Considerations

It was a very hard, intense and fun challenge! I really enjoyed making it!

The requirement that tells that we **CAN'T** use `any` library (only using for tests) makes the challenge more complicated.

As we are using `Spring`, `Lombok` and other libraries, somethings we forget how the things works behind the scene.

Cohesion and Coupling comes to our mind all the time. At this time you miss so much: `@Autowired`, `@Bean`, `@DefaultArgsConstructor` and so many code tricks that we use every day. 

Testing is very important for me, so I used `Jacoco` to help me, telling the methods, lines and branches that I could possibly have forgotten.