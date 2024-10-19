plugins {
    alias(libs.plugins.gymsterMultiplatform)
    alias(libs.plugins.gymsterCompose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.data.plans)
            implementation(projects.data.trainings)
            implementation(projects.core.ui)
            implementation(projects.core.utils)
        }
    }
}

android {
    namespace = "com.maruchin.gymster.feature.home"
}
