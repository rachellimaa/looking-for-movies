plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.rachellima.gg"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(AppDependencies.appLibraries)
    implementation(Koin.koinAndroid)
    implementation(Koin.koinCore)
    implementation(Nav.navigationRuntimeKtx)
    implementation(Nav.navigationUiKtx)
    implementation(Nav.navigationFragment)

    testImplementation(AppDependencies.junit)
    androidTestImplementation(AppDependencies.androidTestLibraries)
}