# Template Android

## Requirements to compile and run the project

In order to compile and run the project you need some configuration and property files.

[Required Files](https://drive.google.com/drive/u/0/folders/1AqcmMemMHaxP3r7K0JNNBs_MX7hqGSAn)

After cloning the project create a `configs` folder on the root directory of the project then
download all the properties file on the given link above.

NOTE: For the new contributors you need to request access on the given link in order to download the
properties files.

You also need the `google-services.json` file that contains the firebase configuration.
Add it on the app folder. You can access that also on the given link above as well.

One last thing is the `keystore.properties` file add that as well on the root.

## Guide to app architecture

This guide encompasses best practices
and [recommended architecture](https://developer.android.com/topic/architecture#recommended-app-arch)
for building robust, high-quality apps.

## Build

This project has multiple build variants. Each environments is connected on different API.

- Develop - A development environment is a place where software applications and services are
  created and developed. An application or service is gradually built up piece by piece in this
  space, where developers write, test, and debug code. Prototyping and experiments are often
  conducted in the development environment, which is typically more flexible and dynamic than the
  production or testing environment.
- Staging - Testing environments are simulated versions of production environments where developers
  and quality assurance (QA) professionals can test a new application or service for functionality,
  performance, and reliability before releasing it to the general public. Test environments often
  mirror images of production environments, but with some key differences. In order to simulate the
  production environment more accurately, for example, the testing environment may have different
  hardware and software configurations.
- Production - A production environment is where software applications and services are deployed and
  made available to end users. It is a live environment where the application or service is used for
  its intended purpose, and users can access it through the Internet or other means.