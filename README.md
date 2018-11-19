<h2>Current Developement Status</h2>

# fluent.ly [![Build Status](https://travis-ci.org/TechnionYP5779/team2.svg?branch=master)](https://travis-ci.org/TechnionYP5779/team2)



<h2>Our Project</h2>

Our main goal is to refactor the the old Spartanizer code in various ways: creating new classes, adding unit tests, adding features, cleaning code, etc.

<h2>What is Spartanizer?</h2>
<ul>
  <li> An Eclipse plugin</li>
  <li>Offers in the problems view tips for simplifying your code </li>
  <li>Make your code laconic: say much in few words.</li>
  <li>Platform for other research: nano-patterns, source to source transformation, and The Athenizer</li>
</ul>

The Spartanizer applies the principles of <a href="https://github.com/SpartanRefactoring/Main/wiki/Spartan-Programming">Spartan Programming</a> to your Java code. It applies many different _tippers_, which are little rules that provide suggestions on how to shorten and
simplify your code, e.g, by using fewer variables, factoring out common structures, more efficient use of control flow, etc. 

The Spartanizer help you make a sequence small, nano-refactorings of your code, to make it shorter, and more conforming to a language of nano-patterns. The resulting code is not just shorter, it is more regular. The spartanization process tries to remove as many distracting details and variations from the code, stripping it to its bare bone.

This includes removal of piles of _syntactic baggage_, which is code that does nothing, except for being there:  curly brackets around one statement, initializations which reiterate the default, modifiers which do not change the semantics, implicit call to `super()` which every constructor has, fancy, but uselessly long variable names, variables which never vary and contain temporaries and  many more. Overall, the Spartanizer has over 100 tippers.

This project was conceived as an academic project in the [Technion - Israel
Institute of Technology], and was later developed for several years by
different students and members of the Computer Science faculty.

The refactorings made by this plug-in are based on the concept of Spartan Programming, which suggests guidelines for writing short, clean code. There's a lot of reading material on the subject in the [project wiki].


<h2>Contributers</h2>
<ul>
  <li>Jessica Shelly Milgram</li>
  <li>Dor Kabareti</li>
  <li>Omer Glick</li>
  <li>Guy Suday</li>
  <li>Nerya Cohen</li>
  <li>Tal Porat</li>
  <li>Addir Abasker</li>
