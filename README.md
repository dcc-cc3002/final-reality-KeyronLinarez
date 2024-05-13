# Final Reality

Final Reality is a simplified clone of the renowned game, Final Fantasy. Its main purpose is to
serve as an educational tool, teaching foundational programming concepts.

In designing this project, several decisions were made to ensure the readability of the codebase. This project's classes were first designed and structured following the UML Design: class implementation follows the hierarchy of Traits, abstract, and concrete classes, respectively. All interfaces are also grouped by packages (e.g. AbstractCharacter and its implementation BlackMage are under the characters package).

This approach helped make code easier to read, and more importantly, easier to write. Specifically, organizing classes by package made writing extensive test cases much easier, since methods and associated variables could be tested on a case-by-case basis. I leveraged the MUnit testing library to create extensive testing of cases and edge cases of each respective class.

My project is designed to maintain the Liskov principle - every concrete class implements an abstract class, which implements a trait. This allowed me to continue adding and removing concrete classes during my design process, without altering the superclasses since all of my methods were already defined :)

This was a rewarding and insightful project. The decisions I made by the end were ones that I had learned after making many mistakes (like realizing the Enemy class cannot have a weapon!) I hope the structure of this project is easy to engage with! Thank you for reading.

This project is licensed under the
[Creative Commons Attribution 4.0 International License](https://creativecommons.org/licenses/by/4.0/).
