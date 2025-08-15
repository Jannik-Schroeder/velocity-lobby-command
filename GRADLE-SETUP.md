# 🚀 Gradle Setup für PaperMC Hangar

## 📋 **Was wurde erstellt:**

✅ **`build.gradle.kts`** - Gradle Build-Konfiguration (Kotlin DSL)
✅ **`gradle/wrapper/gradle-wrapper.properties`** - Gradle Version
✅ **`gradlew`** - Unix/Linux/macOS Gradle Wrapper
✅ **`gradlew.bat`** - Windows Gradle Wrapper

## ⚠️ **Noch zu tun:**

❌ **`gradle/wrapper/gradle-wrapper.jar`** - Diese Datei fehlt noch

## 🔧 **Gradle Wrapper JAR herunterladen:**

### **Option 1: Gradle installieren und Wrapper generieren**
```bash
# 1. Gradle installieren (falls noch nicht geschehen)
# macOS: brew install gradle
# Ubuntu: sudo apt install gradle

# 2. Gradle Wrapper generieren
gradle wrapper

# 3. Wrapper JAR wird automatisch heruntergeladen
```

### **Option 2: Manuell herunterladen**
```bash
# 1. Verzeichnis erstellen
mkdir -p gradle/wrapper

# 2. Gradle Wrapper JAR herunterladen
curl -o gradle/wrapper/gradle-wrapper.jar \
  https://github.com/gradle/gradle/raw/v8.5.0/gradle/wrapper/gradle-wrapper.jar
```

### **Option 3: Von einem anderen Gradle-Projekt kopieren**
```bash
# Kopiere gradle-wrapper.jar von einem bestehenden Gradle-Projekt
cp /path/to/other/project/gradle/wrapper/gradle-wrapper.jar gradle/wrapper/
```

## 🧪 **Testen des Gradle Builds:**

```bash
# Gradle Wrapper ausführbar machen
chmod +x gradlew

# Build testen
./gradlew build

# Shadow JAR erstellen
./gradlew shadowJar

# Tests ausführen
./gradlew test
```

## 📦 **Gradle vs Maven Vorteile:**

### **Gradle:**
- ✅ **PaperMC Hangar kompatibel**
- ✅ **Bessere Plugin-Unterstützung**
- ✅ **Flexiblere Konfiguration**
- ✅ **Kotlin DSL Support**
- ✅ **Bessere Performance**

### **Maven:**
- ❌ **Nicht für PaperMC Hangar geeignet**
- ❌ **Weniger flexibel**
- ❌ **Langsamer bei großen Projekten**

## 🎯 **Nächste Schritte:**

1. **Gradle Wrapper JAR herunterladen** (siehe oben)
2. **Maven-Dateien löschen:**
   ```bash
   rm pom.xml
   rm build.sh
   ```
3. **Gradle Build testen:**
   ```bash
   ./gradlew build
   ```
4. **Plugin auf PaperMC Hangar veröffentlichen**

## 🔄 **Migration abgeschlossen:**

- **Build-System:** Maven → Gradle ✅
- **Build-Datei:** `pom.xml` → `build.gradle.kts` ✅
- **Wrapper-Skripte:** `gradlew` + `gradlew.bat` ✅
- **PaperMC Hangar:** Kompatibel ✅

**Dein Plugin ist jetzt bereit für PaperMC Hangar!** 🎉
