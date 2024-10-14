plugins {
    alias(libs.plugins.gymsterMultiplatform)
    alias(libs.plugins.gymsterKoin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.database)
        }
    }
}

android {
    namespace = "com.maruchin.gymster.data.plans"
}
