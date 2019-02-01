# Task Master
Health Tracker (Android Mobile)

## Functionality
Task Master performs the following activities:

#### Project
* Users should be able to create a Project.
* Users should be able to add a task to a Project.
* Both Tasks and Projects should be saved locally to a database.

#### Tasks
* A user should be able to “Assign” themselves a task, “Accept” that task, and later “Complete” that task.
* A task should have one property which represents what state the task is in.
  * `Available` - the task has been created, and is publicly available, but no other user has claimed it yet
  * `Assigned` - someone has been assigned that task
  * `Accepted` - the assignee has accepted that task
  * `Finished` - the task is totally complete. Write tests making sure a task progresses through it’s states properly

#### Firebase
* Users should be able to log in.
* At a minimum, they should be able to log in with email and password.
* Users should be able to see all the Projects in a cloud database, and add Tasks to those projects.
  * (Hint: In a NoSQL database, there are many options for how to store Tasks associated with Projects and Users. Read the Firebase documentation on structuring data carefully, and have fun exploring!)
* A user should be able to “Assign” a task to themself or another user.
* The user assigned to a task should be able to “Accept” that task, and later “Complete” that task.

#### Firebase Cloud Functions
* Users should be able to view all of the tasks assigned to them on a screen.
* Users should be able to sort the tasks assigned to them based on the title of the task, the state the task is in, or the person who assigned the task to them
* This sorting should be done in the cloud, to avoid using too many resources on the user’s phone.

#### TaskMaster Accessibility Features
* Any iconography in your app should be well-labeled with a contentDescription.
* Use the hint attribute on all editable elements in your app, or labelFor to allow a TextView to serve as a label.
* Use the focusable attribute to show that a particular ViewGroup consists of one piece of data.

#### Polish TaskMaster / Build an APK
* Complete all feature tasks from the last 4 labs.
* Build an .apk file that can be directly installed on a device. Include that file in your repo, linked from your README.

## Change Log
#### 1/28/2019
- Initialized repo
- Created new Android project
- Added dependencies

#### 1/29/2019
- Achieved basic functionality to add a project and view in recycler on MainActivity.

#### 1/31/2019
- Instantiated Firebase account and completed dependencies additions

#### 2/1/2019
-

## Activity Screenshots
#### Main Activity
<p float="left">
  <img src="./screenshots/Screenshot_MainActivity.png" width="125" />
</p>

#### Project Activity
<p float="left">
  <img src="./screenshots/Screenshot_ProjectActivity.png" width="125" />
</p>

## Resources
* Code review Day 41 pt 1 (project creation)
* [Room Relationships](https://android.jlelse.eu/android-architecture-components-room-relationships-bf473510c14a)
* [Firebase Setup](https://firebase.google.com/docs/android/setup)
* [Enums](https://stackoverflow.com/questions/44498616/android-architecture-components-using-enums)

## Helpful Human Collaborators
* Special thanks to Team Alpha Table (Jessica Lovell, Evan Slaton, Jeff Borda, Dan Logerstedt and Zahra Mohamed) for always being willing to help a guy out when needed with direction and correction.
* Sooz demands literary excellence - I shall deliver!

