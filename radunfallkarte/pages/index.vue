<template>
  <div id="map-wrap" style="height: 80vh">
    <no-ssr>
      <l-map :zoom=13 :center="[52.029, 8.533]">
        <l-tile-layer url="http://{s}.tile.osm.org/{z}/{x}/{y}.png"></l-tile-layer>
        <l-marker v-for="casualty in casualties" :key="casualty.id" :lat-lng="[casualty.lat, casualty.lng]">
          <l-popup>
            <div @click="innerClick">
             {{ casualty.msg }} <a href="">Details</a>
             </div>
           </l-popup>
        </l-marker>
      </l-map>
    </no-ssr>
  </div>
</template>
<script>
import cfile from './json/unfall_2018_bi.json'
export default {
  data () {
    return {
      casualties: cfile
    }
  },
  methods: {
    innerClick () {
      alert('You clicked here')
    }
  }
}
</script>
