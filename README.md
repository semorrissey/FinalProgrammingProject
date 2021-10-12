FinalProgrammingProject

**DISCLAIMER** <br/>
Note that over the term, Android Sutdio consistently did not run well on either of our machines due to the memory it would eat up. This affected our workflow greatly, causing the program to be nearly unusable. We saw this in build times of at least 6 minutes, sometimes ranging to double this time. We also saw this in the in the software lagging when typing and sometimes not responding after the long build times. This alongside other time constraints related to project work both in and outside of this class had us face more challenges for our completion.Therefore, please take this into consideration when grading our project. Thank you!


**Tasks**<br/>

Task 1:

For the checkpoint pdf, we completed this together before the due date fo the checkpoint. In this we proposed our ideas and what we thought would be good in terms of how we wanted to complete it. The UI Mockup was done in photoshop, showing each of the different view fragments we expected to create. We described what would be our functional designs , the proposed design patterns, external libraries, and intentions for the project. This can be assesed by the PDF that was previously turned in during the checkpoint.
<br/>

Task 2:

For the video, we chose to record ourselves presenting slides. In this video we describe how we complete,or get close to completing, the requirements that were outlined for us, the correctness of our application, and more. We also show how our app functions wiht the android profilier. This can be assesed by watching the video provided.
<br/>

Task 4:

Our source code was the area where we ran into many of our issues. First, some of our layouts for our fragments are buggy. We had UI issues for our project despite the XML file previews being perfect. For example, the Profile Fragments view objects are overlapping eachother and are not in the positions defined by the XML file. In addition, the avatar image assets that we included are not viewable at all. The Home Fragment also includes this issue as the main avatar image we planned to include is blank when the app is ran on the device. Despite this, the functionality for this fragment in terms of the QR code and Database conection work perfectly without errors. Each of the fragments had UI issues, despite the previews in our XML files which makes us believe we did not make any errors. Secondly, we used an Android Project template to start our project. It is the one with the bottom navigation bar, this may have been a contributer to our issues, but we are not certian. Lastly, our JUnit files tests the app's relationship with the database. The QR code is another cirtical feature but we were unsure of how to test it using JUnit. In addition, we had issues with our camera. We initially planned to include the ability to take your own profile pictures, but due to errors revolving around the launch of the camera, we could not complete this aspect. We attempted to follow best practices with our code using a MVVM design.
<br/>

Task 7:

For our desgin achievement, we believe that our bottom navigation bar helps fill this requirement. The bottom navigation bar splits the application into portions, profile, home, settings, and messages. By tapping each of their respective Icons, one can cycle through each portion of our aplpication. The navigation works by using view binding and cycling through fragments that are instantiated in the main acitivy. In addition, we attempted to add popup actvities for each of the settings options. While they do function, we reached similar issues with XML and them not being filled in. Thus, we belive these portions of our application accomplish respetice design achievements to the best of our ability. This can be assesed in the mobile navigation and bottom bar XML files.
<br/>

Task 8:

For our technical achievements, we belive that both the database connection and data plus the QR code generator accomplish this achievement. The database had to be changed from the proposed MongoDB to Firebase as we found that MongoDB's Java Driver is not compatible with Android Studio. After switching to firebase, using the database was quite easy in terms of designing it like our intentions in the proposal. We belive our QR code generator is also a technical achievement as it would connect users to each other via this outside connection. In an ideal situation, we would have been able to allow this feature to work, but due to our constraints mentioned in the disclaimer, we were only able to have it generate one per user that includes their name. Both of these features can be assesed in the OnViewCreate function of the ProfileFragment.
<br/>

Task 5:

The Debug APK was produced and added to the project. It can be assesed in the file directory.
<br />

Task 6:

This file demonstrates the completion of this task
