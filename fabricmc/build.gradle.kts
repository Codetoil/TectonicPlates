plugins {
	multiloader
	id("org.quiltmc.loom.no_remap")
}

val commonJava: Configuration by configurations.creating {
	isCanBeResolved = true
}
val commonResources: Configuration by configurations.creating {
	isCanBeResolved = true
}

val commonClientJava: Configuration by configurations.creating {
	isCanBeResolved = true
}
val commonClientResources: Configuration by configurations.creating {
	isCanBeResolved = true
}

repositories {
	maven("https://libraries.minecraft.net") { name = "Mojang" }
	mavenCentral()
	exclusiveContent {
		forRepositories(
			maven("https://maven.parchmentmc.org") { name = "ParchmentMC" }
		)
		filter { includeGroup("org.parchmentmc.data") }
	}
	maven("https://maven.quiltmc.org/repository/release/") { name = "QuiltMC" }
	maven("https://maven.fabricmc.net/") { name = "FabricMC" }

}

loom {
	accessWidenerPath = common.file("src/main/resources/${mod.id}.classtweaker")

	splitEnvironmentSourceSets()

	mods {
		create(commonMod.id) {
			sourceSet(sourceSets.main.get())
			sourceSet(sourceSets.named("client").get())
		}
	}

	runs {
		getByName("client") {
			client()
			configName = "Fabric Client"
			ideConfigGenerated(true)
		}
		getByName("server") {
			server()
			configName = "Fabric Server"
			ideConfigGenerated(true)
		}
	}
}

sourceSets {
	getByName("client") {
		compileClasspath += sourceSets["main"].output + configurations.getByName("compileClasspath")
		runtimeClasspath += sourceSets["main"].output + configurations.getByName("runtimeClasspath")
	}
}

dependencies {
	minecraft("com.mojang:minecraft:${commonMod.minecraft_version}")

	implementation("net.fabricmc:fabric-loader:${commonMod.prop("fabric_loader_version")}")
	implementation("net.fabricmc.fabric-api:fabric-api:${commonMod.prop("fabric_api_version")}")

	compileOnly(project(":common"))
	commonJava(project(":common", "commonJava"))
	commonResources(project(":common", "commonResources"))

	sourceSets.named("client") {
		commonClientJava(project(":common", "commonClientJava"))
		commonClientResources(project(":common", "commonClientResources"))
	}
}

fabricApi {
	configureDataGeneration()
	{
		modId = commonMod.id
	}
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

	getByName<JavaCompile>("compileClientJava") {
		dependsOn(commonJava, commonClientJava)
		source(commonJava, commonClientJava)
	}

	getByName<ProcessResources>("processClientResources") {
		dependsOn(commonResources, commonClientResources)
		from(commonResources, commonClientResources)
	}

	jar {
		duplicatesStrategy = DuplicatesStrategy.WARN
	}
}