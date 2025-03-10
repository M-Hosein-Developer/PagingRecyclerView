plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "ir.androidcoder.pagingrecyclerviewlibrary"
    compileSdk = 35

    buildFeatures{
        viewBinding = true
    }

    defaultConfig {
        minSdk = 21

        group = "com.github.M-Hosein-Developer"
        version = "1.0.4"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    afterEvaluate {
        publishing {
            publications {
                create<MavenPublication>("release") {
                    from(components["release"])

                    groupId = "com.github.M-Hosein-Developer"
                    artifactId = "PagingRecyclerViewLib"
                    version = "1.0.3"
                }
            }

            repositories {
                maven {
                    url = uri("https://jitpack.io")
                }
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //paging
    implementation(libs.androidx.paging.runtime)

    //skeleton shimmer effect
    implementation(libs.koleton)
    implementation(libs.shimmer)

}