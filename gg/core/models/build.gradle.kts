plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.rachellima.models"
    compileSdk = AppConfig.compileSdk

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(Deps.retrofitConverter)
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.junit)
    androidTestImplementation(Deps.espressoCore)
}