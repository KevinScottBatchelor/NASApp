<template>
  <div id="app">
    <Image />
  </div>
</template>

<script>
import Image from "./components/Image.vue";

export default {
  name: "App",
  components: {
    Image
  }
};
</script>

<style>
#nav {
  margin: -1% -1% 1% -1%;
  position: fixed;
  padding: 20px;
  justify-content: space-between;
  align-items: center;
  width: 100%;
  background: #5b8291;
  box-shadow: 0px 2px 6px -1px rgba(109, 103, 103, 0.712);
  height: 10%;
}

footer {
  position: fixed;
  left: 0;
  bottom: 0;
  width: 100%;
  background: #053e55;
  box-shadow: 0px 2px 6px -1px rgba(109, 103, 103, 0.712);
  height: 12%;
}

</style>
