<template>
  <div id="map-wrap" style="height: 80vh">
    <no-ssr>
      <l-map :zoom="13" :center="[52.029, 8.533]">
        <l-tile-layer url="http://{s}.tile.osm.org/{z}/{x}/{y}.png" />
        <l-tile-layer url="http://localhost:8080/tiles/{z}/{x}/{y}.png?months=1" />
        <!--
        <l-marker v-for="casualty in casualties" :key="casualty.id" :lat-lng="[casualty.lat, casualty.lng]">
          <l-popup>
            <div @click="innerClick">
              {{ casualty.msg }} <a href="">Details</a>
            </div>
          </l-popup>
        </l-marker>
        -->
      </l-map>
    </no-ssr>
  </div>
</template>
<script>
import cfile from './json/atlas_bi_2019.json'
export default {
  components: {
  },
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
