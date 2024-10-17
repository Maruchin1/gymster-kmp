plugins {
    alias(libs.plugins.gymsterMultiplatform)
    alias(libs.plugins.gymsterKoin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.androidx.datastore)
        }
    }
}

android {
    namespace = "com.maruchin.gymster.core.preferences"
}
