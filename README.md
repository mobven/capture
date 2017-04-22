
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
  compile(name:'bugtrackerlibrary', ext:'aar')
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


####4. Add BroadCast Receiver to your app (if you have a receiver please add only if control)

```java
public class ReceiveMessages extends BroadcastReceiver {
 public static final String CAPTURE_APP_NAME = "com.mobven.bugtrackerlibrary";
    @Override
    public void onReceive(Context context, Intent intent)
    {
        String action = intent.getAction();
        if(action.equalsIgnoreCase(CAPTURE_APP_NAME)){
            
	    // Do here whatever you want on Capture Success response 
	
        }
    }
}
```

####5. (Optional) 

```java
//If you use this code you will recieve logs from JIRA to your e-mail.
Log.i("Log","info")
```

## Links
[http://www.capture-mobile.com](http://www.capture-mobile.com)
