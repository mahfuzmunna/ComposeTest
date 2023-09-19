object Deps {
    val composeBom by lazy { "androidx.compose:compose-bom:2023.03.00" }
    val coreKtx by lazy { "androidx.core:core-ktx:1.9.0" }
    val composeUi by lazy { "androidx.compose.ui:ui" }
    val uiGraphics by lazy { "androidx.compose.ui:ui-graphics" }
    val toolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview" }
    val material3 by lazy { "androidx.compose.material3:material3" }

    val activityCompose by lazy { "androidx.activity:activity-compose:1.7.2" }
    val runtimeKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:2.6.2" }

    //test
    val junit by lazy { "junit:junit:4.13.2" }
    val junitExt by lazy { "androidx.test.ext:junit:1.1.5" }
    val expressoCore by lazy { "androidx.test.espresso:espresso-core:3.5.1" }
    val junit4 by lazy { "androidx.compose.ui:ui-test-junit4" }

    val uiTooling by lazy { "androidx.compose.ui:ui-tooling" }
    val testManifest by lazy { "androidx.compose.ui:ui-test-manifest" }


}