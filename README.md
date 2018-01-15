
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


## Usage

###Android:

####1. In project gradle file add following maven repository 

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

####2. In app gradle file add following dependency

```gradle
compile ('com.mobven.capture:library:1.0.3@aar'){
        transitive = true
    }
```

## Links
[http://www.capture-mobile.com](http://www.capture-mobile.com)
