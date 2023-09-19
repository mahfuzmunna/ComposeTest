plugins {
    id(Plugins.pluginAndroid)
    id(Plugins.kotlinAndroid)
}

android {
    namespace = AppConfig.namespace
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.testInstrumentRunner
        vectorDrawables {
            useSupportLibrary = AppConfig.useSupportLibrary
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = AppConfig.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile(Constants.PROGUARD_ANDROID_OPTIMIZE),
                Constants.PROGUARD_RULES
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Versions.jvmTarget
    }
    buildFeatures {
        compose = AppConfig.compose
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
    packaging {
        resources {
            excludes += AppConfig.excludes
        }
    }
}

dependencies {

    implementation(Deps.coreKtx)
    implementation(Deps.runtimeKtx)
    implementation(Deps.activityCompose)
    implementation(platform(Deps.composeBom))
    implementation(Deps.composeUi)
    implementation(Deps.uiGraphics)
    implementation(Deps.toolingPreview)
    implementation(Deps.material3)

    testImplementation(Deps.junit)

    androidTestImplementation(Deps.junitExt)
    androidTestImplementation(Deps.expressoCore)
    androidTestImplementation(platform(Deps.composeBom))
    androidTestImplementation(Deps.junit4)

    debugImplementation(Deps.uiTooling)
    debugImplementation(Deps.testManifest)
}