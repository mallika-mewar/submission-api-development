#!/bin/bash

http --session=./sess PUT localhost:8000/comment/1 name=changed_name message=changed_message
