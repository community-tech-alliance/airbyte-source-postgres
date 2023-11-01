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

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  source-postgres startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
@rem This is normally unused
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and SOURCE_POSTGRES_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS="-XX:+ExitOnOutOfMemoryError" "-XX:MaxRAMPercentage=75.0"

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\io.airbyte.airbyte-integrations.connectors-source-postgres-0.50.19.jar;%APP_HOME%\lib\2df95229b6fda70326096e9de704377d;%APP_HOME%\lib\io.airbyte.airbyte-integrations.bases-debezium-0.50.19.jar;%APP_HOME%\lib\io.airbyte.airbyte-integrations.connectors-source-jdbc-0.50.19.jar;%APP_HOME%\lib\io.airbyte.airbyte-integrations.connectors-source-relational-db-0.50.19.jar;%APP_HOME%\lib\io.airbyte.airbyte-db-db-lib-0.50.19.jar;%APP_HOME%\lib\io.airbyte.airbyte-integrations.bases-base-java-0.50.19.jar;%APP_HOME%\lib\f03175fea38c0c19f21b6ec5ba760257;%APP_HOME%\lib\io.airbyte.airbyte-config-oss-config-models-oss-0.50.19.jar;%APP_HOME%\lib\io.airbyte-airbyte-json-validation-0.50.19.jar;%APP_HOME%\lib\io.airbyte-airbyte-commons-cli-0.50.19.jar;%APP_HOME%\lib\io.airbyte-airbyte-commons-0.50.19.jar;%APP_HOME%\lib\protocol-models-0.3.6.jar;%APP_HOME%\lib\appender-log4j2-3.6.0.jar;%APP_HOME%\lib\appender-core-3.6.0.jar;%APP_HOME%\lib\elasticsearch-rest-high-level-client-7.11.1.jar;%APP_HOME%\lib\elasticsearch-7.11.1.jar;%APP_HOME%\lib\elasticsearch-x-content-7.11.1.jar;%APP_HOME%\lib\jackson-dataformat-yaml-2.14.1.jar;%APP_HOME%\lib\debezium-embedded-2.2.0.Final.jar;%APP_HOME%\lib\debezium-connector-sqlserver-2.2.0.Final.jar;%APP_HOME%\lib\debezium-connector-mysql-2.2.0.Final.jar;%APP_HOME%\lib\debezium-connector-postgres-2.2.0.Final.jar;%APP_HOME%\lib\debezium-connector-mongodb-2.2.0.Final.jar;%APP_HOME%\lib\debezium-storage-kafka-2.2.0.Final.jar;%APP_HOME%\lib\debezium-storage-file-2.2.0.Final.jar;%APP_HOME%\lib\debezium-ddl-parser-2.2.0.Final.jar;%APP_HOME%\lib\debezium-core-2.2.0.Final.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.14.1.jar;%APP_HOME%\lib\aws-java-sdk-s3-1.12.6.jar;%APP_HOME%\lib\aws-java-sdk-kms-1.12.6.jar;%APP_HOME%\lib\aws-java-sdk-core-1.12.6.jar;%APP_HOME%\lib\jmespath-java-1.12.6.jar;%APP_HOME%\lib\jackson-dataformat-cbor-2.14.1.jar;%APP_HOME%\lib\json-schema-validator-1.0.72.jar;%APP_HOME%\lib\jackson-json-reference-core-0.3.2.jar;%APP_HOME%\lib\connect-runtime-3.4.0.jar;%APP_HOME%\lib\connect-json-3.4.0.jar;%APP_HOME%\lib\kafka-tools-3.4.0.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.14.1.jar;%APP_HOME%\lib\jackson-jaxrs-json-provider-2.14.1.jar;%APP_HOME%\lib\jackson-jaxrs-base-2.14.1.jar;%APP_HOME%\lib\jackson-module-jaxb-annotations-2.14.1.jar;%APP_HOME%\lib\jackson-databind-2.14.1.jar;%APP_HOME%\lib\jdbc-1.15.3.jar;%APP_HOME%\lib\database-commons-1.15.3.jar;%APP_HOME%\lib\testcontainers-1.15.3.jar;%APP_HOME%\lib\docker-java-api-3.2.8.jar;%APP_HOME%\lib\jackson-annotations-2.14.1.jar;%APP_HOME%\lib\google-cloud-bigquery-1.133.1.jar;%APP_HOME%\lib\jackson-core-2.14.1.jar;%APP_HOME%\lib\google-cloud-storage-2.17.2.jar;%APP_HOME%\lib\google-api-client-2.2.0.jar;%APP_HOME%\lib\google-oauth-client-1.34.1.jar;%APP_HOME%\lib\google-http-client-gson-1.42.3.jar;%APP_HOME%\lib\google-http-client-apache-v2-1.42.3.jar;%APP_HOME%\lib\google-http-client-1.42.3.jar;%APP_HOME%\lib\opencensus-contrib-http-util-0.31.1.jar;%APP_HOME%\lib\guava-31.1-jre.jar;%APP_HOME%\lib\commons-io-2.11.0.jar;%APP_HOME%\lib\commons-compress-1.20.jar;%APP_HOME%\lib\maven-artifact-3.8.4.jar;%APP_HOME%\lib\commons-lang3-3.11.jar;%APP_HOME%\lib\log4j-slf4j-impl-2.17.2.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.36.jar;%APP_HOME%\lib\sshd-mina-2.8.0.jar;%APP_HOME%\lib\sshd-core-2.8.0.jar;%APP_HOME%\lib\sshd-common-2.8.0.jar;%APP_HOME%\lib\jcl-over-slf4j-1.7.36.jar;%APP_HOME%\lib\log4j-over-slf4j-1.7.36.jar;%APP_HOME%\lib\dd-trace-ot-0.111.0.jar;%APP_HOME%\lib\json-path-2.7.0.jar;%APP_HOME%\lib\s3-2.20.20.jar;%APP_HOME%\lib\aws-xml-protocol-2.20.20.jar;%APP_HOME%\lib\aws-query-protocol-2.20.20.jar;%APP_HOME%\lib\protocol-core-2.20.20.jar;%APP_HOME%\lib\aws-core-2.20.20.jar;%APP_HOME%\lib\auth-2.20.20.jar;%APP_HOME%\lib\regions-2.20.20.jar;%APP_HOME%\lib\sdk-core-2.20.20.jar;%APP_HOME%\lib\arns-2.20.20.jar;%APP_HOME%\lib\profiles-2.20.20.jar;%APP_HOME%\lib\apache-client-2.20.20.jar;%APP_HOME%\lib\netty-nio-client-2.20.20.jar;%APP_HOME%\lib\http-client-spi-2.20.20.jar;%APP_HOME%\lib\metrics-spi-2.20.20.jar;%APP_HOME%\lib\json-utils-2.20.20.jar;%APP_HOME%\lib\utils-2.20.20.jar;%APP_HOME%\lib\HikariCP-5.0.1.jar;%APP_HOME%\lib\debezium-api-2.2.0.Final.jar;%APP_HOME%\lib\micronaut-inject-java-3.8.3.jar;%APP_HOME%\lib\mina-core-2.0.21.jar;%APP_HOME%\lib\docker-java-transport-zerodep-3.2.8.jar;%APP_HOME%\lib\connect-file-3.4.0.jar;%APP_HOME%\lib\connect-transforms-3.4.0.jar;%APP_HOME%\lib\connect-api-3.4.0.jar;%APP_HOME%\lib\micronaut-aop-3.8.3.jar;%APP_HOME%\lib\micronaut-inject-3.8.3.jar;%APP_HOME%\lib\kafka-server-common-3.4.0.jar;%APP_HOME%\lib\kafka-clients-3.4.0.jar;%APP_HOME%\lib\jose4j-0.7.9.jar;%APP_HOME%\lib\micronaut-core-3.8.3.jar;%APP_HOME%\lib\metrics-core-2.2.0.jar;%APP_HOME%\lib\slf4j-api-1.7.36.jar;%APP_HOME%\lib\log4j-web-2.17.2.jar;%APP_HOME%\lib\spotbugs-annotations-4.7.3.jar;%APP_HOME%\lib\log4j-layout-template-json-2.17.2.jar;%APP_HOME%\lib\log4j-core-2.17.2.jar;%APP_HOME%\lib\log4j-api-2.17.2.jar;%APP_HOME%\lib\postgresql-42.5.1.jar;%APP_HOME%\lib\dd-trace-api-0.111.0.jar;%APP_HOME%\lib\jackson-dataformat-smile-2.14.1.jar;%APP_HOME%\lib\jersey-container-servlet-2.34.jar;%APP_HOME%\lib\jersey-hk2-2.34.jar;%APP_HOME%\lib\jersey-container-servlet-core-2.34.jar;%APP_HOME%\lib\jersey-server-2.34.jar;%APP_HOME%\lib\jersey-client-2.34.jar;%APP_HOME%\lib\jersey-common-2.34.jar;%APP_HOME%\lib\snakeyaml-1.33.jar;%APP_HOME%\lib\failureaccess-1.0.1.jar;%APP_HOME%\lib\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;%APP_HOME%\lib\protobuf-java-util-3.21.12.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\checker-qual-3.29.0.jar;%APP_HOME%\lib\api-common-2.5.0.jar;%APP_HOME%\lib\error_prone_annotations-2.18.0.jar;%APP_HOME%\lib\j2objc-annotations-1.3.jar;%APP_HOME%\lib\google-http-client-jackson2-1.42.3.jar;%APP_HOME%\lib\elasticsearch-rest-client-7.11.1.jar;%APP_HOME%\lib\httpclient-4.5.14.jar;%APP_HOME%\lib\commons-codec-1.15.jar;%APP_HOME%\lib\google-api-services-storage-v1-rev20220705-2.0.0.jar;%APP_HOME%\lib\gson-2.10.1.jar;%APP_HOME%\lib\google-cloud-core-2.9.4.jar;%APP_HOME%\lib\auto-value-annotations-1.10.1.jar;%APP_HOME%\lib\google-cloud-core-http-2.9.4.jar;%APP_HOME%\lib\google-http-client-appengine-1.42.3.jar;%APP_HOME%\lib\gax-httpjson-0.107.0.jar;%APP_HOME%\lib\google-cloud-core-grpc-2.9.4.jar;%APP_HOME%\lib\gax-2.22.0.jar;%APP_HOME%\lib\gax-grpc-2.22.0.jar;%APP_HOME%\lib\grpc-alts-1.52.1.jar;%APP_HOME%\lib\grpc-grpclb-1.52.1.jar;%APP_HOME%\lib\conscrypt-openjdk-uber-2.5.2.jar;%APP_HOME%\lib\grpc-auth-1.52.1.jar;%APP_HOME%\lib\grpc-protobuf-1.52.1.jar;%APP_HOME%\lib\grpc-protobuf-lite-1.52.1.jar;%APP_HOME%\lib\google-auth-library-credentials-1.14.0.jar;%APP_HOME%\lib\google-auth-library-oauth2-http-1.14.0.jar;%APP_HOME%\lib\auto-value-1.10.1.jar;%APP_HOME%\lib\javax.annotation-api-1.3.2.jar;%APP_HOME%\lib\opencensus-api-0.31.1.jar;%APP_HOME%\lib\grpc-context-1.52.1.jar;%APP_HOME%\lib\proto-google-iam-v1-1.8.0.jar;%APP_HOME%\lib\mysql-connector-java-8.0.30.jar;%APP_HOME%\lib\proto-google-common-protos-2.13.0.jar;%APP_HOME%\lib\protobuf-java-3.21.12.jar;%APP_HOME%\lib\threetenbp-1.6.5.jar;%APP_HOME%\lib\proto-google-cloud-storage-v2-2.17.2-alpha.jar;%APP_HOME%\lib\grpc-google-cloud-storage-v2-2.17.2-alpha.jar;%APP_HOME%\lib\gapic-google-cloud-storage-v2-2.17.2-alpha.jar;%APP_HOME%\lib\grpc-api-1.52.1.jar;%APP_HOME%\lib\grpc-netty-shaded-1.52.1.jar;%APP_HOME%\lib\perfmark-api-0.26.0.jar;%APP_HOME%\lib\grpc-core-1.52.1.jar;%APP_HOME%\lib\annotations-4.1.1.4.jar;%APP_HOME%\lib\animal-sniffer-annotations-1.22.jar;%APP_HOME%\lib\grpc-stub-1.52.1.jar;%APP_HOME%\lib\grpc-googleapis-1.52.1.jar;%APP_HOME%\lib\grpc-xds-1.52.1.jar;%APP_HOME%\lib\opencensus-proto-0.2.0.jar;%APP_HOME%\lib\grpc-services-1.52.1.jar;%APP_HOME%\lib\re2j-1.7.jar;%APP_HOME%\lib\endpoints-spi-2.20.20.jar;%APP_HOME%\lib\annotations-2.20.20.jar;%APP_HOME%\lib\jooq-meta-3.13.4.jar;%APP_HOME%\lib\jooq-3.13.4.jar;%APP_HOME%\lib\flyway-core-7.14.0.jar;%APP_HOME%\lib\jna-platform-5.8.0.jar;%APP_HOME%\lib\visible-assertions-2.1.2.jar;%APP_HOME%\lib\jna-5.8.0.jar;%APP_HOME%\lib\lombok-1.18.20.jar;%APP_HOME%\lib\mongodb-driver-sync-4.7.1.jar;%APP_HOME%\lib\terajdbc4-17.20.00.12.jar;%APP_HOME%\lib\commons-cli-1.4.jar;%APP_HOME%\lib\eddsa-0.3.0.jar;%APP_HOME%\lib\bcpkix-jdk15on-1.66.jar;%APP_HOME%\lib\bctls-jdk15on-1.66.jar;%APP_HOME%\lib\bcprov-jdk15on-1.66.jar;%APP_HOME%\lib\plexus-utils-3.4.2.jar;%APP_HOME%\lib\validation-api-1.1.0.Final.jar;%APP_HOME%\lib\opentracing-util-0.32.0.jar;%APP_HOME%\lib\opentracing-noop-0.32.0.jar;%APP_HOME%\lib\opentracing-tracerresolver-0.1.0.jar;%APP_HOME%\lib\opentracing-api-0.32.0.jar;%APP_HOME%\lib\okhttp-3.12.12.jar;%APP_HOME%\lib\moshi-1.11.0.jar;%APP_HOME%\lib\okio-1.17.5.jar;%APP_HOME%\lib\jctools-core-3.3.0.jar;%APP_HOME%\lib\sketches-java-0.8.2.jar;%APP_HOME%\lib\java-dogstatsd-client-4.0.0.jar;%APP_HOME%\lib\jnr-unixsocket-0.36.jar;%APP_HOME%\lib\jnr-posix-3.1.15.jar;%APP_HOME%\lib\json-smart-2.4.7.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\ion-java-1.0.2.jar;%APP_HOME%\lib\joda-time-2.10.4.jar;%APP_HOME%\lib\reactive-streams-1.0.3.jar;%APP_HOME%\lib\eventstream-1.0.1.jar;%APP_HOME%\lib\third-party-jackson-core-2.20.20.jar;%APP_HOME%\lib\httpcore-4.4.16.jar;%APP_HOME%\lib\netty-codec-http2-4.1.86.Final.jar;%APP_HOME%\lib\netty-codec-http-4.1.86.Final.jar;%APP_HOME%\lib\netty-handler-4.1.86.Final.jar;%APP_HOME%\lib\netty-codec-4.1.86.Final.jar;%APP_HOME%\lib\netty-transport-classes-epoll-4.1.86.Final.jar;%APP_HOME%\lib\netty-transport-native-unix-common-4.1.86.Final.jar;%APP_HOME%\lib\netty-transport-4.1.86.Final.jar;%APP_HOME%\lib\netty-buffer-4.1.86.Final.jar;%APP_HOME%\lib\netty-resolver-4.1.86.Final.jar;%APP_HOME%\lib\netty-common-4.1.86.Final.jar;%APP_HOME%\lib\jaxb-api-2.3.1.jar;%APP_HOME%\lib\jakarta.annotation-api-2.1.1.jar;%APP_HOME%\lib\checker-compat-qual-2.5.5.jar;%APP_HOME%\lib\google-api-services-bigquery-v2-rev20210529-1.31.0.jar;%APP_HOME%\lib\mongodb-driver-core-4.7.1.jar;%APP_HOME%\lib\bson-record-codec-4.7.1.jar;%APP_HOME%\lib\bson-4.7.1.jar;%APP_HOME%\lib\junit-4.12.jar;%APP_HOME%\lib\duct-tape-1.0.8.jar;%APP_HOME%\lib\mssql-jdbc-10.2.1.jre8.jar;%APP_HOME%\lib\mysql-binlog-connector-java-0.27.2.jar;%APP_HOME%\lib\mysql-connector-j-8.0.32.jar;%APP_HOME%\lib\jnr-enxio-0.30.jar;%APP_HOME%\lib\jnr-ffi-2.2.11.jar;%APP_HOME%\lib\jnr-constants-0.10.3.jar;%APP_HOME%\lib\accessors-smart-2.4.7.jar;%APP_HOME%\lib\mapper-extras-client-7.11.1.jar;%APP_HOME%\lib\parent-join-client-7.11.1.jar;%APP_HOME%\lib\aggs-matrix-stats-client-7.11.1.jar;%APP_HOME%\lib\rank-eval-client-7.11.1.jar;%APP_HOME%\lib\lang-mustache-client-7.11.1.jar;%APP_HOME%\lib\javax.activation-api-1.2.0.jar;%APP_HOME%\lib\itu-1.7.0.jar;%APP_HOME%\lib\hamcrest-core-1.3.jar;%APP_HOME%\lib\docker-java-transport-3.2.8.jar;%APP_HOME%\lib\javax.ws.rs-api-2.1.1.jar;%APP_HOME%\lib\reload4j-1.2.19.jar;%APP_HOME%\lib\activation-1.1.1.jar;%APP_HOME%\lib\jetty-servlet-9.4.48.v20220622.jar;%APP_HOME%\lib\jetty-security-9.4.48.v20220622.jar;%APP_HOME%\lib\jetty-server-9.4.48.v20220622.jar;%APP_HOME%\lib\jetty-servlets-9.4.48.v20220622.jar;%APP_HOME%\lib\jetty-client-9.4.48.v20220622.jar;%APP_HOME%\lib\reflections-0.9.12.jar;%APP_HOME%\lib\swagger-annotations-2.2.0.jar;%APP_HOME%\lib\antlr4-runtime-4.10.1.jar;%APP_HOME%\lib\zstd-jni-1.5.2-1.jar;%APP_HOME%\lib\jffi-1.3.9.jar;%APP_HOME%\lib\jffi-1.3.9-native.jar;%APP_HOME%\lib\asm-commons-9.2.jar;%APP_HOME%\lib\asm-util-9.2.jar;%APP_HOME%\lib\asm-analysis-9.2.jar;%APP_HOME%\lib\asm-tree-9.2.jar;%APP_HOME%\lib\asm-9.2.jar;%APP_HOME%\lib\jnr-a64asm-1.0.0.jar;%APP_HOME%\lib\jnr-x86asm-1.0.2.jar;%APP_HOME%\lib\elasticsearch-cli-7.11.1.jar;%APP_HOME%\lib\elasticsearch-core-7.11.1.jar;%APP_HOME%\lib\elasticsearch-secure-sm-7.11.1.jar;%APP_HOME%\lib\elasticsearch-geo-7.11.1.jar;%APP_HOME%\lib\lucene-core-8.7.0.jar;%APP_HOME%\lib\lucene-analyzers-common-8.7.0.jar;%APP_HOME%\lib\lucene-backward-codecs-8.7.0.jar;%APP_HOME%\lib\lucene-grouping-8.7.0.jar;%APP_HOME%\lib\lucene-highlighter-8.7.0.jar;%APP_HOME%\lib\lucene-join-8.7.0.jar;%APP_HOME%\lib\lucene-memory-8.7.0.jar;%APP_HOME%\lib\lucene-misc-8.7.0.jar;%APP_HOME%\lib\lucene-queries-8.7.0.jar;%APP_HOME%\lib\lucene-queryparser-8.7.0.jar;%APP_HOME%\lib\lucene-sandbox-8.7.0.jar;%APP_HOME%\lib\lucene-spatial-extras-8.7.0.jar;%APP_HOME%\lib\lucene-spatial3d-8.7.0.jar;%APP_HOME%\lib\lucene-suggest-8.7.0.jar;%APP_HOME%\lib\hppc-0.8.1.jar;%APP_HOME%\lib\t-digest-3.2.jar;%APP_HOME%\lib\HdrHistogram-2.1.9.jar;%APP_HOME%\lib\jna-5.5.0.jar;%APP_HOME%\lib\elasticsearch-plugin-classloader-7.11.1.jar;%APP_HOME%\lib\httpasyncclient-4.1.4.jar;%APP_HOME%\lib\httpcore-nio-4.4.12.jar;%APP_HOME%\lib\compiler-0.9.6.jar;%APP_HOME%\lib\jakarta.inject-api-2.0.1.jar;%APP_HOME%\lib\lz4-java-1.8.0.jar;%APP_HOME%\lib\snappy-java-1.1.8.4.jar;%APP_HOME%\lib\argparse4j-0.7.0.jar;%APP_HOME%\lib\javax.servlet-api-3.1.0.jar;%APP_HOME%\lib\jetty-http-9.4.48.v20220622.jar;%APP_HOME%\lib\jetty-io-9.4.48.v20220622.jar;%APP_HOME%\lib\jetty-util-ajax-9.4.48.v20220622.jar;%APP_HOME%\lib\jetty-continuation-9.4.48.v20220622.jar;%APP_HOME%\lib\jetty-util-9.4.48.v20220622.jar;%APP_HOME%\lib\javassist-3.26.0-GA.jar;%APP_HOME%\lib\jakarta.ws.rs-api-2.1.6.jar;%APP_HOME%\lib\hk2-locator-2.6.1.jar;%APP_HOME%\lib\jopt-simple-5.0.2.jar;%APP_HOME%\lib\hk2-api-2.6.1.jar;%APP_HOME%\lib\hk2-utils-2.6.1.jar;%APP_HOME%\lib\jakarta.inject-2.6.1.jar;%APP_HOME%\lib\osgi-resource-locator-1.0.3.jar;%APP_HOME%\lib\jakarta.validation-api-2.0.2.jar;%APP_HOME%\lib\aopalliance-repackaged-2.6.1.jar;%APP_HOME%\lib\jakarta.xml.bind-api-2.3.3.jar;%APP_HOME%\lib\jakarta.activation-api-1.2.2.jar


@rem Execute source-postgres
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %SOURCE_POSTGRES_OPTS%  -classpath "%CLASSPATH%" io.airbyte.integrations.source.postgres.PostgresSource %*

:end
@rem End local scope for the variables with windows NT shell
if %ERRORLEVEL% equ 0 goto mainEnd

:fail
rem Set variable SOURCE_POSTGRES_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
set EXIT_CODE=%ERRORLEVEL%
if %EXIT_CODE% equ 0 set EXIT_CODE=1
if not ""=="%SOURCE_POSTGRES_EXIT_CONSOLE%" exit %EXIT_CODE%
exit /b %EXIT_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
