plugins {
	multiloader
	id("net.neoforged.moddev")
}

repositories {
	mavenCentral()
	maven("https://maven.fabricmc.net/") { name = "FabricMC" }
}

val commonJava: Configuration by configurations.creating {
	isCanBeResolved = true
}
val commonResources: Configuration by configurations.creating {
	isCanBeResolved = true
}

neoForge {
	enable {
		version = commonMod.prop("neoforge_version")
	}
}

dependencies {
	compileOnly(project(":common"))
	commonJava(project(":common", "commonJava"))
	commonResources(project(":common", "commonResources"))
	commonJava(project(":common", "commonClientJava"))
	commonResources(project(":common", "commonClientResources"))
}

neoForge {
	val at = common.file("src/main/resources/META-INF/accesstransformer.cfg");

	accessTransformers.from(at.absolutePath)
	validateAccessTransformers = true

	runs {
		register("client") {
			client()
			ideName = "NeoForge Client (${project.path})"
		}
		register("clientData") {
			clientData()
			ideName = "NeoForge Client Data (${project.path})"
		}
		register("serverData") {
			serverData()
			ideName = "NeoForge Server Data (${project.path})"
		}
		register("server") {
			server()
			ideName = "NeoForge Server (${project.path})"
		}
	}

	mods {
		register(commonMod.id) {
			sourceSet(sourceSets.main.get())
		}
	}
}

sourceSets.main {
	resources.srcDir("src/generated/resources")
}

tasks {
	compileJava {
		dependsOn(commonJava)
		source(commonJava)
	}

	processResources {
		dependsOn(commonResources)
		from(commonResources)
	}
}