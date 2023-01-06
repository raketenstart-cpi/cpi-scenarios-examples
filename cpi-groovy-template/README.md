# cpi-groovy-template
CPI Groovy Project

![mit-license](https://img.shields.io/github/license/raketenstart-cpi/cpi-groovy-template?style=for-the-badge">)

### Code coverage

JaCoCo plugin provides code coverage metrics for Java code via integration with 
[JaCoCo](https://www.eclemma.org/jacoco/).

| **goal**                         | **description**                                                            |
|----------------------------------|----------------------------------------------------------------------------|
| `jacocoTestReport`               | Generates code coverage report for the test task.                          |
| `jacocoTestCoverageVerification` | Verifies code coverage metrics based on specified rules for the test task. |

### Example

At the root, run statements in order to collect JaCoCo results.

- `./gradlew jacocoTestReport`
- `./gradlew jacocoTestCoverageVerification`
