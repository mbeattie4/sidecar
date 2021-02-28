package com.quicksilver.sidecar.buildsrc

object Libraries {

    object Coroutines {
        private const val version = "1.4.1"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:1.5.0-beta01"

        object Compose {
            const val version = "1.0.0-beta01"
            const val animation = "androidx.compose.animation:animation:$version"
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val foundationLayout = "androidx.compose.foundation:foundation-layout:$version"
            const val material = "androidx.compose.material:material:$version"
            const val materialIconsExtended = "androidx.compose.material:material-icons-extended:$version"
            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val ui = "androidx.compose.ui:ui:$version"
            const val uiTooling = "androidx.compose.ui:ui-tooling:$version"
            const val uiUtil = "androidx.compose.ui:ui-util:$version"
            const val uiTest = "androidx.compose.ui:ui-test-junit4:$version"
        }

        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:1.3.0-alpha03"
        }

        object AppCompat {
            const val appCompat = "androidx.appcompat:appcompat:1.2.0"
        }

        object ConstraintLayout {
            const val constraintLayoutCompose = "androidx.constraintlayout:constraintlayout-compose:1.0.0-alpha03"
        }

        object Lifecycle {
            private const val version = "2.3.0"
            const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }

        object Navigation {
            const val navigationCompose = "androidx.navigation:navigation-compose:1.0.0-alpha08"
        }

        object Test {
            private const val version = "1.3.0"
            const val core = "androidx.test:core:$version"
            const val rules = "androidx.test:rules:$version"

            object Espresso {
                const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0"
            }

            object Ext {
                private const val version = "1.1.2"
                const val junit = "androidx.test.ext:junit:$version"
                const val junitKtx = "androidx.test.ext:junit-ktx:$version"
            }
        }
    }

    object Material {
        const val material = "com.google.android.material:material:1.3.0"
    }

    object Accompanist {
        private const val version = "0.6.1"
        const val coil = "dev.chrisbanes.accompanist:accompanist-coil:$version"
    }

    object JUnit {
        private const val version = "4.13.2"
        const val junit = "junit:junit:$version"
    }
}