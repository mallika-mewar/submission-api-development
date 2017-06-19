The scripts use the Httpie HTTP client. To test the application, you can use these scripts or use some other client. However, in our tests, **no other HTTP client handled the sessions properly**.

Therefore, if you use e.g. Postman and it never shows you as logged in, then this is due to the tool, not the application.

To thoroughly test our application you can run the scripts in this order:

 * `get_all_comments` should return an empty list since there are initially no comments
 * `post_comment` should return 401 since only students are allowed to post comments
 * `register_student` should return 200 and log you in as the student
 * `logout` should log you out
 * `login_as_student` should log you back in.
 * `post_comment` should now post a comment and return 200 because you are now logged in as a student.
 * `get_all_comments` should now return a list containing all of the comments
 * `change_comment` should now change the content and author of the comment.
 * `get_specific_comment` should return the specific comment that was posted only.
 * `logout` to log back out again.
 * `register_admin` registers the admin user
 * `post_comment` should now be forbidden
 * `change_comment` also now be forbidden
 * `delete_comment` should now delete the comment that was posted.
 * Finally, you can `get_all_comments` again to show that the comment indeed was deleted.
