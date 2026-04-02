plugins {
	id("java-library")
	id("idea")
}

version = "${loader}-${commonMod.version}+mc1.20.1"

base {
	archivesName = commonMod.id
}

java {
	toolchain.languageVersion = JavaLanguageVersion.of(common.prop("java.version")!!)
}

tasks {
	processResources {
		val multilined = listOf("mod_description", "jingling_journeys_license_statement")
		val expandProps = mapOf(
			"java_version" to commonMod.propOrNull("java.version"),
			"mod_version" to commonMod.version,
			"mod_group" to commonMod.group,
			"mod_name" to commonMod.name,
			"mod_authors" to commonMod.authors,
			"mod_id" to commonMod.id,
			"mod_license" to commonMod.license,
			"mod_description" to commonMod.description,
			"mod_credits" to commonMod.credits,
			"license_statement" to commonMod.prop("license_statement"),
			"minecraft_version" to commonMod.prop("minecraft_version"),
			"minecraft_version_minor" to commonMod.prop("minecraft_version_minor"),
			"fabric_api_version" to commonMod.propOrNull("fabric_api_version"),
			"fabric_loader_version" to commonMod.propOrNull("fabric_loader_version"),
			"minecraftforge_version" to commonMod.propOrNull("minecraftforge_version"),
			"minecraftforge_loader_version_range" to commonMod.propOrNull("minecraftforge_loader_version_range"),
			"minecraftforge_version_range" to commonMod.propOrNull("minecraftforge_version_range"),
			"minecraftforge_eventbus_validator_version" to
				commonMod.propOrNull("minecraftforge_eventbus_validator_version"),
			"neoforge_version" to commonMod.propOrNull("neoforge_version"),
			"neoforge_version_range" to commonMod.propOrNull("neoforge_version_range"),
			"neoforge_loader_version_range" to commonMod.propOrNull("neoforge_loader_version_range"),
		).filterValues { it?.isNotEmpty() == true }.mapValues { (_, v) -> v!! }

		val jsonExpandProps = expandProps.mapValues { (key, v) ->
			if (multilined.contains(key)) v else v.replace("\n", "\\\\n")
		} // Ensure description remains multilined

		filesMatching(listOf("META-INF/mods.toml", "META-INF/neoforge.mods.toml")) {
			expand(expandProps)
		}

		filesMatching(listOf("pack.mcmeta", "fabric.mod.json", "quilt.mod.json", "*.mixins.json")) {
			expand(jsonExpandProps)
		}

		inputs.properties(expandProps)
	}
}
