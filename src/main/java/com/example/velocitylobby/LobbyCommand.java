package com.example.velocitylobby;

import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.proxy.server.RegisteredServer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.slf4j.Logger;

import java.util.List;
import java.util.Optional;

public class LobbyCommand implements SimpleCommand {

    private final ProxyServer server;
    private final Logger logger;
    private static final String LOBBY_SERVER_NAME = "lobby"; // Change this to your lobby server name

    public LobbyCommand(ProxyServer server, Logger logger) {
        this.server = server;
        this.logger = logger;
    }

    @Override
    public void execute(Invocation invocation) {
        if (!(invocation.source() instanceof Player player)) {
            invocation.source().sendMessage(Component.text("This command can only be used by players!", NamedTextColor.RED));
            return;
        }

        // Get the lobby server
        Optional<RegisteredServer> lobbyServer = server.getServer(LOBBY_SERVER_NAME);
        
        if (lobbyServer.isEmpty()) {
            player.sendMessage(Component.text("Lobby server is not available!", NamedTextColor.RED));
            logger.warn("Player {} tried to connect to lobby server, but it's not available", player.getUsername());
            return;
        }

        // Check if player is already on the lobby server
        if (player.getCurrentServer().isPresent() && 
            player.getCurrentServer().get().getServerInfo().getName().equals(LOBBY_SERVER_NAME)) {
            player.sendMessage(Component.text("You are already on the lobby server!", NamedTextColor.YELLOW));
            return;
        }

        // Connect player to lobby server
        lobbyServer.get().ping().thenAccept(ping -> {
            if (ping != null) {
                player.createConnectionRequest(lobbyServer.get()).fireAndForget();
                player.sendMessage(Component.text("Connecting to lobby...", NamedTextColor.GREEN));
                logger.info("Player {} is connecting to lobby server", player.getUsername());
            } else {
                player.sendMessage(Component.text("Lobby server is offline!", NamedTextColor.RED));
                logger.warn("Player {} tried to connect to lobby server, but it's offline", player.getUsername());
            }
        }).exceptionally(throwable -> {
            player.sendMessage(Component.text("Failed to connect to lobby server!", NamedTextColor.RED));
            logger.error("Error connecting player {} to lobby server", player.getUsername(), throwable);
            return null;
        });
    }

    @Override
    public List<String> suggest(Invocation invocation) {
        return List.of(); // No tab completion needed for this command
    }

    @Override
    public boolean hasPermission(Invocation invocation) {
        return true; // Everyone can use this command
    }
}
