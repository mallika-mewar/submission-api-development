<?php

namespace App\Http\Controllers\Auth;

use App\Http\Controllers\Controller;
use Illuminate\Foundation\Auth\AuthenticatesUsers;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class LoginController extends Controller
{

    /**
     * Create a new controller instance.
     *
     * @return void
     */
    public function __construct()
    {
        $this->middleware('guest')->except('logout');
    }
    /*
     * @param \Illuminate\Http\Request $request
     * @return \Illuminate\Http\Response
     *
     *
     */
    public function ourLoginImplementation(Request $request) {
      if(Auth::guard()->attempt($request->only('email','password'),$request->has('remember'))) {
        $request->session()->regenerate();
        return response(200)->cookie('bla','blub');
      }
      return response(401);
    }
    public function loginWithoutCredentials($userid) {
      Auth::loginUsingId($userid);
      return response(200);
    }
    public function ourLogoutImplementation(Request $request) {
      Auth::logout();
      return response(200);
    }
}
