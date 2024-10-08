# Final Reality

Final Reality is a simplified clone of the renowned game, Final Fantasy. Its main purpose is to
serve as an educational tool, teaching foundational programming concepts.

This is the second submission for the Final Reality project, and I have focused heavily on improving readability since the first submission as well as implementing magic spells. In designing this project, several decisions were made to ensure the readability of the codebase. This project's classes were first designed and structured following the UML Design: class implementation follows the hierarchy of Traits, abstract, and concrete classes, respectively. All interfaces are also grouped by packages (e.g. AbstractCharacter and its implementation BlackMage are under the characters package).

One specefic area that I expanded on in this version was the design of my AbstractMagicCharacter class, which contains all of my code for magicvspells. AbstractMagicCharacter is an abstract class representing a the black mage and white mage character, and expands on magic while extending the base functionality of AbstractCharacter. This class focuses on  managing their mana and magic weapons. Mana is a critical property for magical characters, controlled through specific methods (getMana and useMana) to prevent direct modifications.

In designing the AbstractMagicCharacter class, I ensured strict adherence to the Liskov Substitution Principle (LSP). Each  magical user class  implements this abstract class, which in turn implements a broader trait defining character behavior. Levearging the AbstractMagicCharacter class allowed me to add spells without altering the superclass or game logic. By defining all the magic character methods in the abstract class, I was able to simplify the creation process without having to alter too much code between the Black and White mages.

I have learned a lot since the first submission, and did a better job at documenting my code as well as adding more rigorous testing. I focused on  testing, addressing complexities in methods like hechizo through comprehensive unit and integration tests, ensuring accurate behavior across various scenarios. I hope the project’s structure is intuitive and engaging—thank you for reviewing it! :3
