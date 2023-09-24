import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.8.22"
}

repositories {
    mavenLocal()
    mavenCentral()
    maven { url = uri("https://mirrors.cloud.tencent.com/nexus/repository/maven-public/") }
}

group = "xyz.frish2021"
version = "1.0"
description = "solon-study"


dependencies {
    implementation(platform("org.noear:solon-parent:2.5.6"))
    
    implementation("org.noear:solon-web")
    implementation("org.noear:solon.logging.simple")
    implementation("org.xerial:sqlite-jdbc:3.32.3")
    implementation("org.mybatis:mybatis:3.5.5")

    testImplementation("org.noear:solon-test")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}
tasks.withType<KotlinCompile> {
    kotlinOptions.javaParameters = true
}

tasks.withType<Jar> {
    manifest {
        attributes.apply {
            set("Main-Class", "xyz.frish2021.AppKt")
        }
    }

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(configurations.runtimeClasspath.get().map {
        if (it.isDirectory) it else zipTree(it)
    })

    from(sourceSets.main.get().output)
}