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
    implementation(project(Modules.ggCoreModels))
    implementation(project(Modules.ggCoreNetwork))
    implementation(project(Modules.ggCoreRepository))
    implementation(project(Modules.ggCoreCommon))
    implementation(project(Modules.ggCoreUiComponent))

    implementation(Deps.appcompat)
    implementation(Deps.coreKtx)
    implementation(Deps.constraintLayout)
    implementation(Deps.material)
    implementation(Deps.navigationRuntimeKtx)
    implementation(Deps.navigationUiKtx)
    implementation(Deps.navigationFragment)
    implementation(Deps.koinCore)
    implementation(Deps.koinAndroid)
    implementation(Deps.coil)

    //test libs
    testImplementation(Deps.junit)

    androidTestImplementation(Deps.espressoCore)
    androidTestImplementation(Deps.extJUnit)
}