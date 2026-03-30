plugins {
	id("multiloader")
	id("org.quiltmc.loom.no_remap")
}

repositories {
	maven("https://libraries.minecraft.net") { name = "Mojang" }
	mavenCentral()
	maven("https://maven.quiltmc.org/repository/release/") { name = "QuiltMC" }
	maven("https://maven.fabricmc.net/") { name = "FabricMC" }
}

loom {
	accessWidenerPath = common.file("src/main/resources/${mod.id}.classtweaker")

	splitEnvironmentSourceSets()

	mods {
		create("jingling_journeys") {
			sourceSet(sourceSets.main.get())
			sourceSet(sourceSets.named("client").get())
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
}

val commonJava: Configuration by configurations.creating {
	isCanBeResolved = false
	isCanBeConsumed = true
}

val commonResources: Configuration by configurations.creating {
	isCanBeResolved = false
	isCanBeConsumed = true
}

val commonClientJava: Configuration by configurations.creating {
	isCanBeResolved = false
	isCanBeConsumed = true
}

val commonClientResources: Configuration by configurations.creating {
	isCanBeResolved = false
	isCanBeConsumed = true
}

artifacts {
	afterEvaluate {
		val mainSourceSet = sourceSets.main.get()
		mainSourceSet.java.sourceDirectories.files.forEach {
			add(commonJava.name, it)
		}
		mainSourceSet.resources.sourceDirectories.files.forEach {
			add(commonResources.name, it)
		}
		val clientSourceSet = sourceSets.named("client").get()
		clientSourceSet.java.sourceDirectories.files.forEach {
			add(commonClientJava.name, it)
		}
		clientSourceSet.resources.sourceDirectories.files.forEach {
			add(commonClientResources.name, it)
		}
	}
}