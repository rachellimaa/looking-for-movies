object Deps {
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val coil = "io.coil-kt:coil:${Versions.coil}"
    const val junit = "junit:junit:${Versions.junit}"
    const val koinCore = "io.insert-koin:koin-core:${Versions.koin}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.archNavigation}"
    const val navigationRuntimeKtx = "androidx.navigation:navigation-runtime-ktx:${Versions.archNavigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.archNavigation}"
    const val retrofitLib = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
}

object Modules {
    const val ggCoreModels = ":gg:core:models"
    const val ggCoreNetwork = ":gg:core:network"
    const val ggCoreRepository = ":gg:core:repository"
    const val ggFeatureListMovies = ":gg:feature:listmovies"
}