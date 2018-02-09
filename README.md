
Capture
==================

  - [About](#about)
  - [Usage](#usage)
    - [IOS](http://github.com/mobven/capture-ios)
    - [Android](#android)
  - [Links](#links)


## About

Capture makes reporting bugs easy, which increases the productivity of your test engineers; standardized reporting enables your developers to focus on fixing the bug instead of finding and reproducing it.

Capture greatly improves your mobile testing processes.
Just shake the phone to report a bug and be amazed how
easy it can be.

## Needs Permissions

Capture needs runtime permissions to work properly.

WRITE_EXTERNAL_STORAGE
READ_EXTERNAL_STORAGE
RECORD_AUDIO
CAMERA

## Usage

### Android

Capture needs to add WRITE_EXTERNAL_STORAGE permission on Manifest.
TrackEvent can be SHAKE or OVERLAY

```xml
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" tools:node="replace"/>
```

### 1. In project gradle file add following maven repository 

```gradle
allprojects {
  repositories {
    ...
    maven {
      url "http://capture.mobven.com:8081/artifactory/libs-release-local"
      credentials {
        username = "ARTIFACTORY_USERNAME"
        password = "ARTIFACTORY_PASSWORD"
      }
    }
  }
```

### 2. In app gradle file add following dependency

```gradle
compile ('com.mobven.capture:library:1.2.3@aar'){
        transitive = true
    }
```

### 3. Init Capture in application class

If you do not have Application class, create new one then add to your manifest file.

```gradle
Capture.init(this, TrackEvent.OVERLAY, boolean isCrashReportActive, int appId, int projectId, int secret, boolean isDebugLogEnable);
```
## Links
[http://www.capture-mobile.com](http://www.capture-mobile.com)
