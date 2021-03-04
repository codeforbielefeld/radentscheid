# Unfallserver

Der Unfallserver liefert die aufbereiteten Unfalldaten mit Radbeteilung als vereinheitlichtes JSON.
Daneben liefert er 'Heatmaps' in Form von PNG Bildern aus, die als Overlay z.B. in Leaflet genutzt werden können.

# Getting Started

## Build
### Linux
```
$ ./gradlew build
```
### Windows
```
$ gradlew build
```
Error: Could not target platform: 'Java SE 11' using tool chain: 'JDK 8 (1.8)'.
--> Change sourceCompatibility in build.gradle from '11' to '8' and use java 8 as project sdk (files -> project 
structure)

## Run
```
$ java -jar ./build/libs/unfallserver-0.0.1-SNAPSHOT.jar
```

## Test
```
$ curl http://localhost:8080/api/accident
```

```
$ curl http://localhost:8080/tiles/14/8581/5409.png > tile_14_8581_5409.png
```

![tile_14_8581_5409](https://raw.githubusercontent.com/codeforbielefeld/radentscheid/master/unfallserver/documentation/tile_14_8581_5409.png)
