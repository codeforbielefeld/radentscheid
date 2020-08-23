# Unfallserver

Der Unfallserver liefert die aufbereiteten Unfalldaten mit Radbeteilung als vereinheitlichtes JSON.
Daneben liefert er 'Heatmaps' in Form von PNG Bildern aus, die als Overlay z.B. in Leaflet genutzt werden können.

# Getting Started

## Build 

```
$ ./gradlew build
```

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

![tile_14_8581_5409](https://github.com/codeforbielefeld/radentscheid/tree/master/unfallserver/documentation/tile_14_8581_5409.png)
