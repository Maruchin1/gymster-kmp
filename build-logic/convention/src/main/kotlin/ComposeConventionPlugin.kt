import com.maruchin.gymster.buildlogic.compose
import com.maruchin.gymster.buildlogic.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class ComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        apply(plugin = "org.jetbrains.compose")
        apply(plugin = "org.jetbrains.kotlin.plugin.compose")
        apply(plugin = "org.jetbrains.kotlin.plugin.serialization")

        configure<KotlinMultiplatformExtension> {
            with(sourceSets) {
                commonMain.dependencies {
                    implementation(compose.runtime)
                    implementation(compose.foundation)
                    implementation(compose.material3)
                    implementation(compose.materialIconsExtended)
                    implementation(compose.ui)
                    implementation(compose.components.resources)
                    implementation(compose.components.uiToolingPreview)
                    implementation(libs.findLibrary("kotlinx-serialization").get())
                    implementation(libs.findLibrary("androidx-navigation-compose").get())
                    implementation(libs.findLibrary("androidx-lifecycle-viewmodel").get())
                    implementation(libs.findLibrary("androidx-lifecycle-runtime-compose").get())
                    implementation(libs.findLibrary("koin-compose").get())
                    implementation(libs.findLibrary("koin-compose-viewmodel").get())
                    implementation(libs.findLibrary("koin-compose-viewmodel-navigation").get())
                }
                androidMain.dependencies {
                    implementation(compose.preview)
                    implementation(libs.findLibrary("androidx-activity-compose").get())
                }
            }
        }
        dependencies {
            add("debugImplementation", compose.uiTooling)
        }
    }
}
