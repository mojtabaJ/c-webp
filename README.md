## FCM SERVER [![Maven Central](https://img.shields.io/maven-central/v/com.github.morteza-j8/fcm-server.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.github.morteza-j8%22%20AND%20a:%22fcm-server%22)

Firebase cloud messaging server side (send message to client)



---

### Setup
The simplest way to send message via firebase cloud message is to add the library as dependency to your build.

### Maven
```xml
<dependency>
    <groupId>com.github.mojtabaJ</groupId>
    <artifactId>fcm-server</artifactId>
    <version>1.1.1</version>
</dependency>

```

### Gradle
```xml
implementation 'com.github.morteza-j8:fcm-server:1.1.1'
```


### Usage

<b>Step 1</b>. create class <b>FirebaseHandler</b> and set the Firebase Server key:
```java
public class FirebaseHandler extends FirebaseNotification {

    private static FirebaseHandler firebaseHandler;

    public static FirebaseHandler getInstance(){
        if(FirebaseHandler.firebaseHandler == null){
            FirebaseHandler.firebaseHandler = new FirebaseHandler();
        }
        return FirebaseHandler.firebaseHandler;
    }


    @Override
    protected String getFirebaseRemoteToken() {
        return "<your project server key>";
    }

}
```

Server Key is accessible via your <a href="https://console.firebase.google.com/">Firebase Console</a> dashboard.
 

<b>Step 2</b>.send message to client:

    FirebaseHandler.getInstance()
                    .sendNotification( 
                            "client notification ids" , 
                            "notification type(set into data object)" , 
                            YourPayLoadObject 
                    );


### Example:
the client example.
 [Example of web client FCM](https://github.com/Morteza-j8/FCM-Web-Client-Exapmle)

the server example.
 [Example of server FCM](https://github.com/Morteza-j8/FCM-Server-Exapmle)

##### Use From 
[Retrofit](https://github.com/square/retrofit)

##### License
[Apache License Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

```
Copyright 2019 Morteza Jalambadani

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
