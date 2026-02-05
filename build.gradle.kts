// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Используем ТОЛЬКО alias, чтобы всё бралось из твоего TOML файла
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.hilt) apply false
}

