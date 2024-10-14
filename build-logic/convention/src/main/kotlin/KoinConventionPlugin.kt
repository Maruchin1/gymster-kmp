import com.maruchin.gymster.buildlogic.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KoinConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        configure<KotlinMultiplatformExtension> {
            with(sourceSets) {
                commonMain.dependencies {
                    implementation(libs.findLibrary("koin-core").get())
                }
                commonTest.dependencies {
                    implementation(libs.findLibrary("koin-test").get())
                }
            }
        }
    }
}
