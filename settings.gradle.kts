// global settings for the BasicGame-on-Kotlin project

rootProject.name = "BasicGame-on-Kotlin"

dependencyResolutionManagement {
    repositories {
        //mavenLocal() // to find libraries installed locally
        //flatDir { dirs("lib") } // to find libraries in the project's "lib" directory
        mavenCentral()
        maven { url = uri("https://jitpack.io") } // to find the Blocks library
        //maven { url = uri("https://s01.oss.sonatype.org/content/groups/staging") } // to find libraries staged but not yet released
        //maven { url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots") } // to find public snapshots of libraries
        //maven { url = uri("https://nifty-gui.sourceforge.net/nifty-maven-repo") }
        //google()

        // Read more about repositories here:
        //   https://docs.gradle.org/current/userguide/dependency_management.html#sec:repositories
    }
}
