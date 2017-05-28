#!/usr/bin/env bash
#
# This is the main script that runs the crawler

inputFile=$1

java -jar build/libs/convoyInterview-0.1.0.jar $inputFile