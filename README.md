# Liz
[![](https://jitpack.io/v/com.github.HoraApps/Liz.svg)](https://jitpack.io/#com.github.HoraApps/Liz)

Add support to themes in your app.

Usage example [LeafPic](https://github.com/HoraApps/LeafPic)

## Setup:

### Gradle Dependency:

*Liz* is available on [**jitpack.io**](https://jitpack.io/#com.github.HoraApps/Liz).

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):
```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

Add this in your module `build.gradle` file:
```gradle

dependencies {
    implementation 'com.github.HoraApps:Liz:-SNAPSHOT'
}
```