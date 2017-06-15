<?php


/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

//Dont create 'create' and 'edit' routes because we do not need them for the api
Route::resource('comment','CommentController',['except' =>  ['create','edit']]);

//routes to use for authentication. Note that we could have used the builtin Auth::routes function to generate these, but that generates lots of routes that we do not need.

//The default implementation for this endpoint does what we want. We have, however modified it so that it also add the user's role as per the example in the assignment.
Route::post('register', ['as' => 'register.post', 'uses' => 'Auth\RegisterController@register']);


//Our own implementation of authentication with credentials
Route::post('login', ['as' => 'login.post', 'uses' => 'Auth\LoginController@ourLoginImplementation']);
//This logs a user in without checking the credentials. However, one must still of course provide the id so that we know, which user we have to log in.
Route::post('login/{userid}', ['as' => 'login.post', 'uses' => 'Auth\LoginController@loginWithoutCredentials']);
//just a logout implementation
Route::post('logout', ['as' => 'logout', 'uses' => 'Auth\LoginController@ourLogoutImplementation']);
