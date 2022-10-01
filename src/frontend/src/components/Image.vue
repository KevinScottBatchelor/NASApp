<template>
<div>
  <div class="container-one">
    <div class="container-item">
      <form class="form" onsubmit="return false">
        <input
          type="number"
          min="1"
          max="5"
          class="form-field"
          placeholder="NASA Photos Desired (5 photos max)"
          v-model="request"
        />
        <div id="error-message" v-if="outOfRange === true">{{ errorMsg }}</div>
      </form>
    </div>
  </div>
  <div class="container-two">
    <button
      type="button"
      id="toggle"
      class="btn btn--primary btn--inside uppercase"
      v-on:click="isHidden = false; getImagesFromCall()"
    >Confirm</button>
  </div>
    <div id="spacer"></div>
    <div v-show="!isHidden" v-if="request !== ''" class="container-three">
      <div class="box">
        <div id="image" class="imgBx">
          <img v-for="image in images" v-bind:key="image" src= {{ images.Array[0] }} />
        </div>
          <div class="content">
          <div>
            <h2>Image Title</h2>
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Commodi accusamus molestias quidem
            iusto.
          </p>
        </div>
      </div>
    </div>
  </div>
</div>
</template>

<script>
import ImageService from "../services/ImageService";

export default {
  name: "Image",
  data() {
    return {
      request: "",
      images: [],
      outOfRange: false,
      errorMsg: "",
      isHidden: true
    };
  },
  methods: {
    delay(time) {
      return new Promise(resolve => setTimeout(resolve, time));
    },
    fullDataReset() {
      Object.assign(this.$data, this.$options.data.apply(this));
    },
    getImagesFromCall() {
      if (this.request < 1 || this.request > 5) {
        this.outOfRange = true;
        this.errorMsg = "Please enter a number from (1 - 5)";
        this.delay(2000).then(() => this.reset());
      } else
        ImageService.getImagesFromNasaApodApi(this.request).then(response => {
          this.images = response.data;
        });
    }
  }
};
</script>

<style>
* {
  margin: 0;
  padding: 0;
}

body {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-color: #e4e5e6;
  background: #f5f6fa;
  color: #9c9c9c;
  font: 1rem "PT Sans", sans-serif;
}

a {
  color: inherit;
}

a:hover {
  color: #00416a;
}

.container-one {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.container-two {
  display: flex;
  flex-direction: column;
  align-items: center;
}

#spacer {
  height: 5rem;
}

.container-three {
  position: relative;
  width: 1160px;
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
  transform-style: preserve-3d;
  perspective: 200px;
  margin: auto;
}

.uppercase {
  text-transform: uppercase;
}

.btn {
  display: inline-block;
  background: transparent;
  color: inherit;
  font: inherit;
  border: 0;
  outline: 0;
  padding: 0;
  transition: all 200ms ease-in;
  cursor: pointer;
}

.btn--primary {
  background: #95a5b6;
  color: #fff;
  box-shadow: 0 0 10px 2px rgba(0, 0, 0, 0.1);
  border-radius: 2px;
  padding: 12px 36px;
}

.btn:hover {
  background: darken(#6f8296, 4%);
}

.btn:active {
  background: #6f8296;
  box-shadow: inset 0 0 10px 2px rgba(0, 0, 0, 0.2);
}

.form {
  width: 50vw;
  color: #a3a3a3;
  font: inherit;
  border: 0;
  outline: 0;
  padding: 22px 18px;
}

.form-field {
  width: 50vw;
  color: #a3a3a3;
  font: inherit;
  box-shadow: 0 6px 10px 0 rgba(0, 0, 0, 0.1);
  border: 0;
  outline: 0;
  padding: 22px 18px;
}


.container-three .box {
  position: relative;
  width: 275px;
  height: 275px;
  background: #000;
  transition: 0.5s;
  transform-style: preserve-3d;
  overflow: hidden;
  margin-right: 15px;
  margin-top: 45px;
}

.container-three:hover .box {
  transform: rotateY(25deg);
}

.container-three .box:hover ~ .box {
  transform: rotateY(-25deg);
}

.container-three .box:hover {
  transform: rotateY(0deg) scale(1.25);
  z-index: 1;
  box-shadow: 0 25px 40px rgba(0, 0, 0, 0.5);
}

.container-three .box .imgBx {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}

.container-three .box .imgBx:before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: linear-gradient(180deg, rgb(194, 188, 188), #000);
  z-index: 1;
  opacity: 0;
  transition: 0.5s;
  mix-blend-mode: multiply;
}

.container-three .box:hover .imgBx:before {
  opacity: 1;
}

.container-three .box .imgBx img {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.container-three .box .content {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 1;
  display: flex;
  padding: 20px;
  align-items: flex-end;
  box-sizing: border-box;
}

.container-three .box .content h2 {
  color: #fff;
  transition: 0.5s;
  text-transform: uppercase;
  margin-bottom: 5px;
  font-size: 20px;
  transform: translateY(200px);
  transition-delay: 0.3s;
}

.container-three .box:hover .content h2 {
  transform: translateY(0px);
}

.container-three .box .content p {
  color: #fff;
  transition: 0.5s;
  font-size: 14px;
  transform: translateY(200px);
  transition-delay: 0.4s;
}

.container-three .box:hover .content p {
  transform: translateY(0px);
}
#error-message {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-top: 15px;
  padding-bottom: 5px;
  padding-left: 10px;
  color: rgb(186, 81, 81);
}
</style>