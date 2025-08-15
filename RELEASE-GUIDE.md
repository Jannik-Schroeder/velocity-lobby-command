# Release Guide - Velocity Lobby Command

## 🚀 **Wie du ein Release erstellst:**

### **Methode 1: Git Tag (Empfohlen)**

```bash
# 1. Tag erstellen (OHNE v am Anfang!)
git tag 1.1.0

# 2. Tag pushen
git push origin 1.1.0

# 3. GitHub Actions starten automatisch
# 4. Release wird erstellt mit JAR-Download
```

### **Methode 2: Manuell über GitHub**

1. Gehe zu **Actions** → **Simple Release**
2. Klicke **"Run workflow"**
3. Gib Version ein (z.B. `1.1.0` - OHNE v!)
4. Klicke **"Run workflow"**

## ⚠️ **Wichtig:**

- **NICHT** `v1.1.0` (das erzeugt `vv1.1.0`)
- **Sondern** `1.1.0` (das erzeugt `v1.1.0`)

## 📦 **Was passiert:**

1. Plugin wird automatisch gebaut
2. Release wird erstellt
3. JAR-Datei wird hochgeladen
4. Benutzer können direkt herunterladen

## 🎯 **Ergebnis:**

- Release erscheint unter **Releases** Tab
- JAR-Datei ist direkt herunterladbar
- Vollständige Dokumentation im Release
- Keine doppelten `v` mehr!

## 🔧 **Workflows:**

- **`simple-release.yml`** - Erstellt Releases
- **`ci.yml`** - Überwacht Code-Qualität
- **`quality.yml`** - Code-Qualitätsprüfungen

Alle anderen problematischen Workflows wurden gelöscht! 🎉
