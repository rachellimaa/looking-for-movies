plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.rachellima.uicomponents"
    compileSdk = AppConfig.compileSdk

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(Deps.appcompat)
    implementation(Deps.coreKtx)
    implementation(Deps.constraintLayout)
    implementation(Deps.material)
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.junit)
    androidTestImplementation(Deps.espressoCore)
}