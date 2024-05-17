// Gradle script to build the BasicGame-on-Kotlin project

plugins {
    alias(libs.plugins.jvm)
    application // to build JVM applications
}

// select one version of JMonkeyEngine:
//val jme3Version = "3.1.0-stable" // from mavenCentral
//val jme3Version = "3.2.4-stable" // from mavenCentral
//val jme3Version = "3.3.2-stable" // from mavenCentral
//val jme3Version = "3.4.1-stable" // from mavenCentral
//val jme3Version = "3.5.2-stable" // from mavenCentral
val jme3Version = "3.6.1-stable" // from mavenCentral
//val jme3Version = "3.7.0-beta1" // from mavenCentral
//val jme3Version = "3.8.0-SNAPSHOT" // from mavenLocal or SonaType

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
    implementation("org.jmonkeyengine:jme3-core:" + jme3Version)
    implementation("org.jmonkeyengine:jme3-desktop:" + jme3Version)
    //implementation("org.jmonkeyengine:jme3-effects:" + jme3Version)
    //implementation("org.jmonkeyengine:jme3-networking:" + jme3Version)
    //implementation("org.jmonkeyengine:jme3-niftygui:" + jme3Version)
    implementation("org.jmonkeyengine:jme3-terrain:" + jme3Version)
    runtimeOnly("org.jmonkeyengine:jme3-testdata:" + jme3Version)
    //runtimeOnly("org.jmonkeyengine:jme3-awt-dialogs:" + jme3Version) // only for JMonkeyEngine v3.6 or later!

    // select one version of LWJGL (from mavenCentral or mavenLocal)
    //runtimeOnly("org.jmonkeyengine:jme3-lwjgl:" + jme3Version) // LWJGL 2.x
    runtimeOnly("org.jmonkeyengine:jme3-lwjgl3:" + jme3Version) // LWJGL 3.x

    // BasicGame doesn't use physics. If your game needs physics, select either:
    //    1. Minie
    //implementation("com.github.stephengold:Minie:8.1.0")
    // OR
    //    2. jme3-jbullet
    //implementation("org.jmonkeyengine:jme3-jbullet:" + jme3Version)

    // BasicGame doesn't use jme3-jogg nor jme3-plugins
    //  -- they are included solely to avoid warnings from AssetConfig.
    runtimeOnly("org.jmonkeyengine:jme3-jogg:" + jme3Version)
    runtimeOnly("org.jmonkeyengine:jme3-plugins:" + jme3Version)

    // libraries related to the Lemur GUI and Groovy:
    //implementation("com.simsilica:lemur:1.16.0")
    //implementation("com.simsilica:lemur-props:1.2.0")
    //implementation("com.simsilica:lemur-proto:1.13.0")
    //runtimeOnly("org.codehaus.groovy:groovy-jsr223:3.0.21")

    // other add-on libraries:
    //implementation("com.github.rvandoosselaer:Blocks:1.7.1")
    //implementation("com.github.stephengold:Heart:9.0.0")
    //implementation("com.github.stephengold:JmePower:1.1.1")
    //implementation("com.github.stephengold:SkyControl:1.0.5")
    //implementation("com.simsilica:sim-math:1.6.0")
    //runtimeOnly("org.jmonkeyengine:jme3-testdata:" + jme3Version)
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
