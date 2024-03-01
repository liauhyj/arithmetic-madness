# Arithmetic Madness

This repository contains the source code for a web-based game called Arithmetic madness.

The techstack used is HTML/Bootstrap/CSS/JavaScript/jQuery for the frontend and Spring MVC in Java for the backend.

## Brief Description of the Game

The goal of the game is to score as many points as possible.

On clicking the 'Click to begin' button in the homepage, the game initializes number pairs from 0(inclusive) to 12(inclusive) and assigns random arithmetic operations to each pair.
These are then presented as equations for the user to solve.
Additionally, a timer of 60 seconds starts to count down.

The user starts with a score of 0. Each correct answer adds 1 to the user's current score and each wrong answer subtracts 1 from the user's current score.
The user may also choose to skip the question, but the question is considered unsolved and will not appear again.

The game ends when either condition is met:
1) All 169 equations are solved or skipped.
2) The timer counts down to 0.
