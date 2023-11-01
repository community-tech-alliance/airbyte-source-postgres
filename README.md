# Postgres Source - CTA STYLE

## What is this?

This is CTA's patched version of Airbyte's Postgres source connector. We have made some small tweaks that, for various reasons, have not been merged into the code for the officially supported connector.

## News u can use

As of 11/1/2023:

**Dockerhub image:** `communitytechalliance/airbyte-source-postgres-patch:0.0.3`
**Corresponds to official source version:** 3.1.3
**Compiled using Airbyte version:** 0.52.0

## Files changed in CTA patch

As of 11/1/2023, our "patch" only modifies two files:

[src/main/resources/spec.json](src/main/resources/spec.json) - this is where we added the `require` SSL mode (needed to connect to Blocks)
[src/main/java/io/airbyte/integrations/source/postgres/cdc/PostgresCdcProperties.java](src/main/java/io/airbyte/integrations/source/postgres/cdc/PostgresCdcProperties.java) - increased heartbeat timeout (`HEARTBEAT_FREQUENCY_SEC`) to 20 seconds.

## How to make further changes

Since this is a Java source connector, you have to compile the source connector in Gradle before you can build the docker image and push it to Dockerhub. This requires some fiddly manual steps because you need to use the `airbyte` repo in order to run the `gradle` commands to compile the image.

Thus you must take the following steps on your journey to further modify the source connector:

1) Copy the [airbyte repository](https://github.com/airbytehq/airbyte) to your machine. (Download a ZIP, clone the repo, whatever you want. We aren't going to version-control this - we just need to have the files available in order to run `gradle` commands.)
2) `cd` into the `airbyte` folder. You know, the stuff you just downloaded.
3) Try running this command to make sure the officially supported postgres source builds successfully: `./gradlew :airbyte-integrations:connectors:source-postgres:build` 
4) NOTE that when running a `gradle build` command, first it compiles the source connector image, and then it runs a bunch of integration tests. We only really care about whether it can build the image successfully. I mean, tests are fine, but they take forever. So: keep an eye on the logs and once it starts running tests, that means it successfully compiled the image. Hooray!
5) Swap out the files we need to change.
6) Run this again: `./gradlew :airbyte-integrations:connectors:source-postgres:build`
7) If the image is compiled successfully, build the docker image and push it to CTA's dockerhub account! Make sure you are authenticated using the creds in 1Password.

```shell
cd airbyte-integrations/connectors/source-postgres/
docker login
docker build . -t communitytechalliance/airbyte-source-postgres-patch:TAG
docker push -t communitytechalliance/airbyte-source-postgres-patch:TAG
```

## Gradle what?

It may surprise you to learn that in order to run `gradle` commands, you need to install `gradle`. Airbyte does not provide guidance on this, but you can start [here](https://gradle.org/install/) to install gradle, and also make sure you have the right Java SDK installed. As of writing, that would be Java SDK version 17 - you can see the latest in the build.gradle file of the airbyte repo ([here](https://github.com/airbytehq/airbyte/blob/master/build.gradle#L439-L442)). You might hit additional errors, and sadly you are on your own. Please take notes here if you make any useful discoveries!

## Testing the source connector locally

If you want to iterate more quickly, you will need to build Airbyte locally and swap out the source connector image in your local deployment.

1. from the top level of `airbyte`, run: `./run-ab-platform.sh`
2. Follow the steps above to gradle-build your modified source connector.
3. Build a docker image, but name it `airbyte/source-postgres` instead of `communitytechalliance/...`. Tag it with whatever. `dev` maybe?
4. Within your local Airbyte deployment, update the version of the Postgres source connector to whatever you tagged it in step 3.
5. Test the connector.

Rinse and repeat etcet.

# The end

Thus concludes CTA's notes about custom source development for Java based sources. What follows below is the documentation that Airbyte originally provided for this source connector. It probably will not help you.

***

# Airbyte documentation (probably not helpful)

## Performance Test

To run performance tests in commandline:
```shell
./gradlew :airbyte-integrations:connectors:source-postgres:performanceTest [--cpulimit=cpulimit/<limit>] [--memorylimit=memorylimit/<limit>]
```

In pull request:
```shell
/test-performance connector=connectors/source-postgres [--cpulimit=cpulimit/<limit>] [--memorylimit=memorylimit/<limit>]
```

- `cpulimit`: Limit the number of CPUs. The minimum is `2`. E.g. `--cpulimit=cpulimit/2`.
- `memorylimit`: Limit the size of the memory. Must include the unit at the end (e.g. `MB`, `GB`). The minimum size is `6MB`. E.g. `--memorylimit=memorylimit/4GB`.
- When none of the CPU or memory limit is provided, the performance tests will run without memory or CPU limitations. The available resource will be bound that those specified in `ResourceRequirements.java`.

### Use Postgres script to populate the benchmark database

In order to create a database with a certain number of tables, and a certain number of records in each of them, 
you need to follow a few simple steps.

1. Create a new database.
2. Follow the TODOs in [3-run-script.sql](src/test-performance/sql/3-run-script.sql) to change the number of tables, and the number of records of different sizes.
3. On the new database, run the following script:
   ```shell
   cd airbyte-integrations/connectors/source-postgres
   psql -h <host> -d <db-name> -U <username> -p <port> -a -q -f src/test-performance/sql/1-create-copy-tables-procedure.sql
   psql -h <host> -d <db-name> -U <username> -p <port> -a -q -f src/test-performance/sql/2-create-insert-rows-to-table-procedure.sql
   psql -h <host> -d <db-name> -U <username> -p <port> -a -q -f src/test-performance/sql/3-run-script.sql
   ```
4. After the script finishes, you will receive the number of tables specified in the script, with names starting with **test_0** and ending with **test_(the number of tables minus 1)**.
