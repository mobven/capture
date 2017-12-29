
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

####1. To add aar file to project, copy aar file to lib folder

```gradle
repositories {
flatDir { dirs 'libs'} 
}
dependencies { 
  compile(name:'library-debug', ext:'aar')
}
```

####2. Initialize Capture instance in Application class. 

```java
public class MyApplication extends Application {

	@Override
	public void onCreate() {
		//Initilizing the Capture String appId=""; String secret=""; String projectId="";
		/**
		 * public enum TRACKEVENT
		 * OVERLAY, SHAKE 
		 */
		Capture.init(this, TrackEvent.OVERLAY, isCrashReportActive, appId, projectId, secret);
	}
}
```

## Links
[http://www.capture-mobile.com](http://www.capture-mobile.com)
