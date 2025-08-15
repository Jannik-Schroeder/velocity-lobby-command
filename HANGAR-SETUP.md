# 🚀 PaperMC Hangar Integration Setup

## 📋 **Was wurde eingerichtet:**

✅ **`gradle.properties`** - Platform-Versionen für Hangar
✅ **`build.gradle.kts`** - Hangar Publish Plugin Integration
✅ **`.github/workflows/publish.yml`** - Auto-Publishing Workflow
✅ **README.md** - Hangar-Informationen hinzugefügt

## 🔑 **Schritt 1: Hangar API Token erstellen**

1. **Gehe zu [Hangar](https://hangar.papermc.io/)**
2. **Logge dich ein** mit deinem GitHub Account
3. **Klicke auf dein Profil** (oben rechts)
4. **Wähle "Api keys"** aus dem Menü
5. **Erstelle einen neuen API Key:**
   - ✅ **create_version** Permission aktivieren
   - **Name:** `velocity-lobby-command-github`
   - **Beschreibung:** `GitHub Actions Auto-Publishing`
6. **Kopiere den API Token** (wird nur einmal angezeigt!)

## 🔐 **Schritt 2: GitHub Repository Secret hinzufügen**

1. **Gehe zu deinem GitHub Repository**
2. **Klicke auf "Settings"**
3. **Wähle "Secrets and variables" → "Actions"**
4. **Klicke "New repository secret"**
5. **Fülle aus:**
   - **Name:** `HANGAR_API_TOKEN`
   - **Secret:** `[Dein Hangar API Token]`
6. **Klicke "Add secret"**

## 📁 **Schritt 3: Snapshot Channel auf Hangar erstellen**

1. **Gehe zu [Hangar](https://hangar.papermc.io/)**
2. **Erstelle ein neues Projekt:**
   - **Name:** `velocity-lobby-command`
   - **Beschreibung:** `A Velocity plugin that provides lobby teleportation commands`
   - **Kategorie:** `Proxy`
   - **Tags:** `velocity`, `lobby`, `teleport`, `proxy`
3. **Gehe zu "Channels"**
4. **Erstelle einen "Snapshot" Channel:**
   - **Name:** `Snapshot`
   - **Beschreibung:** `Development builds and snapshots`
   - **Farbe:** `#FF6B6B` (oder eine andere Farbe)

## 🧪 **Schritt 4: Testen der Integration**

### **Lokal testen:**
```bash
# Build und Publish testen (ohne zu veröffentlichen)
./gradlew build

# Shadow JAR erstellen
./gradlew shadowJar

# Dependency Tree anzeigen
./gradlew dependencies
```

### **GitHub Actions testen:**
1. **Push einen Commit** zu deinem main Branch
2. **Gehe zu Actions** in deinem Repository
3. **Überprüfe den "Publish to Hangar" Workflow**
4. **Schau auf Hangar** ob dein Plugin erscheint

## 📦 **Schritt 5: Plugin auf Hangar veröffentlichen**

### **Automatisch (empfohlen):**
- **Jeder Commit** zum main Branch wird automatisch veröffentlicht
- **Snapshot Channel** für alle Builds
- **Release Channel** für stabile Versionen

### **Manuell:**
```bash
# Plugin manuell veröffentlichen
./gradlew publishPluginPublicationToHangar

# Oder mit Stacktrace bei Fehlern
./gradlew publishPluginPublicationToHangar --stacktrace
```

## ⚙️ **Konfiguration anpassen:**

### **Platform-Versionen ändern:**
```properties
# In gradle.properties
velocityVersion=3.4.0, 3.5.0, 3.6.0
paperVersion=1.19-1.20.4, 1.21.0
```

### **Channels ändern:**
```kotlin
// In build.gradle.kts
channel.set("Alpha") // Statt "Snapshot"
```

### **Abhängigkeiten hinzufügen:**
```kotlin
// In build.gradle.kts
dependencies {
    hangar("Maintenance") {
        required.set(false)
    }
    url("Velocity API", "https://github.com/PaperMC/Velocity") {
        required.set(true)
    }
}
```

## 🎯 **Nächste Schritte:**

1. **Hangar API Token erstellen** ✅
2. **GitHub Secret hinzufügen** ✅
3. **Hangar Projekt erstellen** ✅
4. **Snapshot Channel erstellen** ✅
5. **Testen mit einem Commit** 🚀
6. **Plugin auf Hangar veröffentlichen** 🎉

## 🔍 **Troubleshooting:**

### **Fehler: "HANGAR_API_TOKEN not found"**
- Überprüfe den Repository Secret Namen
- Stelle sicher, dass der Secret korrekt gesetzt ist

### **Fehler: "Project not found"**
- Überprüfe die Projekt-ID in `build.gradle.kts`
- Stelle sicher, dass das Projekt auf Hangar existiert

### **Fehler: "Channel not found"**
- Erstelle den Snapshot Channel auf Hangar
- Überprüfe den Channel-Namen in `build.gradle.kts`

### **Build schlägt fehl:**
- Überprüfe die Java-Version (17+)
- Stelle sicher, dass alle Dependencies korrekt sind

## 🎉 **Fertig!**

**Dein Plugin wird jetzt automatisch auf PaperMC Hangar veröffentlicht!**

- **Jeder Commit** → Auto-Publish auf Hangar
- **Snapshot Channel** → Entwicklung Builds
- **Velocity Support** → Vollständige Kompatibilität
- **GitHub Integration** → Nahtlose Workflows

**Viel Erfolg mit deinem Plugin!** 🚀
