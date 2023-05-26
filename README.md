# Template Android

## Requirements to compile and run the project

In order to compile and run the project you need some configuration and property files.

[Required Files](https://drive.google.com/drive/folders/1SrTVzbMgHHCIkGMigzuZMa8ct-aGrREf?usp=sharing)

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

### Why Clean Architecture?

- ```Loose coupling between the code``` - The code can easily be modified without affecting any or a
  large part of the app's codebase thus easier to scale the application later on.
- Easier to ```test``` code.
- ```Separation of Concern``` - Different modules have specific responsibilities making it easier
  for modification and maintenance.

### S.O.L.I.D Principles

- [__Single Responsibility__](https://en.wikipedia.org/wiki/Single-responsibility_principle): Each software component should have only one reason to change – one responsibility.

- [__Open-Closed__](https://en.wikipedia.org/wiki/Open%E2%80%93closed_principle#:~:text=In%20object%2Doriented%20programming%2C%20the,without%20modifying%20its%20source%20code.): You should be able to extend the behavior of a component, without breaking its usage, or modifying its extensions.

- [__Liskov Substitution__](https://en.wikipedia.org/wiki/Liskov_substitution_principle): If you have a class of one type, and any subclasses of that class, you should be able to represent the base class usage with the subclass, without breaking the app.

- [__Interface Segregation__](https://en.wikipedia.org/wiki/Interface_segregation_principle): It’s better to have many smaller interfaces than a large one, to prevent the class from implementing the methods that it doesn’t need.

- [__Dependency Inversion__](https://en.wikipedia.org/wiki/Dependency_inversion_principle): Components should depend on abstractions rather than concrete implementations. Also higher level modules shouldn’t depend on lower level modules.

## Project Structure - Layers

### App

The `app/` layer is responsible for common and general properties.

### Build source

The `buildSrc/` layer is responsible for dependency management. It control and manage all
dependencies in one place with Kotlin.

### Core

- `common/`
- `data/`
  - `di/`
    - `feature/`
      - FeatureDataModule
  - `model/`
    - `feature/`
      - FeatureResponseExtension (extension to entity model, extension from entity model to data model)
  - `repository/`
    - `feature/`
      - `source/`
        - FeatureFirebaseDataSource
        - FeatureLocalDataSource
        - FeatureRemoteDataSource
        - FeatureDataSource
      - DefaultFeatureRepository
      - FeatureRepository
- `database/`
  - `dao/`
    - FeatureDao
  - `di/`
    - DatabaseModule
    - `feature/`
      - FeatureDaoModule
  - `migrations/`
    - `feature/`
      - Schema1To2 : AutoMigrationSpec
  - `model/`
    - FeatureEntity
  - AppDatabase
- `datastore/`
  - `di/`
    - `feature/`
      - FeatureDataStoreModule
  - `feature/`
    - FeatureDataStore
- `domain/`
  - `feature/`
    - CreateFeatureUseCase
    - ReadFeatureUseCase
    - UpdateFeatureUseCase
    - DeleteFeatureUseCase
- `model/`
  - FeatureDataModel
- `network/`
  - `di/`
    - `feature/`
      - FeatureNetworkModule
    - NetworkModule
  - `model/`
    - `request/`
      - FeatureRequest
    - `response/`
      - FeatureResponse
  - `retrofit/`
    - `feature/`
      - FeatureNetworkApi
- `utils/`
  - `helpers/`
  - `extensions/`

### Feature
- `feature/`
  - FeatureScreen | FeatureFragment | FeatureActivity
  - FeatureViewModel

### Package naming convention
DO NOT! Use:
- snake case (eg. number_of_donuts)
- kebab case (eg. number-of-donuts)
- camel case (eg. numberOfDonuts)
- pascal case (eg. NumberOfDonuts)

### Resources naming convention
- `resources/`
  - `color/`
    - `outline_primary.xml`
  - `drawables/`
    - `selector_button_primary.xml`
    - `shape_circle_4dp.xml`
    - `dialog_top_radius_4dp.xml`
    - `ic_feature_logo.(xml or webp)`
    - `image_feature_header.(xml or webp)`
    - `image_feature_background.(xml or webp)`
  - `layout/`
    - `activity_feature.xml`
    - `fragment_feature.xml`
    - `layout_feature.xml`
    - `item_feature.xml`
    - `dialog_feature.xml`

## Branch naming convention

- `main/`: (default)
  - `hotfix/`: is for changing code with a temporary solution and/or without following the usual
    process (usually because of an emergency)
- `preproduction/`
- `staging/`
- `develop/`
  - `feature/`: is for adding, refactoring or removing a feature
  - `bugfix/`:  is for fixing a bug

## Commit naming convention

- `build`: Build related changes (eg: npm related/ adding external dependencies)
- `chore`: A code change that external user won't see (eg: change to .gitignore file or .prettierrc
  file)
- `feat`: A new feature
- `fix`: A bug fix
- `docs`: Documentation related changes
- `refactor`: A code that neither fix bug nor adds a feature. (eg: You can use this when there is
  semantic changes like renaming a variable/ function name)
- `perf`: A code that improves performance
- `style`: A code that is related to styling
- `test`: Adding new test or making changes to existing test

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