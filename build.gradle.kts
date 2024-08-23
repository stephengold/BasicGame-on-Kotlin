// Gradle script to build the BasicGame-on-Kotlin project

plugins {
    alias(libs.plugins.kotlin.jvm)
    application // to build JVM applications
}

application {
    mainClass = "mygame.MainKt"
}

configurations.all {
    resolutionStrategy.cacheChangingModulesFor(0, "seconds") // to disable caching of snapshots
}

dependencies {
    // You can read more about how to add dependencies here:
    // https://docs.gradle.org/current/userguide/dependency_management.html#declaring-dependencies

    // from mavenCentral (or mavenLocal) repositories:
    implementation(libs.jme3.core)
    implementation(libs.jme3.desktop)
    //implementation(libs.jme3.effects)
    //implementation(libs.jme3.networking)
    //implementation(libs.jme3.niftygui)
    //implementation(libs.jme3.terrain)
    //runtimeOnly(libs.jme3.awt.dialogs) // only for JMonkeyEngine v3.6 or later!

    // select one version of LWJGL (from mavenCentral or mavenLocal)
    //runtimeOnly(libs.jme3.lwjgl) // LWJGL 2.x
    runtimeOnly(libs.jme3.lwjgl3) // LWJGL 3.x

    // BasicGame doesn't use physics. If your game needs physics, select one of:
    //    1. Minie
    //implementation(libs.minie)
    // OR
    //    2. jme3-jbullet
    //implementation(libs.jme3.jbullet)
    // OR
    //    3. KK Physics
    //implementation(libs.kk.physics)
    //runtimeOnly(variantOf(libs.jolt.jni.linux64){ classifier("ReleaseSp") })
    //runtimeOnly(variantOf(libs.jolt.jni.linuxarm32hf){ classifier("ReleaseSp") })
    //runtimeOnly(variantOf(libs.jolt.jni.linuxarm64){ classifier("ReleaseSp") })
    //runtimeOnly(variantOf(libs.jolt.jni.macosx64){ classifier("ReleaseSp") })
    //runtimeOnly(variantOf(libs.jolt.jni.macosxarm64){ classifier("ReleaseSp") })
    //runtimeOnly(variantOf(libs.jolt.jni.windows64){ classifier("ReleaseSp") })

    // BasicGame doesn't use jme3-jogg nor jme3-plugins
    //  -- they are included solely to avoid warnings from AssetConfig.
    runtimeOnly(libs.jme3.jogg)
    runtimeOnly(libs.jme3.plugins)

    // libraries related to the Lemur GUI and Groovy:
    //implementation(libs.lemur)
    //implementation(libs.lemur.props)
    //implementation(libs.lemur.proto)
    //runtimeOnly(libs.groovy.jsr223)

    // other add-on libraries:
    //implementation(libs.blocks)
    //implementation(libs.heart)
    //implementation(libs.jmePower)
    //implementation(libs.sim.math)
    //implementation(libs.skyControl)
    //runtimeOnly(libs.jme3.testdata)
}

// Register cleanup tasks:

tasks.named("clean") {
    dependsOn("cleanDLLs", "cleanDyLibs", "cleanLogs", "cleanSOs")
}

tasks.register<Delete>("cleanDLLs") { // extracted Windows native libraries
    delete(fileTree(".").matching {
        include("*.dll")
    })
}
tasks.register<Delete>("cleanDyLibs") { // extracted macOS native libraries
    delete(fileTree(".").matching {
        include("*.dylib")
    })
}
tasks.register<Delete>("cleanLogs") { // JVM crash logs
    delete(fileTree(".").matching {
        include("hs_err_pid*.log")
    })
}
tasks.register<Delete>("cleanSOs") { // extracted Linux/Android native libraries
    delete(fileTree(".").matching {
        include("*.so")
    })
}
