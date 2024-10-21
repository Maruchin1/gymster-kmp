plugins {
    alias(libs.plugins.gymsterMultiplatform)
    alias(libs.plugins.gymsterCompose)
}

android {
    namespace = "com.maruchin.gymster.core.ui"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.utils)
        }
    }
}
