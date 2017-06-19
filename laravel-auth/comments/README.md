This is our implementation of the comments API with authentication. To develop we used the laravel homestead vm, which is described in the official docs. Once you have setup vagrant and virtualbox, you should be able to start the webapp simply by `vagrant up` and then tear it down again with `vagrant destroy`. Running `vagrant up` also runs the migrations, as per `after.sh`. 

Otherwise, we have simply implemented the REST API and added session-based authentication as described in the documentation. One can also login without credentials by using the `/login/{userid}` route. 


Changed files from the original template are

 * `after.sh`
 * `routes/web.php`
 * `app/Comment.php`
 * `app/Http/Controllers/CommentController.php`
 * `app/Http/Controllers/Auth/LoginController.php`

