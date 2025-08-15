#!/bin/bash

echo "Building Velocity Lobby Command..."

# Check if Maven is installed
if ! command -v mvn &> /dev/null; then
    echo "Error: Maven is not installed. Please install Maven first."
    echo "Visit: https://maven.apache.org/install.html"
    exit 1
fi

# Clean and package
mvn clean package

if [ $? -eq 0 ]; then
    echo ""
    echo "✅ Build successful!"
    echo "📦 Plugin JAR created: target/velocity-lobby-command-1.0.0.jar"
    echo ""
    echo "To install:"
    echo "1. Copy the JAR file to your Velocity server's plugins/ directory"
    echo "2. Restart your Velocity server"
    echo "3. Configure your lobby server in velocity.toml"
    echo ""
    echo "Usage: Players can use /hub, /lobby, or /l to teleport to the lobby"
else
    echo ""
    echo "❌ Build failed! Check the error messages above."
    exit 1
fi
