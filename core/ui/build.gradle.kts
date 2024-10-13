plugins {
    alias(libs.plugins.gymsterMultiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.jetbrainsCompose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(compose.runtime)
            api(compose.foundation)
            api(compose.material3)
            api(compose.materialIconsExtended)
            api(compose.ui)
            api(compose.components.resources)
            api(compose.components.uiToolingPreview)
            api(libs.androidx.navigation.compose)
            api(libs.androidx.lifecycle.viewmodel)
            api(libs.androidx.lifecycle.runtime.compose)
        }
        androidMain.dependencies {
            api(compose.preview)
            api(libs.androidx.activity.compose)
        }
    }
}

dependencies {
    debugApi(compose.uiTooling)
}

android {
    namespace = "com.maruchin.gymster.core.ui"
    compileSdk = 34
}
