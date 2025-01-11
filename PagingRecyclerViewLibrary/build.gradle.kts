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
        version = "1.0.1"

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
                    version = "1.0.1"
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
    implementation("androidx.paging:paging-runtime:3.3.2")

    //skeleton shimmer effect
    implementation("com.ericktijerou.koleton:koleton:1.0.0-beta01")
    implementation("com.facebook.shimmer:shimmer:0.5.0")

}