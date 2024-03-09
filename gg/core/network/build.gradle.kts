plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.rachellima.network"
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

    implementation(Deps.appcompat)
    implementation(Deps.coreKtx)
    implementation(Deps.constraintLayout)
    implementation(Deps.material)

    implementation(Deps.retrofitLib)
    implementation(Deps.retrofitConverter)
    implementation(Deps.okHttp)
    implementation(Deps.interceptor)
    implementation(Deps.koinAndroid)
    implementation(Deps.koinCore)

    testImplementation(Deps.junit)
    androidTestImplementation(Deps.espressoCore)
    androidTestImplementation(Deps.extJUnit)
}