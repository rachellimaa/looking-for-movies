plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.rachellima.lookingmovies"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.rachellima.lookingmovies"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
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

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(Modules.ggCoreModels))
    implementation(project(Modules.ggCoreNetwork))
    implementation(project(Modules.ggFeatureListMovies))
    implementation(project(Modules.ggCoreRepository))

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