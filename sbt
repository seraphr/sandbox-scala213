#!/bin/bash
SBT_OPTS="-Xms512M -Xmx8G -Xss2M -Dfile.encoding=UTF-8 -XX:MaxMetaspaceSize=1024M"
exec java $SBT_OPTS -jar `dirname $0`/sbt-launch.jar "$@"
