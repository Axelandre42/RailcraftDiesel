#!/bin/sh
# -Deploy script-
echo 'Publishing...'
gradle publish
echo 'Updating versions.json on server...'
gradle updateVersions