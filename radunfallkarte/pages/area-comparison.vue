<template>
  <div class="area-comparison">
    <no-ssr>
      <l-map v-bind="{ zoom, center }">
        <l-control-layers />
        <l-tile-layer url="http://{s}.tile.osm.org/{z}/{x}/{y}.png" />
        <l-geo-json v-bind="{ geojson }" />
      </l-map>
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
    zoom: 12
  })
}
</script>

<style>
.area-comparison {
  height: 80vh;
}
</style>
