# Exercise: Decoupling (Java)

### Scenario

- We have a Bets class which represents the bets on a poker table
- When I want to place a bet, the "bet" method is called with my bet amount
- We can ask the "Bets" class if all bets are even, i.e. if every player has bet the same amount
  - This information can e.g. be used to decide whether the players now have to show their cards (showdown)
- There is a table limit that I am not allowed to exceed for my bet, i.e. I am not allowed to bet more than 100 USD

### Your Task

- Execute the tests - some of them will fail - find the root cause
- Fix the root cause by applying the dependency inversion principle
- Discuss alternative variants

### Hints

- Apparently the Bets, within its "bet" method, does two things - one of it is not really related to the core business logic, and makes it also hard to test at this point
- If you want to try using a mock framework, have a look into Mockito. A dependency has already been added to the pom.xml, so you can use it right away. The documentation can be found here: http://mockito.org/

## Test support tools
- To continuously execute your tests you can use [Infinitest](http://infinitest.github.io/) which has plugins for Eclipse and IntelliJ
- To get code coverage statistics you can use:
	- IntelliJ's built-in [code coverage runner](https://www.jetbrains.com/help/idea/code-coverage.html)
	- [EclEmma](https://www.eclemma.org/) plugin for Eclipse
- Mutation tests are available using the PIT maven plugin.
	- Simply run `mvn org.pitest:pitest-maven:mutationCoverage` the report will be available at **target/pit-reports/{timestamp}/index.html**
	- NOTE: If pitest reports any problems you can try to run `mvn install` and then retry.