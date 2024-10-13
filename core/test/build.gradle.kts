plugins {
    alias(libs.plugins.gymsterMultiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.kotlin.test)
            api(libs.kotlinx.coroutines.test)
            api(libs.koin.test)
            api(libs.turbine)
        }
    }
}

android {
    namespace = "com.maruchin.gymster.core.test"
    compileSdk = 34
}
