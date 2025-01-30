# xtracise
## by Aaron Kieran Southcombe

### Images

#### Landing page:

![image](https://github.com/user-attachments/assets/2a92ba52-31b1-4fe5-9f09-718877e214df)

#### Login dialog:

![image](https://github.com/user-attachments/assets/29a06d2c-7edf-4aa5-8b36-6ab5d58e0d8d)


#### Workouts, clients and Exercises viewer:

![image](https://github.com/user-attachments/assets/bcf2fd45-f897-4407-be6a-d21d138daef1)

#### Workout edit and create:

![image](https://github.com/user-attachments/assets/c44727a4-ff5c-4c9e-8ca6-431f4bdb79d8)


Logo photo taken from [here](https://www.publicdomainpictures.net/en/view-image.php?image=487289&picture=fitness-and-gym-logo)

### Usage

To use the app, all you have to do is sign in with your credentials, and you can edit, create, delete or modify any of your users' workouts!

You can also log out. You can only modify the workouts of users who you instruct.

### Development issues

For efficiency, I tried using the date column to display the exercises, but it seems to not account for time, so as seen in the code, it has been changed to use IDs.

Also, to minimize code footprint, the workout modification has been done via delete + create, seeing as the timestamp would be updated anyway. Thanks to this improvement, DataAccess only had to be modified to have delete functionality.

The minimal objective of this project has lead to a very reduced code footprint, achieving as much as possible in as simple and uncomplicated code achievable. This has lead to easily readable and understandable code.

### Documentation and references used in development

MigLayout: http://www.miglayout.com/
Maven: https://maven.apache.org/guides/index.html
SQL Server for on cascade reference: https://learn.microsoft.com/en-us/sql/?view=sql-server-ver16
