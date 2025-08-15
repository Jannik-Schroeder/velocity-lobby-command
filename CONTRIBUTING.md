# Contributing to Velocity Lobby Plugin

Thank you for your interest in contributing to the Velocity Lobby Plugin! This document provides guidelines and information for contributors.

## Table of Contents

- [Code of Conduct](#code-of-conduct)
- [How Can I Contribute?](#how-can-i-contribute)
- [Development Setup](#development-setup)
- [Pull Request Process](#pull-request-process)
- [Code Style Guidelines](#code-style-guidelines)
- [Testing](#testing)
- [Reporting Bugs](#reporting-bugs)
- [Feature Requests](#feature-requests)

## Code of Conduct

This project and everyone participating in it is governed by our Code of Conduct. By participating, you are expected to uphold this code.

## How Can I Contribute?

### Reporting Bugs

- Use the GitHub issue tracker
- Include detailed steps to reproduce the bug
- Provide your Velocity version, Java version, and plugin version
- Include relevant logs and error messages
- Use the bug report template

### Suggesting Enhancements

- Use the GitHub issue tracker
- Clearly describe the enhancement
- Explain why this enhancement would be useful
- Provide examples of how it would work

### Pull Requests

- Fork the repository
- Create a feature branch
- Make your changes
- Test thoroughly
- Submit a pull request

## Development Setup

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Git
- A Velocity server for testing

### Getting Started

1. **Fork the repository**
   ```bash
   git clone https://github.com/YOUR_USERNAME/velocity-lobby-plugin.git
   cd velocity-lobby-plugin
   ```

2. **Set up your development environment**
   ```bash
   # Install dependencies
   mvn clean install
   
   # Run tests
   mvn test
   
   # Build the plugin
   mvn clean package
   ```

3. **Create a feature branch**
   ```bash
   git checkout -b feature/your-feature-name
   ```

### Project Structure

```
src/
├── main/
│   ├── java/com/example/velocitylobby/
│   │   ├── VelocityLobbyPlugin.java    # Main plugin class
│   │   └── LobbyCommand.java           # Command executor
│   └── resources/
│       ├── velocity-plugin.json        # Plugin metadata
│       └── config.yml                  # Configuration
.github/workflows/                      # GitHub Actions
├── build.yml                           # Build and release workflow
├── ci.yml                             # Continuous integration
├── quality.yml                        # Code quality checks
└── release.yml                        # Release management
```

## Pull Request Process

1. **Ensure your code follows the style guidelines**
2. **Add tests for new functionality**
3. **Update documentation if needed**
4. **Update the CHANGELOG.md**
5. **Ensure all tests pass**
6. **Submit your pull request**

### Pull Request Checklist

- [ ] Code follows the style guidelines
- [ ] Tests pass locally
- [ ] Documentation is updated
- [ ] CHANGELOG.md is updated
- [ ] No merge conflicts
- [ ] Descriptive commit messages

## Code Style Guidelines

### Java Code Style

- Follow Java naming conventions
- Use meaningful variable and method names
- Add Javadoc comments for public methods
- Keep methods under 50 lines when possible
- Use proper indentation (4 spaces)

### Example

```java
/**
 * Executes the lobby command for a player.
 * 
 * @param player the player executing the command
 * @param server the proxy server instance
 */
public void executeLobbyCommand(Player player, ProxyServer server) {
    // Implementation here
}
```

### Configuration Files

- Use consistent indentation (2 spaces for YAML)
- Add descriptive comments
- Group related settings together
- Use clear, descriptive names

## Testing

### Running Tests

```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=LobbyCommandTest

# Run tests with coverage
mvn jacoco:prepare-agent test jacoco:report
```

### Writing Tests

- Test all public methods
- Include edge cases
- Mock external dependencies
- Use descriptive test names
- Follow AAA pattern (Arrange, Act, Assert)

### Example Test

```java
@Test
public void testPlayerAlreadyOnLobbyServer() {
    // Arrange
    Player player = mock(Player.class);
    when(player.getCurrentServer()).thenReturn(Optional.of(mockServer));
    
    // Act
    command.execute(player);
    
    // Assert
    verify(player).sendMessage(contains("already on lobby"));
}
```

## Reporting Bugs

### Bug Report Template

```markdown
**Bug Description**
A clear description of what the bug is.

**Steps to Reproduce**
1. Go to '...'
2. Click on '...'
3. See error

**Expected Behavior**
What you expected to happen.

**Actual Behavior**
What actually happened.

**Environment**
- Velocity Version: [e.g., 3.4.0]
- Java Version: [e.g., 17]
- Plugin Version: [e.g., 1.0.0]
- OS: [e.g., Ubuntu 20.04]

**Additional Information**
Any other context about the problem.
```

## Feature Requests

### Feature Request Template

```markdown
**Feature Description**
A clear description of the feature you're requesting.

**Use Case**
Why this feature would be useful.

**Proposed Implementation**
How you think this could be implemented (optional).

**Alternatives Considered**
Any alternative solutions you've considered.

**Additional Information**
Any other context or screenshots.
```

## Getting Help

- **GitHub Issues**: For bugs and feature requests
- **GitHub Discussions**: For questions and general discussion
- **Pull Requests**: For code contributions

## Release Process

1. **Create a new branch for the release**
2. **Update version numbers**
3. **Update CHANGELOG.md**
4. **Create a pull request**
5. **After review, merge and create a tag**
6. **GitHub Actions will automatically build and release**

## Thank You

Thank you for contributing to the Velocity Lobby Plugin! Your contributions help make this project better for everyone in the Minecraft community.
