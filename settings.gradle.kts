pluginManagement {
	repositories {
		gradlePluginPortal()
		mavenCentral()
		maven("https://maven.quiltmc.org/repository/release/") { name = "QuiltMC" }
		maven("https://maven.fabricmc.net/") { name = "FabricMC" }
		maven("https://maven.neoforged.net/releases") { name = "NeoForge" }
		maven("https://maven.minecraftforge.net") { name = "MinecraftForge" }
	}
}

plugins {
	id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "Tectonic Plates"

include("common")
include("fabricmc")
include("minecraftforge")
include("neoforge")