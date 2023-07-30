plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
//    id("com.google.gms.google-services")
//    id("com.google.firebase.crashlytics")
}

android {
    namespace = "com.dnd_9th_3_android.gooding"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.dnd_9th_3_android.gooding"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        named("release") {
            @Suppress("UnstableApiUsage")
            isMinifyEnabled = false
            setProguardFiles(listOf(
                @Suppress("UnstableApiUsage")
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
            )
        }
    }
    kapt.correctErrorTypes = true
    @Suppress("UnstableApiUsage")
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.activity:activity-ktx:1.7.2")
    implementation("androidx.fragment:fragment-ktx:1.6.0")
    implementation("androidx.recyclerview:recyclerview:1.3.0")
    implementation("androidx.annotation:annotation:1.6.0")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")

    // LiveData
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.6.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-process:2.6.1")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.14.2")
    kapt("com.github.bumptech.glide:compiler:4.14.2")

    // Retrofit2
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
    implementation("com.squareup.okhttp3:okhttp-urlconnection:4.9.1")

    implementation("com.google.code.gson:gson:2.9.0")

    implementation("com.google.android.play:core:1.10.3")

    // Paging
    implementation("androidx.paging:paging-runtime:3.2.0")

    // ExoPlayer
    implementation("com.google.android.exoplayer:exoplayer:2.19.0")
    implementation("com.google.android.exoplayer:exoplayer-core:2.19.0")
    implementation("com.google.android.exoplayer:exoplayer-dash:2.19.0")
    implementation("com.google.android.exoplayer:exoplayer-ui:2.19.0")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.45")
    kapt("com.google.dagger:hilt-compiler:2.45")

    // 구글 로그인 모듈
//    implementation ("com.google.android.gms:play-services-auth:20.6.0")
//
//    implementation(platform("com.google.firebase:firebase-bom:32.1.0"))
//    implementation ("com.google.firebase:firebase-analytics-ktx")
//    implementation ("com.google.firebase:firebase-crashlytics-ktx")
//    implementation ("com.google.firebase:firebase-messaging-ktx")
//    implementation ("com.google.firebase:firebase-auth-ktx")

    // 카카오 로그인 모듈
    implementation("com.kakao.sdk:v2-user:2.14.0")

    implementation("io.github.ParkSangGwon:tedkeyboardobserver:1.0.1")

    implementation("com.github.skydoves:elasticviews:2.1.0")

    // Sliding Up Panel
    implementation ("com.sothree.slidinguppanel:library:3.4.0")
}