<script setup>
import { ref, watchEffect } from "vue";

const currentTheme = ref("retro");

function setTheme(themeName) {
  currentTheme.value = themeName;
}

watchEffect(() => {
  // document.documentElement ist das <html>-Tag
  document.documentElement.setAttribute("data-theme", currentTheme.value);
});
</script>
<template>
  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Cupcake"
      @click="setTheme('cupcake')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>

      <span class="is-drawer-close:hidden">Light</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Halloween theme"
      data-theme="halloween"
      @click="setTheme('halloween')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>

      <span class="is-drawer-close:hidden">halloween</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Light theme"
      data-theme="light"
      @click="setTheme('light')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">light</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Dark theme"
      data-theme="dark"
      @click="setTheme('dark')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">dark</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Cupcake theme"
      data-theme="cupcake"
      @click="setTheme('cupcake')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">cupcake</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Emerald theme"
      data-theme="emerald"
      @click="setTheme('emerald')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">emerald</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Corporate theme"
      data-theme="corporate"
      @click="setTheme('corporate')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">corporate</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Synthwave theme"
      data-theme="synthwave"
      @click="setTheme('synthwave')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">synthwave</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Retro theme"
      data-theme="retro"
      @click="setTheme('retro')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">retro</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Cyberpunk theme"
      data-theme="cyberpunk"
      @click="setTheme('cyberpunk')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">cyberpunk</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Valentine theme"
      data-theme="valentine"
      @click="setTheme('valentine')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">valentine</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Halloween theme"
      data-theme="halloween"
      @click="setTheme('halloween')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">halloween</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Garden theme"
      data-theme="garden"
      @click="setTheme('garden')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">garden</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Forest theme"
      data-theme="forest"
      @click="setTheme('forest')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">forest</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Aqua theme"
      data-theme="aqua"
      @click="setTheme('aqua')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">aqua</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Lofi theme"
      data-theme="lofi"
      @click="setTheme('lofi')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">lofi</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Pastel theme"
      data-theme="pastel"
      @click="setTheme('pastel')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">pastel</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Fantasy theme"
      data-theme="fantasy"
      @click="setTheme('fantasy')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">fantasy</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Wireframe theme"
      data-theme="wireframe"
      @click="setTheme('wireframe')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">wireframe</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Black theme"
      data-theme="black"
      @click="setTheme('black')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">black</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Luxury theme"
      data-theme="luxury"
      @click="setTheme('luxury')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">luxury</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Dracula theme"
      data-theme="dracula"
      @click="setTheme('dracula')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">dracula</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Cmyk theme"
      data-theme="cmyk"
      @click="setTheme('cmyk')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">cmyk</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Autumn theme"
      data-theme="autumn"
      @click="setTheme('autumn')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">autumn</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Business theme"
      data-theme="business"
      @click="setTheme('business')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">business</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Acid theme"
      data-theme="acid"
      @click="setTheme('acid')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">acid</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Lemonade theme"
      data-theme="lemonade"
      @click="setTheme('lemonade')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">lemonade</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Night theme"
      data-theme="night"
      @click="setTheme('night')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">night</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Coffee theme"
      data-theme="coffee"
      @click="setTheme('coffee')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">coffee</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Winter theme"
      data-theme="winter"
      @click="setTheme('winter')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">winter</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Dim theme"
      data-theme="dim"
      @click="setTheme('dim')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">dim</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Nord theme"
      data-theme="nord"
      @click="setTheme('nord')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">nord</span>
    </button>
  </li>

  <li>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      data-tip="Set Sunset theme"
      data-theme="sunset"
      @click="setTheme('sunset')"
    >
      <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path
          fill-rule="evenodd"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="1.5"
          d="M11.995 7.23319C10.5455 5.60999 8.12832 5.17335 6.31215 6.65972C4.49599 8.14609 4.2403 10.6312 5.66654 12.3892L11.995 18.25L18.3235 12.3892C19.7498 10.6312 19.5253 8.13046 17.6779 6.65972C15.8305 5.18899 13.4446 5.60999 11.995 7.23319Z"
          clip-rule="evenodd"
        ></path>
      </svg>
      <span class="is-drawer-close:hidden">sunset</span>
    </button>
  </li>
</template>
