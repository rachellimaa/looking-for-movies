plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.rachellima.listmovies"
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
    implementation(project(":gg:data:movies"))
    implementation(project(":gg:core:models"))
    implementation(project(":gg:core:network"))

    implementation(Deps.appcompat)
    implementation(Deps.coreKtx)
    implementation(Deps.constraintLayout)
    implementation(Deps.material)
    implementation(Nav.navigationRuntimeKtx)
    implementation(Nav.navigationUiKtx)
    implementation(Nav.navigationFragment)
    implementation(Koin.koinCore)
    implementation(Koin.koinAndroid)
    //test libs
    testImplementation(Deps.junit)

    androidTestImplementation(Deps.espressoCore)
    androidTestImplementation(Deps.extJUnit)
}