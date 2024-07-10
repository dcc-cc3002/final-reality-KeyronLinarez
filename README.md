**# Final Reality

Final Reality is a simplified clone of the renowned game, Final Fantasy. Its main purpose is to
serve as an educational tool, teaching foundational programming concepts.

This is the final submission for the Final Reality project, and I have focused heavily on improving readability since the first submission as well as implementing magic spells. In designing this project, several decisions were made to ensure the readability of the codebase. This project's classes were first designed and structured following the UML Design: class implementation follows the hierarchy of Traits, abstract, and concrete classes, respectively. All interfaces are also grouped by packages (e.g. AbstractCharacter and its implementation BlackMage are under the characters package).

I implemented the state design pattern in order to manage and keep track of the current game's state. Here is the basic outline of my project's game states:

![FinalReality Diagram drawio](https://github.com/dcc-cc3002/final-reality-KeyronLinarez/assets/112719213/faffbe56-8059-49a4-a6ed-03854e1f284d)

With this deisgn pattern, I was able to simplify my game's structure while making its flow easier to understand. i am very grateful for all the learning opportunities I have been able to experience while developing this, and I hope you enjoy taking a look at my code. I think I did a better job at documenting my code as well as adding more testing. I had a massive roadblock halfway through this project while trying to refactor my code - I overwrote several key methods, and was unable to build or compile my project for the lognest time :( Fortunately, I was able to revert to a previous stage of my project, but this meant that I lost a lot of progress and was not able to fully implement a lot of the code that I wanted. Some code (like my exception classes) used to be much more expansive, but i was only able to implement the basics due to time restraints. 

I hope the project’s structure is intuitive and engaging—thank you for reviewing it! :3
 
This project is licensed under the
[Creative Commons Attribution 4.0 International License](https://creativecommons.org/licenses/by/4.0/).**
