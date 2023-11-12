plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.voicechanger"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.voicechanger"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        viewBinding.enable = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true

        ndk {
            abiFilters.addAll(listOf("armeabi-v7a","x86"))
//            abiFilters.add("armeabi-v7a")
//            abiFilters.add("x86")
//            abiFilters.add("arm64-v8a")
//            abiFilters.add("x86_64")
        }
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
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //множество запросов
    implementation ("androidx.multidex:multidex:2.0.1")
    implementation ("com.google.android.material:material:1.9.0")

    //получение разрешений
    implementation ("com.karumi:dexter:6.2.2")
    //удобный seekbar
    implementation ("com.github.warkiz.widget:indicatorseekbar:2.1.2")
    //добавление header and footer
    implementation ("in.srain.cube:grid-view-with-header-footer:1.0.12")

    //Navigation Component
    implementation ("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation ("androidx.navigation:navigation-ui-ktx:2.5.3")
}