# AntiFlood

[![Modrinth Download](https://img.shields.io/badge/Download-Modrinth-245315?style=for-the-badge&logo=modrinth&logoColor=white)](https://modrinth.com/plugin/antiflood)

**AntiFlood** is a lightweight Minecraft server plugin designed to prevent server griefing and lag caused by flood machines using pistons and waterlogged blocks.

---

## 🔗 Download

Download the latest version on [Modrinth](https://modrinth.com/plugin/antiflood).

---

## ⚡ Features

- **Piston Flood Machine Prevention:** Stops pistons from pushing or pulling waterlogged blocks.
- **Waterlogged Piston Protection:** Prevents pistons from operating if the piston block itself is waterlogged.
- **Zero Configuration Required:** Simply drop the JAR into your plugins folder and restart your server.
- **Lightweight & Efficient:** Hooks into native Bukkit event priority with minimal performance overhead.

---

## 🛠️ Requirements & Compatibility

One universal jar works on every platform:

| Platform | Support |
|----------|---------|
| Spigot / Paper / Purpur | Minecraft 1.16+, Java 8+ |
| Folia | Supported |
| Fabric | Minecraft 26.1+, Java 25 (Fabric API not required) |
| NeoForge | Minecraft 26.1+, Java 25 |

## 🔨 Building

`./gradlew assemble` produces `build/libs/AntiFlood-<version>.jar` (requires JDK 25).

---

## 📥 Installation

1. Download the plugin from [Modrinth](https://modrinth.com/plugin/antiflood).
2. Place the `.jar` file into `plugins/` (Spigot/Paper/Purpur/Folia) or `mods/` (Fabric/NeoForge).
3. Restart or reload your Minecraft server.

---

## 👤 Author

Developed by **UsainSrht**.
