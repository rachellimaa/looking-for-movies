plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.rachellima.data.movies"
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
    implementation(project(":gg:core:network"))
    implementation(project(":gg:core:models"))

    implementation(Deps.coreKtx)
    implementation(Deps.constraintLayout)
    implementation(Koin.koinAndroid)
    implementation(Koin.koinCore)
    implementation(Coroutines.coroutinesCore)
    implementation(Coroutines.coroutines)
    implementation(Retrofit.retrofitLib)
    implementation(Retrofit.retrofitConverter)

    testImplementation(Deps.junit)

    androidTestImplementation(Deps.espressoCore)
    androidTestImplementation(Deps.extJUnit)
}