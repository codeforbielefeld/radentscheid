<template>
  <div class="area-comparison">
    <no-ssr>
      <div class="area-comparison__map">
        <l-map v-bind="{ zoom, center }">
          <l-control-layers />
          <l-tile-layer url="http://{s}.tile.osm.org/{z}/{x}/{y}.png" />
          <l-geo-json v-if="geojsonEnabled" v-bind="{ geojson }" />
        </l-map>
      </div>

      <div class="area-comparison__controls">
        <v-checkbox v-model="geojsonEnabled" label="GeoJSON" />
      </div>
    </no-ssr>
  </div>
</template>

<script>
import flurstueckeSubset from './json/flurstuecke_wgs84_small.json'

// eslint-disable-next-line
import flurstueckeAll from './json/flurstuecke_wgs84.json'

export default {
  name: 'AreaComparison',

  data: () => ({
    center: [52.029, 8.533],
    geojson: flurstueckeSubset,
    geojsonEnabled: true,
    zoom: 12
  })
}
</script>

<style>
.area-comparison {
  display: flex;
  flex-direction: column;
  height: 100%;
}

.area-comparison__map {
  height: 80vh;
}

.area-comparison__controls {
  display: flex;
}
</style>>
