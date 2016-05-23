
Capture
==================

  - [About](#about)
  - [Usage](#usage)
    - [IOS](#ios)
    - [Android](#android)
  - [Links](#links)


## About

Capture makes reporting bugs easy, which increases the productivity of your test engineers; standardized reporting enables your developers to focus on fixing the bug instead of finding and reproducing it.

Capture greatly improves your mobile testing processes.
Just shake the phone to report a bug and be amazed how
easy it can be.


## Usage

###IOS:

####Static Lib Requirements :

1) Turn off App Transportation Security

2) Target -> Build Settings -> Write “other linker flag” to search and add -ObjC -all_load to the related place

####To AppDelegate.m file

```
#import "MobvenBugReporter.h"
``` 
import in this way. 
```
didFinishLaunchingWithOptions
```
add the following code in the method above:

```
[MobvenBugReporter initializeAppSecret:@"1" appId:@"1" projectId:@"1" in- vokeTypes:@[@(Shake), @(FloatingButton)]];
```

####Usage of Embedded Framework//Objective C // ----------

1) Target-> General -> Embedded Binaries
Add MobvenBugKit.framework

2) Target -> Build Settings -> Write "Bitcode" to search and set the related place as 'YES'

3) Turn off App Transportation Security

####To the AppDelegate.m File:
```
#import <MobvenBugKit/MobvenBugKit.h>
didFinishLaunchingWithOptions
```
add the following code in the method above: 
```
[MobvenBugReporter initializeAppSecret:@"1" appId:@"1" projectId:@"1" in- vokeTypes:@[@(Shake), @(FloatingButton)]];
```

####Usage of Embedded Framework//Swift // —————

1) Target-> General -> Embedded Binaries
Add MobvenBugKit.framework

2) Target -> Build Settings -> Write "Bitcode" to Search and set the related place as 'YES'

3) Turn off App Transportation Security

####To the AppDelegate file:
```
import MobvenBugKit
didFinishLaunchingWithOptions
```
add the following code to the method above:
```
let types = [NSNumber(unsignedInteger:InvocationType.Shake.rawValue),NSNumber(un- signedInteger:InvocationType.FloatingButton.rawValue)]
MobvenBugReporter.initializeAppSecret("1", appId: "1", projectId: "1", in- vokeTypes:types)
```

###Android:

####1. To add aar file to project, copy aar file to lib folder

```gradle
repositories {
flatDir { dirs 'libs'} 
}
dependencies { 
  compile(name:’bugtrackerlibrary', ext:'aar')
}
```

####2. Add BugTracker to Override methods of activity as you see on the example. 

####3. (Optional) To be able to turn on events like”2 finger swipe", "volume up/down” your activities should override

```public void dispatchKeyEvent(Key event);```method and  ```BugTracker.dispatchKeyEvent(KeyEvent event);``` method should be called.

```java
public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);

		//Initilizing the BugTracker String yourAppId=""; String yourAppSecret=""; String yourProjectId="";

		/**
		 * public enum TRACKEVENT
		 * SHAKE, TWO_FINGER_SWIPE, VOLUME_UP, VOLUME_DOWN 
		 */
		BugTracker.initialize(this, yourAppId, yourAppSecret, yourProjectId , BugTracker.TRACKEVENT.SHAKE, true);

		//Attach on onCreate
		BugTracker.onCreate(this);
	}

	@Override
	public void onResume() {
		super.onResume();
		// Add theme following line to register the Session Manager Listener onResume 
		BugTracker.onResume(this);
	}

	@Override
	public void onPause() {
		// Add the following line to unregister the Sensor Manager onPause 
		BugTracker.onPause(this);
		super.onPause();
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		//Register for dispatchKeyEvent 
		BugTracker.dispatchKeyEvent(event);
		return super.dispatchKeyEvent(event);
	}
}
```


## Links
[http://www.capture-mobile.com](http://www.capture-mobile.com)
