plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.rachellima.repository"
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
    implementation(project(Modules.ggCoreModels))
    implementation(project(Modules.ggCoreNetwork))

    implementation(Deps.koinAndroid)
    implementation(Deps.koinCore)
    implementation(Deps.coroutinesCore)
    implementation(Deps.coroutines)
    implementation(Deps.retrofitLib)
    implementation(Deps.retrofitConverter)

    testImplementation(Deps.junit)

    androidTestImplementation(Deps.espressoCore)
    androidTestImplementation(Deps.extJUnit)
}