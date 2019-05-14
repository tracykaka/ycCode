#!/usr/bin/env bash
git checkout dev
git pull
gradle build -x test
java -jar build/libs/rencai-web-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev >/dev/null 2>&1 &