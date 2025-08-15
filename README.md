# Velocity Lobby Command

[![Build Status](https://github.com/Jannik-Schroeder/velocity-lobby-command/workflows/Build%20and%20Release/badge.svg)](https://github.com/Jannik-Schroeder/velocity-lobby-command/actions)
[![CI Status](https://github.com/Jannik-Schroeder/velocity-lobby-command/workflows/Continuous%20Integration/badge.svg)](https://github.com/Jannik-Schroeder/velocity-lobby-command/actions)
[![Code Quality](https://github.com/Jannik-Schroeder/velocity-lobby-command/workflows/Code%20Quality/badge.svg)](https://github.com/Jannik-Schroeder/velocity-lobby-command/actions)

A Velocity server plugin that provides a simple command for players to teleport to the lobby server using `/hub`, `/lobby`, and `/l` commands.

## Features

- **Multiple Commands**: Players can use `/hub`, `/lobby`, or `/l` to teleport to the lobby
- **Smart Teleportation**: Automatically detects if the player is already on the lobby server
- **Server Status Check**: Verifies lobby server availability before attempting connection
- **Configurable**: Easy to customize server names and messages
- **Logging**: Comprehensive logging for debugging and monitoring

## Requirements

- **Velocity**: 3.4.0 or higher
- **Java**: 17 or higher
- **Maven**: For building the plugin

## Installation

### 1. Build the Plugin

```bash
# Clone the repository
git clone https://github.com/Jannik-Schroeder/velocity-lobby-command.git
cd velocity-lobby-command

# Build with Maven
mvn clean package
```

The compiled plugin will be in the `target/` directory as `velocity-lobby-command-1.0.0.jar`.

### 2. Install on Velocity Server

1. Copy the `velocity-lobby-command-1.0.0.jar` file to your Velocity server's `plugins/` directory
2. Restart your Velocity server
3. The plugin will automatically load and register the commands

### 3. Configure Your Lobby Server

Make sure you have a lobby server configured in your `velocity.toml` file:

```toml
[servers]
lobby = "127.0.0.1:25566"  # Your lobby server address
```

## Configuration

The plugin creates a `config.yml` file in the `plugins/velocity-lobby-command/` directory after first run.

### Main Configuration

```yaml
# The name of your lobby server as configured in velocity.toml
lobby-server-name: "lobby"

# Messages configuration
messages:
  already-on-lobby: "&eYou are already on the lobby server!"
  connecting: "&aConnecting to lobby..."
  server-offline: "&cLobby server is offline!"
  server-unavailable: "&cLobby server is not available!"
  connection-failed: "&cFailed to connect to lobby server!"
  players-only: "&cThis command can only be used by players!"

# Command configuration
commands:
  hub-enabled: true
  lobby-enabled: true
  l-enabled: true
```

### Customizing Messages

You can customize all messages using color codes:
- `&a` = Green
- `&c` = Red  
- `&e` = Yellow
- `&f` = White
- `&b` = Aqua
- `&d` = Light Purple

## Usage

### Commands

Players can use any of these commands to teleport to the lobby:

- `/hub` - Teleport to lobby
- `/lobby` - Teleport to lobby  
- `/l` - Teleport to lobby (short version)

### Permissions

By default, all players can use these commands. If you want to restrict access, you can modify the `hasPermission` method in the `LobbyCommand` class.

## Troubleshooting

### Common Issues

1. **"Lobby server is not available"**
   - Check that your lobby server is configured in `velocity.toml`
   - Ensure the server name matches exactly (case-sensitive)
   - Verify the lobby server is running

2. **"Lobby server is offline"**
   - Check if your lobby server is actually running
   - Verify the server address and port in `velocity.toml`
   - Check firewall settings

3. **Plugin not loading**
   - Ensure you're using Velocity 3.4.0+ and Java 17+
   - Check the server console for error messages
   - Verify the plugin JAR is in the correct directory

### Logs

The plugin logs all activities to the Velocity server console:
- Player connections to lobby
- Failed connection attempts
- Server availability issues

## Development

### Building from Source

```bash
# Clone the repository
git clone https://github.com/Jannik-Schroeder/velocity-lobby-command.git
cd velocity-lobby-command

# Build the project
mvn clean package

# Run tests (if any)
mvn test
```

### Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── me/jsde/velocitylobby/
│   │       ├── VelocityLobbyPlugin.java    # Main plugin class
│   │       └── LobbyCommand.java           # Command executor
│   └── resources/
│       ├── velocity-plugin.json            # Plugin metadata
│       └── config.yml                      # Default configuration
pom.xml                                     # Maven configuration
README.md                                   # This file
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## License

This project is dedicated to the **Public Domain**. You are free to use, modify, distribute, and commercialize this software without any restrictions or attribution requirements.

See the [LICENSE](LICENSE) file for details.

## Support

If you encounter any issues or have questions:

1. Check the troubleshooting section above
2. Review the server console logs
3. Open an issue on the project repository
4. Contact the development team

## Changelog

### Version 1.0.0
- Initial release
- Basic lobby teleportation functionality
- Support for `/hub`, `/lobby`, and `/l` commands
- Configurable messages and server names
- Comprehensive logging and error handling
