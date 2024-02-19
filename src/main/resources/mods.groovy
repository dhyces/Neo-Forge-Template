import modsdotgroovy.Dependency

ModsDotGroovy.make {
    modLoader = "javafml"
    loaderVersion = "[${libs.versions.fml.loader},)"

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
            neoforge = ">=${this.libs.versions.neoforge}"
            minecraft = this.minecraftVersionRange
        }

        dependencies = dependencies.collect { dep ->
            new Dependency() {
                @Override
                Map asForgeMap() {
                    def map = dep.asForgeMap()
                    def mandatory = map.mandatory
                    map.remove('mandatory')
                    map.put('type', mandatory ? 'required' : 'optional')
                    return map
                }
            }
        }
    }
}