buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:8.6")
        classpath("com.google.gms:google-services:4.4.1")
    }
}
allprojects {
    repositories {
        google()
        mavenCentral()
        maven{
        }
    }
}