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
    implementation(Deps.kotlinStdLib)
    implementation(Deps.coreKtx)
    implementation(Deps.appcompat)
    implementation(Deps.constraintLayout)
    implementation(Deps.material)
    implementation(Deps.koinAndroid)
    implementation(Deps.koinCore)
    implementation(Deps.navigationRuntimeKtx)
    implementation(Deps.navigationUiKtx)
    implementation(Deps.navigationFragment)
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.extJUnit)
    androidTestImplementation(Deps.espressoCore)
}