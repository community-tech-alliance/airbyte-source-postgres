# Postgres Source - CTA STYLE

## What is this?

This is CTA's patched version of Airbyte's Postgres source connector. We have made some small tweaks that, for various reasons, have not been merged into the code for the officially supported connector.

## News u can use

As of 11/1/2023:

**Dockerhub image:** `communitytechalliance/airbyte-source-postgres-patch:0.0.4`
**Corresponds to official source version:** 3.2.16
**Compiled using Airbyte version:** 0.50.33

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