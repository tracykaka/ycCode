#!/usr/bin/env bash
DEF_ENV=test
ENV=$1
git checkout $ENV
git pull
#rm -rf /root/.gradle/caches/modules-2/files-2.1/com.rencai
gradle build -x test

JAVA_OPTS="-Xms2048M -Xmx2048M -Xmn1024M -Xss128m -XX:+DisableExplicitGC -XX:MaxTenuringThreshold=15 -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -XX:+CMSParallelRemarkEnabled -XX:LargePageSizeInBytes=128m -XX:CMSInitiatingOccupancyFraction=75 -Duser.timezone=Asia/Shanghai"
#kill -9 $(netstat -nlp | grep :8000 | awk '{print $7}' | awk -F"/" '{ print $1 }')
pkill -f data-service
sleep 5
nohup java $JAVA_OPTS -jar build/libs/data-service-0.0.1-SNAPSHOT.jar --spring.profiles.active=$ENV >/dev/null 2>&1 &