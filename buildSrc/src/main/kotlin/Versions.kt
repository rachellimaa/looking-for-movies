object Versions {
    //app level
    const val kotlin = "1.9.10"
    const val application = "8.2.0"

    //libs
    const val coreKtx = "1.12.0"
    const val appcompat = "1.6.1"
    const val constraintLayout = "2.1.4"
    const val material = "1.11.0"

    //test
    const val junit = "4.13.2"
    const val extJunit = "1.1.5"
    const val espresso = "3.5.1"

    const val koin = "3.5.0"
    const val retrofit = "2.9.0"
    const val okHttp = "4.12.0"
    const val coroutinesVersion = "1.5.1"
    const val archNavigation = "2.7.7"
    const val fragmentKtx = "1.3.1"
}

object Deps{
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val material = "com.google.android.material:material:${Versions.material}"

    //test libs
    const val junit = "junit:junit:${Versions.junit}"
    const val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

object Koin {
    const val koinCore = "io.insert-koin:koin-core:${Versions.koin}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"
}

object Nav{
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.archNavigation}"
    const val navigationRuntimeKtx = "androidx.navigation:navigation-runtime-ktx:${Versions.archNavigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.archNavigation}"
}

object Retrofit {
    const val retrofitLib = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

}

object Coroutines {
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
}

