plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.services)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.dagger.hilt)
}

android {
    namespace = "com.jahez"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.jahez"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "v1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            applicationIdSuffix = ".debug"
        }

        create("qa") {
            initWith(getByName("release"))
            isDebuggable = true
            versionNameSuffix = ".qa"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    projects()
    jetpackLibs()
    androidX()
    kotlinx()
    implementation(libs.bundles.coil.bundle)
    //implementation(libs.bundles.firebase.bundle)
    androidXtest()
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}

fun DependencyHandlerScope.projects() {
    implementation(project(":ui"))
    implementation(project(":core"))
    implementation(project(":feature:home"))
    implementation(project(":feature:product_details"))
    implementation(project(":feature:merchant-menu"))
    implementation(project(":feature:basket"))
    implementation(project(":navigation"))
}

fun DependencyHandlerScope.androidXtest() {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
}

fun DependencyHandlerScope.androidX() {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.hilt.navigation.compose)
}

fun DependencyHandlerScope.jetpackLibs() {
    // hilt
    implementation(libs.hilt.android)
    implementation(libs.hilt.viewmodel.compose)
    kapt(libs.hilt.android.compiler)

    // room
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    annotationProcessor(libs.room.compiler)
}

fun DependencyHandlerScope.kotlinx() {
    implementation(libs.android.coroutine)
}
// Allow references to generated code
kapt {
    correctErrorTypes = true
}