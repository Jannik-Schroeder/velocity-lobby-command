# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Added
- GitHub Actions workflows for automated building and testing
- Code quality checks with Checkstyle
- Automated release management
- Continuous integration pipeline

### Changed
- Improved error handling in command execution
- Enhanced logging for better debugging

## [1.2.1] - 2025-01-15

### Added
- GitHub Actions workflows for automated building and testing
- Code quality checks with Checkstyle
- Automated release management
- Continuous integration pipeline

### Changed
- Improved error handling in command execution
- Enhanced logging for better debugging
- Updated package structure to me.jsde domain
- Fixed GitHub Actions workflows and permissions
- Corrected release naming and versioning

## [1.0.0] - 2024-01-XX

### Added
- Initial release of Velocity Lobby Plugin
- Support for `/hub`, `/lobby`, and `/l` commands
- Automatic lobby server detection
- Configurable messages and server names
- Comprehensive logging system
- Smart teleportation (prevents duplicate connections)
- Server status checking before connection
- Maven build system with proper dependencies
- Configuration file support
- Example Velocity configuration

### Features
- **Multiple Commands**: Players can use `/hub`, `/lobby`, or `/l` to teleport to the lobby
- **Smart Teleportation**: Automatically detects if the player is already on the lobby server
- **Server Status Check**: Verifies lobby server availability before attempting connection
- **Configurable**: Easy to customize server names and messages
- **Logging**: Comprehensive logging for debugging and monitoring

### Technical Details
- Built for Velocity 3.4.0+
- Requires Java 17+
- Maven-based build system
- Plugin metadata in `velocity-plugin.json`
- YAML configuration support
- Proper error handling and user feedback

### Installation
1. Download the JAR file from GitHub Releases
2. Place it in your Velocity server's `plugins/` directory
3. Restart your Velocity server
4. Configure your lobby server in `velocity.toml`

### Configuration
- Default lobby server name: `lobby`
- Customizable messages with color code support
- Command enable/disable options
- Flexible alias configuration

---

## Version History

- **v1.0.0**: Initial release with core functionality
- **Future versions**: Will include new features, bug fixes, and improvements

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct and the process for submitting pull requests.

## License

This project is dedicated to the **Public Domain**. You are free to use, modify, distribute, and commercialize this software without any restrictions or attribution requirements.

See the [LICENSE](LICENSE) file for details.
