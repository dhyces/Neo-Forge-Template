ModsDotGroovy.make {
    modLoader = "javafml"
    loaderVersion = "[${(this.libs.versions.forge as String).split("\\.")[0]},)"

    license = this.buildProperties["mod_license"]
    issueTrackerUrl = this.buildProperties["mod_issues_url"]

    mod {
        modId = this.buildProperties["mod_id"]
        displayName = this.buildProperties["mod_name"]
        
        displayUrl =  this.buildProperties["mod_display_url"]

        version = this.version

        description = this.buildProperties["mod_description"]
        authors = (this.buildProperties["mod_authors"] as String).split(",")

        logoFile = "assets/${modId}/logo.png"

        dependencies {
            forge = "[${this.forgeVersion},)"
            minecraft = this.minecraftVersionRange
        }
    }
}