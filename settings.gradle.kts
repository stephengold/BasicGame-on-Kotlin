// global build settings for the BasicGame-on-Kotlin project

rootProject.name = "BasicGame-on-Kotlin"

dependencyResolutionManagement {
    repositories {
        //mavenLocal() // to find libraries installed locally
        //flatDir { dirs("lib") } // to find libraries in the project's "lib" directory
        mavenCentral() // to find libraries released to the Maven Central repository
        maven { url = uri("https://jitpack.io") } // to find the Blocks library
        maven {
            name = "Central Portal Snapshots"
            url = uri("https://central.sonatype.com/repository/maven-snapshots/")
        }
        //maven { url = uri("https://nifty-gui.sourceforge.net/nifty-maven-repo") }
        //google() // to find libraries released to Google's Maven Repository

        // Read more about repositories here:
        //   https://docs.gradle.org/current/userguide/dependency_management.html#sec:repositories
    }
}

// no subprojects
