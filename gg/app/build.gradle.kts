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
    implementation(project(":gg:core:models"))
    implementation(project(":gg:core:network"))
    implementation(project(":gg:feature:listmovies"))
    implementation(project(":gg:data:movies"))

    implementation(AppDependencies.appLibraries)
    implementation(Koin.koinAndroid)
    implementation(Koin.koinCore)
    implementation(Nav.navigationRuntimeKtx)
    implementation(Nav.navigationUiKtx)
    implementation(Nav.navigationFragment)

    //test libs
    testImplementation(AppDependencies.junit)
    androidTestImplementation(AppDependencies.androidTestLibraries)
}