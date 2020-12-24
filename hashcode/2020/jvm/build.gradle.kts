plugins {
    java
    kotlin("jvm") version "1.4.21"
}

group = "org.club-code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://jitpack.io")
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.github.club-code:library-kotlin:master-SNAPSHOT")

    testImplementation("junit", "junit", "4.12")
    testImplementation(kotlin("reflect"))
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    test {
        onlyIf {
            project.hasProperty("forceTests")
        }
    }
}