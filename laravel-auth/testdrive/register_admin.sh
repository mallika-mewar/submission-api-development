#!/bin/bash

http --session=./sess POST localhost:8000/register name=admin email=admin@admin.com password=blubber password_confirmation=blubber role=manager 
