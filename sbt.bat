@echo off
set SCRIPT_DIR=%~dp0
java -Xms512M -Xmx8G -Xss2M -Dfile.encoding=SJIS -Dinput.encoding=Cp1252 -XX:MaxMetaspaceSize=1024M -jar "%SCRIPT_DIR%sbt-launch.jar" %*
