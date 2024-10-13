plugins {
    alias(libs.plugins.gymsterMultiplatform)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.kotlin)
            implementation(projects.core.ui)
        }
        commonTest.dependencies {
            implementation(projects.core.test)
        }
    }
}

android {
    namespace = "com.maruchin.gymster.feature.home"
    compileSdk = 34
}
