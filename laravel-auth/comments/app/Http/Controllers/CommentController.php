<?php

namespace App\Http\Controllers;

use App\Comment;
use Illuminate\Http\Request;
use Auth;

class CommentController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index() {
      $comments = Comment::all();
      return $comments->toJson();
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request) {
      if(Auth::check() && $this->isStudent()) {
        $comment = new Comment;
        $comment->name = $request->name;
        $comment->message = $request->message;
        $comment->Save();
        return response('',200);
      }
      return response(Auth::user()->role,401);
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Comment  $comment
     * @return \Illuminate\Http\Response
     */
    public function show(Comment $comment) {
      return $comment->toJson();
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Comment  $comment
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Comment $comment) {
      if(Auth::check() && $this->isStudent()) {
        $comment->name = $request->name;
        $comment->message = $request->message;
        $comment->Save();
        return response($comment->toJson(),200);
      }
      return response(Auth::user()->role,401);

    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Comment  $comment
     * @return \Illuminate\Http\Response
     */
    public function destroy(Comment $comment) {
      if(Auth::check() && $this->isAdmin()) {
        $comment->delete();
        return response('',200);
      }
      return response(Auth::user()->role,401);
    }
    private function isAdmin() {
      return Auth::user()->role == 'manager';
    }
    private function isStudent() {
      return Auth::user()->role == 'client';
    }
}
