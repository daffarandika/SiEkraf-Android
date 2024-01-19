// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0" apply false
    id("com.android.library") version "8.0.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.10"
    id("com.google.dagger.hilt.android") version "2.50" apply false // make sure this and the one in module level are the same version
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}