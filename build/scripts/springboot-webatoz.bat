@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  springboot-webatoz startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Add default JVM options here. You can also use JAVA_OPTS and SPRINGBOOT_WEBATOZ_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windows variants

if not "%OS%" == "Windows_NT" goto win9xME_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\webatoz-0.1.0.jar;%APP_HOME%\lib\gson-2.8.6.jar;%APP_HOME%\lib\jackson-dataformat-yaml-2.8.6.jar;%APP_HOME%\lib\google-java-format-1.7.jar;%APP_HOME%\lib\spring-cloud-starter-netflix-zuul-2.1.2.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-hateoas-2.2.5.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-web-2.2.5.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-data-jpa-2.2.1.RELEASE.jar;%APP_HOME%\lib\spring-data-jpa-2.2.5.RELEASE.jar;%APP_HOME%\lib\zuul-core-1.3.1.jar;%APP_HOME%\lib\spring-hateoas-1.0.3.RELEASE.jar;%APP_HOME%\lib\mybatis-spring-boot-starter-2.1.1.jar;%APP_HOME%\lib\spring-boot-starter-jdbc-2.2.5.RELEASE.jar;%APP_HOME%\lib\HikariCP-3.4.2.jar;%APP_HOME%\lib\spring-data-commons-2.2.5.RELEASE.jar;%APP_HOME%\lib\spring-cloud-netflix-zuul-2.1.2.RELEASE.jar;%APP_HOME%\lib\spring-cloud-starter-netflix-ribbon-2.1.2.RELEASE.jar;%APP_HOME%\lib\ribbon-httpclient-2.3.0.jar;%APP_HOME%\lib\ribbon-2.3.0.jar;%APP_HOME%\lib\ribbon-transport-2.3.0.jar;%APP_HOME%\lib\ribbon-loadbalancer-2.3.0.jar;%APP_HOME%\lib\netflix-commons-util-0.3.0.jar;%APP_HOME%\lib\spring-cloud-starter-netflix-hystrix-2.1.2.RELEASE.jar;%APP_HOME%\lib\hystrix-metrics-event-stream-1.5.18.jar;%APP_HOME%\lib\hystrix-serialization-1.5.18.jar;%APP_HOME%\lib\hystrix-javanica-1.5.18.jar;%APP_HOME%\lib\hystrix-core-1.5.18.jar;%APP_HOME%\lib\ribbon-core-2.3.0.jar;%APP_HOME%\lib\spring-cloud-starter-netflix-archaius-2.1.2.RELEASE.jar;%APP_HOME%\lib\archaius-core-0.7.6.jar;%APP_HOME%\lib\spring-plugin-core-2.0.0.RELEASE.jar;%APP_HOME%\lib\json-path-2.4.0.jar;%APP_HOME%\lib\spring-boot-starter-json-2.2.5.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-validation-2.2.5.RELEASE.jar;%APP_HOME%\lib\spring-cloud-netflix-hystrix-2.1.2.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-aop-2.2.5.RELEASE.jar;%APP_HOME%\lib\spring-cloud-starter-2.1.2.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-actuator-2.2.5.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-2.2.5.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-logging-2.2.5.RELEASE.jar;%APP_HOME%\lib\logback-classic-1.2.3.jar;%APP_HOME%\lib\log4j-to-slf4j-2.12.1.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.30.jar;%APP_HOME%\lib\rxnetty-contexts-0.4.9.jar;%APP_HOME%\lib\rxnetty-servo-0.4.9.jar;%APP_HOME%\lib\rxnetty-0.4.9.jar;%APP_HOME%\lib\servo-core-0.10.1.jar;%APP_HOME%\lib\netflix-statistics-0.1.1.jar;%APP_HOME%\lib\servo-internal-0.10.1.jar;%APP_HOME%\lib\slf4j-api-1.7.30.jar;%APP_HOME%\lib\log4jdbc-log4j2-jdbc4-1.16.jar;%APP_HOME%\lib\postgresql-42.1.4.jar;%APP_HOME%\lib\selenium-chrome-driver-3.141.59.jar;%APP_HOME%\lib\selenium-remote-driver-3.141.59.jar;%APP_HOME%\lib\guava-28.1-jre.jar;%APP_HOME%\lib\jsoup-1.12.1.jar;%APP_HOME%\lib\poi-ooxml-4.1.2.jar;%APP_HOME%\lib\jasypt-spring-boot-starter-2.1.0.jar;%APP_HOME%\lib\jaxb-api-2.3.0.jar;%APP_HOME%\lib\spring-boot-devtools-2.2.5.RELEASE.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.10.2.jar;%APP_HOME%\lib\spring-boot-actuator-autoconfigure-2.2.5.RELEASE.jar;%APP_HOME%\lib\spring-boot-actuator-2.2.5.RELEASE.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.10.2.jar;%APP_HOME%\lib\jackson-module-parameter-names-2.10.2.jar;%APP_HOME%\lib\jackson-module-afterburner-2.10.2.jar;%APP_HOME%\lib\jackson-databind-2.10.2.jar;%APP_HOME%\lib\jackson-core-2.10.2.jar;%APP_HOME%\lib\snakeyaml-1.25.jar;%APP_HOME%\lib\javac-shaded-9+181-r4173-1.jar;%APP_HOME%\lib\spring-boot-starter-tomcat-2.2.5.RELEASE.jar;%APP_HOME%\lib\spring-webmvc-5.2.4.RELEASE.jar;%APP_HOME%\lib\spring-web-5.2.4.RELEASE.jar;%APP_HOME%\lib\mybatis-spring-boot-autoconfigure-2.1.1.jar;%APP_HOME%\lib\mybatis-3.5.3.jar;%APP_HOME%\lib\mybatis-spring-2.0.3.jar;%APP_HOME%\lib\hibernate-core-5.4.12.Final.jar;%APP_HOME%\lib\jaxb-runtime-2.3.2.jar;%APP_HOME%\lib\stax-ex-1.8.1.jar;%APP_HOME%\lib\jakarta.xml.bind-api-2.3.2.jar;%APP_HOME%\lib\istack-commons-runtime-3.0.8.jar;%APP_HOME%\lib\jakarta.activation-api-1.2.2.jar;%APP_HOME%\lib\jakarta.persistence-api-2.2.3.jar;%APP_HOME%\lib\jakarta.transaction-api-1.3.3.jar;%APP_HOME%\lib\spring-aspects-5.2.4.RELEASE.jar;%APP_HOME%\lib\failureaccess-1.0.1.jar;%APP_HOME%\lib\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\checker-qual-2.8.1.jar;%APP_HOME%\lib\error_prone_annotations-2.3.2.jar;%APP_HOME%\lib\j2objc-annotations-1.3.jar;%APP_HOME%\lib\animal-sniffer-annotations-1.18.jar;%APP_HOME%\lib\selenium-api-3.141.59.jar;%APP_HOME%\lib\byte-buddy-1.10.8.jar;%APP_HOME%\lib\commons-exec-1.3.jar;%APP_HOME%\lib\okhttp-3.14.7.jar;%APP_HOME%\lib\okio-1.17.2.jar;%APP_HOME%\lib\poi-4.1.2.jar;%APP_HOME%\lib\poi-ooxml-schemas-4.1.2.jar;%APP_HOME%\lib\commons-compress-1.19.jar;%APP_HOME%\lib\curvesapi-1.06.jar;%APP_HOME%\lib\jasypt-spring-boot-2.1.0.jar;%APP_HOME%\lib\spring-boot-autoconfigure-2.2.5.RELEASE.jar;%APP_HOME%\lib\spring-boot-2.2.5.RELEASE.jar;%APP_HOME%\lib\jakarta.annotation-api-1.3.5.jar;%APP_HOME%\lib\spring-context-5.2.4.RELEASE.jar;%APP_HOME%\lib\spring-aop-5.2.4.RELEASE.jar;%APP_HOME%\lib\spring-orm-5.2.4.RELEASE.jar;%APP_HOME%\lib\spring-jdbc-5.2.4.RELEASE.jar;%APP_HOME%\lib\spring-tx-5.2.4.RELEASE.jar;%APP_HOME%\lib\spring-beans-5.2.4.RELEASE.jar;%APP_HOME%\lib\spring-expression-5.2.4.RELEASE.jar;%APP_HOME%\lib\spring-core-5.2.4.RELEASE.jar;%APP_HOME%\lib\tomcat-embed-websocket-9.0.31.jar;%APP_HOME%\lib\tomcat-embed-core-9.0.31.jar;%APP_HOME%\lib\tomcat-embed-el-9.0.31.jar;%APP_HOME%\lib\jakarta.validation-api-2.0.2.jar;%APP_HOME%\lib\hibernate-validator-6.0.18.Final.jar;%APP_HOME%\lib\aspectjweaver-1.9.5.jar;%APP_HOME%\lib\hibernate-commons-annotations-5.1.0.Final.jar;%APP_HOME%\lib\jboss-logging-3.4.1.Final.jar;%APP_HOME%\lib\javassist-3.24.0-GA.jar;%APP_HOME%\lib\antlr-2.7.7.jar;%APP_HOME%\lib\jandex-2.1.1.Final.jar;%APP_HOME%\lib\classmate-1.5.1.jar;%APP_HOME%\lib\dom4j-2.1.1.jar;%APP_HOME%\lib\jersey-apache-client4-1.19.1.jar;%APP_HOME%\lib\httpclient-4.5.11.jar;%APP_HOME%\lib\commons-codec-1.13.jar;%APP_HOME%\lib\commons-collections4-4.4.jar;%APP_HOME%\lib\commons-math3-3.6.1.jar;%APP_HOME%\lib\SparseBitSet-1.2.jar;%APP_HOME%\lib\xmlbeans-3.1.0.jar;%APP_HOME%\lib\jasypt-1.9.2.jar;%APP_HOME%\lib\spring-cloud-context-2.1.2.RELEASE.jar;%APP_HOME%\lib\spring-cloud-commons-2.1.2.RELEASE.jar;%APP_HOME%\lib\spring-security-rsa-1.0.7.RELEASE.jar;%APP_HOME%\lib\micrometer-core-1.3.5.jar;%APP_HOME%\lib\spring-cloud-netflix-ribbon-2.1.2.RELEASE.jar;%APP_HOME%\lib\rxjava-reactive-streams-1.2.1.jar;%APP_HOME%\lib\rxjava-1.3.8.jar;%APP_HOME%\lib\spring-cloud-netflix-archaius-2.1.2.RELEASE.jar;%APP_HOME%\lib\commons-configuration-1.8.jar;%APP_HOME%\lib\commons-io-2.4.jar;%APP_HOME%\lib\spring-jcl-5.2.4.RELEASE.jar;%APP_HOME%\lib\jackson-annotations-2.10.2.jar;%APP_HOME%\lib\txw2-2.3.2.jar;%APP_HOME%\lib\FastInfoset-1.2.16.jar;%APP_HOME%\lib\httpcore-4.4.13.jar;%APP_HOME%\lib\javax.inject-1.jar;%APP_HOME%\lib\spring-security-crypto-5.2.2.RELEASE.jar;%APP_HOME%\lib\bcpkix-jdk15on-1.60.jar;%APP_HOME%\lib\HdrHistogram-2.1.11.jar;%APP_HOME%\lib\LatencyUtils-2.0.3.jar;%APP_HOME%\lib\commons-lang3-3.9.jar;%APP_HOME%\lib\json-smart-2.3.jar;%APP_HOME%\lib\accessors-smart-1.2.jar;%APP_HOME%\lib\asm-5.0.4.jar;%APP_HOME%\lib\reactive-streams-1.0.3.jar;%APP_HOME%\lib\annotations-2.0.0.jar;%APP_HOME%\lib\commons-lang-2.6.jar;%APP_HOME%\lib\commons-collections-3.2.2.jar;%APP_HOME%\lib\jersey-client-1.19.1.jar;%APP_HOME%\lib\logback-core-1.2.3.jar;%APP_HOME%\lib\log4j-api-2.12.1.jar;%APP_HOME%\lib\bcprov-jdk15on-1.60.jar;%APP_HOME%\lib\jersey-core-1.19.1.jar;%APP_HOME%\lib\jsr311-api-1.1.1.jar

@rem Execute springboot-webatoz
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %SPRINGBOOT_WEBATOZ_OPTS%  -classpath "%CLASSPATH%" com.webatoz.backend.WebatozApplication %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable SPRINGBOOT_WEBATOZ_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%SPRINGBOOT_WEBATOZ_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
