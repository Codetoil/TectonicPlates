import org.gradle.api.Project

val Project.mod: ModData get() = ModData(this)
fun Project.prop(key: String): String? = findProperty(key)?.toString()

val Project.common
	get() = requireNotNull(project(":common")) {
		"No common project for $project"
	}
val Project.commonMod get() = common.mod

val Project.loader: String? get() = prop("loader")

@JvmInline
value class ModData(private val project: Project) {
	val id: String get() = modProp("id")
	val name: String get() = modProp("name")
	val version: String get() = modProp("version")
	val group: String get() = modProp("group")
	val authors: String get() = modProp("authors")
	val description: String get() = modProp("description")
	val license: String get() = modProp("license")
	val credits: String get() = modProp("credits")
	val minecraft_version: String get() = prop("minecraft_version")

	fun propOrNull(key: String) = project.prop(key)
	fun prop(key: String) = requireNotNull(propOrNull(key)) { "Missing '$key'" }
	fun modPropOrNull(key: String) = project.prop("mod.$key")
	fun modProp(key: String) = requireNotNull(modPropOrNull(key)) { "Missing 'mod.$key'" }
	fun modrinth(name: String, version: String) = "maven.modrinth:$name:$version"
}