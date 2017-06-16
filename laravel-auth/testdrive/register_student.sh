#!/bin/bash

http --session=./sess POST localhost:8000/register name=student email=student@student.com password=blubber password_confirmation=blubber role=client 
