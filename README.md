# Capture

##İOS

####Static Lib Gereklilikleri :

1) App Transportation Security Kapatilmasi

2) Target -> Build Settings -> Arama kismina “other linker flag” yazilip ilgili yere -ObjC -all_load eklenecek.

####AppDelegate.m Dosyasina

```
#import "MobvenBugReporter.h"
``` 
seklinde import edilir. 
```
didFinishLaunchingWithOptions
```
methodun icinde asagidaki kod eklenir: 

```
[MobvenBugReporter initializeAppSecret:@"1" appId:@"1" projectId:@"1" in- vokeTypes:@[@(Shake), @(FloatingButton)]];
```

####Embedded Framework Kullanimi //Objective C // ----------

1) Target-> General -> Embedded Binaries
Add MobvenBugKit.framework
2) Target -> Build Settings -> Arama kismina “Bitcode” yazilip ilgili yer YES olarak set edilir
3) App Transportation Security Kapatilmasi

####AppDelegate.m Dosyasina:
```
#import <MobvenBugKit/MobvenBugKit.h>
didFinishLaunchingWithOptions methodun icinde asagidaki kod eklenir : [MobvenBugReporter initializeAppSecret:@"1" appId:@"1" projectId:@"1" in- vokeTypes:@[@(Shake), @(FloatingButton)]];
```

####Embedded Framework Kullanimi //Swift // —————

1) Target-> General -> Embedded Binaries
Add MobvenBugKit.framework
2) Target -> Build Settings -> Arama kismina “Bitcode” yazilip ilgili yer YES olarak set edilir
3) App Transportation Security Kapatilmasi

####AppDelegate Dosyasina:
```
import MobvenBugKit
didFinishLaunchingWithOptions methodun icinde asagidaki kod eklenir :
let types = [NSNumber(unsignedInteger:InvocationType.Shake.rawValue),NSNumber(un- signedInteger:InvocationType.FloatingButton.rawValue)]
MobvenBugReporter.initializeAppSecret("1", appId: "1", projectId: "1", in- vokeTypes:types)
```

## Android

1.aar dosyasını projeye eklemek için; aar dosyasını lib klasörüne kopyalayın.

2. gradle.build dosyasınıza şu satırları ekleyin: 

```
repositories {
flatDir { dirs 'libs'} 
}
dependencies { 
  compile(name:’bugtrackerlibrary', ext:'aar')
}
```

3.Activity’nin override methodları olan; *onCreate
*onResume
*onPause
**dispatchKeyEvent
methodlarına örnekteki gibi BugTracker eklenir.

**Opsiyonel :"2 finder swipe", "volume up/down” eventlerin çalışabilmesi için aktivitelerinizin

```
public void dispatchKeyEvent(Key event event);
```
methodunu override edip Bug-Tracker.dispatchKeyEvent(KeyEvent event); methodunu çağırmanız gerekmektedir. 

```
public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);

//Initilizing the BugTracker String yourAppId=""; String yourAppSecret=""; String yourProjectId="";

/**
* public enum TRACKEVENT {
* SHAKE, TWO_FINGER_SWIPE, VOLUME_UP, VOLUME_DOWN */
BugTracker.initialize(this, yourAppId, yourAppSecret, yourProjectId , BugTrack- er.TRACKEVENT.SHAKE, true);
 
//Attach on onCreate
BugTracker.onCreate(this); 
}

@Override
public void onResume() {
super.onResume();
// Add theme following line to register the Session Manager Listener onResume BugTracker.onResume(this);
}

@Override
public void onPause() {
// Add the following line to unregister the Sensor Manager onPause BugTracker.onPause(this);
super.onPause(); 
}

@Override
public boolean dispatchKeyEvent(KeyEvent event) {
//Register for dispatchKeyEvent BugTracker.dispatchKeyEvent(event); return super.dispatchKeyEvent(event);
} 
}
```
