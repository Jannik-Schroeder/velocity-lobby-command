package com.example.velocitylobby;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.proxy.server.RegisteredServer;
import org.slf4j.Logger;

import java.nio.file.Path;

@Plugin(
    id = "velocity-lobby-plugin",
    name = "Velocity Lobby Plugin",
    version = "1.0.0",
    description = "A Velocity plugin that allows players to teleport to the lobby using /hub, /lobby, and /l commands",
    authors = {"YourName"}
)
public class VelocityLobbyPlugin {

    private final ProxyServer server;
    private final Logger logger;
    private final Path dataDirectory;

    @Inject
    public VelocityLobbyPlugin(ProxyServer server, Logger logger, @DataDirectory Path dataDirectory) {
        this.server = server;
        this.logger = logger;
        this.dataDirectory = dataDirectory;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        logger.info("Velocity Lobby Plugin is starting up!");
        
        // Register commands
        registerCommands();
        
        logger.info("Velocity Lobby Plugin has been enabled!");
    }

    private void registerCommands() {
        // Register /hub command
        server.getCommandManager().register(
            server.getCommandManager().metaBuilder("hub")
                .aliases("lobby", "l")
                .build(),
            new LobbyCommand(server, logger)
        );
        
        // Register /lobby command
        server.getCommandManager().register(
            server.getCommandManager().metaBuilder("lobby")
                .aliases("hub", "l")
                .build(),
            new LobbyCommand(server, logger)
        );
        
        // Register /l command
        server.getCommandManager().register(
            server.getCommandManager().metaBuilder("l")
                .aliases("hub", "lobby")
                .build(),
            new LobbyCommand(server, logger)
        );
    }
}
