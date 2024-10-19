plugins {
    alias(libs.plugins.gymsterMultiplatform)
    alias(libs.plugins.gymsterCompose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.data.trainings)
            implementation(projects.core.utils)
            implementation(projects.core.ui)
        }
    }
}

android {
    namespace = "com.maruchin.gymster.feature.trainings"
}
