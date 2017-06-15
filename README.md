
# Api Development Submission

## Question 1

### (a)

  (i). This request inserts a new comment.
  (ii). This request changes an existing comment
  (iii). This request deletes an existing comment

### (b)

  (i). TODO
  (ii). It is quite difficult to tell from the provided code which of the mistakes we are supposed to find. For example, in provided file, the `app` object is never created properly, nor is the `Flask` function that would be used to do so even imported. Similarly, the global `request` object, the `json_response` annotation, the `db_session` and the `Comment` class are never defined anywhere. The obvious solution to these problems is to import the required definitions, properly setup and configure the application and implement the `Comment` class (possibly with the help of SQLAlchemy). Furthermore, the `json_response` annotation throws an error when used without parameters. Using `as_json` instead solves the problem at least in our development environment. This highlights the **most important error**: Neither the python version, nor the version of the packages to be used are specified anywhere.

  Finally, there are some indentation errors: 

    * The statements in lines 16-19 are indented too far. In general the beginning of a python statement can only be indented more than that of the previous statement if it is the beginning of a loop-body if the body of a conditional. In this case the first 12 spaces of each of the lines needs to be removed.
    * The same applies to lines 39-42
    * The statements in lines 45 and 46, however, are not indented enough and 4 more spaces at the beginning should be added 

    (iii).

      1. The snippet is correct
      2. The snippet is incorrect: there is a superfluous round closing brace in that line.
      3. The snippet is incorrect: the `id` that is passed as a parameter in line 4 is undefined. The intention was probably to get the `id` from the url but that does not happen here.
  
