plugins {
    alias(libs.plugins.gymsterMultiplatform)
    alias(libs.plugins.gymsterKoin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.data.plans)
            implementation(projects.core.database)
            implementation(projects.core.utils)
        }
    }
}

android {
    namespace = "com.maruchin.gymster.data.trainings"
}
