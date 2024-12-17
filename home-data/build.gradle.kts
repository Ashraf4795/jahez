plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.jahez.home_data"
    compileSdk = 35

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}


dependencies {
    implementation(project(":data_model"))
    implementation(project(":core"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    implementation(libs.android.coroutine)

    implementation(libs.moshi)
    kapt(libs.moshi.codegen)

    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    kapt(libs.room.compiler)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.firestore)
    testImplementation(libs.kotlinx.coroutines.test) // Matches your coroutines version.

    // Optional: AndroidX Test extensions for JUnit
    testImplementation(libs.androidx.junit)
    testImplementation(libs.junit)
    testImplementation(libs.mockk)
    testImplementation(libs.strikt)
}