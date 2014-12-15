Android-The-Big-Nerd-Ranch-Guide
================================

Learning the book "Android Programming: The Big Nerd Ranch Guide"

##Project 01 -- GeoQuiz

###Chap 01 Your First Android Application

> * The layout name reverses the order of the activity name, is all lowercase, and has underscores between words.
 This naming style is recommended for layouts as well as other resources. Sch as `QuizActivity-->activity_quiz`.
> * Android application build process.![build-process](http://developer.android.com/images/build.png)

###Chap 02 Android and Model-View-Controller

> * `A model object` holds the application’s data and "business logic".
> * `View objects` know how to draw themselves on the screen and how to respond to user input, like touches.
> * `Controller objects` tie the view and model objects together.
> * MVC flow with user input![mvc](https://github.com/acprimer/Android-The-Big-Nerd-Ranch-Guide/blob/master/pic/mvc.png)

###Chap 03 The Activity Lifecycle

> * State: non-existent --> stopped(not visible) --> paused(visible) --> running(visible & foreground)
> * call: onCreate() --> onStart() --> onResume() --> onPause() --> onStop() --> onDestroy()
> * Rotating the device changes the device configuration. The device configuration is a set of characteristics that describe the
current state of an individual device. The characteristics that make up the configuration include screen orientation, screen
density, screen size, keyboard type, dock mode, language, and more.
> * Note that Android destroys the current activity and creates a new one whenever any runtime configuration change occurs.