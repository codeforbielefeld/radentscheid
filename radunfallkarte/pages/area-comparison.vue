<template>
  <div class="area-comparison">
    <no-ssr>
      <div class="area-comparison__map">
        <l-map v-bind="{ zoom, center }">
          <l-control-layers />
          <l-tile-layer url="http://{s}.tile.osm.org/{z}/{x}/{y}.png" />
          <l-geo-json v-if="geojsonEnabled" v-bind="{ geojson }" />
          <template v-if="wmsEnabled">
            <l-lwms-tile-layer
              v-for="layer in wms.layers"
              :key="layer.name"
              :base-url="wms.baseUrl"
              :format="layer.format"
              :layers="layer.layers"
              :name="layer.name"
            />
          </template>
        </l-map>
      </div>

      <div class="area-comparison__controls">
        <v-checkbox v-model="geojsonEnabled" label="GeoJSON" />
        <v-checkbox v-model="wmsEnabled" label="WMS (need to zoom)" />
      </div>
    </no-ssr>
  </div>
</template>

<script>
import flurstueckeSubset from './json/flurstuecke_wgs84_small.json'

// eslint-disable-next-line
import flurstueckeAll from './json/flurstuecke_wgs84.json'

const WMS_BIELEFELD = {
  baseUrl: 'http://www.bielefeld01.de/md/WMS/alkis_light/03',
  layers: [
    {
      format: 'image/png',
      layers: 'alkis_flst_pl',
      name: 'Flurstuecke'
    }
  ]
}

export default {
  name: 'AreaComparison',

  data: () => ({
    center: [52.029, 8.533],
    geojson: flurstueckeSubset,
    geojsonEnabled: true,
    wms: WMS_BIELEFELD,
    wmsEnabled: false,
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
