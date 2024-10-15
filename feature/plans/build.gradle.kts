plugins {
    alias(libs.plugins.gymsterMultiplatform)
    alias(libs.plugins.gymsterCompose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.data.plans)
            implementation(projects.core.ui)
        }
    }
}

android {
    namespace = "com.maruchin.gymster.feature.plans"
}
