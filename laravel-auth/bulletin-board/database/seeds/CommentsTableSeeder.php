<?php

use Illuminate\Database\Seeder;

class CommentsTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
	DB::table('comments')->insert(['name'=> str_random(10),'message' => str_random(10)]);
    }
}
