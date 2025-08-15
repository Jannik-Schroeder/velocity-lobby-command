plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("xyz.jpenilla.run-paper") version "2.2.2"
    id("io.papermc.hangar-publish-plugin") version "0.1.2"
}

group = "me.jsde"
version = "1.2.1"
description = "A Velocity plugin that provides a simple command for players to teleport to the lobby using /hub, /lobby, and /l commands"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
    compileOnly("com.velocitypowered:velocity-api:3.4.0-SNAPSHOT")
    
    // Test dependencies
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("org.mockito:mockito-core:5.7.0")
    testImplementation("org.mockito:mockito-junit-jupiter:5.7.0")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    sourceCompatibility = "17"
    targetCompatibility = "17"
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks {
    shadowJar {
        archiveClassifier.set("")
        archiveBaseName.set("velocity-lobby-command")
        archiveVersion.set(project.version.toString())
        
        // Relocate dependencies if needed
        // relocate("com.example", "me.jsde.velocitylobby.libs")
    }
    
    build {
        dependsOn(shadowJar)
    }
    
    // PaperMC specific tasks
    runServer {
        minecraftVersion("1.20.4")
    }
}

// Checkstyle configuration
tasks.register("checkstyle", JavaExec::class) {
    group = "verification"
    description = "Run Checkstyle on the source code"
    
    classpath = configurations.compileClasspath.get()
    mainClass.set("com.puppycrawl.tools.checkstyle.Main")
    
    args(
        "-c", "checkstyle.xml",
        "-r", "src/main/java"
    )
    
    // Only run if checkstyle.xml exists
    onlyIf { file("checkstyle.xml").exists() }
}

// Version management
tasks.register("updateVersion") {
    group = "versioning"
    description = "Update version in all files"
    
    doLast {
        val newVersion = project.version.toString()
        
        // Update Java files
        fileTree("src/main/java").matching { include("**/*.java") }.forEach { file ->
            file.writeText(
                file.readText()
                    .replace(Regex("version = \"[^\"]*\""), "version = \"$newVersion\"")
                    .replace(Regex("@Plugin\\([^)]*version = \"[^\"]*\"[^)]*\\)"), 
                           "@Plugin(version = \"$newVersion\"")
            )
        }
        
        // Update velocity-plugin.json
        val pluginJson = file("src/main/resources/velocity-plugin.json")
        if (pluginJson.exists()) {
            val content = pluginJson.readText()
            val updatedContent = content.replace(Regex("\"version\": \"[^\"]*\""), "\"version\": \"$newVersion\"")
            pluginJson.writeText(updatedContent)
        }
        
        println("✅ Version updated to $newVersion in all files")
    }
}

// Hangar Publish Configuration
hangarPublish {
    publications.register("plugin") {
        version.set(project.version as String)
        channel.set("Snapshot") // We're using the 'Snapshot' channel
        // TODO: Edit the project name to match your Hangar project
        id.set("velocity-lobby-command")
        apiKey.set(System.getenv("HANGAR_API_TOKEN") ?: "dummy-key-for-local-build")
        platforms {
            // Velocity platform support
            register(io.papermc.hangarpublishplugin.model.Platforms.VELOCITY) {
                // Use ShadowJar for the JAR file to upload
                jar.set(tasks.shadowJar.flatMap { it.archiveFile })

                // Set platform versions from gradle.properties file
                val versions: List<String> = (property("velocityVersion") as String)
                        .split(",")
                        .map { it.trim() }
                platformVersions.set(versions)

                // Configure your plugin dependencies, if any
                dependencies {
                    // Example for an external dependency
                    url("Velocity API", "https://github.com/PaperMC/Velocity") {
                        required.set(true)
                    }
                }
            }
        }
    }
}

// Ensure proper task dependencies
tasks.named("publishPluginPublicationToHangar") {
    dependsOn("shadowJar")
}
